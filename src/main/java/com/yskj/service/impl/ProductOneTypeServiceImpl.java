package com.yskj.service.impl;

import com.yskj.Entity.ProductOneType;
import com.yskj.dao.ProductOneTypeDao;
import com.yskj.dto.LeftClassVo;
import com.yskj.service.ProductOneTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/5.
 */
@Service
public class ProductOneTypeServiceImpl implements ProductOneTypeService {

    @Autowired
    private ProductOneTypeDao productOneTypeDao;

    @Override
    public List<ProductOneType> list(Map<String, Object> map) {
        return productOneTypeDao.list(map);
    }

    @Override
    public Long getTotal(Map<String, Object> map) {
        return productOneTypeDao.getTotal(map);
    }

    @Override
    public int deleteByPrimaryKey(Integer oneTypeId) {
        return productOneTypeDao.deleteByPrimaryKey(oneTypeId);
    }

    @Override
    public int insert(ProductOneType record) {
        return productOneTypeDao.insert(record);
    }

    @Override
    public int insertSelective(ProductOneType record) {
        return productOneTypeDao.insertSelective(record);
    }

    @Override
    public ProductOneType selectByPrimaryKey(Integer oneTypeId) {
        return productOneTypeDao.selectByPrimaryKey(oneTypeId);
    }

    @Override
    public int updateByPrimaryKeySelective(ProductOneType record) {
        return productOneTypeDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ProductOneType record) {
        return productOneTypeDao.updateByPrimaryKey(record);
    }

    @Override
    public List<LeftClassVo> getLeftClass() {
        return productOneTypeDao.getLeftClass();
    }
}
