package br.com.tt.petshop.api;

import br.com.tt.petshop.dto.UnidadeDto;
import br.com.tt.petshop.service.UnidadeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UnidadeRestController {
    //Atributos??
    private UnidadeService unidadeService;

    //construtor
    public UnidadeRestController(UnidadeService unidadeService){
        this.unidadeService = unidadeService;
    }

    @GetMapping(value = "/unidades", produces = "application/json")
    public List<UnidadeDto> lista(){
        return unidadeService.listarUnidades();
    }

    @GetMapping(value = "/unidades/{id}", produces = "application/json")
    public UnidadeDto buscaPorId(@PathVariable("id") Long idUnidade) {
        return unidadeService.buscarPorId(idUnidade);

    }

}
