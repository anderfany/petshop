package br.com.tt.petshop.model;

import javax.persistence.*;

@Entity
public class Cliente {

    Cliente(){//Construtor default para o Hibernate funcionar!!
    }

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    //Construtor - Declarado assim para funcionar o JPQL
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Geração automatica pelo banco
    //@GeneratedValue(strategy = GenerationType.TABLE)//Tabela do Hibernate no Banco para controle
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "minhaSequence")//Bancos com Sequence a parte
    //@SequenceGenerator(name = "minhaSequence", sequenceName = "MEUDB_RUN.seq_cliente")
    private Integer id;

    @Column(name = "txt_nome")
    private String nome;

    @Column(name = "nro_cpf", columnDefinition = "VARCHAR(14)", nullable = false)
    private String cpf;

    public String getDescricao(){
        return String.format("%s (%s)",this.nome, this.cpf);
    }

    public String getCpf(){
        return cpf;
    }

}
