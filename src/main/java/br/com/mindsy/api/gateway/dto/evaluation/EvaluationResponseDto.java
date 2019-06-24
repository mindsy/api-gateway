package br.com.mindsy.api.gateway.dto.evaluation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EvaluationResponseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<EvaluationDto> evaluations = new ArrayList<>();


    public List<EvaluationDto> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(List<EvaluationDto> evaluations) {
        this.evaluations = evaluations;
    }
}
