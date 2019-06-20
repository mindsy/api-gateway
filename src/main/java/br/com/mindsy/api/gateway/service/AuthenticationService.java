package br.com.mindsy.api.gateway.service;

import br.com.mindsy.api.gateway.dto.AuthenticationRequestDto;
import br.com.mindsy.api.gateway.dto.AuthenticationResponseDto;
import br.com.mindsy.api.gateway.dto.MessageResponseDto;
import br.com.mindsy.api.gateway.exception.ApiGatewayException;
import br.com.mindsy.api.gateway.exception.UnauthorizadExeption;
import br.com.mindsy.api.gateway.service.feign.AuthenticationFeign;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationFeign authenticationFeign;

    public AuthenticationResponseDto login(final AuthenticationRequestDto authenticationRequestDto) throws ApiGatewayException, UnauthorizadExeption {
        try {
            return authenticationFeign.login(authenticationRequestDto);
        } catch (FeignException e) {
            if(e.status() == 401) {
                throw new UnauthorizadExeption("Usuário ou senha inválido!", e);
            } else {
                throw new ApiGatewayException("Erro interno.", e);
            }
        }
    }

    public MessageResponseDto logout(final String bearerToken, final String crp) throws UnauthorizadExeption, ApiGatewayException {
        try {
            return authenticationFeign.logout(bearerToken, crp);
        } catch(FeignException e) {
            if(e.status() == 401) {
                throw new UnauthorizadExeption("Token inválido", e);
            } else {
                throw new ApiGatewayException("Erro interno.", e);
            }
        }
    }

}
