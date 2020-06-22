package br.com.tt.petshop.model;

import br.com.tt.petshop.enumaration.TipoAnimal;
import br.com.tt.petshop.enumaration.TipoServico;
import javax.persistence.*;

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
    private String descricao;

    @Column(name = "DATA_HORA")
    private LocalDate dataHora;

    @Column(name = "TIPO")
    @Enumerated(EnumType.STRING)
    private TipoServico tipo;

    @Column(name = "VALOR")
    private BigDecimal valorTotal;

    @JoinColumn(name = "ID_FUNCIONARIO")
    @OneToOne
    private Funcionario funcionario;

    @JoinColumn(name = "ID_ANIMAL")
    @ManyToOne
    private Animal animal;
}
