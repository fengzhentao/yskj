package com.yskj.Entity;

public class ProductTwoType {
    private Integer twoTypeId;

    private String twoTypeName;

    private Integer oneTypeId;

    private Integer languageType;

    private Integer recommend;

    private String imageUrl;

    //判断选中那个二类菜单
    private int openTwoType;

    private String oneTypeName;

    public String getOneTypeName() {
        return oneTypeName;
    }

    public void setOneTypeName(String oneTypeName) {
        this.oneTypeName = oneTypeName;
    }

    public int getOpenTwoType() {
        return openTwoType;
    }

    public void setOpenTwoType(int openTwoType) {
        this.openTwoType = openTwoType;
    }

    public Integer getTwoTypeId() {
        return twoTypeId;
    }

    public void setTwoTypeId(Integer twoTypeId) {
        this.twoTypeId = twoTypeId;
    }

    public String getTwoTypeName() {
        return twoTypeName;
    }

    public void setTwoTypeName(String twoTypeName) {
        this.twoTypeName = twoTypeName == null ? null : twoTypeName.trim();
    }

    public Integer getOneTypeId() {
        return oneTypeId;
    }

    public void setOneTypeId(Integer oneTypeId) {
        this.oneTypeId = oneTypeId;
    }

    public Integer getLanguageType() {
        return languageType;
    }

    public void setLanguageType(Integer languageType) {
        this.languageType = languageType;
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
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }
}