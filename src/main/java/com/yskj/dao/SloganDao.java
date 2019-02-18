package com.yskj.dao;

import com.yskj.Entity.Slogan;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SloganDao {
    int deleteByPrimaryKey(Integer sloganId);

    int insert(Slogan record);

    int insertSelective(Slogan record);

    Slogan selectByPrimaryKey(Integer sloganId);

    int updateByPrimaryKeySelective(Slogan record);

    int updateByPrimaryKey(Slogan record);

    /**
     * 分页查询产品信息
     * @param map
     * @return
     */
    public List<Slogan> list(Map<String,Object> map);

    /**
     * 获取总记录数
     * @param map
     * @return
     */
    public Long getTotal(Map<String,Object> map);
}