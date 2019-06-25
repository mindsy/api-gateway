package br.com.mindsy.api.gateway.service;

import br.com.mindsy.api.gateway.dto.*;
import br.com.mindsy.api.gateway.dto.patient.PatientBackendDto;
import br.com.mindsy.api.gateway.dto.patient.PatientRequestDto;
import br.com.mindsy.api.gateway.dto.patient.PatientResponseBackDto;
import br.com.mindsy.api.gateway.dto.patient.PatientResponseDto;
import br.com.mindsy.api.gateway.exception.ApiGatewayException;
import br.com.mindsy.api.gateway.exception.ObjectAlredyExistsException;
import br.com.mindsy.api.gateway.exception.UserNotFoundException;
import br.com.mindsy.api.gateway.mapper.PatientMapper;
import br.com.mindsy.api.gateway.service.feign.PatientFeign;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public PatientResponseDto get(final Long id) throws UserNotFoundException, ApiGatewayException {
        try {
            PatientResponseBackDto patientBackendDto = patientFeign.get(id);
            PatientResponseDto patientResponseDto = patientMapper.backToResponse(patientBackendDto);

            for (PhoneBackendDto  phoneBackendDto: patientBackendDto.getTelephone()) {
                patientResponseDto.getPhone().add(patientMapper.phoneBackToPhone(phoneBackendDto));
            }
            return patientResponseDto;
        }catch(FeignException e) {
            if(e.status() == 404) {
                throw new UserNotFoundException("Paciente não encontrado!", e);
            }
            throw new ApiGatewayException("Erro Interno", e);
        }
    }

    public List<PatientResponseDto> getByCrp(final String crp) throws UserNotFoundException, ApiGatewayException {
        try {
            List<PatientResponseBackDto> patientBackendDto = patientFeign.getByCrp(crp);
            return patientBackendDto.
                    stream().map(patientResponseBackDto ->
                    processPhone(patientMapper.backToResponse(patientResponseBackDto), patientResponseBackDto)).collect(Collectors.toList());

        }catch(FeignException e) {
            if(e.status() == 404) {
                throw new UserNotFoundException("Paciente não encontrado!", e);
            }
            throw new ApiGatewayException("Erro Interno!", e);
        }
    }

    public MessageResponseDto update(final Long id, final PatientRequestDto patientRequestDto) throws UserNotFoundException, ApiGatewayException {
        PatientBackendDto patientBackendDto = patientMapper.requestToBack(patientRequestDto);
        try {
            return patientFeign.update(id, patientBackendDto);
        }catch(FeignException e) {
            if(e.status() == 404) {
                throw new UserNotFoundException("Paciente não encontrado!", e);
            }
            throw new ApiGatewayException("Erro Interno!", e);
        }
    }

    private PatientResponseDto processPhone(PatientResponseDto backToResponse, PatientResponseBackDto patientBackendDto) {
        patientBackendDto.getTelephone().forEach(phoneBackendDto -> {
            backToResponse.getPhone().add(patientMapper.phoneBackToPhone(phoneBackendDto));
        });

        return backToResponse;
    }
}
