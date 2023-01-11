package com.dangkang.client.dto.protocol.request;

/**
 * @date 2023/1/11 14:03
 */
public class QueryRequest {

    private int index;//页码
    private int size;//每页记录数


    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
