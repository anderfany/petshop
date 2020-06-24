package br.com.tt.petshop.model;

import br.com.tt.petshop.enumaration.TipoAnimal;
import br.com.tt.petshop.enumaration.TipoServico;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "TB_ATENDIMENTO")
public class Atendimento {

    //Construtor para o Hibernate
    Atendimento(){
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DESCRICAO")
    @NotBlank
    private String descricao;

    @Column(name = "DATA_HORA")
    @NotBlank
    private LocalDate dataHora;

    @Column(name = "TIPO")
    @Enumerated(EnumType.STRING)
    private TipoServico tipo;

    @Column(name = "VALOR")
    @Positive
    private BigDecimal valorTotal;

    @JoinColumn(name = "ID_FUNCIONARIO")
    @OneToOne
    @NotBlank
    private Funcionario funcionario;

    @JoinColumn(name = "ID_ANIMAL")
    @ManyToOne
    @NotBlank
    private Animal animal;

    public Long getId() { return id; }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataHora() {
        return dataHora;
    }

    public TipoServico getTipo() {
        return tipo;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public Funcionario getFuncionario() { return funcionario; }

    public Animal getAnimal() {
        return animal;
    }

}
