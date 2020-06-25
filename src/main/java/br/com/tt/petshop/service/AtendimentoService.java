package br.com.tt.petshop.service;

import br.com.tt.petshop.dto.AtendimentoEntradaDto;
import br.com.tt.petshop.dto.AtendimentoSaidaDto;
import br.com.tt.petshop.model.Animal;
import br.com.tt.petshop.model.Atendimento;
import br.com.tt.petshop.repository.AtendimentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AtendimentoService {

    //Atributos
    private final AnimalService animalService;
    private final AtendimentoRepository atendimentoRepository;

    //Construtor
    private AtendimentoService(AnimalService animalService,
                               AtendimentoRepository atendimentoRepository) {
        this.animalService = animalService;
        this.atendimentoRepository = atendimentoRepository;
    }

    //Metodos
    public List<AtendimentoSaidaDto> listarAtendimentos() {

        //Foi usado o construtor principal do SaidaDTO ao inves do metodo por Build
        return atendimentoRepository.findAll()
                .stream()
                //.map(AtendimentoSaidaDto::new)
                .map(AtendimentoSaidaDto::new)
                .collect(Collectors.toList());
    }

    public Atendimento criarAtendimento(AtendimentoEntradaDto atendimentoEntradaDto) {
//        Atendimento atendimentoNovo = new Atendimento(atendimentoEntradaDto);
//        Atendimento atendimentoSalvo = atendimentoRepository.save(atendimentoNovo);
//        return atendimentoSalvo;

        //Convertido para toEntity que é a boa pratica
        //Pre-requisito, buscar o Animal com o idAnimal que informado no PostMapping
        Animal animal = animalService.buscarPorId(atendimentoEntradaDto.getIdAnimal());
        //Converte
        Atendimento atendimentoAserSalvo = atendimentoEntradaDto.toEntity(animal);
        //Salvar
        Atendimento atendimentoSalvo = atendimentoRepository.save(atendimentoAserSalvo);
        //retornar o atendimento salvo
        return atendimentoSalvo;
    }


}
