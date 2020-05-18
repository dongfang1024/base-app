package com.bat.common.pojo;

import java.util.List;


public class PageResult<T> {

    private List<T> items;
    private Long total;
    private Integer totalPage;

    public PageResult() {
    }

    public PageResult(List<T> items, Long total) {
        this.items = items;
        this.total = total;
    }

    public PageResult(List<T> items, Long total, Integer totalPage) {
        this.items = items;
        this.total = total;
        this.totalPage = totalPage;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
