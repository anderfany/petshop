package br.com.tt.petshop.dto;

import br.com.tt.petshop.enumaration.TipoAnimal;
import br.com.tt.petshop.model.Animal;

import java.time.LocalDate;

public class AnimalSaidaDto {

    //Atributos
    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private TipoAnimal tipo;

    //Construtor
    private AnimalSaidaDto(Animal animal)
    {
        this.id = animal.getId();
        this.nome = animal.getNome();
        this.dataNascimento = animal.getDataNascimento();
        this.tipo = animal.getTipo();
    }

    //Conversao para do Repository -> Service
    public static AnimalSaidaDto converte(Animal animal){
        return new AnimalSaidaDto(animal);
    }

    //Getters
    public Long getId() { return id; }

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
