package com.yskj.service;

import com.yskj.Entity.Product;
import com.yskj.dto.ProductVo;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/5.
 */
public interface ProductService {

    /**
     * 分页查询产品信息
     * @param map
     * @return
     */
    public List<Product> list(Map<String,Object> map);

    /**
     * 获取总记录数
     * @param map
     * @return
     */
    public Long getTotal(Map<String,Object> map);

    int deleteByPrimaryKey(Integer productId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer productId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKeyWithBLOBs(Product record);

    int updateByPrimaryKey(Product record);

    public List<ProductVo> getList(Product product);
    public ProductVo getProductDetailById(Integer productId);
}
