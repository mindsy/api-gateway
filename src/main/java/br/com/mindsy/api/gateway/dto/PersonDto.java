package br.com.mindsy.api.gateway.dto;

import java.io.Serializable;
import java.util.List;

public class PersonDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id_person;
    private String name;
    private String email;
    private List<PhoneBackendDto> telephone;

    public String getId_person() {
        return id_person;
    }

    public void setId_person(String id_person) {
        this.id_person = id_person;
    }

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

    public List<PhoneBackendDto> getTelephone() {
        return telephone;
    }

    public void setTelephone(List<PhoneBackendDto> telephone) {
        this.telephone = telephone;
    }
}
