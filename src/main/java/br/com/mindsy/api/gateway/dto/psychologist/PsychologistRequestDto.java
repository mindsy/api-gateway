package br.com.mindsy.api.gateway.dto.psychologist;

import br.com.mindsy.api.gateway.dto.enums.PhoneTypeEnum;

import java.io.Serializable;

public class PsychologistRequestDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String email;
    private String phoneNumber;
    private PhoneTypeEnum phoneType;
    private String crp;
    private String password;
    private String birthDate;
    private String CNPJHospital;

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public PhoneTypeEnum getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneTypeEnum phoneType) {
        this.phoneType = phoneType;
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getCNPJHospital() {
        return CNPJHospital;
    }

    public void setCNPJHospital(String CNPJHospital) {
        this.CNPJHospital = CNPJHospital;
    }
}
