package br.com.tt.petshop.model;

import javax.persistence.*;

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
    private String nome;

    @OneToOne(mappedBy = "funcionario")
    private Atendimento atendimento;

}
