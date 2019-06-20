package br.com.mindsy.api.gateway.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class ObjectAlredyExistsException extends Exception {

    public ObjectAlredyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
