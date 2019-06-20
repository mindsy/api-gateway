package br.com.mindsy.api.gateway.dto.authentication;

import java.io.Serializable;

public class AuthenticationResponseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String access_token;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }
}
