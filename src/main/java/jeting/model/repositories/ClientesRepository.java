package jeting.model.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import jeting.model.entities.ClientesEntidades;

public class ClientesRepository implements BasicCrud {
	
	EntityManager em = Persistence.createEntityManagerFactory("JetingDB").createEntityManager();

	@Override
	public Object create(Object object) {
		ClientesEntidades cliente = (ClientesEntidades) object;
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		return cliente;
	}

	@Override
	public Object findById(Long id) {
		return em.find(ClientesEntidades.class, id);
	}

	@Override
	public Object updateById(Object object) {
		ClientesEntidades cliente = (ClientesEntidades) object;
		em.getTransaction().begin();
		cliente = em.merge(cliente);
		em.getTransaction().commit();
		return cliente;
	}

	@Override
	public void delete(Long id) {
		ClientesEntidades cliente = (ClientesEntidades) findById(id);
		if(cliente != null) {
			em.getTransaction().begin();
			em.remove(cliente);
			em.getTransaction().commit();
		}
	}

	public List<ClientesEntidades> findAll() {
		return em.createQuery("SELECT c FROM clientes c", ClientesEntidades.class).getResultList();
	}
	
	public Long countClientes() {
		return (Long) em.createQuery("SELECT COUNT(c) FROM clientes c").getSingleResult();
	}

}
