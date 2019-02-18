package com.yskj.service.impl;

import com.yskj.Entity.AdminUser;
import com.yskj.dao.AdminUserDao;
import com.yskj.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/24.
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserDao adminUserDao;

    @Override
    public AdminUser getAdminUserById(Long id) {
        return adminUserDao.getAdminUserById(id);
    }

    @Override
    public List<AdminUser> list(Map<String, Object> map) {
        return adminUserDao.list(map);
    }

    @Override
    public Long getTotal(Map<String, Object> map) {
        return adminUserDao.getTotal(map);
    }

    @Override
    public int add(AdminUser adminUser) {
        return adminUserDao.insertSelective(adminUser);
    }

    @Override
    public int update(AdminUser adminUser) {
        return adminUserDao.updateByPrimaryKeySelective(adminUser);
    }

    @Override
    public void delete(Long aLong) {
        adminUserDao.delete(aLong);
    }

}
