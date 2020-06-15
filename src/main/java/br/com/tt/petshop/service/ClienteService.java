package br.com.tt.petshop.service;

import br.com.tt.petshop.dto.ClienteEntradaDto;
import br.com.tt.petshop.dto.ClienteSaidaDto;
import br.com.tt.petshop.exception.CpfInvalidoException;
import br.com.tt.petshop.exception.ErroDeNegocioException;
import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.repository.ClienteRepository;
import br.com.tt.petshop.util.CpfValidator;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ClienteService {

    public static String SEPARADOR = " "; //Constante para usar no espaço em branco
    private ClienteRepository clienteRepository;
    private CpfValidator cpfValidator;

    public ClienteService(ClienteRepository clienteRepository, CpfValidator cpfValidator) {
        this.clienteRepository = clienteRepository;
        this.cpfValidator = cpfValidator;
    }

    public List<ClienteSaidaDto> listarClientes(){

        return this.clienteRepository.listarClientes()
                .stream()
                .map(ClienteSaidaDto::converte)
                .collect(Collectors.toList());
    }

    @Transactional//Deixa tudo abaixo de uma transação, ou seja, propricia ROLLBACK!
    //Poderia estar no Repository também, mas é mais comum no Service.
    public Cliente criarCliente(ClienteEntradaDto clienteParaCriar) {

        if( ! cpfValidator.verificaSeCpfValido(clienteParaCriar.getCpf())){
            throw new CpfInvalidoException("O formato do CPF está incorreto");
        }

        //Cliente tem que ter no minimo duas partes
        if(!verificaSeClientePossuiDuasPartes(clienteParaCriar.getNome())){
            throw new ErroDeNegocioException("nome_invalido", "Cliente deve conter nome e sobrenome");
        }

        //Cada parte do cliente tem que ter no minimo duas letras
        if(!verificaSePartesClientePossuiDuasLetras(clienteParaCriar.getNome())){
            throw new ErroDeNegocioException("nome_invalido", "Cliente nao pode conter duas letras ou menos");
        }

        Cliente clienteConvertidoDtoParaEntidade = new Cliente(clienteParaCriar);
        return clienteRepository.criarCliente(clienteConvertidoDtoParaEntidade);
    }

    //Cliente tem que ter no minimo duas partes
    private boolean verificaSeClientePossuiDuasPartes(String nome) {
        return nome.split(SEPARADOR).length > 2;
    }

    //Cada parte do cliente tem que ter no minimo duas letras
    private boolean verificaSePartesClientePossuiDuasLetras(String nome) {
        return Stream.of(nome.split(SEPARADOR)).allMatch(parte -> parte.length() > 2);
    }

    public Cliente buscaPorId(Integer id) {
        return this.clienteRepository.buscarPorId(id);
    }

    @Transactional
    public Cliente atualizar(Integer id, ClienteEntradaDto clienteParaAtualizar) {
        Cliente clienteSalvoNoBanco = clienteRepository.buscarPorId(id);
        clienteSalvoNoBanco.atualizarDadosClienteNaMemoria(clienteParaAtualizar);
        return clienteRepository.atualizar(clienteSalvoNoBanco);
    }

    @Transactional
    public void remover(Integer id){
        Cliente clienteASerRemovido = this.buscaPorId(id);
        if (clienteASerRemovido != null) {
            clienteRepository.remover(clienteASerRemovido);
        }
    }

    @Transactional
    public void removerPorId(Integer id) { clienteRepository.removerPorId(id); }
}
