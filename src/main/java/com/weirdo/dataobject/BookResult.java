package com.weirdo.dataobject;

import java.util.List;

/**
 * Created by DQ on 2015/12/21.
 */
public class BookResult {
    private List<Book> books;
    private int total;
    private int size;
    private int pageNo;
    private int totalPages;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getTotalPages() {
        int result = 0;
        result = total / size;
        if (total % size != 0){
            result++;
        }
        this.setTotalPages(result);
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    @Override
    public String toString() {
        return "BookResult{" +
                "books=" + books +
                ", total=" + total +
                ", size=" + size +
                ", pageNo=" + pageNo +
                ", totalPages=" + totalPages +
                '}';
    }
}
