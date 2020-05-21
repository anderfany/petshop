package br.com.tt.petshop.service;

import br.com.tt.petshop.dto.UnidadeDto;
import br.com.tt.petshop.repository.UnidadeRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UnidadeService {

    private UnidadeRepository unidadeRepository;

    public UnidadeService(UnidadeRepository unidadeRepository){

        this.unidadeRepository = unidadeRepository;
    }

    public List<UnidadeDto> listarUnidades(){
        //List<String> unidades = Arrays.asList("ZN","ZS");
        return unidadeRepository.listarUnidades();
    }

    public void criarUnidade(UnidadeDto unidadeDto){
        unidadeRepository.criarUnidade(unidadeDto);
    }
}
