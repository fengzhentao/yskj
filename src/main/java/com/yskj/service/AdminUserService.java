package com.yskj.service;

import com.yskj.Entity.AdminUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/24.
 */
public interface AdminUserService {
    /**
     * 查询单个用户信息
     */
    public AdminUser getAdminUserById(Long id);
    /**
     * 分页查询博客类别信息
     * @param map
     * @return
     */
    public List<AdminUser> list(Map<String,Object> map);

    /**
     * 获取总记录数
     * @param map
     * @return
     */
    public Long getTotal(Map<String,Object> map);

    /**
     * 添加用户
     * @param adminUser
     * @return
     */
    int add(AdminUser adminUser);

    /**
     * 修改用户
     * @param adminUser
     * @return
     */
    int update(AdminUser adminUser);

    /**
     * 删除用户
     * @param aLong
     */
    void delete(Long aLong);
}
