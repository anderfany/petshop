package br.com.tt.petshop.service;

import br.com.tt.petshop.dto.ClienteEntradaDto;
import br.com.tt.petshop.dto.ClienteSaidaDto;
import br.com.tt.petshop.exception.CpfInvalidoException;
import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.repository.ClienteRepository;
import br.com.tt.petshop.util.CpfValidator;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class ClienteService {

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
        Cliente clienteConvertidoDtoParaEntidade = new Cliente(clienteParaCriar);
        return clienteRepository.criarCliente(clienteConvertidoDtoParaEntidade);
    }

    public Cliente buscaPorId(Integer id){

        return this.clienteRepository.buscarPorId(id);
    }

    @Transactional
    public void atualizar(Integer id, ClienteEntradaDto clienteParaAtualizar) {
        Cliente clienteSalvoNoBanco = this.buscaPorId(id);
        clienteSalvoNoBanco.atualizarDadosClienteNaMemoria(clienteParaAtualizar);
        clienteRepository.salvar(clienteSalvoNoBanco);
    }

    @Transactional
    public void remover(Integer id){
        Cliente clienteASerRemovido = this.buscaPorId(id);
        if (clienteASerRemovido != null) {
            clienteRepository.remover(clienteASerRemovido);
        }
    }

    @Transactional
    public void removerPorId(Integer id) {

        clienteRepository.removerPorId(id);
    }
}
