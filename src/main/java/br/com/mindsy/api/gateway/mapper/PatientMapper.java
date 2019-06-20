package br.com.mindsy.api.gateway.mapper;

import br.com.mindsy.api.gateway.dto.PatientBackendDto;
import br.com.mindsy.api.gateway.dto.PatientRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    @Mapping(target = "number", source = "phoneNumber")
    @Mapping(target = "telephone_type", source = "phoneType.descritption")
    @Mapping(target = "date_of_birth", source = "birthDate")
    @Mapping(target = "kinship_degree", source = "kinshipDegree")
    @Mapping(target = "manual_domain", source = "manualDomain.description")
    @Mapping(target = "registry_number_pat", source = "registryNumberPat")
    @Mapping(target = "registry_number_acc", source = "registryNumberAcc")
    @Mapping(target = "status", source = "status.description")
    PatientBackendDto requestToBack(PatientRequestDto patientRequestDto);

}
