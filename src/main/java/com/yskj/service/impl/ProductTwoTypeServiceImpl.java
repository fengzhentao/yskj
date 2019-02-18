package com.yskj.service.impl;

import com.yskj.Entity.ProductTwoType;
import com.yskj.dao.ProductTwoTypeDao;
import com.yskj.dto.TwoTypeVo;
import com.yskj.service.ProductTwoTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/5.
 */
@Service
public class ProductTwoTypeServiceImpl implements ProductTwoTypeService {

    @Autowired
    private ProductTwoTypeDao productTwoTypeDao;

    @Override
    public List<ProductTwoType> list(Map<String, Object> map) {
        return productTwoTypeDao.list(map);
    }

    @Override
    public Long getTotal(Map<String, Object> map) {
        return productTwoTypeDao.getTotal(map);
    }

    @Override
    public int deleteByPrimaryKey(Integer twoTypeId) {
        return productTwoTypeDao.deleteByPrimaryKey(twoTypeId);
    }

    @Override
    public int insert(ProductTwoType record) {
        return productTwoTypeDao.insert(record);
    }

    @Override
    public int insertSelective(ProductTwoType record) {
        return productTwoTypeDao.insertSelective(record);
    }

    @Override
    public ProductTwoType selectByPrimaryKey(Integer twoTypeId) {
        return productTwoTypeDao.selectByPrimaryKey(twoTypeId);
    }

    @Override
    public int updateByPrimaryKeySelective(ProductTwoType record) {
        return productTwoTypeDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ProductTwoType record) {
        return productTwoTypeDao.updateByPrimaryKey(record);
    }

    @Override
    public List<TwoTypeVo> getList() {
        return productTwoTypeDao.getList();
    }
}
