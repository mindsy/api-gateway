package br.com.mindsy.api.gateway.controller;

import br.com.mindsy.api.gateway.dto.MessageResponseDto;
import br.com.mindsy.api.gateway.dto.PatientRequestDto;
import br.com.mindsy.api.gateway.exception.ApiGatewayException;
import br.com.mindsy.api.gateway.exception.PersonAlredyExistsException;
import br.com.mindsy.api.gateway.exception.UnauthorizadExeption;
import br.com.mindsy.api.gateway.service.PatientService;
import br.com.mindsy.api.gateway.service.PsychologistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    PsychologistService psychologistService;

    @PostMapping
    public MessageResponseDto insert(@RequestBody PatientRequestDto patientRequestDto,
                                     @RequestHeader("Authorization") final String bearerToken,
                                     @RequestHeader("crp") final String crp) throws ApiGatewayException, PersonAlredyExistsException, UnauthorizadExeption {
        psychologistService.validateToken(crp, bearerToken);
        return patientService.insert(patientRequestDto);
    }

}
