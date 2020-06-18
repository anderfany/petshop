package br.com.tt.petshop.api;

import br.com.tt.petshop.dto.ClienteEntradaDto;
import br.com.tt.petshop.dto.ClienteSaidaDto;
import br.com.tt.petshop.dto.MensagemErroDto;
import br.com.tt.petshop.exception.CpfInvalidoException;
import br.com.tt.petshop.exception.ErroDeNegocioException;
import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.service.ClienteService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/clientes")
public class ClienteRestController {

    private ClienteService clienteService;

    public ClienteRestController(ClienteService clienteService) {

        this.clienteService = clienteService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ClienteSaidaDto> lista(){

        return clienteService.listarClientes();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity criar(@RequestBody @Valid ClienteEntradaDto clienteParaCriar) {
        Cliente clienteCriado = clienteService.criarCliente(clienteParaCriar);
        String location = String.format("/clientes/%d", clienteCriado.getId());

        return ResponseEntity
                .created(URI.create(location)).
                        build();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Cliente buscaPorId(@PathVariable(value = "id") Integer id) {

        return this.clienteService.buscaPorId(id);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity atualizar(@PathVariable("id") Integer id,
                                    @RequestBody @Valid ClienteEntradaDto clienteParaAtualizar) {
        clienteService.atualizar(id, clienteParaAtualizar);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity remover(@PathVariable("id") Integer id) {
        clienteService.remover(id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(CpfInvalidoException.class)
    public ResponseEntity<MensagemErroDto>
            trataCpfInvalido(CpfInvalidoException excessao) {

        MensagemErroDto mensagemErro = new MensagemErroDto("cpf_invalido", excessao.getMessage());
        return ResponseEntity.badRequest().body(mensagemErro);
    }

    @ExceptionHandler(ErroDeNegocioException.class)
    public ResponseEntity<ErroDeNegocioException>
    tratarErroNegocio(ErroDeNegocioException excessao) {

        ErroDeNegocioException mensagemErro = new ErroDeNegocioException("nome_invalido", excessao.getMessage());
        return ResponseEntity.badRequest().body(mensagemErro);
    }
}
