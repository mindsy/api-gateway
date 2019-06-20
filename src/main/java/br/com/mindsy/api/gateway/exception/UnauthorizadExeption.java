package br.com.mindsy.api.gateway.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorizadExeption extends Exception {

    public UnauthorizadExeption(String message, Throwable cause) {
        super(message, cause);
    }


    public UnauthorizadExeption(String message) {
        super(message);
    }
}
