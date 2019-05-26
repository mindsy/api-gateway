package br.com.mindsy.api.gateway.dto;

import java.io.Serializable;

public class PsychologistResponseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
