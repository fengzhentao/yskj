package com.yskj.service.impl;

import com.yskj.Entity.Logo;
import com.yskj.dao.LogoDao;
import com.yskj.service.LogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by jyd on 2017/3/22.
 */
@Service
public class LogoServiceImpl implements LogoService {
    @Autowired
    private LogoDao logoDao;
    @Override
    public int deleteByPrimaryKey(Integer logoId) {
        return logoDao.deleteByPrimaryKey(logoId);
    }

    @Override
    public int insert(Logo record) {
        return logoDao.insert(record);
    }

    @Override
    public int insertSelective(Logo record) {
        return logoDao.insertSelective(record);
    }

    @Override
    public Logo selectByPrimaryKey(Integer logoId) {
        return logoDao.selectByPrimaryKey(logoId);
    }

    @Override
    public int updateByPrimaryKeySelective(Logo record) {
        return logoDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Logo record) {
        return logoDao.updateByPrimaryKey(record);
    }

    @Override
    public List<Logo> list(Map<String, Object> map) {
        return logoDao.list(map);
    }

    @Override
    public Long getTotal(Map<String, Object> map) {
        return logoDao.getTotal(map);
    }
}
