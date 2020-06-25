package br.com.tt.petshop.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "TB_FUNCIONARIO")
public class Funcionario {

    //Construtor para o Hibernate
    Funcionario(){
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME")
    @NotBlank
    private String nome;

//    @OneToOne(mappedBy = "funcionario")
//    private Atendimento atendimento;

    //Getters
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    //Construtor


}
