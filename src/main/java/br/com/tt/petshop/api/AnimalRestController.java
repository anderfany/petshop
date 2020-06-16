package br.com.tt.petshop.api;

import br.com.tt.petshop.dto.AnimalEntradaDto;
import br.com.tt.petshop.dto.AnimalSaidaDto;
import br.com.tt.petshop.model.Animal;
import br.com.tt.petshop.service.AnimalService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes/{idCliente}/animais")
public class AnimalRestController {

    //Atributo
    private AnimalService animalService;

    //Construtor
    public AnimalRestController(AnimalService animalService) {

        this.animalService = animalService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AnimalSaidaDto> listar(@PathVariable("idCliente") Integer idCliente) {
        return animalService.listarAnimais(idCliente);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Animal> buscarPorId(@PathVariable("id") Long id) {
        return animalService.buscarPorId(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity criar(@PathVariable("idCliente") Integer idCliente,
                                @RequestBody AnimalEntradaDto animalEntradaDto){
        Animal animalPersistido = animalService.criarAnimal(animalEntradaDto, idCliente);

        String location = String.format("/clientes/%d/animais/%d", idCliente, animalPersistido.getId());
        return ResponseEntity.created(URI.create(location)).build();
    }


}
