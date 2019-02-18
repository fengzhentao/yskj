package com.yskj.dao;

import com.yskj.Entity.Product;
import com.yskj.dto.ProductVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ProductDao {
    int deleteByPrimaryKey(Integer productId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer productId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKeyWithBLOBs(Product record);

    int updateByPrimaryKey(Product record);

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


    public List<ProductVo> getList(Product product);

    public ProductVo getProductDetailById(Integer productId);
}