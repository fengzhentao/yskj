package com.yskj.Entity;

public class Slogan {
    private Integer sloganId;

    private String sloganName;

    private String sloganContext;

    public Integer getSloganId() {
        return sloganId;
    }

    public void setSloganId(Integer sloganId) {
        this.sloganId = sloganId;
    }

    public String getSloganName() {
        return sloganName;
    }

    public void setSloganName(String sloganName) {
        this.sloganName = sloganName == null ? null : sloganName.trim();
    }

    public String getSloganContext() {
        return sloganContext;
    }

    public void setSloganContext(String sloganContext) {
        this.sloganContext = sloganContext == null ? null : sloganContext.trim();
    }
}