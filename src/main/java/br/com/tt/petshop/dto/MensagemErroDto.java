package br.com.tt.petshop.dto;

public class MensagemErroDto {
    private String codigo;
    private String mensagem;

    public MensagemErroDto(String codigo, String mensagem) {
        this.codigo = codigo;
        this.mensagem = mensagem;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getMensagem() {
        return mensagem;
    }
}
