package com.yskj.dao;

import com.yskj.Entity.AdminUser;
import com.yskj.dto.AdminUserQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/23.
 */
@Repository
public interface AdminUserDao {
    /**
     * 查询单个用户信息
     */
    public AdminUser getAdminUserById(Long id);
    /**
     * 用户登录
     */
    public AdminUser getAdminUser(AdminUserQuery adminUserQuery);
    /**
     * 用户注册
     */
    public int registerAdminUser(AdminUser adminUser);
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

    int insertSelective(AdminUser record);

    int updateByPrimaryKeySelective(AdminUser record);
}
