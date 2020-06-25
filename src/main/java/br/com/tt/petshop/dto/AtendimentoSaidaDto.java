package br.com.tt.petshop.dto;

import br.com.tt.petshop.enumaration.TipoServico;
import br.com.tt.petshop.model.Atendimento;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class AtendimentoSaidaDto {

    //Atributos
    private Long id;
    private String descricao;
    private LocalDateTime dataHora;
    private TipoServico tipo;
    private BigDecimal valorTotal;
    private String funcionario;
    private AnimalSaidaDto animal;

    //Neste exemplo nao criamos o metodo por Build para o construtor e deixamos o construtor principal exposto
    //para ser invocado para a construcao no Service
    public AtendimentoSaidaDto(Atendimento atendimento) {
        this.id = atendimento.getId();
        this.descricao = atendimento.getDescricao();
        this.dataHora = atendimento.getDataHora();
        this.tipo = atendimento.getTipo();
        this.valorTotal = atendimento.getValorTotal();
        //this.funcionario = FuncionarioSaidaDto.build(atendimento.getFuncionario());
        this.funcionario = atendimento.getFuncionario();
        this.animal = AnimalSaidaDto.build(atendimento.getAnimal());
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public TipoServico getTipo() {
        return tipo;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

//    public FuncionarioSaidaDto getFuncionario() {
//        return funcionario;
//    }

    public String getFuncionario() {
        return funcionario;
    }

    public AnimalSaidaDto getAnimal() {
        return animal;
    }
}
