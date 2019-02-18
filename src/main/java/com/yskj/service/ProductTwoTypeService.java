package com.yskj.service;

import com.yskj.Entity.ProductTwoType;
import com.yskj.dto.TwoTypeVo;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/5.
 */
public interface ProductTwoTypeService {
    /**
     * 分页查询产品二级分类信息
     * @param map
     * @return
     */
    public List<ProductTwoType> list(Map<String,Object> map);

    /**
     * 获取总记录数
     * @param map
     * @return
     */
    public Long getTotal(Map<String,Object> map);

    int deleteByPrimaryKey(Integer twoTypeId);

    int insert(ProductTwoType record);

    int insertSelective(ProductTwoType record);

    ProductTwoType selectByPrimaryKey(Integer twoTypeId);

    int updateByPrimaryKeySelective(ProductTwoType record);

    int updateByPrimaryKey(ProductTwoType record);

    public List<TwoTypeVo> getList();

}
