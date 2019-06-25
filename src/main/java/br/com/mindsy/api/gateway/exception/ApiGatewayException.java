package br.com.mindsy.api.gateway.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ApiGatewayException extends Exception {

    public ApiGatewayException(String message, Throwable cause) {
        super(message, cause);
    }
}
