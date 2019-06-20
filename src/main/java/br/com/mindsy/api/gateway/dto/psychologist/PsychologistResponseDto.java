package br.com.mindsy.api.gateway.dto.psychologist;

import br.com.mindsy.api.gateway.dto.HospitalDto;
import br.com.mindsy.api.gateway.dto.PersonDto;

import java.io.Serializable;

public class PsychologistResponseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private PersonDto person;
    private PsychologistDto psychologist;
    private HospitalDto hospital;

    public PersonDto getPerson() {
        return person;
    }

    public void setPerson(PersonDto person) {
        this.person = person;
    }

    public PsychologistDto getPsychologist() {
        return psychologist;
    }

    public void setPsychologist(PsychologistDto psychologist) {
        this.psychologist = psychologist;
    }

    public HospitalDto getHospital() {
        return hospital;
    }

    public void setHospital(HospitalDto hospital) {
        this.hospital = hospital;
    }
}
