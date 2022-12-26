package com.ddd.domain.model.trade;

/**
 * @author anzj
 * @date 2022/12/23 10:22
 */
public class DomainObject {


    public DomainObject() {
    }

    public DomainObject(String email, String phoneNumber) {
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    private String email;

    private String phoneNumber;


    public void toDo(){
        //todo 领域对象业务逻辑
    }


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
