package br.com.tt.petshop.api;

import br.com.tt.petshop.dto.UnidadeEntradaDto;
import br.com.tt.petshop.dto.UnidadeDto;
import br.com.tt.petshop.service.UnidadeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/unidades")
@Api(tags = "unidade")
public class UnidadeRestController {
    //Atributos??
    private UnidadeService unidadeService;

    //construtor
    public UnidadeRestController(UnidadeService unidadeService) {
        this.unidadeService = unidadeService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UnidadeDto> lista(){
        return unidadeService.listarUnidades();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UnidadeDto buscaPorId(@PathVariable("id") Long idUnidade) {
        return unidadeService.buscarPorId(idUnidade);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity atualizar(@PathVariable("id") Long idUnidade,
                                    @RequestBody @Valid UnidadeEntradaDto unidadeParaAtualizar) {
        unidadeService.atualizar(idUnidade, unidadeParaAtualizar);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity remover(
            @ApiParam(name = "id", value = "ID sequencial")
            @PathVariable("id") Long id) {
        unidadeService.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity criar(@RequestBody @Valid UnidadeEntradaDto unidadeParaCriar) {
        unidadeService.criarUnidade(unidadeParaCriar);
        URI location = URI.create("/unidades/");
        return ResponseEntity.created(location).build();
    }
}
