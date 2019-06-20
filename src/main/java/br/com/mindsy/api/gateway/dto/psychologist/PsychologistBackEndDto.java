package br.com.mindsy.api.gateway.dto.psychologist;

import java.io.Serializable;

public class PsychologistBackEndDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String email;
    private String number;
    private String telephone_type;
    private String crp;
    private String password;
    private String date_of_birth;
    private String registry_number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getRegistry_number() {
        return registry_number;
    }

    public void setRegistry_number(String registry_number) {
        this.registry_number = registry_number;
    }
}
