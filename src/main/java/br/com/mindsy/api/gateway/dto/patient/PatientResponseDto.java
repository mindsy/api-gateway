package br.com.mindsy.api.gateway.dto.patient;

import br.com.mindsy.api.gateway.dto.PhoneDto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PatientResponseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String email;
    private List<PhoneDto> phone = new ArrayList<>();
    private String scholarity;
    private String observation;
    private String manualDomain;
    private String registryNumberPat;
    private String birthDate;
    private String status;
    private String registryNumberAcc;
    private String kinshipDegree;
    private Long idPatient;

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

    public String getManualDomain() {
        return manualDomain;
    }

    public void setManualDomain(String manualDomain) {
        this.manualDomain = manualDomain;
    }

    public String getRegistryNumberPat() {
        return registryNumberPat;
    }

    public void setRegistryNumberPat(String registryNumberPat) {
        this.registryNumberPat = registryNumberPat;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRegistryNumberAcc() {
        return registryNumberAcc;
    }

    public void setRegistryNumberAcc(String registryNumberAcc) {
        this.registryNumberAcc = registryNumberAcc;
    }

    public String getKinshipDegree() {
        return kinshipDegree;
    }

    public void setKinshipDegree(String kinshipDegree) {
        this.kinshipDegree = kinshipDegree;
    }

    public Long getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Long idPatient) {
        this.idPatient = idPatient;
    }

    public List<PhoneDto> getPhone() {
        return phone;
    }

    public void setPhone(List<PhoneDto> phone) {
        this.phone = phone;
    }
}
