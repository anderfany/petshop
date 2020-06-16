package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Animal;
import br.com.tt.petshop.model.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AnimalRepository extends
        CrudRepository<Animal, Long>
//        , JpaRepository<Animal, Long>
//        , PagingAndSortingRepository<Animal, Long>
{
    List<Animal> findAll();

    Optional<Animal> findById(Long id);

    //Query Methods
    //Optional<Animal> findByNomeAndCliente(String nome, Cliente cliente);



    //Query JPQL
    @Query("select a from Animal a where a.dataNascimento = :dataNascimento")
    List<Animal> buscarPorDataDeNascimento(@Param("dataNascimento") LocalDate dataNascimento);

    @Query("select a from Animal a join a.cliente c where c.id = :idCliente")
    List<Animal> buscaAnimaisDoCliente(@Param("idCliente") Integer idCliente);

    @Query("select a from Animal a join a.cliente c where c.cpf = :cpf ")
    List<Animal> buscaAnimaisDoClientePorCpf(@Param("cpf") String cpf);

    //Query Nativa
    @Query(value = "select A.NOME FROM TB_ANIMAL A order limit 1 by A.ID desc", nativeQuery = true)
    String buscarUltimoNomeAnimalCadastrado();
}
