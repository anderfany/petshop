package br.com.tt.petshop.service;

import br.com.tt.petshop.dto.UnidadeDto;
import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.repository.UnidadeRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class UnidadeServiceTest {

    private UnidadeRepository unidadeRepositoryMock;
    private UnidadeService unidadeService;

    @BeforeEach
    void inicializacao(){
        unidadeRepositoryMock = Mockito.mock(UnidadeRepository.class);
        unidadeService = new UnidadeService(unidadeRepositoryMock);
    }

    @Test
    void deveriaCriarComSucessoUsandoRepository(){

        UnidadeDto unidade = new UnidadeDto(1,"NOME_VALIDO", "ENDERECO_VALIDO");

        unidadeService.criarUnidade(unidade);

        verify(unidadeRepositoryMock).criarUnidade(unidade);
    }

    @Test
    void deveriaListarUnidadeUsandoRepository(){
        //Preparacao
        List<UnidadeDto> listaUnidades = Arrays.asList(
                new UnidadeDto(1, "NOME_VALIDO", "ENDERECO_VALIDO"));
        Mockito.when(unidadeRepositoryMock.listarUnidades()).thenReturn(listaUnidades);

        //Acao
        List<UnidadeDto> unidades = unidadeService.listarUnidades();

        //Verificao
        assertEquals(1, unidades.size());
        UnidadeDto algumaUnidade = unidades.get(0);
        assertEquals("NOME_VALIDO", algumaUnidade.getNome());
        assertEquals("ENDERECO_VALIDO", algumaUnidade.getEndereco());
        assertEquals("NOME_VALIDO - ENDERECO_VALIDO", algumaUnidade.getDescricao());

        verify(unidadeRepositoryMock).listarUnidades();
    }

}