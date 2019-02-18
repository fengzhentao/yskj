package com.yskj.Entity;

import java.util.Date;

public class Banner {
    private Integer bannerId;

    private String bannerUrl;

    private String bannerImage;

    private String bannerName;

    private Date createTime;

    private Integer bannerLanguage;

    public Integer getBannerId() {
        return bannerId;
    }

    public void setBannerId(Integer bannerId) {
        this.bannerId = bannerId;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl == null ? null : bannerUrl.trim();
    }

    public String getBannerImage() {
        return bannerImage;
    }

    public void setBannerImage(String bannerImage) {
        this.bannerImage = bannerImage == null ? null : bannerImage.trim();
    }

    public String getBannerName() {
        return bannerName;
    }

    public void setBannerName(String bannerName) {
        this.bannerName = bannerName == null ? null : bannerName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getBannerLanguage() {
        return bannerLanguage;
    }

    public void setBannerLanguage(Integer bannerLanguage) {
        this.bannerLanguage = bannerLanguage;
    }
}