package br.com.mindsy.api.gateway.service.feign;

import br.com.mindsy.api.gateway.dto.PsychologistBackEndDto;
import br.com.mindsy.api.gateway.dto.MessageResponseDto;
import br.com.mindsy.api.gateway.dto.PsychologistResponseDto;
import br.com.mindsy.api.gateway.dto.TokenRespnseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@FeignClient(name = "psychologist", url = "${url.backend.psychologist}")
public interface PsychologistFeign {

    @PostMapping("/psychologist")
    MessageResponseDto insert(@RequestBody final PsychologistBackEndDto psychologistBackEndDto);

    @PutMapping("/psychologist/{crp}")
    MessageResponseDto update(@PathVariable("crp") final String crp, final PsychologistBackEndDto psychologistBackEndDto);

    @DeleteMapping("/psychologist/{crp}")
    MessageResponseDto delete(@PathVariable("crp") final String crp);

    @GetMapping("/psychologist/{crp}")
    PsychologistResponseDto find(@PathVariable("crp") final String crp);

    @GetMapping("/psychologist/token/{crp}")
    TokenRespnseDto getToken(@PathVariable("crp") final String crp);

}
