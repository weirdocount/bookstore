package com.weirdo.dataobject;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by DQ on 2015/12/22.
 */
public class Cart {

    private Map<Integer,CartItem> map = new HashMap<Integer, CartItem>();
    private int totalNum = 0;
    private double totalMoney = 0.0;

    public Cart() {
    }

    /**
     * 获取map的values的值
     * @return
     */
    public Collection<CartItem> getItems(){
        return map.values();
    }

    public Map<Integer, CartItem> getMap() {
        return map;
    }

    public void setMap(Map<Integer, CartItem> map) {
        this.map = map;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "map=" + map +
                ", totalNum=" + totalNum +
                ", totalMoney=" + totalMoney +
                '}';
    }
}
