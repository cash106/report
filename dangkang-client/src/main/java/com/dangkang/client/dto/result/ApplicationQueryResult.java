package com.dangkang.client.dto.result;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @date 2023/1/11 10:46
 */
public class ApplicationQueryResult<T> extends PageQueryResult{

    /**
     * 查询多条数据返回
     */
    private List<T> list;
    /**
     * 查询单条数据返回
     */
    private T t;

    public void of(PageInfo<T> pageInfo){
        if(pageInfo != null){
            this.setTotalSize(pageInfo.getTotal());
            this.setTotalPages(pageInfo.getPages());
            this.setCurrentIndex(pageInfo.getPageNum());
            this.setCurrentIndex(pageInfo.getPageNum());
            this.setPageSize(pageInfo.getPageSize());
            this.setList(pageInfo.getList());
        }
    }


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
