package br.com.mindsy.api.gateway.controller;

import br.com.mindsy.api.gateway.dto.psychologist.PsychologistRequestDto;
import br.com.mindsy.api.gateway.dto.MessageResponseDto;
import br.com.mindsy.api.gateway.dto.psychologist.PsychologistResponseDto;
import br.com.mindsy.api.gateway.exception.*;
import br.com.mindsy.api.gateway.service.PsychologistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/psychologists")
public class PsychologistController {

    @Autowired
    private PsychologistService psychologistService;

    @PostMapping
    public MessageResponseDto insert(@RequestBody PsychologistRequestDto psychologistRequestDto) throws InvalidParameterException, ObjectAlredyExistsException, ApiGatewayException {
        return psychologistService.insert(psychologistRequestDto);
    }

    @PutMapping("/{crp}")
    public MessageResponseDto update(@PathVariable("crp") final String crp, @RequestBody PsychologistRequestDto psychologistRequestDto,
                                     @RequestHeader("Authorization") final String bearerToken) throws InvalidParameterException, ApiGatewayException, UserNotFoundException, UnauthorizadExeption {
        psychologistService.validateToken(crp, bearerToken);
        return psychologistService.update(crp, psychologistRequestDto);
    }

    @DeleteMapping("/{crp}")
    public MessageResponseDto delete(@PathVariable("crp") final String crp,
        @RequestHeader("Authorization") final String bearerToken) throws ApiGatewayException, UserNotFoundException, UnauthorizadExeption {
        psychologistService.validateToken(crp, bearerToken);
        return psychologistService.delete(crp);
    }

    @GetMapping("/{crp}")
    public PsychologistResponseDto find(@PathVariable("crp") final String crp,
                                        @RequestHeader("Authorization") final String bearerToken) throws ApiGatewayException, UserNotFoundException, UnauthorizadExeption {
        psychologistService.validateToken(crp, bearerToken);
        return psychologistService.find(crp);
    }
}
