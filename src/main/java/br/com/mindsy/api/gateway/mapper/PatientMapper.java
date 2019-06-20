package br.com.mindsy.api.gateway.mapper;

import br.com.mindsy.api.gateway.dto.*;
import br.com.mindsy.api.gateway.dto.patient.PatientBackendDto;
import br.com.mindsy.api.gateway.dto.patient.PatientRequestDto;
import br.com.mindsy.api.gateway.dto.patient.PatientResponseBackDto;
import br.com.mindsy.api.gateway.dto.patient.PatientResponseDto;
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

    @Mapping(source = "date_of_birth", target = "birthDate")
    @Mapping(source = "kinship_degree", target = "kinshipDegree")
    @Mapping(source = "manual_domain", target = "manualDomain")
    @Mapping(source = "registry_number_pat", target = "registryNumberPat")
    @Mapping(source = "registry_number_acc", target = "registryNumberAcc")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "id_patient", target = "idPatient")
    PatientResponseDto backToResponse(PatientResponseBackDto patientBackendDto);

    @Mapping(source = "number", target = "phoneNumber")
    @Mapping(source = "telephone_type", target = "phoneType")
    PhoneDto phoneBackToPhone(PhoneBackendDto phoneBackendDto);

}
