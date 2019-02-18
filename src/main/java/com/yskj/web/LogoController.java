package com.yskj.web;

import com.yskj.Entity.Logo;
import com.yskj.Entity.PageBean;
import com.yskj.service.LogoService;
import com.yskj.util.CommonString;
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
 * Created by jyd on 2017/3/22.
 */
@Controller
@RequestMapping("/logo")
public class LogoController {
    @Autowired
    private LogoService logoService;

    /**
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
        List<Logo> bannerList=logoService.list(map);
        Long total=logoService.getTotal(map);
        for (Logo logo : bannerList) {
            if (1== logo.getLogoType()) {
                logo.setLogoTypeName(CommonString.ONE_1);
            }
            if (2== logo.getLogoType()) {
                logo.setLogoTypeName(CommonString.ONE_2);
            }
            if (3== logo.getLogoType()) {
                logo.setLogoTypeName(CommonString.ONE_3);
            }
            if (4== logo.getLogoType()) {
                logo.setLogoTypeName(CommonString.ONE_4);
            }
            if (5== logo.getLogoType()) {
                logo.setLogoTypeName(CommonString.ONE_5);
            }
            if (6== logo.getLogoType()) {
                logo.setLogoTypeName(CommonString.ONE_6);
            }
        }
        JSONObject result=new JSONObject();
        JSONArray jsonArray=JSONArray.fromObject(bannerList);
        result.put("rows", jsonArray);
        result.put("total", total);
        ResponseUtil.write(response, result);
    }

    @RequestMapping("/save.html")
    public String save(@RequestParam("imageFile") MultipartFile imageFile, Logo logo, HttpServletResponse response, HttpServletRequest required)throws Exception{
        int resultTotal=0;
        if(!imageFile.isEmpty()){
            String filePath=required.getServletContext().getRealPath("/");
            String imageName= DateUtil.getCurrentDateStr()+"."+imageFile.getOriginalFilename().split("\\.")[1];
            imageFile.transferTo(new File(filePath+"static/userImages/"+imageName));
            logo.setLogoUrl("static/userImages/"+imageName);
        }
        if(logo.getLogoId()==null){
            logo.setCreatTime(new Date());
            logo.setRecommend(1);
            resultTotal=logoService.insertSelective(logo);
        }else{
            resultTotal=logoService.updateByPrimaryKeySelective(logo);
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
     * ����ɾ��
     * @param ids
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/delete.html")
    public void delete(@RequestParam(value="ids")String ids,HttpServletResponse response)throws Exception {
        String []idsStr=ids.split(",");
        JSONObject result=new JSONObject();
        for(int i=0;i<idsStr.length;i++){
            logoService.deleteByPrimaryKey(Integer.valueOf(idsStr[i]));
        }
        result.put("success", true);
        ResponseUtil.write(response, result);
    }
}
