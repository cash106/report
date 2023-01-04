package com.dangkang.client.dto;


import org.hibernate.validator.constraints.NotBlank;

public class ApplicationServiceDTO {

    private String email;
    @NotBlank
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
