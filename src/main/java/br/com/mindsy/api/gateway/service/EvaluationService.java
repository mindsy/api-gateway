package br.com.mindsy.api.gateway.service;

import br.com.mindsy.api.gateway.dto.MessageResponseDto;
import br.com.mindsy.api.gateway.dto.evaluation.EvaluationBackRequestDto;
import br.com.mindsy.api.gateway.dto.evaluation.EvaluationBackResponseDto;
import br.com.mindsy.api.gateway.dto.evaluation.EvaluationRequestDto;
import br.com.mindsy.api.gateway.dto.evaluation.EvaluationResponseDto;
import br.com.mindsy.api.gateway.exception.ApiGatewayException;
import br.com.mindsy.api.gateway.exception.InvalidParameterException;
import br.com.mindsy.api.gateway.exception.ObjectAlredyExistsException;
import br.com.mindsy.api.gateway.exception.UserNotFoundException;
import br.com.mindsy.api.gateway.mapper.EvaluationMapper;
import br.com.mindsy.api.gateway.service.feign.EvaluationFeign;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class EvaluationService {

    @Autowired
    private EvaluationFeign evaluationFeign;

    @Autowired
    private EvaluationMapper evaluationMapper;

    public MessageResponseDto create(EvaluationRequestDto evaluationRequestDto) throws ObjectAlredyExistsException, InvalidParameterException, ApiGatewayException {

        EvaluationBackRequestDto evaluationBackendDto = evaluationMapper.requestToBack(evaluationRequestDto);
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

    public MessageResponseDto update(final Long id, final EvaluationRequestDto evaluationRequestDto) throws InvalidParameterException, UserNotFoundException, ApiGatewayException {

        if(evaluationRequestDto.getIdPatient() != null || evaluationRequestDto.getCrp() != null) {
            throw new InvalidParameterException("CRP ou identificador do paciente não podem ser alterados.");
        }
        EvaluationBackRequestDto evaluationBackendDto = evaluationMapper.requestToBack(evaluationRequestDto);
        try {
            return evaluationFeign.update(id, evaluationBackendDto);
        } catch (FeignException e) {
            switch (e.status()) {
                case 404:
                    throw new UserNotFoundException("Avaliação não encontada!", e);
                case 400:
                    throw new InvalidParameterException("Parâmetros inválidos!", e);
                default:
                    throw new ApiGatewayException("Erro Interno", e);
            }
        }
    }

    public EvaluationResponseDto getAll(final Long idPatient, final String crp) throws UserNotFoundException, ApiGatewayException {

        try {
            EvaluationBackResponseDto evaluationBackResponseDto = evaluationFeign.getAll(idPatient, crp);
            EvaluationResponseDto evaluationResponseDto = new EvaluationResponseDto();
            evaluationResponseDto.setEvaluations(evaluationBackResponseDto.getEvaluations().stream().map(evaluationBackResponseDto1 ->
                    evaluationMapper.backToResponse(evaluationBackResponseDto1)).collect(Collectors.toList()));
            return evaluationResponseDto;
        } catch (FeignException e) {
            if(e.status() == 404) {
                throw new UserNotFoundException("Avaliação não encontada!", e);
            }
            throw new ApiGatewayException("Erro Interno!", e);
        }
    }

}
