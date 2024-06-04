package jeting.model.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import jeting.model.entities.ServicosEntidades;


public class ServicosRepository implements BasicCrud {
	
	EntityManager em = Persistence.createEntityManagerFactory("JetingDB").createEntityManager();

	@Override
	public Object create(Object object) {
		ServicosEntidades servico = (ServicosEntidades) object;
		em.getTransaction().begin();
		em.persist(servico);
		em.getTransaction().commit();
		return servico;
	}

	@Override
	public Object findById(Long id) {
		return em.find(ServicosEntidades.class, id);
	}

	@Override
	public Object updateById(Object object) {
		ServicosEntidades servico = (ServicosEntidades) object;
		em.getTransaction().begin();
		servico = em.merge(servico);
		em.getTransaction().commit();
		return servico;
	}

	@Override
	public void delete(Long id) {
		ServicosEntidades servico = (ServicosEntidades) findById(id);
		if(servico != null) {
			em.getTransaction().begin();
			em.remove(servico);
			em.getTransaction().commit();
		}
	}

	public List<ServicosEntidades> findAll() {
		return em.createQuery("SELECT s FROM servicos s", ServicosEntidades.class).getResultList();
	}

}