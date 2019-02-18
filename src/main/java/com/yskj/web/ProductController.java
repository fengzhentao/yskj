package com.yskj.web;

import com.yskj.Entity.*;
import com.yskj.dto.TwoTypeVo;
import com.yskj.service.AttachmentService;
import com.yskj.service.ProductOneTypeService;
import com.yskj.service.ProductService;
import com.yskj.service.ProductTwoTypeService;
import com.yskj.util.DateUtil;
import com.yskj.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/5.
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private AttachmentService attachmentService;
    @Autowired
    private ProductTwoTypeService productTwoTypeService;


    /**
     * 分页查询列表
     * @param page
     * @param rows
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/list.html")
    public void list(@RequestParam(value="page",required=false)String page, @RequestParam(value="rows",required=false)String rows, HttpServletResponse response)throws Exception{
        PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<Product> productList=productService.list(map);
        for(Product product : productList) {
            ProductTwoType productTwoType = productTwoTypeService.selectByPrimaryKey(product.getTwoTypeId());
            if(null != productTwoType) {
                product.setTwoTypeName(productTwoType.getTwoTypeName());
            }
        }
        Long total=productService.getTotal(map);
        JSONObject result=new JSONObject();
        JSONArray jsonArray=JSONArray.fromObject(productList);
        result.put("rows", jsonArray);
        result.put("total", total);
        ResponseUtil.write(response, result);
    }

    @RequestMapping("/save.html")
    public String save(@RequestParam("imageFile") MultipartFile imageFile,@RequestParam("detailImageFiles") MultipartFile[] detailImageFiles,
                       Product product,HttpServletResponse response,HttpServletRequest required)throws Exception{
        int resultTotal=0; // 操作的记录条数
        if(product.getProductId()==null){
            product.setRecommend(1);
            int twoTypeId = product.getTwoTypeId();
            ProductTwoType productTwoType = productTwoTypeService.selectByPrimaryKey(twoTypeId);
            if (productTwoType != null && !"".equals(productTwoType)) {
                product.setOneTypeId(productTwoType.getOneTypeId());
            }
            resultTotal=productService.insertSelective(product);
        }else{
            Product oldProduct = productService.selectByPrimaryKey(product.getProductId());
            if (product.getOneTypeId() == null){
                product.setOneTypeId(oldProduct.getOneTypeId());
            }
            resultTotal=productService.updateByPrimaryKeyWithBLOBs(product);
            if (!imageFile.isEmpty()) {
                Attachment attachment = new Attachment();
                attachment.setTableId(product.getProductId());
                attachment.setTableName("product");
                attachment.setAttachmentType(1);
                List<Attachment> attachments = attachmentService.selectList(attachment);
                if (attachments.size()>0) {
                    for (Attachment att : attachments) {
                        attachmentService.deleteByPrimaryKey(att.getAttachmentId());
                    }
                }
            }
            for (MultipartFile detailImageFile : detailImageFiles) {
                if (!detailImageFile.isEmpty()) {
                    Attachment attachment = new Attachment();
                    attachment.setTableId(product.getProductId());
                    attachment.setTableName("product");
                    attachment.setAttachmentType(2);
                    List<Attachment> attachments = attachmentService.selectList(attachment);
                    if (attachments.size()>0) {
                        for (Attachment att : attachments) {
                            attachmentService.deleteByPrimaryKey(att.getAttachmentId());
                        }
                    }
                }
            }

        }
        if(!imageFile.isEmpty()){
            String filePath=required.getServletContext().getRealPath("/");
            String imageName= DateUtil.getCurrentDateStr()+Math.random()*10000+"."+imageFile.getOriginalFilename().split("\\.")[1];
            imageFile.transferTo(new File(filePath+"static/userImages/"+imageName));
            Attachment attachment = new Attachment();
            attachment.setTableName("product");
            attachment.setTableId(product.getProductId());
            attachment.setAttachmentType(1);//附件类型 1，头图2，详情图
            attachment.setLanguage(0);
            attachment.setUrl("static/userImages/" + imageName);
            attachment.setAttachmentName(imageFile.getOriginalFilename());
            attachmentService.insertSelective(attachment);
        }
        for(MultipartFile detailImageFile : detailImageFiles) {
            if (!detailImageFile.isEmpty()) {
                String filePath=required.getServletContext().getRealPath("/");
                String imageName= DateUtil.getCurrentDateStr()+Math.random()*10000+"."+detailImageFile.getOriginalFilename().split("\\.")[1];
                detailImageFile.transferTo(new File(filePath+"static/userImages/"+imageName));
                Attachment attachment = new Attachment();
                attachment.setTableName("product");
                attachment.setTableId(product.getProductId());
                attachment.setAttachmentType(2);
                attachment.setLanguage(0);
                attachment.setUrl("static/userImages/" + imageName);
                attachment.setAttachmentName(detailImageFile.getOriginalFilename());
                attachmentService.insertSelective(attachment);
            }
        }
        JSONObject result=new JSONObject();
        if(resultTotal>0){
            result.put("success", true);
        }else{
            result.put("success", false);
        }
        ResponseUtil.write(response, result);
        return null;
    }

    /**
     * 批量删除
     * @param ids
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/delete.html")
    public void delete(@RequestParam(value="ids")String ids,HttpServletResponse response)throws Exception{
        String []idsStr=ids.split(",");
        JSONObject result=new JSONObject();
        for(int i=0;i<idsStr.length;i++){
            productService.deleteByPrimaryKey(Integer.valueOf(idsStr[i]));
        }
        result.put("success", true);
        ResponseUtil.write(response, result);
    }

    @RequestMapping("/getProductTwoList.html")
    public void getProductTwoList(HttpServletResponse response) throws Exception{
//        List<TwoTypeVo> productTwoTypes = productTwoTypeService.getList();
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("start", 0);
        map.put("size", 100);
        List<ProductTwoType> productTwoTypeList=productTwoTypeService.list(map);
        JSONObject result=new JSONObject();
        result.put("productTwoTypes", productTwoTypeList);
        ResponseUtil.writeList(response,result);
    }
}
