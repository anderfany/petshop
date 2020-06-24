package br.com.tt.petshop.dto;

import br.com.tt.petshop.enumaration.TipoServico;
import br.com.tt.petshop.model.Atendimento;
import br.com.tt.petshop.model.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AtendimentoSaidaDto {

    //Atributos
    private Long id;
    private String descricao;
    private LocalDate dataHora;
    private TipoServico tipo;
    private BigDecimal valorTotal;
    private Funcionario funcionario;
    private AnimalSaidaDto animal;

    //Neste exemplo nao criamos o metodo por Build para o construtor e deixamos o construtor principal exposto
    //para ser invocado para a construcao do DTO
    public AtendimentoSaidaDto(Atendimento atendimento) {
        this.id = atendimento.getId();
        this.descricao = atendimento.getDescricao();
        this.dataHora = atendimento.getDataHora();
        this.tipo = atendimento.getTipo();
        this.valorTotal = atendimento.getValorTotal();
        //this.funcionario = FuncionarioDto
        this.animal = AnimalSaidaDto.build(atendimento.getAnimal());

    }



}
