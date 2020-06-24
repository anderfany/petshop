package br.com.tt.petshop.dto;

import br.com.tt.petshop.enumaration.TipoServico;
import br.com.tt.petshop.model.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AtendimentoEntradaDto {

    //Atributos
    private String descricao;
    private LocalDate dataHora;
    private TipoServico tipo;
    private BigDecimal valorTotal;
    private Funcionario funcionario;
    private AnimalSaidaDto animal;



}
