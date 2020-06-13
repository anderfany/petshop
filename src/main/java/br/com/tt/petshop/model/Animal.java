package br.com.tt.petshop.model;

import br.com.tt.petshop.enumaration.TipoAnimal;

import javax.persistence.*;

import java.time.LocalDate;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Animal {

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
    private Cliente Cliente;

    //Construtor default Hibernate
    Animal(){
    }

    //Getters
    public Long getId() { return id; }

    public String getNome() { return nome; }

    public LocalDate getDataNascimento() { return dataNascimento; }

    public TipoAnimal getTipo() { return tipo; }
}
