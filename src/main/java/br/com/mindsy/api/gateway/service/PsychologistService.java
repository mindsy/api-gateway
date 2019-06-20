package br.com.mindsy.api.gateway.service;

import br.com.mindsy.api.gateway.dto.*;
import br.com.mindsy.api.gateway.dto.authentication.TokenRespnseDto;
import br.com.mindsy.api.gateway.dto.psychologist.PsychologistBackEndDto;
import br.com.mindsy.api.gateway.dto.psychologist.PsychologistRequestDto;
import br.com.mindsy.api.gateway.dto.psychologist.PsychologistResponseDto;
import br.com.mindsy.api.gateway.exception.*;
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

    public MessageResponseDto insert(final PsychologistRequestDto psychologistRequestDto) throws ObjectAlredyExistsException, InvalidParameterException, ApiGatewayException {
        PsychologistBackEndDto psychologistBackEndDto = psychologistMapper.requestToBack(psychologistRequestDto);

        try {
            return psychologistFeign.insert(psychologistBackEndDto);
        } catch (FeignException e) {

            switch (e.status()) {
                case 422:
                    throw new ObjectAlredyExistsException("Psicólogo já cadastrado!", e);
                case 400:
                    throw new InvalidParameterException("Email ou telephone já cadastrado!", e);
                default:
                    throw new ApiGatewayException("Erro Interno", e);
            }
        }
    }

    public MessageResponseDto update(final String crp, final PsychologistRequestDto psychologistRequestDto)
            throws InvalidParameterException, ApiGatewayException, UserNotFoundException {

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

    public MessageResponseDto delete(final String crp)
            throws UserNotFoundException, ApiGatewayException {

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

    public PsychologistResponseDto find(final String crp)
            throws UserNotFoundException, ApiGatewayException {

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

    public void validateToken(final String crp, String token)
            throws UnauthorizadExeption {
        TokenRespnseDto tokenRespnseDto = psychologistFeign.getToken(crp);
        token = token.replace("Bearer ", "").trim();
        if(tokenRespnseDto.getToken() == null || !tokenRespnseDto.getToken().equalsIgnoreCase(token)) {
            throw new UnauthorizadExeption("Não autorizado");
        }

    }
}
