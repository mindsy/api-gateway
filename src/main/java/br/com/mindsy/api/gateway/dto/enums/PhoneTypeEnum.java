package br.com.mindsy.api.gateway.dto.enums;

public enum PhoneTypeEnum {

    COMMERCIAL("comercial"),
    RESIDENTIAL("residencial"),
    PERSONAL("pessoal");

    private String descritption;

    PhoneTypeEnum(String descritption) {
        this.descritption = descritption;
    }

    public String getDescritption() {
        return descritption;
    }

    public void setDescritption(String descritption) {
        this.descritption = descritption;
    }
}
