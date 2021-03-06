package br.com.tt.petshop.api;

import br.com.tt.petshop.dto.AnimalEntradaDto;
import br.com.tt.petshop.dto.AnimalSaidaDto;
import br.com.tt.petshop.enumaration.TipoAnimal;
import br.com.tt.petshop.model.Animal;
import br.com.tt.petshop.service.AnimalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clientes/{idCliente}/animais")
@Api(tags = "animal")
public class AnimalRestController {

    //Atributo
    private AnimalService animalService;

    //Construtor
    public AnimalRestController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @ApiOperation(value = "Listar animais")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AnimalSaidaDto> listarPorTipo(@PathVariable("idCliente") Integer idCliente,
                                @RequestParam(required = false, name = "tipo") TipoAnimal tipo) {
        return animalService.listarAnimais(idCliente, tipo);
    }

    @GetMapping(value = "/{idAnimal}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AnimalSaidaDto buscarPorId(@PathVariable("idCliente") Integer idCliente,
                                      @PathVariable("idAnimal") Long idAnimal) {
        return animalService.buscaAnimalPorId(idCliente, idAnimal);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity criar(@PathVariable("idCliente") Integer idCliente,
                                @RequestBody @Valid AnimalEntradaDto animalEntradaDto) {
        Animal animalPersistido = animalService.criarAnimal(animalEntradaDto, idCliente);

        String location = String.format("/clientes/%d/animais/%d", idCliente, animalPersistido.getId());
        return ResponseEntity.created(URI.create(location)).build();
    }


}
