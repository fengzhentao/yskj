package com.yskj.web;

import com.yskj.Entity.*;
import com.yskj.service.AttachmentService;
import com.yskj.service.ProductOneTypeService;
import com.yskj.service.ProductTwoTypeService;
import com.yskj.util.DateUtil;
import com.yskj.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@RequestMapping("/productTwoType")
public class ProductTwoTypeController {

    @Autowired
    private ProductTwoTypeService productTwoTypeService;

    @Autowired
    private ProductOneTypeService productOneTypeService;

    @Autowired
    private AttachmentService attachmentService;
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
        List<ProductTwoType> productTwoTypeList=productTwoTypeService.list(map);
        for(ProductTwoType productTwoType : productTwoTypeList) {
            ProductOneType productOneType = productOneTypeService.selectByPrimaryKey(productTwoType.getOneTypeId());
            if (null != productOneType) {
                productTwoType.setOneTypeName(productOneType.getOneTypeName());
            }
        }
        Long total=productTwoTypeService.getTotal(map);
        JSONObject result=new JSONObject();
        JSONArray jsonArray=JSONArray.fromObject(productTwoTypeList);
        result.put("rows", jsonArray);
        result.put("total", total);
        ResponseUtil.write(response, result);
    }

    @RequestMapping("/save.html")
    public String save(@RequestParam("imageFile") MultipartFile imageFile,ProductTwoType productTwoType,@RequestParam("detailImageFiles") MultipartFile[] detailImageFiles,
                       HttpServletResponse response,HttpServletRequest required)throws Exception{
        int resultTotal=0; // 操作的记录条数
        if(!imageFile.isEmpty()){
            String filePath=required.getServletContext().getRealPath("/");
            String imageName= DateUtil.getCurrentDateStr()+"."+imageFile.getOriginalFilename().split("\\.")[1];
            imageFile.transferTo(new File(filePath+"static/userImages/"+imageName));
            productTwoType.setImageUrl("static/userImages/"+imageName);
        }
        if(productTwoType.getTwoTypeId()==null){
            resultTotal=productTwoTypeService.insertSelective(productTwoType);
        }else{
            resultTotal=productTwoTypeService.updateByPrimaryKeySelective(productTwoType);
            for (MultipartFile detailImageFile : detailImageFiles) {
                if (!detailImageFile.isEmpty()) {
                    Attachment attachment = new Attachment();
                    attachment.setTableId(productTwoType.getTwoTypeId());
                    attachment.setTableName("product_two_type");
                    attachment.setAttachmentType(4);
                    List<Attachment> attachments = attachmentService.selectList(attachment);
                    if (attachments.size()>0) {
                        for (Attachment att : attachments) {
                            attachmentService.deleteByPrimaryKey(att.getAttachmentId());
                        }
                    }
                }
            }
        }
        for(MultipartFile detailImageFile : detailImageFiles) {
            if (!detailImageFile.isEmpty()) {
                String filePath=required.getServletContext().getRealPath("/");
                String imageName= DateUtil.getCurrentDateStr()+Math.random()*10000+"."+detailImageFile.getOriginalFilename().split("\\.")[1];
                detailImageFile.transferTo(new File(filePath+"static/userImages/"+imageName));
                Attachment attachment = new Attachment();
                attachment.setTableName("product_two_type");
                attachment.setTableId(productTwoType.getTwoTypeId());
                attachment.setAttachmentType(4);//附件类型 1，头图2，详情 3.logo，4参数
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
        String[] idsStr=ids.split(",");
        JSONObject result=new JSONObject();
        for(int i=0;i<idsStr.length;i++){
            productTwoTypeService.deleteByPrimaryKey(Integer.valueOf(idsStr[i]));
        }
        result.put("success", true);
        ResponseUtil.write(response, result);
    }

    @RequestMapping("/getProductOneList.html")
    public void getProductOneList(HttpServletResponse response) throws Exception{
        Map<String,Object> oneTypeMap = new HashMap<>();
        oneTypeMap.put("start", 0);
        oneTypeMap.put("size", 100);
        List<ProductOneType> productOneTypes = productOneTypeService.list(oneTypeMap);
        JSONObject result=new JSONObject();
        result.put("productOneTypes", productOneTypes);
//        JSONArray result = JSONArray.fromObject(productOneTypes);
        ResponseUtil.writeList(response,result);
    }


}
