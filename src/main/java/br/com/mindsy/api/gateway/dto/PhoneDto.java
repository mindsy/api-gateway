package br.com.mindsy.api.gateway.dto;

import java.io.Serializable;

public class PhoneDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String phoneNumber;
    private String phoneType;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }
}
