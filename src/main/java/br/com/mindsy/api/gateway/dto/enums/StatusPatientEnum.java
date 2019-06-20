package br.com.mindsy.api.gateway.dto.enums;

public enum StatusPatientEnum {

    IN_PROGRESS("andamento"),
    FINALIZED("finalizado"),
    WAITING("aguardando");

    private String description;

    StatusPatientEnum(String description) {
        this.description = description;
    }
}
