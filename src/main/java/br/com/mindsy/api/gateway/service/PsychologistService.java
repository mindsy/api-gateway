package br.com.mindsy.api.gateway.service;

import br.com.mindsy.api.gateway.dto.PsychologistRequestDto;
import br.com.mindsy.api.gateway.dto.PsychologistResponseDto;
import br.com.mindsy.api.gateway.service.feign.PsychologistFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PsychologistService {

    @Autowired
    private PsychologistFeign psychologistFeign;

    public PsychologistResponseDto insert(final PsychologistRequestDto psychologistRequestDto) {
        return psychologistFeign.insert(psychologistRequestDto);
    }
}
