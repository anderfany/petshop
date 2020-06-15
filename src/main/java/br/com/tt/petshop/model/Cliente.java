package br.com.tt.petshop.model;

import br.com.tt.petshop.dto.ClienteEntradaDto;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_CLIENTE")
public class Cliente {

    //Construtor default para o Hibernate
    Cliente() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Geração automática pelo BD
    //@GeneratedValue(strategy = GenerationType.TABLE)//Tabela do Hibernate no Banco para controle
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "minhaSeq")//BDs com SEQUENCE a parte
    //@SequenceGenerator(name = "minhaSeq", sequenceName = "MEUDB_RUN.seq_cliente")
    @Column(name = "ID")
    private Integer id;

    @Column(name = "txt_nome")
    //Propriedades de colum: insertable (não é considerado no insert) / updatable, não é considerado no update
    private String nome;

    @Column(name = "nro_cpf", columnDefinition = "VARCHAR(14)", nullable = false)
    private String cpf;

    @OneToMany(mappedBy = "cliente")
    private List<Animal> animais;

    //Construtor
    public Cliente(ClienteEntradaDto clienteEntrada) { this.atualizarDadosClienteNaMemoria(clienteEntrada); }

    //Getters
    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() { return cpf; }

    //Poderia ir para uma classe Mapper???
    public void atualizarDadosClienteNaMemoria(ClienteEntradaDto clienteParaAtualizar) {
        this.nome = clienteParaAtualizar.getNome();
        this.cpf = clienteParaAtualizar.getCpf();
    }

}
