package br.com.mindsy.api.gateway.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

@Service
@FeignClient(name = "patient", url = "${url.backend.evaluation}")
public interface EvaluationFeign {
}
