package br.com.mindsy.api.gateway.service.feign;

import br.com.mindsy.api.gateway.dto.MessageResponseDto;
import br.com.mindsy.api.gateway.dto.patient.PatientBackendDto;
import br.com.mindsy.api.gateway.dto.patient.PatientResponseBackDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/patient/{id}")
    MessageResponseDto update(@PathVariable("id") final Long id, final PatientBackendDto patientBackendDto);
}
