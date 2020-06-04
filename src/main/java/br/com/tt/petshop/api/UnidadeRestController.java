package br.com.tt.petshop.api;

import br.com.tt.petshop.dto.UnidadeDto;
import br.com.tt.petshop.service.UnidadeService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/unidades")
public class UnidadeRestController {
    //Atributos??
    private UnidadeService unidadeService;

    //construtor
    public UnidadeRestController(UnidadeService unidadeService){
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
                                    @RequestBody UnidadeDto unidadeParaAtualizar){
        unidadeService.atualizar(idUnidade, unidadeParaAtualizar);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity remover(@PathVariable("id") Long id){
        unidadeService.remover(id);
        return ResponseEntity.noContent().build();
    }
}
