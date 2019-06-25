package br.com.mindsy.api.gateway.service;

import br.com.mindsy.api.gateway.dto.evaluation.EvaluationRequestDto;
import br.com.mindsy.api.gateway.mapper.EvaluationMapper;
import br.com.mindsy.api.gateway.service.feign.EvaluationFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvaluationService {

    @Autowired
    private EvaluationFeign evaluationFeign;

    @Autowired
    private EvaluationMapper evaluationMapper;

    public EvaluationRequestDto create(EvaluationRequestDto evaluationRequestDto) {
        return evaluationRequestDto;
    }
}
