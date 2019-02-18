package com.yskj.web.front;

import com.yskj.Entity.*;
import com.yskj.dto.LeftClassVo;
import com.yskj.dto.ProductVo;
import com.yskj.dto.TwoTypeVo;
import com.yskj.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/11.
 */
@Controller
//@RequestMapping("gsc")
@RequestMapping("/")
/*http://127.0.0.1:8080/yskj/gsc/homePage.html*/
/*http://127.0.0.1:8080/yskj/fornt/goods/goodPage.jsp*/
public class GoodsController {

    @Autowired
    private ProductOneTypeService productOneTypeService;
    @Autowired
    private ProductTwoTypeService productTwoTypeService;
    @Autowired
    private ProductService productService;
    @Autowired
    private BannerService bannerService;
    @Autowired
    private NewsService newsService;
    @Autowired
    private LogoService logoService;
//    @RequestMapping(value="/homePage.html")
    @RequestMapping(value="/index.html",method = RequestMethod.GET)
    public ModelAndView toGooDsPage() {
        ModelAndView modelAndView = new ModelAndView();
        Map<String,Object> oneTypeMap = new HashMap<>();
        oneTypeMap.put("start", 0);
        oneTypeMap.put("size", 4);
        List<ProductOneType> productOneTypes = productOneTypeService.list(oneTypeMap);
        Map<String,Object> twoTypeMap = new HashMap<>();
        twoTypeMap.put("start", 0);
        twoTypeMap.put("size", 4);
        twoTypeMap.put("recommend", 1);
        List<ProductTwoType> productTwoTypes = productTwoTypeService.list(twoTypeMap);
        Product product = new Product();
        product.setStart(0);
        product.setSize(12);
        product.setRecommend(1);
        List<ProductVo> products = productService.getList(product);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("start", 0);
        map.put("size", 5);
        List<Banner> bannerList=bannerService.list(map);

        Map<String,Object> newsMap=new HashMap<String,Object>();
        newsMap.put("start", 0);
        newsMap.put("size", 10);
        newsMap.put("newsType", 1);
        List<News> newsList = newsService.list(newsMap);
        newsMap.put("newsType", 5);
        List<News> newsList_5 = newsService.list(newsMap);
        newsMap.put("newsType", 6);
        List<News> newsList_6 = newsService.list(newsMap);
        newsMap.put("newsType", 7);
        List<News> newsList_7 = newsService.list(newsMap);

        //导航图
        Map<String,Object> logomap=new HashMap<String,Object>();
        logomap.put("start", 0);
        logomap.put("size", 100);
        List<Logo> banners=logoService.list(logomap);
        Logo dahangtu = new Logo();
        if (banners.size()>0) {
            dahangtu = banners.get(0);
        }
        List<LeftClassVo> leftClassVos = productOneTypeService.getLeftClass();
        modelAndView.addObject("leftClassVos",leftClassVos);
        modelAndView.addObject("products",products);
        modelAndView.addObject("productOneTypes",productOneTypes);
        modelAndView.addObject("productTwoTypes",productTwoTypes);
        modelAndView.addObject("bannerList",bannerList);
        modelAndView.addObject("newsList",newsList);
        modelAndView.addObject("newsList_5",newsList_5);
        modelAndView.addObject("newsList_6",newsList_6);
        modelAndView.addObject("newsList_7",newsList_7);
        modelAndView.addObject("dahangtu",dahangtu);
        modelAndView.setViewName("front/goods/goodPage");
        return modelAndView;
    }
}
