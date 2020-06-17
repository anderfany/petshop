package br.com.tt.petshop.exception;

public class ErroDeNegocioException extends RuntimeException{

    private String codigo;

    public ErroDeNegocioException(String codigo, String message) {
        super(message);
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}
