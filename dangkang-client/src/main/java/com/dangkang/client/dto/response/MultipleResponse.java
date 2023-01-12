package com.dangkang.client.dto.response;

import com.dangkang.client.dto.response.resultdto.QueryResultDTO;

import java.util.List;
import java.util.Map;

/**
 * @date 2023/1/11 17:00
 */
public class MultipleResponse<T> extends AbstractResponse {

    private int totalPages;//总页数
    private long totalSize;//总记录数
    private int currentIndex;//当前页码
    private int pageSize;//每页记录数
    private int startPosition;//当前页起始位置
    private int endPosition;//当前页结束位置

    private List<T> data;

    public  MultipleResponse  buildPage(Map<String, Object> pages) {
        this.setTotalSize((long) pages.get("totalSize"));
        this.setTotalPages((int) pages.get("totalPages"));
        this.setCurrentIndex((int) pages.get("currentIndex"));
        this.setPageSize((int) pages.get("pageSize"));
        this.setData((List<T>)pages.get("dataList"));
        return this;
    }


    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(int startPosition) {
        this.startPosition = startPosition;
    }

    public int getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(int endPosition) {
        this.endPosition = endPosition;
    }
}
