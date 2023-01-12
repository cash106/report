package com.dangkang.client.dto.request;

/**
 * @date 2023/1/11 17:08
 */
public class QueryRequest extends AbstractRequest {

    private int index;//页码
    private int size;//页大小

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
