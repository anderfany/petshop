package br.com.tt.petshop.dto;

import br.com.tt.petshop.enumaration.TipoServico;
import br.com.tt.petshop.model.Animal;
import br.com.tt.petshop.model.Atendimento;
import br.com.tt.petshop.model.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class AtendimentoEntradaDto {

    //Atributos
    private TipoServico tipo;
    private String descricao;
    private BigDecimal valorTotal;
    //private Funcionario funcionario;
    private String funcionario;
    private Long idAnimal;

    public AtendimentoEntradaDto(TipoServico tipo,
                                 String descricao,
                                 BigDecimal valorTotal,
                                 //Funcionario funcionario,
                                 String funcionario,
                                 Long idAnimal) {
        this.descricao = descricao;
        this.tipo = tipo;
        this.valorTotal = valorTotal;
        this.funcionario = funcionario;
        this.idAnimal = idAnimal;
    }

    public TipoServico getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public Long getIdAnimal() {
        return idAnimal;
    }

    public Atendimento toEntity(Animal animal) {
        return new Atendimento(null, LocalDateTime.now(), tipo, descricao,
                funcionario, valorTotal, animal);
    }
}
