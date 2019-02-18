package com.yskj.dto;

import com.yskj.Entity.ProductOneType;
import com.yskj.Entity.ProductTwoType;

import java.util.List;

/**
 * Created by Administrator on 2017/3/11.
 */
public class GoodClassVo extends ProductOneType{
    private List<ProductTwoType> productTwoTypes;

    public List<ProductTwoType> getProductTwoTypes() {
        return productTwoTypes;
    }

    public void setProductTwoTypes(List<ProductTwoType> productTwoTypes) {
        this.productTwoTypes = productTwoTypes;
    }
}
