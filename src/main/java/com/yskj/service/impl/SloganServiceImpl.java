package com.yskj.service.impl;

import com.yskj.Entity.Slogan;
import com.yskj.dao.SloganDao;
import com.yskj.service.SloganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by jyd on 2017/3/22.
 */
@Service
public class SloganServiceImpl implements SloganService {

    @Autowired
    private SloganDao sloganDao;

    @Override
    public int deleteByPrimaryKey(Integer sloganId) {
        return sloganDao.deleteByPrimaryKey(sloganId);
    }

    @Override
    public int insert(Slogan record) {
        return sloganDao.insert(record);
    }

    @Override
    public int insertSelective(Slogan record) {
        return sloganDao.insertSelective(record);
    }

    @Override
    public Slogan selectByPrimaryKey(Integer sloganId) {
        return sloganDao.selectByPrimaryKey(sloganId);
    }

    @Override
    public int updateByPrimaryKeySelective(Slogan record) {
        return sloganDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Slogan record) {
        return sloganDao.updateByPrimaryKey(record);
    }

    @Override
    public List<Slogan> list(Map<String, Object> map) {
        return sloganDao.list(map);
    }

    @Override
    public Long getTotal(Map<String, Object> map) {
        return sloganDao.getTotal(map);
    }
}
