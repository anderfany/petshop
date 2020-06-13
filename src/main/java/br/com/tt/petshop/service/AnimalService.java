package br.com.tt.petshop.service;

import br.com.tt.petshop.model.Animal;
import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {
    //Você pode injetar tanto classes quanto interfaces
    // (desde que as interfaces tenham uma implementação)
    // Neste caso o Spring irá criar essa implementação EM RUNTIME.
    //Atributo
    private AnimalRepository animalRepository;

    //Construtor
    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> listarAnimais() {
        return animalRepository.findAll();
    }

    public Optional<Animal> buscarPorId(Long id)
    {
        return animalRepository.findById(id);
    }

    public void removerAnimal(Long id){
        animalRepository.findById(id)
                .ifPresentOrElse( animal -> animalRepository.delete(animal),
                        () -> {throw new RuntimeException("Animal não existe");});
    }

    //public Animal buscarPorAnimalECliente(String nome, Cliente cliente){
    //    return animalRepository.findByNomeAndCliente(nome, cliente);
    //}

}
