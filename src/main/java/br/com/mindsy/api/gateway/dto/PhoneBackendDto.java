package br.com.mindsy.api.gateway.dto;

import java.io.Serializable;

public class PhoneBackendDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String number;
    private String telephone_type;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTelephone_type() {
        return telephone_type;
    }

    public void setTelephone_type(String telephone_type) {
        this.telephone_type = telephone_type;
    }
}
