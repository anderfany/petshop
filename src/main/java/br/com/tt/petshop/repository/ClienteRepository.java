package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Cliente;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ClienteRepository {

    private EntityManager em;

    public ClienteRepository(EntityManager em){
        this.em = em;
    }

    public List<Cliente> listarClientes(){
        String minhaQueryJpql = "select c.nome from Cliente c";
        return em.createQuery(minhaQueryJpql).getResultList();
    }

    public Cliente buscarPorId(Integer id){
        return em.find(Cliente.class, id);
    }

    public void criarCliente(Cliente cliente){
        em.persist(cliente);
    }

}
