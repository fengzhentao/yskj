package com.yskj.service;

import com.yskj.Entity.Attachment;

import java.util.List;

/**
 * Created by Administrator on 2017/3/8.
 */
public interface AttachmentService {

    int deleteByPrimaryKey(Integer attachmentId);

    int insert(Attachment record);

    int insertSelective(Attachment record);

    Attachment selectByPrimaryKey(Integer attachmentId);

    int updateByPrimaryKeySelective(Attachment record);

    int updateByPrimaryKey(Attachment record);

    List<Attachment> selectList(Attachment attachment);
}
