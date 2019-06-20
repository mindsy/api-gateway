package br.com.mindsy.api.gateway.controller;

import br.com.mindsy.api.gateway.dto.MessageResponseDto;
import br.com.mindsy.api.gateway.dto.patient.PatientRequestDto;
import br.com.mindsy.api.gateway.dto.patient.PatientResponseDto;
import br.com.mindsy.api.gateway.exception.ApiGatewayException;
import br.com.mindsy.api.gateway.exception.ObjectAlredyExistsException;
import br.com.mindsy.api.gateway.exception.UnauthorizadExeption;
import br.com.mindsy.api.gateway.exception.UserNotFoundException;
import br.com.mindsy.api.gateway.service.PatientService;
import br.com.mindsy.api.gateway.service.PsychologistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    PsychologistService psychologistService;

    @PostMapping
    public MessageResponseDto insert(@Valid @RequestBody PatientRequestDto patientRequestDto,
                                     @RequestHeader("Authorization") final String bearerToken,
                                     @RequestHeader("crp") final String crp) throws ApiGatewayException, ObjectAlredyExistsException, UnauthorizadExeption {
        psychologistService.validateToken(crp, bearerToken);
        return patientService.insert(patientRequestDto);
    }

    @GetMapping("{id}")
    public PatientResponseDto get(@PathVariable("id") final Long id,
                                     @RequestHeader("Authorization") final String bearerToken,
                                     @RequestHeader("crp") final String crp) throws ApiGatewayException, UnauthorizadExeption, UserNotFoundException {
        psychologistService.validateToken(crp, bearerToken);
        return patientService.get(id);
    }

    @GetMapping("/psychologist/{crp}")
    public List<PatientResponseDto> get(@PathVariable("crp") final String crp,
                                        @RequestHeader("Authorization") final String bearerToken) throws ApiGatewayException, UnauthorizadExeption, UserNotFoundException {
        psychologistService.validateToken(crp, bearerToken);
        return patientService.getByCrp(crp);
    }

    @PutMapping("/{id}")
    public MessageResponseDto update(@PathVariable("id") final Long id,
                                           @RequestBody PatientRequestDto patientRequestDto,
                                           @RequestHeader("crp") final String crp,
                                           @RequestHeader("Authorization") final String bearerToken) throws ApiGatewayException, UnauthorizadExeption, UserNotFoundException {
        psychologistService.validateToken(crp, bearerToken);
        return patientService.update(id, patientRequestDto);
    }
}
