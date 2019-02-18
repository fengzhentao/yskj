package com.yskj.dao;

import com.yskj.Entity.ProductOneType;
import com.yskj.dto.LeftClassVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ProductOneTypeDao {
    int deleteByPrimaryKey(Integer oneTypeId);

    int insert(ProductOneType record);

    int insertSelective(ProductOneType record);

    ProductOneType selectByPrimaryKey(Integer oneTypeId);

    int updateByPrimaryKeySelective(ProductOneType record);

    int updateByPrimaryKey(ProductOneType record);

    /**
     * 分页查询产品一级分类信息
     * @param map
     * @return
     */
    public List<ProductOneType> list(Map<String,Object> map);

    /**
     * 获取总记录数
     * @param map
     * @return
     */
    public Long getTotal(Map<String,Object> map);

    public List<LeftClassVo> getLeftClass();
}