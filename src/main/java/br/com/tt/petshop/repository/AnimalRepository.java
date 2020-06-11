package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Animal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends
        CrudRepository<Animal, Long>
//        , JpaRepository<Animal, Long>
//        , PagingAndSortingRepository<Animal, Long>
{
    List<Animal> findAll();

}
