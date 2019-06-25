package br.com.mindsy.api.gateway.controller;

import br.com.mindsy.api.gateway.dto.evaluation.EvaluationRequestDto;
import br.com.mindsy.api.gateway.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/evaluations")
@CrossOrigin
public class EvaluationController {

    @Autowired
    private EvaluationService evaluationService;

    @PostMapping
    public EvaluationRequestDto create(@RequestBody  EvaluationRequestDto evaluationRequestDto) {
        return evaluationService.create(evaluationRequestDto);
    }
}
