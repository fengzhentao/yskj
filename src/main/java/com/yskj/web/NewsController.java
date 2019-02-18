package com.yskj.web;

import com.yskj.Entity.News;
import com.yskj.Entity.PageBean;
import com.yskj.service.NewsService;
import com.yskj.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jyd on 2017/3/20.
 */
@Controller
@RequestMapping("/rt")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @RequestMapping(value = "/save.html")
    public void save(News news, HttpServletResponse response) throws Exception {
        int resultTotal=0; // 操作的记录条数
        if(news.getNewsId()==null){
            news.setCreateTime(new Date());
            news.setNewsLanguage(0);
            resultTotal=newsService.insertSelective(news);
        }else{
            News oldnews = newsService.selectByPrimaryKey(news.getNewsId());
            news.setNewsLanguage(oldnews.getNewsLanguage());
            news.setCreateTime(oldnews.getCreateTime());
            resultTotal=newsService.updateByPrimaryKeySelective(news);
        }
        JSONObject result=new JSONObject();
        if(resultTotal>0){
            result.put("success", true);
        }else{
            result.put("success", false);
        }
        ResponseUtil.write(response, result);
    }

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
        List<News> newsList=newsService.list(map);
        for (News news : newsList) {
            int newsType = news.getNewsType();
            String newsTypeName = "";
                if (newsType == 1) {
                    newsTypeName = new String("资讯快报".getBytes(),"UTF-8");
                    news.setNewTypeName(newsTypeName);
                }
                if (newsType == 2) {
                    newsTypeName = new String("关于我们".getBytes(),"UTF-8");
                    news.setNewTypeName(newsTypeName);
                }
                if (newsType == 3) {
                    newsTypeName = new String("联系我们".getBytes(),"UTF-8");
                    news.setNewTypeName(newsTypeName);
                }
                if (newsType == 4) {
//                    newsTypeName = new String("行业动态".getBytes(),"UTF-8");
                    newsTypeName = new String("行业动向".getBytes("GBK"),"utf-8");
                    news.setNewTypeName(newsTypeName);
                }
                if (newsType == 5) {
                    newsTypeName = new String("新闻资讯".getBytes(),"UTF-8");
                    news.setNewTypeName(newsTypeName);
                }
                if (newsType == 6) {
                    newsTypeName = new String("产品相关".getBytes(),"UTF-8");
                    news.setNewTypeName(newsTypeName);
                }
                if (newsType == 7) {
                    newsTypeName = new String("行业资讯".getBytes(),"UTF-8");
                    news.setNewTypeName(newsTypeName);
                }
        }
        Long total=newsService.getTotal(map);
        JSONObject result=new JSONObject();
        JSONArray jsonArray=JSONArray.fromObject(newsList);
        result.put("rows", jsonArray);
        result.put("total", total);
        ResponseUtil.write(response, result);
    }

    @RequestMapping(value = "/findById.html")
    public void findById(@RequestParam(value = "id") String id,HttpServletResponse response) throws Exception {
        News news = newsService.selectByPrimaryKey(Integer.parseInt(id));
        JSONObject jsonObject=JSONObject.fromObject(news);
        ResponseUtil.write(response, jsonObject);
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
            newsService.deleteByPrimaryKey(Integer.valueOf(idsStr[i]));
        }
        result.put("success", true);
        ResponseUtil.write(response, result);
    }
}
