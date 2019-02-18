package com.yskj.web;

import com.yskj.Entity.AdminUser;
import com.yskj.Entity.PageBean;
import com.yskj.service.AdminUserService;
import com.yskj.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/2/24.
 */
@Controller
@RequestMapping("/adminUser")
public class AdminUserController {
    @Autowired
    private AdminUserService adminUserService;

    /**
     * 登录
     * @param adminUser
     * @return
     */

    @RequestMapping(value = "login.html")
    public ModelAndView login(AdminUser adminUser) {
        ModelAndView modelAndView = new ModelAndView();
        if(adminUser.getPhone()!= null && adminUser.getPassWord() != null) {
            if ("admin".equals(adminUser.getPhone()) && "admin".equals(adminUser.getPassWord())) {
                modelAndView.setViewName("admin/main");
                return modelAndView;
            } else {
                Map<String,Object> map=new HashMap<String,Object>();
                map.put("phone", adminUser.getPhone());
                String pwd = adminUser.getPassWord();
                pwd = Md5.getResult(pwd);
                map.put("passWord",pwd);
                List<AdminUser> adminUserList = adminUserService.list(map);
                if (adminUserList!=null && adminUserList.size()>0) {
                    modelAndView.setViewName("admin/main");
                    return modelAndView;
                } else {
                    modelAndView.addObject("errorInfo", CommonString.ERR);
                    modelAndView.setViewName("login");
                    return modelAndView;
                }
            }
        }
        modelAndView.setViewName("login");
        return modelAndView;
    }
    /**
     * 修改密码
     */
    @RequestMapping(value = "modifyPassword.html")
    public String modifyPassword(String passWord, HttpServletResponse response) {
        return "";
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
    public String list(@RequestParam(value="page",required=false)String page, @RequestParam(value="rows",required=false)String rows, HttpServletResponse response)throws Exception{
        PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<AdminUser> adminUserList=adminUserService.list(map);
        Long total=adminUserService.getTotal(map);
        JSONObject result=new JSONObject();
        JSONArray jsonArray=JSONArray.fromObject(adminUserList);
        result.put("rows", jsonArray);
        result.put("total", total);
        ResponseUtil.write(response, result);
        return null;
    }
    @RequestMapping("/save.html")
    public String save(AdminUser adminUser,HttpServletResponse response,HttpServletRequest required)throws Exception{
        int resultTotal=0; // 操作的记录条数
        if(adminUser.getAdminUserId()==null){
            adminUser.setEmail("email");
            adminUser.setAddress("address");
            adminUser.setHeadUrl("url");
            adminUser.setCreateTime(new Date());
            adminUser.setCreateUser(1l);
            adminUser.setUpdateTime(new Date());
            //密码加密
            String password = adminUser.getPassWord();
            password = Md5.getResult(password);
            adminUser.setPassWord(password);
            resultTotal=adminUserService.add(adminUser);
        }else{
            adminUser.setEmail("email");
            adminUser.setAddress("address");
            adminUser.setHeadUrl("url");
            adminUser.setCreateTime(new Date());
            adminUser.setCreateUser(1l);
            adminUser.setUpdateTime(new Date());
            //密码加密
            String password = adminUser.getPassWord();
            if (null != password && !"".equals(password)) {
                password = Md5.getResult(password);
                adminUser.setPassWord(password);
            }else {
                adminUser.setPassWord(adminUserService.getAdminUserById(adminUser.getAdminUserId()).getPassWord());
            }
            resultTotal=adminUserService.update(adminUser);
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
    @RequestMapping("/delete")
    public String delete(@RequestParam(value="ids")String ids,HttpServletResponse response)throws Exception{
        String []idsStr=ids.split(",");
        JSONObject result=new JSONObject();
        for(int i=0;i<idsStr.length;i++){
            adminUserService.delete(Long.valueOf(idsStr[i]));
        }
        result.put("success", true);
        ResponseUtil.write(response, result);
        return null;
    }

}
