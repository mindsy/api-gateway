package br.com.mindsy.api.gateway.mapper;

import br.com.mindsy.api.gateway.dto.evaluation.EvaluationBackendDto;
import br.com.mindsy.api.gateway.dto.evaluation.EvaluationRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EvaluationMapper {

    @Mapping(source = "startDate", target = "dt_start")
    @Mapping(source = "endDate", target = "dt_end")
    @Mapping(source = "idPatient", target = "id_patient")
    EvaluationBackendDto requestToBack(EvaluationRequestDto evaluationRequestDto);
}
