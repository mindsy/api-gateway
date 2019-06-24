package br.com.mindsy.api.gateway.dto.evaluation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EvaluationBackResponseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<EvaluationBackDto> evaluations = new ArrayList<>();

    public List<EvaluationBackDto> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(List<EvaluationBackDto> evaluations) {
        this.evaluations = evaluations;
    }
}
