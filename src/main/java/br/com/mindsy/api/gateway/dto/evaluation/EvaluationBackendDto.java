package br.com.mindsy.api.gateway.dto.evaluation;

import java.io.Serializable;

public class EvaluationBackendDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String conclusion;
    private String anamnese;
    private String dt_start;
    private String dt_end;
    private String crp;
    private Long id_patient;

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public void setAnamnese(String anamnese) {
        this.anamnese = anamnese;
    }

    public void setDt_start(String dt_start) {
        this.dt_start = dt_start;
    }

    public void setDt_end(String dt_end) {
        this.dt_end = dt_end;
    }

    public void setCrp(String crp) {
        this.crp = crp;
    }

    public void setId_patient(Long id_patient) {
        this.id_patient = id_patient;
    }
}
