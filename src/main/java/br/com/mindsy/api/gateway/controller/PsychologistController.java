package br.com.mindsy.api.gateway.controller;

import br.com.mindsy.api.gateway.dto.PsychologistRequestDto;
import br.com.mindsy.api.gateway.dto.PsychologistResponseDto;
import br.com.mindsy.api.gateway.service.PsychologistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/psychologist")
public class PsychologistController {

    @Autowired
    private PsychologistService psychologistService;

    @PostMapping
    public PsychologistResponseDto insert(@RequestBody PsychologistRequestDto psychologistRequestDto) {
        return psychologistService.insert(psychologistRequestDto);
    }
}
