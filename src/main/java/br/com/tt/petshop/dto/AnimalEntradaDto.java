package br.com.tt.petshop.dto;

import br.com.tt.petshop.enumaration.TipoAnimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class AnimalEntradaDto {

    //Atributos
    @NotBlank(message = "É necessario informar o nome do animal!")
    @Size(min = 3, max = 20, message = "O nome deve conter entre 3 e 20 caracteres!")
    private String nome;

    @PastOrPresent(message = "É necessario informar a data de nascimento!")
    private LocalDate dataNascimento;

    @NotNull(message = "É necessario informar o tipo do animal!")
    private TipoAnimal tipo;

    //Construtor
    public AnimalEntradaDto(String nome, LocalDate dataNascimento, TipoAnimal tipo) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public TipoAnimal getTipo() {
        return tipo;
    }
}
