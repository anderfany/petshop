package br.com.tt.petshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class CpfInvalidoException extends RuntimeException {

    public CpfInvalidoException(String message) {
        super(message);
    }

}
