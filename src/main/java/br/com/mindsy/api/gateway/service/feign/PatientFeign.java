package br.com.mindsy.api.gateway.service.feign;

import br.com.mindsy.api.gateway.dto.MessageResponseDto;
import br.com.mindsy.api.gateway.dto.PatientBackendDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@FeignClient(name = "patient", url = "${url.backend.patient}")
public interface PatientFeign {

    @PostMapping("/patient")
    MessageResponseDto insert(@RequestBody final PatientBackendDto patientRequestDto);
}
