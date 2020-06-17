package br.com.tt.petshop.service;

import br.com.tt.petshop.dto.AnimalEntradaDto;
import br.com.tt.petshop.dto.AnimalSaidaDto;
import br.com.tt.petshop.enumaration.TipoAnimal;
import br.com.tt.petshop.exception.ErroDeNegocioException;
import br.com.tt.petshop.model.Animal;
import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<AnimalSaidaDto> listarAnimais(Integer idCliente, TipoAnimal tipo)
    {
        //Cria variavel para poder usar fora do if
        List<Animal> animalDoCliente;
        //Testa se tipo é null para saber qual busca usar
        if(tipo == null) {
            animalDoCliente = animalRepository.buscaAnimaisDoCliente(idCliente);
        } else {
            animalDoCliente = animalRepository.buscaAnimaisDoClientePorTipo(idCliente, tipo);
        }
        //Converte Animal para AnimalSaidaDto
        List<AnimalSaidaDto> listaAnimalDoCliente = animalDoCliente.stream()
                .map(AnimalSaidaDto::build)
                .collect(Collectors.toList());
        //Se retorno do banco for vazio mensagem de erro
        if(listaAnimalDoCliente.isEmpty()){
            throw new ErroDeNegocioException("animal_nao_existe",
                                             "Não existem animais para esse cliente.");
        }
        return listaAnimalDoCliente;
    }

    public AnimalSaidaDto buscaAnimalPorId(Integer idCliente, Long idAnimal)
    {
        Animal animalDoCliente = animalRepository
                .buscaAnimalDoClientePorId(idCliente, idAnimal)
                .orElseThrow(() -> new ErroDeNegocioException("animal_nao_existe",
                                                              "Não existe animal com este ID para esse cliente."));
        return AnimalSaidaDto.converte(animalDoCliente);
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
