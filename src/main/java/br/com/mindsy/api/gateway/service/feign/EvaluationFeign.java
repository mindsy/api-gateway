package br.com.mindsy.api.gateway.service.feign;

import br.com.mindsy.api.gateway.dto.MessageResponseDto;
import br.com.mindsy.api.gateway.dto.evaluation.EvaluationBackRequestDto;
import br.com.mindsy.api.gateway.dto.evaluation.EvaluationBackResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@FeignClient(name = "patient", url = "${url.backend.evaluation}")
public interface EvaluationFeign {

    @PostMapping("/evaluation")
    MessageResponseDto create(@RequestBody EvaluationBackRequestDto evaluationBackendDto);

    @PutMapping("/evaluation/{id}")
    MessageResponseDto update(@PathVariable("id") final Long id,
                              @RequestBody EvaluationBackRequestDto evaluationBackendDto);

    @GetMapping("/psychologist-evaluation/{crp}/{idPatient}")
    EvaluationBackResponseDto getAll(@PathVariable("idPatient") final Long idPatient,
                                     @PathVariable("crp")  final String crp);

    @DeleteMapping("/evaluation/{id}")
    MessageResponseDto delete(@PathVariable("id") final Long id);
}
