package br.com.mindsy.api.gateway.controller;

import br.com.mindsy.api.gateway.dto.AuthenticationRequestDto;
import br.com.mindsy.api.gateway.dto.AuthenticationResponseDto;
import br.com.mindsy.api.gateway.dto.MessageResponseDto;
import br.com.mindsy.api.gateway.exception.ApiGatewayException;
import br.com.mindsy.api.gateway.exception.UnauthorizadExeption;
import br.com.mindsy.api.gateway.service.AuthenticationService;
import br.com.mindsy.api.gateway.service.PsychologistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;


    @Autowired
    private PsychologistService psychologistService;

    @PostMapping("/login")
    public AuthenticationResponseDto login(@RequestBody final AuthenticationRequestDto authenticationRequestDto) throws UnauthorizadExeption, ApiGatewayException {
        return authenticationService.login(authenticationRequestDto);
    }

    @PutMapping("/logout/{crp}")
    public MessageResponseDto logout(@PathVariable("crp") final String crp, @RequestHeader("Authorization") final String bearerToken) throws UnauthorizadExeption, ApiGatewayException {
        psychologistService.validateToken(crp);
        return authenticationService.logout(bearerToken, crp);
    }
}
