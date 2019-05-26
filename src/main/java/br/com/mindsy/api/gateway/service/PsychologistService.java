package br.com.mindsy.api.gateway.service;

import br.com.mindsy.api.gateway.dto.PsychologistBackEndDto;
import br.com.mindsy.api.gateway.dto.PsychologistRequestDto;
import br.com.mindsy.api.gateway.dto.PsychologistResponseDto;
import br.com.mindsy.api.gateway.exception.ApiGatewayException;
import br.com.mindsy.api.gateway.exception.InvalidParameterException;
import br.com.mindsy.api.gateway.exception.PersonAlredyExistsException;
import br.com.mindsy.api.gateway.mapper.PsychologistMapper;
import br.com.mindsy.api.gateway.service.feign.PsychologistFeign;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PsychologistService {

    @Autowired
    private PsychologistFeign psychologistFeign;

    @Autowired
    private PsychologistMapper psychologistMapper;

    public PsychologistResponseDto insert(final PsychologistRequestDto psychologistRequestDto) throws PersonAlredyExistsException, InvalidParameterException, ApiGatewayException {
        PsychologistBackEndDto psychologistBackEndDto = psychologistMapper.requestToBack(psychologistRequestDto);

        try {
            return psychologistFeign.insert(psychologistBackEndDto);
        } catch (FeignException e) {

            switch (e.status()) {
                case 422:
                    throw new PersonAlredyExistsException("Psicólogo já cadastrado!", e);
                case 400:
                    throw new InvalidParameterException("Email ou telephone já cadastrado!", e);
                default:
                    throw new ApiGatewayException("Erro Interno", e);
            }
        }
    }

}
