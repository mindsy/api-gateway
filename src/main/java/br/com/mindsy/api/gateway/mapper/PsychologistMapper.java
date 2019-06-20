package br.com.mindsy.api.gateway.mapper;

import br.com.mindsy.api.gateway.dto.psychologist.PsychologistBackEndDto;
import br.com.mindsy.api.gateway.dto.psychologist.PsychologistRequestDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface PsychologistMapper {

    @Mapping(target = "number", source = "phoneNumber")
    @Mapping(target = "date_of_birth", source = "birthDate")
    @Mapping(target = "registry_number", source = "CNPJHospital")
    @Mapping(target = "telephone_type", source = "phoneType.descritption")
    PsychologistBackEndDto requestToBack(PsychologistRequestDto psychologistRequestDto);
}
