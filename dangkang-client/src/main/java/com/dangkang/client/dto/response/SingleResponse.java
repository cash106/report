package com.dangkang.client.dto.response;

/**
 * @date 2023/1/11 16:55
 */
public class SingleResponse<T> extends Response {

    private T data;


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
