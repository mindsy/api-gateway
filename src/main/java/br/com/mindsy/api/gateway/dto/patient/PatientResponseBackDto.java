package br.com.mindsy.api.gateway.dto.patient;

import br.com.mindsy.api.gateway.dto.PhoneBackendDto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PatientResponseBackDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String email;
    private List<PhoneBackendDto> telephone = new ArrayList<>();
    private Long id_patient;
    private String scholarity;
    private String observation;
    private String manual_domain;
    private String registry_number_pat;
    private String date_of_birth;
    private String status;
    private String registry_number_acc;
    private String kinship_degree;

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

    public Long getId_patient() {
        return id_patient;
    }

    public void setId_patient(Long id_patient) {
        this.id_patient = id_patient;
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

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRegistry_number_acc() {
        return registry_number_acc;
    }

    public void setRegistry_number_acc(String registry_number_acc) {
        this.registry_number_acc = registry_number_acc;
    }

    public String getKinship_degree() {
        return kinship_degree;
    }

    public void setKinship_degree(String kinship_degree) {
        this.kinship_degree = kinship_degree;
    }
}
