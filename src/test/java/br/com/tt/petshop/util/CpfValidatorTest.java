package br.com.tt.petshop.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CpfValidatorTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void deveriaValidarCpfSemFormatacao() {
        //Preparacao
        String cpf = "00011122233";
        //Acao
        boolean resultado = new CpfValidator().verificaSeCpfValido(cpf);
        //Verificacao
        Assertions.assertTrue(resultado, "Deveria ser um CPF valido!");
    }

    //deveriaFalharComCpfMenorQue11Digitos
    @Test
    void deveriaFalharComCpfMenorOnzeCaracteres() {
        //Preparacao
        String cpf = "0001112223";
        //Acao
        boolean resultado = new CpfValidator().verificaSeCpfValido(cpf);
        //Verificacao
        Assertions.assertFalse(resultado, "CPF menor que onze caracteres");
    }

    //deveriaFalharComCpfMaiorQue14Digitos
    @Test
    void deveriaFalharComCpfMaiorQuatorzeCaracteres() {
        //Preparacao
        String cpf = "000111222333444";
        //Acao
        boolean resultado = new CpfValidator().verificaSeCpfValido(cpf);
        //Verificacao
        Assertions.assertFalse(resultado, "CPF maior que quatorze caracteres");
    }

    @Test
    void deveriaFalharCpfSemFormatacaoComLetras() {
        //Preparacao
        String cpf = "0001112223A";
        //Acao
        boolean resultado = new CpfValidator().verificaSeCpfValido(cpf);
        //Verificacao
        Assertions.assertFalse(resultado, "CPF contem letras!");
    }

    @Test
    void deveriaFalharCpfComFormatacaoIncorreta(){
        //Preparação
        String cpf = "000.111.2223-3";

        //Ação
        boolean resultado = new CpfValidator().verificaSeCpfValido(cpf);

        //Verificação
        assertFalse(resultado, "Deveria falhar pois contém formatação inválida");
    }

    @Test
    void deveriaFalharEmCpfComFormatacaoELetras(){
        //Preparação
        String cpf = "000.111.A22-33";

        //Ação
        boolean resultado = new CpfValidator().verificaSeCpfValido(cpf);

        //Verificação
        assertFalse(resultado, "Deveria falhar pois contém letras");
    }



    @Test
    void deveriaValidarCpfComFormatacao() {
        //Preparação
        String cpf = "000.111.222-33";

        //Ação
        boolean resultado = new CpfValidator().verificaSeCpfValido(cpf);

        //Verificação
        Assertions.assertTrue(resultado, "Deveria ser um CPF Válido");
    }

    @ParameterizedTest
    @ValueSource(strings = {"111.222.334-00", "111.111.111-11", "000.111.000-99"})
    void deveriaValidarComSucessoCpfsValidos(String cpf){
        //Ação
        boolean resultado = new CpfValidator().verificaSeCpfValido(cpf);

        //Verificação
        assertTrue(resultado, "Deveria passar pois cpf é válido");
    }

    @ParameterizedTest
    @ValueSource(strings = {"11.222.334-00", "111.11.111-11", "000.111.000-$9", "C00.111.000-11"})
    void deveriaRetornarCpfsInValidos(String cpf){
        //Ação
        boolean resultado = new CpfValidator().verificaSeCpfValido(cpf);

        //Verificação
        assertFalse(resultado, "Deveria falhar pois cpf é válido");
    }

}