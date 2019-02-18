package com.yskj.dao;

import com.yskj.Entity.Attachment;

import java.util.List;

public interface AttachmentDao {
    int deleteByPrimaryKey(Integer attachmentId);

    int insert(Attachment record);

    int insertSelective(Attachment record);

    Attachment selectByPrimaryKey(Integer attachmentId);

    int updateByPrimaryKeySelective(Attachment record);

    int updateByPrimaryKey(Attachment record);

    List<Attachment> selectList(Attachment attachment);
}