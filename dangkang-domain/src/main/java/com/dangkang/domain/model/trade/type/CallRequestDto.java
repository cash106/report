package com.dangkang.domain.model.trade.type;

/**
 * @author anzj
 * @date 2022/12/30 13:57
 */
public class CallRequestDto<T> {
    private T callData;

    public T getCallData() {
        return callData;
    }

    public void setCallData(T callData) {
        this.callData = callData;
    }
}
