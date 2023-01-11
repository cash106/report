package com.dangkang.client.dto.response.resultdata;

/**
 * @date 2023/1/11 17:17
 */
public class QueryResultDataDTO {
    //todo 查询返回结果的数据属性定义
    private String email;
    private String phoneNumber;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
