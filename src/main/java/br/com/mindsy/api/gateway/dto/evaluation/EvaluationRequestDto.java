package br.com.mindsy.api.gateway.dto.evaluation;

import java.io.Serializable;

public class EvaluationRequestDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String conclusion;
    private String anamnese;
    private String startDate;
    private String endDate;
    private String crp;
    private Long idPatient;

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public void setAnamnese(String anamnese) {
        this.anamnese = anamnese;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setCrp(String crp) {
        this.crp = crp;
    }

    public void setIdPatient(Long idPatient) {
        this.idPatient = idPatient;
    }
}
