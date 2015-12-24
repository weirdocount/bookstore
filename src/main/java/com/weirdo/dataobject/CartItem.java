package com.weirdo.dataobject;

/**
 * Created by DQ on 2015/12/22.
 */
public class CartItem {

    private Integer id;
    private int num = 1;
    private double money = 0.0;
    private double price = 0.0;
    private String title = "-";

    public CartItem() {
    }

    public CartItem(Integer id, int num, double money, double price) {
        this.id = id;
        this.num = num;
        this.money = money;
        this.price = price;
    }

    public CartItem(Book book,int num) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.price = book.getPrice();
        this.num = num;
        this.money = num * price;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getMoney() {
        money = price * num;
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", num=" + num +
                ", money=" + money +
                ", price=" + price +
                ", title='" + title + '\'' +
                '}';
    }
}
