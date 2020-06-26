package br.com.tt.petshop.model;

import br.com.tt.petshop.enumaration.TipoServico;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
    private LocalDateTime dataHora;

    @Column(name = "TIPO")
    @Enumerated(EnumType.STRING)
    private TipoServico tipo;

    @Column(name = "VALOR")
    @Positive
    private BigDecimal valorTotal;

//    @JoinColumn(name = "ID_FUNCIONARIO")
//    @OneToOne
//    @NotBlank
//    private Funcionario funcionario;

    @Column(name = "FUNCIONARIO")
    @NotBlank
    private String funcionario;

    @JoinColumn(name = "ID_ANIMAL")
    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Animal animal;

    public Long getId() { return id; }

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

    public String getFuncionario() { return funcionario; }

    public Animal getAnimal() { return animal; }

    //Construtor
    public Atendimento(Long id,
                       LocalDateTime dataHora,
                       TipoServico tipo,
                       String descricao,
                       String funcionario,
                       BigDecimal valorTotal,
                       Animal animal) {
        this.id = id;
        this.descricao = descricao;
        this.dataHora = dataHora;
        this.tipo = tipo;
        this.valorTotal = valorTotal;
        this.funcionario = funcionario;
        this.animal = animal;
    }


}
