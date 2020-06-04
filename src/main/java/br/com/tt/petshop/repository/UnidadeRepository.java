package br.com.tt.petshop.repository;

import br.com.tt.petshop.dto.UnidadeDto;
import br.com.tt.petshop.dto.UnidadeEntradaDto;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class UnidadeRepository {

    private JdbcTemplate jdbcTemplate;

    public UnidadeRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<UnidadeDto> listarUnidades() {
        // Forma antiga
        //List<String> unidades = jdbcTemplate
        //        .queryForList("select nome from unidade", String.class);
        //List<String> unidades = Arrays.asList("ZN", "ZS");
        //return unidades;

        //Forma com DTO
        return jdbcTemplate
                .query("select id,nome,endereco from unidade",
                        (rs, rowNum) -> new UnidadeDto(
                                rs.getInt("id"),
                                rs.getString("nome"),
                                rs.getString("endereco"))
                );
    }

    public void criarUnidade(UnidadeEntradaDto unidadeDto){
        String nome = unidadeDto.getNome();
        String endereco = unidadeDto.getEndereco();
        jdbcTemplate.update(
                "insert into UNIDADE (nome, endereco) values (?, ?)",
                nome, endereco
        );

    }

    public UnidadeDto buscarPorId(Long idUnidade) {
        return jdbcTemplate
                //.queryForList("select nome from unidade", String.class);
                .queryForObject("select id,nome,endereco from unidade where id = ?",
                        new Object[]{idUnidade},
                        (rs, rowNum) -> new UnidadeDto(
                                rs.getInt("id"),
                                rs.getString("nome"),
                                rs.getString("endereco")));
    }

    public void salvar(UnidadeDto unidade) {
        jdbcTemplate.update("update UNIDADE set nome = ?, endereco = ? where id = ?",
                unidade.getNome(), unidade.getEndereco(), unidade.getId());
    }

    public void remover(Long id){
        jdbcTemplate.update("delete from UNIDADE where id = ?", id);
    }


}
