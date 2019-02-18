package com.yskj.Entity;

import java.util.Date;

public class Logo {
    private Integer logoId;

    private String logoUrl;

    private Integer recommend;

    private Integer logoType;

    private Date creatTime;

    private String logoTypeName;

    public Integer getLogoId() {
        return logoId;
    }

    public void setLogoId(Integer logoId) {
        this.logoId = logoId;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl == null ? null : logoUrl.trim();
    }

    public Integer getRecommend() {
        return recommend;
    }

    public void setRecommend(Integer recommend) {
        this.recommend = recommend;
    }

    public Integer getLogoType() {
        return logoType;
    }

    public void setLogoType(Integer logoType) {
        this.logoType = logoType;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public String getLogoTypeName() {
        return logoTypeName;
    }

    public void setLogoTypeName(String logoTypeName) {
        this.logoTypeName = logoTypeName;
    }
}