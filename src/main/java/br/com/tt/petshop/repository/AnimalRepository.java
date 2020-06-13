package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Animal;
import br.com.tt.petshop.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

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

    //Optional<Animal> findByNomeAndCliente(String nome, Cliente cliente);

}
