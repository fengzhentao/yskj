package com.yskj.service;

import com.yskj.Entity.ProductOneType;
import com.yskj.dto.LeftClassVo;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/5.
 */
public interface ProductOneTypeService {

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

    int deleteByPrimaryKey(Integer oneTypeId);

    int insert(ProductOneType record);

    int insertSelective(ProductOneType record);

    ProductOneType selectByPrimaryKey(Integer oneTypeId);

    int updateByPrimaryKeySelective(ProductOneType record);

    int updateByPrimaryKey(ProductOneType record);

    public List<LeftClassVo> getLeftClass();

}
