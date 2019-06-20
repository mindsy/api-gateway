package br.com.mindsy.api.gateway.service;

import br.com.mindsy.api.gateway.dto.MessageResponseDto;
import br.com.mindsy.api.gateway.dto.PatientBackendDto;
import br.com.mindsy.api.gateway.dto.PatientRequestDto;
import br.com.mindsy.api.gateway.exception.ApiGatewayException;
import br.com.mindsy.api.gateway.exception.ObjectAlredyExistsException;
import br.com.mindsy.api.gateway.mapper.PatientMapper;
import br.com.mindsy.api.gateway.service.feign.PatientFeign;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    private PatientFeign patientFeign;

    @Autowired
    private PatientMapper patientMapper;


    public MessageResponseDto insert(PatientRequestDto patientRequestDto) throws ObjectAlredyExistsException, ApiGatewayException {
        PatientBackendDto patientBackendDto = patientMapper.requestToBack(patientRequestDto);
        try {
            return patientFeign.insert(patientBackendDto);
        }catch(FeignException e) {
            if(e.status() == 422) {
                throw new ObjectAlredyExistsException("Dados já cadastrados", e);
            }
            throw new ApiGatewayException("Erro Interno", e);

        }

    }
}
