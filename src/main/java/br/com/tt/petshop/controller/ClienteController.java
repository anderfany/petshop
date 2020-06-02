package br.com.tt.petshop.controller;

import br.com.tt.petshop.dto.UnidadeDto;
import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.repository.ClienteRepository;
import br.com.tt.petshop.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/cliente")
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {

        this.clienteService = clienteService;
    }

    @RequestMapping("lista")
    public String listarClientes(Model model){

        List<Cliente> clientes = clienteService.listarClientes();
        model.addAttribute("clientes", clientes);

        return "cliente_lista";
    }

    @RequestMapping("cadastro")
    public String getPaginaCadastro(){
        return "cliente_cadastro";
    }

    @RequestMapping("acaoCadastrar")
    public ModelAndView acaoCadastrar(
                                      @RequestParam("nome") String nome,
                                      @RequestParam("cpf") String cpf){
        Cliente cliente = new Cliente(nome, cpf);
        clienteService.criarCliente(cliente);

        return new ModelAndView("cliente_cadastro");
    }




}
