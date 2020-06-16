package br.com.tt.petshop.service;

import br.com.tt.petshop.dto.AnimalEntradaDto;
import br.com.tt.petshop.dto.AnimalSaidaDto;
import br.com.tt.petshop.model.Animal;
import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.repository.AnimalRepository;
import br.com.tt.petshop.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnimalService {
    //Você pode injetar tanto classes quanto interfaces
    // (desde que as interfaces tenham uma implementação)
    // Neste caso o Spring irá criar essa implementação EM RUNTIME.
    //Atributo
    private final AnimalRepository animalRepository;
    private final ClienteService clienteService;

    //Construtor
    public AnimalService(AnimalRepository animalRepository, ClienteService clienteService)
    {
        this.animalRepository = animalRepository;
        this.clienteService = clienteService;
    }

    public List<AnimalSaidaDto> listarAnimais(Integer idCliente)
    {
        return animalRepository.buscaAnimaisDoCliente(idCliente)
                .stream()
                .map(AnimalSaidaDto::converte)
                .collect(Collectors.toList());
    }

    public Optional<Animal> buscarPorId(Long id)
    {
        return animalRepository.findById(id);
    }

    public Animal criarAnimal(AnimalEntradaDto animalEntradaDto, Integer idCliente)
    {
        Cliente clienteDonoAnimal = clienteService.buscaPorId(idCliente);
        Animal animalNovo = new Animal(animalEntradaDto, clienteDonoAnimal);
        return animalRepository.save(animalNovo);
    }

    public void removerAnimal(Long id)
    {
        animalRepository.findById(id)
                .ifPresentOrElse( animal -> animalRepository.delete(animal),
                        () -> {throw new RuntimeException("Animal não existe");});
    }

    //public Animal buscarPorAnimalECliente(String nome, Cliente cliente){
    //    return animalRepository.findByNomeAndCliente(nome, cliente);
    //}

}
