package br.com.mindsy.api.gateway.dto.enums;

public enum StatusPatientEnum {

    IN_PROGRESS("andamento"),
    FINALIZED("finalizado"),
    WAITING("aguardando");

    public String description;

    StatusPatientEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
