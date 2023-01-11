package com.dangkang.client.dto.protocol.response;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @date 2023/1/11 10:19
 */
public class ApplicationQueryDataResponse<T> extends ApplicationQueryResponse {
    /**
     * 查询多条数据返回
     */
    private List<T> list;
    /**
     * 查询单条数据返回
     */
    private T t;


    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
