package br.com.mindsy.api.gateway.dto;

import java.io.Serializable;

public class PatientBackendDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String status;
    private String number;
    private String telephone_type;
    private String date_of_birth;
    private String kinship_degree;
    private String scholarity;
    private String observation;
    private String manual_domain;
    private String registry_number_pat;
    private String registry_number_acc;
    private String crp;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getKinship_degree() {
        return kinship_degree;
    }

    public void setKinship_degree(String kinship_degree) {
        this.kinship_degree = kinship_degree;
    }

    public String getScholarity() {
        return scholarity;
    }

    public void setScholarity(String scholarity) {
        this.scholarity = scholarity;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getManual_domain() {
        return manual_domain;
    }

    public void setManual_domain(String manual_domain) {
        this.manual_domain = manual_domain;
    }

    public String getRegistry_number_pat() {
        return registry_number_pat;
    }

    public void setRegistry_number_pat(String registry_number_pat) {
        this.registry_number_pat = registry_number_pat;
    }

    public String getRegistry_number_acc() {
        return registry_number_acc;
    }

    public void setRegistry_number_acc(String registry_number_acc) {
        this.registry_number_acc = registry_number_acc;
    }

    public String getCrp() {
        return crp;
    }

    public void setCrp(String crp) {
        this.crp = crp;
    }
}
