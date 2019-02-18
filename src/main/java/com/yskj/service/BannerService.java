package com.yskj.service;

import com.yskj.Entity.Banner;
import com.yskj.Entity.Product;

import java.util.List;
import java.util.Map;

/**
 * Created by jyd on 2017/3/13.
 */
public interface BannerService {

    int deleteByPrimaryKey(Integer bannerId);

    int insert(Banner record);

    int insertSelective(Banner record);

    Banner selectByPrimaryKey(Integer bannerId);

    int updateByPrimaryKeySelective(Banner record);

    int updateByPrimaryKey(Banner record);

    /**
     * 分页查询产品信息
     * @param map
     * @return
     */
    public List<Banner> list(Map<String,Object> map);

    /**
     * 获取总记录数
     * @param map
     * @return
     */
    public Long getTotal(Map<String,Object> map);
}
