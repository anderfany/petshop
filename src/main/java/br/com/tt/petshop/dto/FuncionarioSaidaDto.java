package br.com.tt.petshop.dto;

import br.com.tt.petshop.model.Funcionario;

public class FuncionarioSaidaDto {

    //Atributos
    private final Long id;
    private final String nome;

    //Construtor
    private FuncionarioSaidaDto(Funcionario funcionario) {
        this.id = funcionario.getId();
        this.nome = funcionario.getNome();
    }

    //Metodo por build
    public static FuncionarioSaidaDto build(Funcionario funcionario) {
        return new FuncionarioSaidaDto(funcionario);
    }

}
