package com.yskj.service.impl;

import com.yskj.Entity.News;
import com.yskj.dao.NewsDao;
import com.yskj.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by jyd on 2017/3/13.
 */
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDao newsDao;
    @Override
    public int deleteByPrimaryKey(Integer newsId) {
        return newsDao.deleteByPrimaryKey(newsId);
    }

    @Override
    public int insert(News record) {
        return newsDao.insert(record);
    }

    @Override
    public int insertSelective(News record) {
        return newsDao.insertSelective(record);
    }

    @Override
    public News selectByPrimaryKey(Integer newsId) {
        return newsDao.selectByPrimaryKey(newsId);
    }

    @Override
    public int updateByPrimaryKeySelective(News record) {
        return newsDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(News record) {
        return newsDao.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByPrimaryKey(News record) {
        return newsDao.updateByPrimaryKey(record);
    }

    @Override
    public List<News> list(Map<String, Object> map) {
        return newsDao.list(map);
    }

    @Override
    public Long getTotal(Map<String, Object> map) {
        return newsDao.getTotal(map);
    }

    @Override
    public News selectByNewsType(Integer newsType) {
        return newsDao.selectByNewsType(newsType);
    }

    @Override
    public News getLastNews(Integer newsId) {
        return newsDao.getLastNews(newsId);
    }

    @Override
    public News getNextNews(Integer newsId) {
        return newsDao.getNextNews(newsId);
    }


}
