package br.com.tt.petshop.dto;

import br.com.tt.petshop.model.Cliente;

public class ClienteSaidaDto {

    //Atributos
    private Integer id;
    private String nome;
    private String cpf;

    //Construtor
    private ClienteSaidaDto(Cliente cliente){
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
    }

    //Conversor Repository -> Service - Mudar para Mapper???
    public static ClienteSaidaDto converte(Cliente cliente){
        return new ClienteSaidaDto(cliente);
    }

    //Getters
    public Integer getId() { return id; }

    public String getNome() { return nome; }

    public String getCpf() { return cpf; }

    //Descricao personalizada
    public String getDescricao() {
        return String.format("Nome: %s e Cpf: %s", this.nome, this.cpf);
    }

}
