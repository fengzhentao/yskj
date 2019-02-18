package com.yskj.dao;

import com.yskj.Entity.Banner;
import com.yskj.Entity.News;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface NewsDao {
    int deleteByPrimaryKey(Integer newsId);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Integer newsId);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKeyWithBLOBs(News record);

    int updateByPrimaryKey(News record);

    /**
     * 分页查询产品信息
     * @param map
     * @return
     */
    public List<News> list(Map<String,Object> map);

    /**
     * 获取总记录数
     * @param map
     * @return
     */
    public Long getTotal(Map<String,Object> map);

    News selectByNewsType(Integer newsType);

    /**
     * 获取上一个
     * @param newsId
     * @return
     */
    public News getLastNews(Integer newsId);

    /**
     * 获取下一个
     * @param newsId
     * @return
     */
    public News getNextNews(Integer newsId);
}