package com.dangkang.client.dto.request.requestdto;

import com.baidu.unbiz.fluentvalidator.annotation.FluentValidate;
import com.dangkang.client.dto.request.AbstractRequest;
import com.dangkang.infrastructure.validator.PhoneNumberValidator;

import javax.validation.constraints.NotNull;

public class ApplicationServiceRequestDTO extends AbstractRequest {

    @NotNull
    private String email;
    @FluentValidate(PhoneNumberValidator.class)
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
