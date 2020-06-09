package br.com.tt.petshop.exception;

public class ErroDeNegocioException extends RuntimeException{

    public ErroDeNegocioException(String message) {
        super(message);
    }

}
