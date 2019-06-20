package br.com.mindsy.api.gateway.service.feign;

import br.com.mindsy.api.gateway.dto.AuthenticationRequestDto;
import br.com.mindsy.api.gateway.dto.AuthenticationResponseDto;
import br.com.mindsy.api.gateway.dto.MessageResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@FeignClient(name = "authentication", url = "${url.backend.authentication}")
public interface AuthenticationFeign {

    @PostMapping("/login")
    AuthenticationResponseDto login(@RequestBody final AuthenticationRequestDto authenticationRequestDto);

    @PostMapping("/logout/{crp}")
    MessageResponseDto logout(@RequestHeader("Authorization") final String bearerToken, @PathVariable("crp") final String crp);

}
