package com.yskj.service;

import com.yskj.Entity.Logo;

import java.util.List;
import java.util.Map;

/**
 * Created by jyd on 2017/3/22.
 */
public interface LogoService {

    int deleteByPrimaryKey(Integer logoId);

    int insert(Logo record);

    int insertSelective(Logo record);

    Logo selectByPrimaryKey(Integer logoId);

    int updateByPrimaryKeySelective(Logo record);

    int updateByPrimaryKey(Logo record);
    /**
     * 分页查询产品信息
     * @param map
     * @return
     */
    public List<Logo> list(Map<String,Object> map);

    /**
     * 获取总记录数
     * @param map
     * @return
     */
    public Long getTotal(Map<String,Object> map);
}
