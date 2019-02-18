package com.yskj.web.front;

import com.yskj.Entity.*;
import com.yskj.dto.LeftClassVo;
import com.yskj.service.LogoService;
import com.yskj.service.NewsService;
import com.yskj.service.ProductOneTypeService;
import com.yskj.service.SloganService;
import com.yskj.util.PageUtil;
import com.yskj.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jyd on 2017/3/20.
 */
@Controller
@RequestMapping("/news")
public class NewsFrontController {

    @Autowired
    private NewsService newsService;
    @Autowired
    private ProductOneTypeService productOneTypeService;
    @Autowired
    private SloganService sloganService;
    @Autowired
    private LogoService logoService;

    /**
     * 请求博客详细信息
     * @return
     * @throws Exception
     */
    @RequestMapping("/{id}/articles.html")
    public ModelAndView details(@PathVariable("id") Integer id, HttpServletRequest request)throws Exception{
        ModelAndView mav=new ModelAndView();
        //导航图
        Map<String,Object> logomap=new HashMap<String,Object>();
        logomap.put("start", 0);
        logomap.put("size", 100);
        logomap.put("logoType",6);
        //1.产品中心2.合作伙伴3.行业动向4.关系/联系我们5.产品详情6.行业详情
        List<Logo> banners=logoService.list(logomap);
        Logo dahangtu = new Logo();
        if (banners.size()>0) {
            dahangtu = banners.get(0);
        }
        Map<String,Object> sloganMap = new HashMap<>();
        sloganMap.put("start", 0);
        sloganMap.put("size", 1);
        Slogan slogan = sloganService.list(sloganMap).get(0);
        Map<String,Object> oneTypeMap = new HashMap<>();
        oneTypeMap.put("start", 0);
        oneTypeMap.put("size", 100);
        List<ProductOneType> productOneTypes = productOneTypeService.list(oneTypeMap);
        News news = newsService.selectByPrimaryKey(id);
        mav.addObject("news", news);
        mav.addObject("slogan", slogan);
        mav.addObject("dahangtu",dahangtu);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("newsId", news.getNewsId());
        List<LeftClassVo> leftClassVos = productOneTypeService.getLeftClass();
        mav.addObject("leftClassVos",leftClassVos);
        mav.addObject("productOneTypes", productOneTypes);
        mav.addObject("pageCode", PageUtil.genUpAndDownPageCode(newsService.getLastNews(id),newsService.getNextNews(id),request.getServletContext().getContextPath()));
        mav.setViewName("front/goods/newsView");
        return mav;
    }



    @RequestMapping("/{newsType}/index.html")
    public ModelAndView index(@RequestParam(value="page",required=false)String page,@PathVariable(value = "newsType") int newsType, HttpServletRequest request)throws Exception{
        ModelAndView mav=new ModelAndView();
        //导航图
        Map<String,Object> logomap=new HashMap<String,Object>();
        logomap.put("start", 0);
        logomap.put("size", 100);
        logomap.put("logoType",3);
        //1.产品中心2.合作伙伴3.行业动向4.关系/联系我们5.产品详情6.行业详情
        List<Logo> banners=logoService.list(logomap);
        Logo dahangtu = new Logo();
        if (banners.size()>0) {
            dahangtu = banners.get(0);
        }
        if(StringUtil.isEmpty(page)){
            page="1";
        }
        Map<String,Object> oneTypeMap = new HashMap<>();
        oneTypeMap.put("start", 0);
        oneTypeMap.put("size", 100);
        List<ProductOneType> productOneTypes = productOneTypeService.list(oneTypeMap);

        PageBean pageBean=new PageBean(Integer.parseInt(page),20);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        map.put("newsType", newsType);
        List<News> newsList=newsService.list(map);
        Long total = newsService.getTotal(map);
        Map<String,Object> sloganMap = new HashMap<>();
        sloganMap.put("start", 0);
        sloganMap.put("size", 1);
        Slogan slogan = sloganService.list(sloganMap).get(0);
        List<LeftClassVo> leftClassVos = productOneTypeService.getLeftClass();
        mav.addObject("leftClassVos",leftClassVos);
        mav.addObject("newsList", newsList);
        mav.addObject("productOneTypes", productOneTypes);
        mav.addObject("slogan", slogan);
        mav.addObject("dahangtu",dahangtu);
        mav.addObject("pageCode", PageUtil.genPagination(request.getContextPath()+"/news/"+newsType+"/index.html", total, Integer.parseInt(page), 20));
        mav.setViewName("front/goods/news");
        return mav;
    }
}
