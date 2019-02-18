package com.yskj.web.front;

import com.yskj.Entity.*;
import com.yskj.dto.LeftClassVo;
import com.yskj.dto.ProductVo;
import com.yskj.service.*;
import com.yskj.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/11.
 */
@Controller
@RequestMapping("/gdc")
public class GoodsDetailController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductOneTypeService productOneTypeService;
    @Autowired
    private AttachmentService attachmentService;
    @Autowired
    private SloganService sloganService;
    @Autowired
    private LogoService logoService;
    @RequestMapping(value = "/{productId}/goodsDetail.html")
    public ModelAndView goodsDetail(@PathVariable("productId")Integer productId) {
        ModelAndView modelAndView = new ModelAndView();
        Product product = new Product();
        product.setStart(0);
        product.setSize(5);
        product.setRecommend(1);
        List<ProductVo> products = productService.getList(product);
        Map<String,Object> oneTypeMap = new HashMap<>();
        oneTypeMap.put("start", 0);
        oneTypeMap.put("size", 100);
        List<ProductOneType> productOneTypes = productOneTypeService.list(oneTypeMap);
        ProductVo productVo = productService.getProductDetailById(productId);
        Attachment attachment = new Attachment();
        attachment.setTableName("product");
        attachment.setTableId(productId);
        attachment.setAttachmentType(2);
        List<Attachment> attachmentList = attachmentService.selectList(attachment);
        //参数
//        Attachment attachmentparam = new Attachment();
//        attachmentparam.setTableName("product_two_type");
//        attachmentparam.setTableId(productVo.getTwoTypeId());
//        attachmentparam.setAttachmentType(4);
//        List<Attachment> paramList = attachmentService.selectList(attachmentparam);
        List<LeftClassVo> leftClassVos = productOneTypeService.getLeftClass();
        Map<String,Object> sloganMap = new HashMap<>();
        sloganMap.put("start", 0);
        sloganMap.put("size", 1);
        Slogan slogan = sloganService.list(sloganMap).get(0);
        //导航图
        Map<String,Object> logomap=new HashMap<String,Object>();
        logomap.put("start", 0);
        logomap.put("size", 100);
        logomap.put("logoType",5);
        //1.产品中心2.合作伙伴3.行业动向4.关系/联系我们5.产品详情6.行业详情
        List<Logo> banners=logoService.list(logomap);
        Logo dahangtu = new Logo();
        if (banners.size()>0) {
            dahangtu = banners.get(0);
        }
        modelAndView.addObject("productOneTypes",productOneTypes);
        modelAndView.addObject("productVo",productVo);
        modelAndView.addObject("attachmentList",attachmentList);
        modelAndView.addObject("leftClassVos",leftClassVos);
        modelAndView.addObject("products",products);
        modelAndView.addObject("slogan",slogan);
        modelAndView.addObject("dahangtu",dahangtu);
//        modelAndView.addObject("paramList",paramList);

        modelAndView.setViewName("front/goods/goodDetail");
        return modelAndView;
    }

    @RequestMapping(value = "/{twoId}/getParams.html")
    @ResponseBody
    public void getParams(@PathVariable("twoId")int twoId, HttpServletResponse response) throws Exception {
        Attachment attachment = new Attachment();
        attachment.setTableName("product_two_type");
        attachment.setTableId(twoId);
        attachment.setAttachmentType(4);
        List<Attachment> paramList = attachmentService.selectList(attachment);
        JSONObject result=new JSONObject();
        JSONArray jsonArray=JSONArray.fromObject(paramList);
        result.put("data", jsonArray);
        ResponseUtil.write(response, result);
    }
}
