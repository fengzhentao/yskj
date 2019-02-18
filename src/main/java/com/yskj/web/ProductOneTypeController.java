package com.yskj.web;

import com.yskj.Entity.PageBean;
import com.yskj.Entity.ProductOneType;
import com.yskj.service.ProductOneTypeService;
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
@RequestMapping("/productOneType")
public class ProductOneTypeController {

    @Autowired
    private ProductOneTypeService productOneTypeService;

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
        List<ProductOneType> productOneTypeList=productOneTypeService.list(map);
        Long total=productOneTypeService.getTotal(map);
        JSONObject result=new JSONObject();
        JSONArray jsonArray=JSONArray.fromObject(productOneTypeList);
        result.put("rows", jsonArray);
        result.put("total", total);
        ResponseUtil.write(response, result);
    }

    @RequestMapping("/save.html")
    public String save(@RequestParam("imageFile") MultipartFile imageFile,ProductOneType productOneType,HttpServletResponse response,HttpServletRequest required)throws Exception{
        int resultTotal=0; // 操作的记录条数
        if(!imageFile.isEmpty()){
            String filePath=required.getServletContext().getRealPath("/");
            String imageName= DateUtil.getCurrentDateStr()+"."+imageFile.getOriginalFilename().split("\\.")[1];
            imageFile.transferTo(new File(filePath+"static/userImages/"+imageName));
            productOneType.setImageUrl("static/userImages/"+imageName);
        }
        if(productOneType.getOneTypeId()==null){
            productOneType.setRecommend(1);
            resultTotal=productOneTypeService.insertSelective(productOneType);
        }else{
            resultTotal=productOneTypeService.updateByPrimaryKeySelective(productOneType);
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
    public String delete(@RequestParam(value="ids")String ids,HttpServletResponse response)throws Exception{
        String[] idsStr=ids.split(",");
        JSONObject result = new JSONObject();
        for(int i=0;i<idsStr.length;i++){
            productOneTypeService.deleteByPrimaryKey(Integer.valueOf(idsStr[i]));
        }
        result.put("success", true);
        ResponseUtil.write(response, result);
        return null;
    }
}
