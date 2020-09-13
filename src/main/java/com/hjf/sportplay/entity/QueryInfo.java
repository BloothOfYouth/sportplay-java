package com.hjf.sportplay.entity;

import java.io.Serializable;

/**
 * @author hjf
 */
public class QueryInfo implements Serializable {
    /**
     * 查询信息
     */
    private String query = "";
    /**
     * 当前页
     */
    private Integer pageNum = 1;
    /**
     * 每页最大数
     */
    private Integer pageSize = 3;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "QueryInfo{" +
                "query='" + query + '\'' +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
