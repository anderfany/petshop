package br.com.tt.petshop.cliente;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreditoDto {

    private String situacao;
    private String pontos;

    @JsonCreator
    public CreditoDto(@JsonProperty("situacao") String situacao,
                            @JsonProperty("pontos") String pontos) {
        //Usar abaixo em casos que api eh baguncada e campo pode ter mais de um nome
        //@JsonProperty("pontos") @JsonAlias("pontos-credito") Integer pontos) {
        this.situacao = situacao;
        this.pontos = pontos;
    }

    public boolean isNegativado() {
        return situacao!= null && "NEGATIVADO".equalsIgnoreCase(situacao); }

    public String getPontos() {
        return pontos;
    }

    public String getSituacao() {
        return situacao;
    }
}

