package br.com.mindsy.api.gateway.controller;

import br.com.mindsy.api.gateway.dto.MessageResponseDto;
import br.com.mindsy.api.gateway.dto.evaluation.EvaluationRequestDto;
import br.com.mindsy.api.gateway.exception.ApiGatewayException;
import br.com.mindsy.api.gateway.exception.InvalidParameterException;
import br.com.mindsy.api.gateway.exception.ObjectAlredyExistsException;
import br.com.mindsy.api.gateway.exception.UnauthorizadExeption;
import br.com.mindsy.api.gateway.service.EvaluationService;
import br.com.mindsy.api.gateway.service.PsychologistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/evaluations")
@CrossOrigin
public class EvaluationController {

    @Autowired
    private EvaluationService evaluationService;

    @Autowired
    private PsychologistService psychologistService;

    @PostMapping
    public MessageResponseDto create(@RequestBody  EvaluationRequestDto evaluationRequestDto,
                                     @RequestHeader("crp") final String crp,
                                     @RequestHeader("Authorization") final String bearerToken) throws ObjectAlredyExistsException, InvalidParameterException, ApiGatewayException, UnauthorizadExeption {
        psychologistService.validateToken(crp, bearerToken);
        return evaluationService.create(evaluationRequestDto);
    }
}
