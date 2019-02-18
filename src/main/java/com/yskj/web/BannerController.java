package com.yskj.web;

import com.yskj.Entity.Banner;
import com.yskj.Entity.PageBean;
import com.yskj.service.BannerService;
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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jyd on 2017/3/14.
 */
@Controller
@RequestMapping("/banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;

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
        List<Banner> bannerList=bannerService.list(map);
        Long total=bannerService.getTotal(map);
        JSONObject result=new JSONObject();
        JSONArray jsonArray=JSONArray.fromObject(bannerList);
        result.put("rows", jsonArray);
        result.put("total", total);
        ResponseUtil.write(response, result);
    }

    @RequestMapping("/save.html")
    public String save(@RequestParam("imageFile") MultipartFile imageFile, Banner banner, HttpServletResponse response, HttpServletRequest required)throws Exception{
        int resultTotal=0; // 操作的记录条数
        if(!imageFile.isEmpty()){
            String filePath=required.getServletContext().getRealPath("/");
            String imageName= DateUtil.getCurrentDateStr()+"."+imageFile.getOriginalFilename().split("\\.")[1];
            imageFile.transferTo(new File(filePath+"static/userImages/"+imageName));
            banner.setBannerImage("static/userImages/"+imageName);
        }
        if(banner.getBannerId()==null){
            banner.setCreateTime(new Date());
            banner.setBannerLanguage(0);
            resultTotal=bannerService.insertSelective(banner);
        }else{
            resultTotal=bannerService.updateByPrimaryKeySelective(banner);
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
            bannerService.deleteByPrimaryKey(Integer.valueOf(idsStr[i]));
        }
        result.put("success", true);
        ResponseUtil.write(response, result);
    }
}
