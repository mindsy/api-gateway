package br.com.mindsy.api.gateway.service;

import br.com.mindsy.api.gateway.dto.MessageResponseDto;
import br.com.mindsy.api.gateway.dto.PsychologistBackEndDto;
import br.com.mindsy.api.gateway.dto.PsychologistRequestDto;
import br.com.mindsy.api.gateway.dto.PsychologistResponseDto;
import br.com.mindsy.api.gateway.exception.ApiGatewayException;
import br.com.mindsy.api.gateway.exception.InvalidParameterException;
import br.com.mindsy.api.gateway.exception.PersonAlredyExistsException;
import br.com.mindsy.api.gateway.exception.UserNotFoundException;
import br.com.mindsy.api.gateway.mapper.PsychologistMapper;
import br.com.mindsy.api.gateway.model.PersonEntity;
import br.com.mindsy.api.gateway.model.PsychologistEntity;
import br.com.mindsy.api.gateway.repository.PersonRepository;
import br.com.mindsy.api.gateway.repository.PsychologistRepository;
import br.com.mindsy.api.gateway.service.feign.PsychologistFeign;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PsychologistService {

    @Autowired
    private PsychologistFeign psychologistFeign;

    @Autowired
    private PsychologistMapper psychologistMapper;

    @Autowired
    private PsychologistRepository psychologistRepository;

    @Autowired
    private PersonRepository personRepository;

    public MessageResponseDto insert(final PsychologistRequestDto psychologistRequestDto) throws PersonAlredyExistsException, InvalidParameterException, ApiGatewayException {
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

    public MessageResponseDto update(final String crp, final PsychologistRequestDto psychologistRequestDto) throws InvalidParameterException, ApiGatewayException, UserNotFoundException {
        PsychologistBackEndDto psychologistBackEndDto = psychologistMapper.requestToBack(psychologistRequestDto);

        try {
            return psychologistFeign.update(crp, psychologistBackEndDto);
        } catch (FeignException e) {
            switch (e.status()) {
                case 404:
                    throw new UserNotFoundException("Psicólogo já cadastrado!", e);
                case 400:
                    throw new InvalidParameterException("Usuário não encontrado!", e);
                default:
                    throw new ApiGatewayException("Erro Interno", e);
            }
        }

    }

    public MessageResponseDto delete(final String crp) throws UserNotFoundException, ApiGatewayException {

        try {
            return psychologistFeign.delete(crp);
        } catch (FeignException e) {
            if(e.status() == 404) {
                throw new UserNotFoundException("Usuário não encontrado!", e);
            } else {
                throw new ApiGatewayException("Erro Interno", e);
            }
        }
    }

    public PsychologistResponseDto find(final String crp) throws UserNotFoundException, ApiGatewayException {

        try {
            return psychologistFeign.find(crp);
        } catch (FeignException e) {
            if(e.status() == 404) {
                throw new UserNotFoundException("Usuário não encontrado!", e);
            } else {
                throw new ApiGatewayException("Erro Interno", e);
            }
        }

    }

    public boolean validateToken(final String crp) {
        return true;
    }

}
