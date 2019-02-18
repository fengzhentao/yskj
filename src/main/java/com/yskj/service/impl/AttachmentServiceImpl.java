package com.yskj.service.impl;

import com.yskj.Entity.Attachment;
import com.yskj.dao.AttachmentDao;
import com.yskj.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/3/8.
 */
@Service
public class AttachmentServiceImpl implements AttachmentService {

    @Autowired
    private AttachmentDao attachmentDao;
    @Override
    public int deleteByPrimaryKey(Integer attachmentId) {
        return attachmentDao.deleteByPrimaryKey(attachmentId);
    }

    @Override
    public int insert(Attachment record) {
        return attachmentDao.insert(record);
    }

    @Override
    public int insertSelective(Attachment record) {
        return attachmentDao.insertSelective(record);
    }

    @Override
    public Attachment selectByPrimaryKey(Integer attachmentId) {
        return attachmentDao.selectByPrimaryKey(attachmentId);
    }

    @Override
    public int updateByPrimaryKeySelective(Attachment record) {
        return attachmentDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Attachment record) {
        return attachmentDao.updateByPrimaryKey(record);
    }

    @Override
    public List<Attachment> selectList(Attachment attachment) {
        return attachmentDao.selectList(attachment);
    }
}
