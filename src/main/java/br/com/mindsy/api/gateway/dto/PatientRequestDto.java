package br.com.mindsy.api.gateway.dto;

import br.com.mindsy.api.gateway.dto.enums.PhoneTypeEnum;
import br.com.mindsy.api.gateway.dto.enums.StatusPatientEnum;

import java.io.Serializable;

public class PatientRequestDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private StatusPatientEnum status;
    private String phoneNumber;
    private PhoneTypeEnum phoneType;
    private String birthDate;
    private String kinshipDegree;
    private String scholarity;
    private String observation;
    private String manualDomain;
    private String registryNumberPat;
    private String registryNumberAcc;
    private String crp;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StatusPatientEnum getStatus() {
        return status;
    }

    public void setStatus(StatusPatientEnum status) {
        this.status = status;
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getKinshipDegree() {
        return kinshipDegree;
    }

    public void setKinshipDegree(String kinshipDegree) {
        this.kinshipDegree = kinshipDegree;
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

    public String getRegistryNumberAcc() {
        return registryNumberAcc;
    }

    public void setRegistryNumberAcc(String registryNumberAcc) {
        this.registryNumberAcc = registryNumberAcc;
    }

    public String getCrp() {
        return crp;
    }

    public void setCrp(String crp) {
        this.crp = crp;
    }
}
