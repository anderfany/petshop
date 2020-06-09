package br.com.tt.petshop.dto;

import br.com.tt.petshop.model.Cliente;

public class ClienteSaidaDto {
    private Integer id;
    private String nome;
    private String cpf;

    public ClienteSaidaDto(Cliente cliente){
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
    }

    public static ClienteSaidaDto converte(Cliente cliente){

        return new ClienteSaidaDto(cliente);
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

    public String getDescricao() {

        return String.format("Nome: %s e Cpf: %s", this.nome, this.cpf);
    }


}
