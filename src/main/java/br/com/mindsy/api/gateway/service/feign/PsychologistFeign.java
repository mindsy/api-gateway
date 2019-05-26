package br.com.mindsy.api.gateway.service.feign;

import br.com.mindsy.api.gateway.dto.PsychologistRequestDto;
import br.com.mindsy.api.gateway.dto.PsychologistResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@FeignClient(name = "psychologist", url = "${url.backend.psychologist}")
public interface PsychologistFeign {

    @PostMapping("/psychologist")
    PsychologistResponseDto insert(@RequestBody final PsychologistRequestDto psychologistRequestDto);
}
