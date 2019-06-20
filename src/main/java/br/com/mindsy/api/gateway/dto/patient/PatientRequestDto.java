package br.com.mindsy.api.gateway.dto.patient;

import br.com.mindsy.api.gateway.dto.enums.ManualDomainEnum;
import br.com.mindsy.api.gateway.dto.enums.PhoneTypeEnum;
import br.com.mindsy.api.gateway.dto.enums.StatusPatientEnum;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class PatientRequestDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank
    @Size(min = 3)
    private String name;
    @NotNull
    private StatusPatientEnum status;
    @NotBlank
    private String email;
    @NotBlank
    @Size(min = 8, max = 15)
    private String phoneNumber;
    @NotNull
    private PhoneTypeEnum phoneType;
    @NotBlank
    private String birthDate;
    @NotBlank
    private String kinshipDegree;
    @NotBlank
    private String scholarity;
    @NotBlank
    private String observation;
    @NotNull
    private ManualDomainEnum manualDomain;
    private String registryNumberPat;
    @NotBlank
    private String registryNumberAcc;
    @NotBlank
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

    public ManualDomainEnum getManualDomain() {
        return manualDomain;
    }

    public void setManualDomain(ManualDomainEnum manualDomain) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
