package br.com.tt.petshop.model;

import br.com.tt.petshop.dto.AnimalEntradaDto;
import br.com.tt.petshop.dto.ClienteEntradaDto;
import br.com.tt.petshop.enumaration.TipoAnimal;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "TB_ANIMAL")
public class Animal {

    //Construtor para o Hibernate
    Animal(){
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataNascimento;

    @Column(name = "TIPO")
    @Enumerated(EnumType.STRING)
    private TipoAnimal tipo;

    @JoinColumn(name = "ID_CLIENTE")
    @ManyToOne
    private Cliente cliente;

    @OneToMany(mappedBy = "animal")
    private List<Atendimento> atendimentos;

    //Getters
    public Long getId() { return id; }

    public String getNome() { return nome; }

    public LocalDate getDataNascimento() { return dataNascimento; }

    public TipoAnimal getTipo() { return tipo; }

    //Poderia ir para uma classe Mapper???
    public Animal(AnimalEntradaDto animalEntradaDto, Cliente cliente) {
        this.nome = animalEntradaDto.getNome();
        this.dataNascimento = animalEntradaDto.getDataNascimento();
        this.tipo = animalEntradaDto.getTipo();
        this.cliente = cliente;
    }
}
