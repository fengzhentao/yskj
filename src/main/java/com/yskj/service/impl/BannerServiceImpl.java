package com.yskj.service.impl;

import com.yskj.Entity.Banner;
import com.yskj.dao.BannerDao;
import com.yskj.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by jyd on 2017/3/13.
 */
@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerDao bannerDao;
    @Override
    public int deleteByPrimaryKey(Integer bannerId) {
        return bannerDao.deleteByPrimaryKey(bannerId);
    }

    @Override
    public int insert(Banner record) {
        return bannerDao.insert(record);
    }

    @Override
    public int insertSelective(Banner record) {
        return bannerDao.insertSelective(record);
    }

    @Override
    public Banner selectByPrimaryKey(Integer bannerId) {
        return bannerDao.selectByPrimaryKey(bannerId);
    }

    @Override
    public int updateByPrimaryKeySelective(Banner record) {
        return bannerDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Banner record) {
        return bannerDao.updateByPrimaryKey(record);
    }

    @Override
    public List<Banner> list(Map<String, Object> map) {
        return bannerDao.list(map);
    }

    @Override
    public Long getTotal(Map<String, Object> map) {
        return bannerDao.getTotal(map);
    }
}
