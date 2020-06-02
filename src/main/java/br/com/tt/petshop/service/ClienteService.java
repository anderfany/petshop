package br.com.tt.petshop.service;

import br.com.tt.petshop.exception.CpfInvalidoException;
import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.repository.ClienteRepository;
import br.com.tt.petshop.util.CpfValidator;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;
    private CpfValidator cpfValidator;

    public ClienteService(ClienteRepository clienteRepository, CpfValidator cpfValidator) {
        this.clienteRepository = clienteRepository;
        this.cpfValidator = cpfValidator;
    }

    public List<Cliente> listarClientes(){
        return this.clienteRepository.listarClientes();
    }

    @Transactional//Deixa tudo abaixo de uma transação, ou seja, propricia ROLLBACK!
    //Poderia estar no Repository também, mas é mais comum no Service.
    public void criarCliente(Cliente cliente) {

        if( ! cpfValidator.verificaSeCpfValido(cliente.getCpf())){
            throw new CpfInvalidoException();
        }
        clienteRepository.criarCliente(cliente);
    }

    public Cliente buscaPorId(Integer id){
        return this.clienteRepository.buscarPorId(id);
    }
}
