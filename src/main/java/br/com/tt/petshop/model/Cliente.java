package br.com.tt.petshop.model;

import br.com.tt.petshop.dto.ClienteEntradaDto;

import javax.persistence.*;

@Entity
public class Cliente {

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

    //Construtor default para o Hibernate funcionar!!
    Cliente(){
    }

    //Construtor
    public Cliente(ClienteEntradaDto clienteEntrada) {

        this.atualizarDadosClienteNaMemoria(clienteEntrada);
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {

        return cpf;
    }

    public void atualizarDadosClienteNaMemoria(ClienteEntradaDto clienteParaAtualizar) {
        this.nome = clienteParaAtualizar.getNome();
        this.cpf = clienteParaAtualizar.getCpf();
    }

}
