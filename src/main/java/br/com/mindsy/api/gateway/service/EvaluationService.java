package br.com.mindsy.api.gateway.service;

import br.com.mindsy.api.gateway.dto.MessageResponseDto;
import br.com.mindsy.api.gateway.dto.evaluation.EvaluationBackendDto;
import br.com.mindsy.api.gateway.dto.evaluation.EvaluationRequestDto;
import br.com.mindsy.api.gateway.exception.ApiGatewayException;
import br.com.mindsy.api.gateway.exception.InvalidParameterException;
import br.com.mindsy.api.gateway.exception.ObjectAlredyExistsException;
import br.com.mindsy.api.gateway.mapper.EvaluationMapper;
import br.com.mindsy.api.gateway.service.feign.EvaluationFeign;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvaluationService {

    @Autowired
    private EvaluationFeign evaluationFeign;

    @Autowired
    private EvaluationMapper evaluationMapper;

    public MessageResponseDto create(EvaluationRequestDto evaluationRequestDto) throws ObjectAlredyExistsException, InvalidParameterException, ApiGatewayException {

        EvaluationBackendDto evaluationBackendDto = evaluationMapper.requestToBack(evaluationRequestDto);
        try {
            return evaluationFeign.create(evaluationBackendDto);
        } catch (FeignException e) {

            switch (e.status()) {
                case 422:
                    throw new ObjectAlredyExistsException("Avaliação já cadastrado!", e);
                case 400:
                    throw new InvalidParameterException("Parâmetros inválidos!", e);
                default:
                    throw new ApiGatewayException("Erro Interno", e);
            }
        }
    }
}
