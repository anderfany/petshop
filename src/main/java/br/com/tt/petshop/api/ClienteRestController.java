package br.com.tt.petshop.api;

import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.service.ClienteService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteRestController {

    private ClienteService clienteService;

    public ClienteRestController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cliente> lista(){
        return clienteService.listarClientes();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Cliente buscaPorId(@PathVariable(value = "id") Integer id){
        return this.clienteService.buscaPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizar(@PathVariable("id") Integer id,
                                    @RequestBody Cliente clienteParaAtualizar){
        clienteService.atualizar(id, clienteParaAtualizar);
        return ResponseEntity.noContent().build();
    }
}
