package com.dangkang.client.dto.response.resultdto;

/**
 * @date 2023/1/11 17:17
 */
public class QueryResultDTO {
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
