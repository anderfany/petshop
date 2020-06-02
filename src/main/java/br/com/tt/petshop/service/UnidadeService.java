package br.com.tt.petshop.service;

import br.com.tt.petshop.dto.UnidadeDto;
import br.com.tt.petshop.repository.UnidadeRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UnidadeService {

    private UnidadeRepository unidadeRepository;

    //Construtor
    public UnidadeService(UnidadeRepository unidadeRepository){
        this.unidadeRepository = unidadeRepository;
    }

    //Metodo
    public List<UnidadeDto> listarUnidades(){
        return unidadeRepository.listarUnidades();
    }

    //Metodo - como nao retorna nada, diz-se que ele retorna void
    public void criarUnidade(UnidadeDto unidadeDto){
        unidadeRepository.criarUnidade(unidadeDto);
    }

    public UnidadeDto buscarPorId(Long idUnidade) {
        return unidadeRepository.buscarPorId(idUnidade);
    }

}
