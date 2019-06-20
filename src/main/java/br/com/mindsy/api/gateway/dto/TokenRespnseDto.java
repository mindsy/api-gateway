package br.com.mindsy.api.gateway.dto;

import java.io.Serializable;

public class TokenRespnseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String crp;
    private String token;

    public String getCrp() {
        return crp;
    }

    public void setCrp(String crp) {
        this.crp = crp;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
