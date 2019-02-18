package com.yskj.service.impl;

import com.yskj.Entity.Product;
import com.yskj.dao.ProductDao;
import com.yskj.dto.ProductVo;
import com.yskj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/5.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> list(Map<String, Object> map) {
        return productDao.list(map);
    }

    @Override
    public Long getTotal(Map<String, Object> map) {
        return productDao.getTotal(map);
    }

    @Override
    public int deleteByPrimaryKey(Integer productId) {
        return productDao.deleteByPrimaryKey(productId);
    }

    @Override
    public int insert(Product record) {
        return productDao.insert(record);
    }

    @Override
    public int insertSelective(Product record) {
        return productDao.insertSelective(record);
    }

    @Override
    public Product selectByPrimaryKey(Integer productId) {
        return productDao.selectByPrimaryKey(productId);
    }

    @Override
    public int updateByPrimaryKeySelective(Product record) {
        return productDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(Product record) {
        return productDao.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByPrimaryKey(Product record) {
        return productDao.updateByPrimaryKey(record);
    }

    @Override
    public List<ProductVo> getList(Product product) {
        return productDao.getList(product);
    }

    @Override
    public ProductVo getProductDetailById(Integer productId) {
        return productDao.getProductDetailById(productId);
    }

}
