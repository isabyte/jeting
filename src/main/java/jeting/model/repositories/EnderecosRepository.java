package jeting.model.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import jeting.model.entities.EnderecosEntidades;


public class EnderecosRepository implements BasicCrud {
	
	EntityManager em = Persistence.createEntityManagerFactory("JetingDB").createEntityManager();

	@Override
	public Object create(Object object) {
		EnderecosEntidades endereco = (EnderecosEntidades) object;
		em.getTransaction().begin();
		em.persist(endereco);
		em.getTransaction().commit();
		return findById(endereco.getId());
	}

	@Override
	public Object findById(Long id) {
		try {
			EnderecosEntidades enderecoInData = em.find(EnderecosEntidades.class, id);
			return enderecoInData;
		} catch (Exception e) {
			System.out.println(e.getCause());
		}
		return null;
	}

	@Override
	public Object updateById(Object object) {
		EnderecosEntidades enderecoUpdate = (EnderecosEntidades) object;
		em.getTransaction().begin();
		em.merge(enderecoUpdate);
		em.getTransaction().commit();
		return null;
	}

	@Override
	public void delete(Long id) {
		em.getTransaction().begin();
		EnderecosEntidades enderecoToDelete = (EnderecosEntidades) findById(id);
		em.remove(enderecoToDelete);
		em.getTransaction().commit();		
	}
	
	public List<EnderecosEntidades> findAll(){
		return em.createQuery("SELECT e FROM EnderecosEntity e",EnderecosEntidades.class).getResultList();
	}

}
