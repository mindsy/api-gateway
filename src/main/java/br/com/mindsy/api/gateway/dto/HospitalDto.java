package br.com.mindsy.api.gateway.dto;

import java.io.Serializable;

public class HospitalDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String registry_number;
    private String social_reason;

    public String getRegistry_number() {
        return registry_number;
    }

    public void setRegistry_number(String registry_number) {
        this.registry_number = registry_number;
    }

    public String getSocial_reason() {
        return social_reason;
    }

    public void setSocial_reason(String social_reason) {
        this.social_reason = social_reason;
    }
}
