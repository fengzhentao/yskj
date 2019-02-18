package com.yskj.web.front;

import com.yskj.Entity.Logo;
import com.yskj.Entity.News;
import com.yskj.Entity.ProductOneType;
import com.yskj.Entity.Slogan;
import com.yskj.dto.LeftClassVo;
import com.yskj.service.LogoService;
import com.yskj.service.NewsService;
import com.yskj.service.ProductOneTypeService;
import com.yskj.service.SloganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/12.
 */
@Controller
@RequestMapping("/ab")
public class AboutController {

    @Autowired
    private ProductOneTypeService productOneTypeService;
    @Autowired
    private NewsService newsService;
    @Autowired
    private SloganService sloganService;
    @Autowired
    private LogoService logoService;

    @RequestMapping(value = "/{type}/about.html",method = RequestMethod.GET)
    public ModelAndView toAboutPage(@PathVariable(value = "type") Integer type) {
        ModelAndView modelAndView = new ModelAndView();
        Map<String,Object> oneTypeMap = new HashMap<>();
        oneTypeMap.put("start", 0);
        oneTypeMap.put("size", 100);
        List<ProductOneType> productOneTypes = productOneTypeService.list(oneTypeMap);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("start",0);
        map.put("size", 100);
        map.put("newsType",type);
        List<News> newsList=newsService.list(map);
        News news = newsList.get(0);
        Map<String,Object> sloganMap = new HashMap<>();
        sloganMap.put("start", 0);
        sloganMap.put("size", 1);
        Slogan slogan = sloganService.list(sloganMap).get(0);
        //导航图
        //1.产品中心2.合作伙伴3.行业动向4.关系/联系我们5.产品详情6.行业详情
        Map<String,Object> logomap=new HashMap<String,Object>();
        logomap.put("start", 0);
        logomap.put("size", 100);
        logomap.put("logoType",4);
        //1.产品中心2.合作伙伴3.行业动向4.关系/联系我们5.产品详情6.行业详情
        List<Logo> bannerList=logoService.list(logomap);
        Logo dahangtu = new Logo();
        if (bannerList.size()>0) {
            dahangtu = bannerList.get(0);
        }
        List<LeftClassVo> leftClassVos = productOneTypeService.getLeftClass();
        modelAndView.addObject("leftClassVos",leftClassVos);
        modelAndView.addObject("productOneTypes",productOneTypes);
        modelAndView.addObject("news",news);
        modelAndView.addObject("slogan",slogan);
        modelAndView.addObject("dahangtu",dahangtu);
        modelAndView.setViewName("front/goods/about");
        return modelAndView;
    }
}
