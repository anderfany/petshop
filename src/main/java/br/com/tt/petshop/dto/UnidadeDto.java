package br.com.tt.petshop.dto;

public class UnidadeDto {

    private Integer id;
    private String nome;
    private String endereco;

    public UnidadeDto(Integer id, String nome, String endereco) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {

        return nome;
    }

    public String getEndereco() {

        return endereco;
    }

    public String getDescricao() {

        return String.format("%s - %s", nome, endereco);
    }

    public void atualizarDadosUnidadeNaMemoria(UnidadeDto unidadeParaAtualizar) {
        this.nome = unidadeParaAtualizar.nome;
        this.endereco = unidadeParaAtualizar.endereco;
    }

}
