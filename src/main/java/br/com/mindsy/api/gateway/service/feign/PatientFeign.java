package br.com.mindsy.api.gateway.service.feign;

import br.com.mindsy.api.gateway.dto.MessageResponseDto;
import br.com.mindsy.api.gateway.dto.PatientBackendDto;
import br.com.mindsy.api.gateway.dto.PatientResponseBackDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@FeignClient(name = "patient", url = "${url.backend.patient}")
public interface PatientFeign {

    @PostMapping("/patient")
    MessageResponseDto insert(@RequestBody final PatientBackendDto patientRequestDto);

    @GetMapping("/patient/{id}")
    PatientResponseBackDto get(@PathVariable("id") final Long id);

    @GetMapping("/patient/psychologist/{crp}")
    List<PatientResponseBackDto> getByCrp(@PathVariable("crp") final String id);
}
