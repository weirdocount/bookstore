package com.weirdo.dataobject;

import java.sql.Date;

/**
 * Created by DQ on 2015/12/21.
 */
public class Book {
    private Integer id;
    private String author;
    private String title;
    private double price;
    //出版日期
    private Date publishingdate;
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getPublishingdate() {
        return publishingdate;
    }

    public void setPublishingdate(Date publishingdate) {
        this.publishingdate = publishingdate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", publishingdate=" + publishingdate +
                ", remark='" + remark + '\'' +
                '}';
    }
}
