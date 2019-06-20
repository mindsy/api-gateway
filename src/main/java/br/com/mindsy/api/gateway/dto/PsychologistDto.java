package br.com.mindsy.api.gateway.dto;

import java.io.Serializable;

public class PsychologistDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String crp;
    private String date_of_birth;
    private String password;

    public String getCrp() {
        return crp;
    }

    public void setCrp(String crp) {
        this.crp = crp;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
