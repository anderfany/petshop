package br.com.tt.petshop.api;

import br.com.tt.petshop.model.Animal;
import br.com.tt.petshop.service.AnimalService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public List<Animal> lista() {
        return animalService.listarAnimais();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Animal buscarPorId(@PathVariable("id") Long id) {
        return animalService.buscarPorId(id);
    }
}
