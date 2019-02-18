package com.yskj.Entity;

public class ProductOneType {
    private Integer oneTypeId;

    private String oneTypeName;

    private Integer recommend;

    private String imageUrl;

    private Integer languageType;
    private String languageTypeString;

    public Integer getOneTypeId() {
        return oneTypeId;
    }

    public void setOneTypeId(Integer oneTypeId) {
        this.oneTypeId = oneTypeId;
    }

    public String getOneTypeName() {
        return oneTypeName;
    }

    public void setOneTypeName(String oneTypeName) {
        this.oneTypeName = oneTypeName == null ? null : oneTypeName.trim();
    }

    public Integer getLanguageType() {
        return languageType;
    }

    public void setLanguageType(Integer languageType) {
        this.languageType = languageType;
    }

    public void setLanguageTypeString(String languageTypeName) {
        this.languageTypeString = languageTypeString;
    }

    public Integer getRecommend() {
        return recommend;
    }

    public void setRecommend(Integer recommend) {
        this.recommend = recommend;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLanguageTypeString() {
        return languageTypeString;
    }
}