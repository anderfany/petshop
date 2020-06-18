package br.com.tt.petshop.dto;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ClienteEntradaDto {

    @NotBlank(message = "É necessario informar o nome do cliente!")
    @Size(min = 5, max = 50, message = "O nome deve conter entre 3 e 20 caracteres!")
    private String nome;

    @NotBlank(message = "É necessario informar um CPF para o cliente!")
    @CPF(message = "É necessario informar um CPF valido!")
    private String cpf;

    public ClienteEntradaDto(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome.replaceAll("[^\\w]", " ")
                .replaceAll("[ ]{2,}", " ");
    }

    public String getCpf() { return cpf; }


}


