package br.com.tt.petshop.service;

import br.com.tt.petshop.dto.AnimalSaidaDto;
import br.com.tt.petshop.dto.AtendimentoEntradaDto;
import br.com.tt.petshop.dto.AtendimentoSaidaDto;
import br.com.tt.petshop.dto.ClienteSaidaDto;
import br.com.tt.petshop.model.Atendimento;
import br.com.tt.petshop.repository.AtendimentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AtendimentoService {

    //Atributos
    private final AtendimentoRepository atendimentoRepository;

    //Construtor
    private AtendimentoService(AtendimentoRepository atendimentoRepository){
        this.atendimentoRepository = atendimentoRepository;
    }

    //Metodos
    public List<AtendimentoSaidaDto> listarAtendimentos() {

        //Foi usado o construtor principal ao inves do metodo por Build
        return atendimentoRepository.findAll()
                .stream()
                .map(AtendimentoSaidaDto::new)
                .collect(Collectors.toList());
    }

    public Atendimento criarAtendimento(AtendimentoEntradaDto atendimentoEntradaDto) {

        return void;
    }


}
