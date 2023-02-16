package com.dangkang.domain.examplecontext.ability.facade;

/**
 * @date 2022/12/30 13:57
 */
public class CallRequestDto<T> {

    private String email;
    private String phoneNumber;

    private T callData;

    public String getEmail() {
        return email;
    }

    public CallRequestDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public CallRequestDto setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public T getCallData() {
        return callData;
    }

    public void setCallData(T callData) {
        this.callData = callData;
    }
}
