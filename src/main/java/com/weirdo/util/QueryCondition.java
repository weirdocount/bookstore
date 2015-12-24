package com.weirdo.util;

/**
 * Created by DQ on 2015/12/21.
 */
public class QueryCondition {
    private double minPrice = 0;
    private double maxPrice = Double.MAX_VALUE;
    private int pageSize = 5;
    private int pageNo = 1;

    public QueryCondition() {
    }

    public QueryCondition(double minPrice, double maxPrice, int pageSize, int pageNo) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.pageSize = pageSize;
        this.pageNo = pageNo;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


}
