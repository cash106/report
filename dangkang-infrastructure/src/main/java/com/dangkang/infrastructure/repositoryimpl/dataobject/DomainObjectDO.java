package com.dangkang.infrastructure.repositoryimpl.dataobject;

/**
 * @date 2022/12/19 15:00
 */
public class DomainObjectDO {

    private String email;

    private String phoneNumber;

    public DomainObjectDO(String email, String phoneNumber) {
        this.email = email;
        this.phoneNumber = phoneNumber;
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
