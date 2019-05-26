package br.com.mindsy.api.gateway.dto;

import java.io.Serializable;

public class AuthenticationRequestDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String crp;
    private String password;

    public String getCrp() {
        return crp;
    }

    public void setCrp(String crp) {
        this.crp = crp;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
