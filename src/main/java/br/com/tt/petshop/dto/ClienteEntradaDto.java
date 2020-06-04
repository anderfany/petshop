package br.com.tt.petshop.dto;

public class ClienteEntradaDto {
    private String nome;
    private String cpf;

    public ClienteEntradaDto(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getDescricao() {
        return String.format("Nome: %s Cpf: %s",this.nome, this.cpf);
    }
}


