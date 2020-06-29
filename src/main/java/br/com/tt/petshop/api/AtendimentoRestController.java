package br.com.tt.petshop.api;

import br.com.tt.petshop.dto.AtendimentoEntradaDto;
import br.com.tt.petshop.dto.AtendimentoSaidaDto;
import br.com.tt.petshop.dto.ClienteEntradaDto;
import br.com.tt.petshop.model.Atendimento;
import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.service.AtendimentoService;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/atendimentos")
@Api(tags = "atendimento")
public class AtendimentoRestController {

    //Atributos
    private AtendimentoService atendimentoService;

    //Construtor
    public AtendimentoRestController(AtendimentoService atendimentoService) {
        this.atendimentoService = atendimentoService;
    }

    //Metodos
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AtendimentoSaidaDto> listar() {
        return atendimentoService.listarAtendimentos();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity criar(@RequestBody @Valid AtendimentoEntradaDto atendimentoParaCriar) {
        Atendimento atendimentoCriado = atendimentoService.criarAtendimento(atendimentoParaCriar);
        String location = String.format("/atendimentos/%d", atendimentoCriado.getId());
        return ResponseEntity
                .created(URI.create(location))
                .build();
    }


}
