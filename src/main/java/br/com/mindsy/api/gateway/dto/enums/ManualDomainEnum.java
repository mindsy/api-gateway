package br.com.mindsy.api.gateway.dto.enums;

public enum ManualDomainEnum {

    DESTRO("destro"),
    CANHOTO("canhoto");

    public String description;

    ManualDomainEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
