package com.yskj.web.front;

import com.yskj.Entity.*;
import com.yskj.dto.LeftClassVo;
import com.yskj.dto.ProductVo;
import com.yskj.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/11.
 */
@Controller
@RequestMapping("/gcc")
@SuppressWarnings("all")
public class GoodsClassController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductOneTypeService productOneTypeService;
    @Autowired
    private ProductTwoTypeService productTwoTypeService;
    @Autowired
    private SloganService sloganService;
    @Autowired
    private LogoService logoService;

    /**
     * 产品中心跳转
     * @return
     */
    @RequestMapping(value = "goodsClass.html")
    public ModelAndView toGoodsClass(){
        ModelAndView modelAndView = new ModelAndView();
        List<ProductVo> productVoses = productService.getList(new Product());
        Map<String,Object> oneTypeMap = new HashMap<>();
        oneTypeMap.put("start", 0);
        oneTypeMap.put("size", 100);
        List<ProductOneType> productOneTypes = productOneTypeService.list(oneTypeMap);
        List<LeftClassVo> leftClassVos = productOneTypeService.getLeftClass();
        Map<String,Object> sloganMap = new HashMap<>();
        sloganMap.put("start", 0);
        sloganMap.put("size", 1);
        Slogan slogan = sloganService.list(sloganMap).get(0);
        //导航图
        Map<String,Object> logomap=new HashMap<String,Object>();
        logomap.put("start", 0);
        logomap.put("size", 100);
        logomap.put("logoType",1);
        //1.产品中心2.合作伙伴3.行业动向4.关系/联系我们5.产品详情6.行业详情
        List<Logo> bannerList=logoService.list(logomap);
        Logo dahangtu = new Logo();
        if (bannerList.size()>0) {
            dahangtu = bannerList.get(0);
        }
        modelAndView.addObject("productVoses",productVoses);
        modelAndView.addObject("productOneTypes",productOneTypes);
        modelAndView.addObject("leftClassVos",leftClassVos);
        modelAndView.addObject("slogan",slogan);
        modelAndView.addObject("dahangtu",dahangtu);
        modelAndView.setViewName("front/goods/goodClass");
        return modelAndView;
    }
    /**
     * 产品一类跳转
     */
    @RequestMapping(value = "/{oneTypeId}/oneGoodsClass.html")
    public ModelAndView oneToGoodsClass(@PathVariable("oneTypeId") Integer oneTypeId){
        ModelAndView modelAndView = new ModelAndView();
        //点击一类查询相关商品
        Product product = new Product();
        product.setOneTypeId(oneTypeId);
        List<ProductVo> productVoses = productService.getList(product);
        //产品中心下拉列表
        Map<String,Object> oneTypeMap = new HashMap<>();
        oneTypeMap.put("start", 0);
        oneTypeMap.put("size", 100);
        List<ProductOneType> productOneTypes = productOneTypeService.list(oneTypeMap);
        //左边列表
        List<LeftClassVo> leftClassVos = productOneTypeService.getLeftClass();
        for (LeftClassVo leftClassVo : leftClassVos) {
            if(oneTypeId == leftClassVo.getOneTypeId()) {
                leftClassVo.setOpentype(1);
            }else{
                leftClassVo.setOpentype(2);
            }
        }
        Map<String,Object> sloganMap = new HashMap<>();
        sloganMap.put("start", 0);
        sloganMap.put("size", 1);
        Slogan slogan = sloganService.list(sloganMap).get(0);
        //导航图
        Map<String,Object> logomap=new HashMap<String,Object>();
        logomap.put("start", 0);
        logomap.put("size", 100);
        logomap.put("logoType",1);
        //1.产品中心2.合作伙伴3.行业动向4.关系/联系我们5.产品详情6.行业详情
        List<Logo> bannerList=logoService.list(logomap);
        Logo dahangtu = new Logo();
        if (bannerList.size()>0) {
            dahangtu = bannerList.get(0);
        }
        modelAndView.addObject("productVoses",productVoses);
        modelAndView.addObject("productOneTypes",productOneTypes);
        modelAndView.addObject("leftClassVos",leftClassVos);
        modelAndView.addObject("slogan",slogan);
        modelAndView.addObject("dahangtu",dahangtu);
        modelAndView.setViewName("front/goods/goodClass");
        return modelAndView;
    }
    /**
     * 产品二类跳转
     */
    @RequestMapping(value = "/{twoTypeId}/twoGoodsClass.html")
    public ModelAndView twoToGoodsClass(@PathVariable("twoTypeId") Integer twoTypeId){
        ModelAndView modelAndView = new ModelAndView();
        int oneTypeId = productTwoTypeService.selectByPrimaryKey(twoTypeId).getOneTypeId();
        //点击二类查询相关商品
        Product product = new Product();
        product.setTwoTypeId(twoTypeId);
        List<ProductVo> productVoses = productService.getList(product);
        //产品中心下拉列表
        Map<String,Object> oneTypeMap = new HashMap<>();
        oneTypeMap.put("start", 0);
        oneTypeMap.put("size", 100);
        List<ProductOneType> productOneTypes = productOneTypeService.list(oneTypeMap);
        //左边列表
        List<LeftClassVo> leftClassVos = productOneTypeService.getLeftClass();
        for (LeftClassVo leftClassVo : leftClassVos) {
            if(oneTypeId == leftClassVo.getOneTypeId()) {
                leftClassVo.setOpentype(1);
            }else{
                leftClassVo.setOpentype(2);
            }
            List<ProductTwoType> productTwoTypes = leftClassVo.getProductTwoTypes();
            for(ProductTwoType productTwoType : productTwoTypes) {
                if(twoTypeId == productTwoType.getTwoTypeId()) {
                    productTwoType.setOpenTwoType(1);
                }else{
                    productTwoType.setOpenTwoType(2);
                }
            }
        }
        Map<String,Object> sloganMap = new HashMap<>();
        sloganMap.put("start", 0);
        sloganMap.put("size", 1);
        Slogan slogan = sloganService.list(sloganMap).get(0);
        //导航图
        Map<String,Object> logomap=new HashMap<String,Object>();
        logomap.put("start", 0);
        logomap.put("size", 100);
        logomap.put("logoType",1);
        //1.产品中心2.合作伙伴3.行业动向4.关系/联系我们5.产品详情6.行业详情
        List<Logo> bannerList=logoService.list(logomap);
        Logo dahangtu = new Logo();
        if (bannerList.size()>0) {
            dahangtu = bannerList.get(0);
        }
        modelAndView.addObject("productVoses",productVoses);
        modelAndView.addObject("productOneTypes",productOneTypes);
        modelAndView.addObject("leftClassVos",leftClassVos);
        modelAndView.addObject("slogan",slogan);
        modelAndView.addObject("dahangtu",dahangtu);
        modelAndView.setViewName("front/goods/goodClass");
        return modelAndView;
    }

}
