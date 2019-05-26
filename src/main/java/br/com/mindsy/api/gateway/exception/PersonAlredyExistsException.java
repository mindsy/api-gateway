package br.com.mindsy.api.gateway.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class PersonAlredyExistsException extends Exception {

    public PersonAlredyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
