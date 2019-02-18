package com.yskj.dto;

import com.yskj.Entity.Attachment;
import com.yskj.Entity.Product;

/**
 * Created by Administrator on 2017/3/11.
 */
public class GoodListVo extends Product{
    private Attachment attachment;

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }
}
