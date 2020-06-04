package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Cliente;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
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

    public Cliente criarCliente(Cliente clienteConvertidoEntidadeParaCriar){
        em.persist(clienteConvertidoEntidadeParaCriar);
        return clienteConvertidoEntidadeParaCriar;
    }

    public void salvar(Cliente cliente){
        em.persist(cliente);
    }

    public void remover(Cliente clienteASerRemovido){
        em.remove(clienteASerRemovido);
    }

    public void removerPorId(Integer id){
        em.createQuery("delete from Cliente c where c.id = :idCliente")
                .setParameter("idCliente", id)
                .executeUpdate();
    }

}
