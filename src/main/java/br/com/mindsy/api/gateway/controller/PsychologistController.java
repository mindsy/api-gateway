package br.com.mindsy.api.gateway.controller;

import br.com.mindsy.api.gateway.dto.PsychologistRequestDto;
import br.com.mindsy.api.gateway.dto.MessageResponseDto;
import br.com.mindsy.api.gateway.dto.PsychologistResponseDto;
import br.com.mindsy.api.gateway.exception.ApiGatewayException;
import br.com.mindsy.api.gateway.exception.InvalidParameterException;
import br.com.mindsy.api.gateway.exception.PersonAlredyExistsException;
import br.com.mindsy.api.gateway.exception.UserNotFoundException;
import br.com.mindsy.api.gateway.service.PsychologistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/psychologist")
public class PsychologistController {

    @Autowired
    private PsychologistService psychologistService;

    @PostMapping
    public MessageResponseDto insert(@RequestBody PsychologistRequestDto psychologistRequestDto) throws InvalidParameterException, PersonAlredyExistsException, ApiGatewayException {
        return psychologistService.insert(psychologistRequestDto);
    }

    @PutMapping("/{crp}")
    public MessageResponseDto update(@PathVariable("crp") final String crp, @RequestBody PsychologistRequestDto psychologistRequestDto) throws InvalidParameterException, ApiGatewayException, UserNotFoundException {
        return psychologistService.update(crp, psychologistRequestDto);
    }

    @DeleteMapping("/{crp}")
    public MessageResponseDto delete(@PathVariable("crp") final String crp) throws ApiGatewayException, UserNotFoundException {
        return psychologistService.delete(crp);
    }

    @GetMapping("/{crp}")
    public PsychologistResponseDto find(@PathVariable("crp") final String crp) throws ApiGatewayException, UserNotFoundException {
        return psychologistService.find(crp);
    }
}
