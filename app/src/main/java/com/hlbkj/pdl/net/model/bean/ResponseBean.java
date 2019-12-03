package com.hlbkj.pdl.net.model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 47804 on 2019/8/20.
 * 请求服务器的参数实体类
 */

public class ResponseBean implements Serializable{
    private ParamsBean params;
    private String token;
    private PageBean page;

    public PageBean getPage() {
        return page;
    }

    public void setPage(PageBean page) {
        this.page = page;
    }

    public ParamsBean getParams() {
        return params;
    }

    public void setParams(ParamsBean params) {
        this.params = params;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public static class ParamsBean {

    }

    public static class PageBean {
        /**
         * pageNum : 1
         * pageSize : 10
         */

        private Integer pageNum;
        private Integer pageSize;

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
    }
}
