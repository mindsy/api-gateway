package br.com.mindsy.api.gateway.mapper;

import br.com.mindsy.api.gateway.dto.evaluation.EvaluationBackRequestDto;
import br.com.mindsy.api.gateway.dto.evaluation.EvaluationBackDto;
import br.com.mindsy.api.gateway.dto.evaluation.EvaluationRequestDto;
import br.com.mindsy.api.gateway.dto.evaluation.EvaluationDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EvaluationMapper {

    @Mapping(source = "startDate", target = "dt_start")
    @Mapping(source = "endDate", target = "dt_end")
    @Mapping(source = "idPatient", target = "id_patient")
    EvaluationBackRequestDto requestToBack(EvaluationRequestDto evaluationRequestDto);

    @Mapping(target = "endDate", source = "dt_end")
    @Mapping(target = "idEvaluation", source = "id_evaluation")
    @Mapping(target = "startDate", source = "dt_start")
    EvaluationDto backToResponse(EvaluationBackDto evaluationBackResponseDto);

}
