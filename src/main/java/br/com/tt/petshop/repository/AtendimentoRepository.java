package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Atendimento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtendimentoRepository extends
        CrudRepository<Atendimento, Long> {

    List<Atendimento> findAll();

}
