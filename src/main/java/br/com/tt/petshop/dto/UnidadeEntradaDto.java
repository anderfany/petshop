package br.com.tt.petshop.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UnidadeEntradaDto {

    @NotBlank(message = "É necessario informar o nome da Unidade!")
    @Size(min = 10, max = 100, message = "O nome deve conter entre 10 e 100 caracteres!")
    private String nome;

    @NotBlank(message = "É necessario informar o endereco da Unidade!")
    @Size(min = 10, max = 100, message = "O nome deve conter entre 10 e 100 caracteres!")
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
