package br.com.mindsy.api.gateway.dto.evaluation;

import java.io.Serializable;

public class EvaluationBackDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id_evaluation;
    private String conclusion;
    private String anamnese;
    private String dt_start;
    private String dt_end;

    public Long getId_evaluation() {
        return id_evaluation;
    }

    public void setId_evaluation(Long id_evaluation) {
        this.id_evaluation = id_evaluation;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public String getAnamnese() {
        return anamnese;
    }

    public void setAnamnese(String anamnese) {
        this.anamnese = anamnese;
    }

    public String getDt_start() {
        return dt_start;
    }

    public void setDt_start(String dt_start) {
        this.dt_start = dt_start;
    }

    public String getDt_end() {
        return dt_end;
    }

    public void setDt_end(String dt_end) {
        this.dt_end = dt_end;
    }
}
