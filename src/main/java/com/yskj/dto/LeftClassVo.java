package com.yskj.dto;

import com.yskj.Entity.ProductOneType;
import com.yskj.Entity.ProductTwoType;

import java.util.List;

/**
 * Created by Administrator on 2017/3/11.
 */
public class LeftClassVo extends ProductOneType {
    List<ProductTwoType> productTwoTypes;

    //判断那个一类菜单下面的二类菜单打开
    private int opentype;


    public int getOpentype() {
        return opentype;
    }

    public void setOpentype(int opentype) {
        this.opentype = opentype;
    }

    public List<ProductTwoType> getProductTwoTypes() {
        return productTwoTypes;
    }

    public void setProductTwoTypes(List<ProductTwoType> productTwoTypes) {
        this.productTwoTypes = productTwoTypes;
    }
}
