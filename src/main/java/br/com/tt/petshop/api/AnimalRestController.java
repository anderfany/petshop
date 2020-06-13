package br.com.tt.petshop.api;

import br.com.tt.petshop.dto.AnimalSaidaDto;
import br.com.tt.petshop.model.Animal;
import br.com.tt.petshop.service.AnimalService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/animais")
public class AnimalRestController {

    //Atributo
    private final AnimalService animalService;

    //Construtor
    public AnimalRestController(AnimalService animalService) {

        this.animalService = animalService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AnimalSaidaDto> lista() {
        return animalService.listarAnimais();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Animal> buscarPorId(@PathVariable("id") Long id) {
        return animalService.buscarPorId(id);
    }

}
