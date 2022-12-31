package com.dangkang.infrastructure.repositoryimpl.dataobject;

/**
 * @author anzj
 * @date 2022/12/19 15:00
 */
public class DomainObjectDO {

    private String email;

    private String phoneNumber;

    public DomainObjectDO(String email, String phoneNumber) {
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
