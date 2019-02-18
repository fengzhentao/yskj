package com.yskj.Entity;

public class Product {
    private Integer productId;

    private String productName;

    private Integer twoTypeId;

    private String productModel;

    private Integer languageType;

    private Integer recommend;

    private Integer oneTypeId;

    private String productSize;

    private String productContext;

    private String productUrl;

    private Integer start;

    private Integer size;

    private String twoTypeName;

    public String getTwoTypeName() {
        return twoTypeName;
    }

    public void setTwoTypeName(String twoTypeName) {
        this.twoTypeName = twoTypeName;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public Integer getTwoTypeId() {
        return twoTypeId;
    }

    public void setTwoTypeId(Integer twoTypeId) {
        this.twoTypeId = twoTypeId;
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel == null ? null : productModel.trim();
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

    public Integer getOneTypeId() {
        return oneTypeId;
    }

    public void setOneTypeId(Integer oneTypeId) {
        this.oneTypeId = oneTypeId;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public String getProductContext() {
        return productContext;
    }

    public void setProductContext(String productContext) {
        this.productContext = productContext;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }
}