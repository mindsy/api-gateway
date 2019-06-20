package br.com.mindsy.api.gateway.service;

import br.com.mindsy.api.gateway.dto.MessageResponseDto;
import br.com.mindsy.api.gateway.dto.PatientBackendDto;
import br.com.mindsy.api.gateway.dto.PatientRequestDto;
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


    public MessageResponseDto insert(PatientRequestDto patientRequestDto) {
        PatientBackendDto patientBackendDto = patientMapper.requestToBack(patientRequestDto);
        try {
            return patientFeign.insert(patientBackendDto);
        }catch(FeignException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
}
