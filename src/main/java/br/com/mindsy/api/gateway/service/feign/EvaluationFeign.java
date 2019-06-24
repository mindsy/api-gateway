package br.com.mindsy.api.gateway.service.feign;

import br.com.mindsy.api.gateway.dto.MessageResponseDto;
import br.com.mindsy.api.gateway.dto.evaluation.EvaluationBackendDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@FeignClient(name = "patient", url = "${url.backend.evaluation}")
public interface EvaluationFeign {

    @PostMapping("/evaluation")
    MessageResponseDto create(@RequestBody EvaluationBackendDto evaluationBackendDto);
}
