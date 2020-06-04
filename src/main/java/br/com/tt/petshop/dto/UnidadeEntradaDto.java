package br.com.tt.petshop.dto;

public class UnidadeEntradaDto {

    private String nome;
    private String endereco;

    public UnidadeEntradaDto(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getNome() {

        return nome;
    }

    public String getEndereco() {

        return endereco;
    }
}
