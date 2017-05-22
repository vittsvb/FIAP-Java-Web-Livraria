package br.com.fiap.si.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.fiap.si.modelo.Autor;
import br.com.fiap.si.util.JPAUtil;

public class AutorDAOImpl implements AutorDAO{

	@Override
	public void saveAutor(Autor autor) {
		EntityManager em = new JPAUtil().getEntityManager();
		try {
			em.getTransaction().begin();
			
			em.persist(autor);
			
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		
	}

	@Override
	public void updateAutor(Autor autor) {
		EntityManager em = new JPAUtil().getEntityManager();
		try{
			em.getTransaction().begin();
			
			em.merge(autor);
			
			em.getTransaction().commit();
			
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		
	}

	@Override
	public void deleteAutor(Autor autor) {
		EntityManager em = new JPAUtil().getEntityManager();
		try{
			em.getTransaction().begin();
			
			Autor attached = em.merge(autor);
			em.remove(attached);
			
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		
	}

	@Override
	public List<Autor> selectAutor(){
		List<Autor> lista;
		EntityManager em = new JPAUtil().getEntityManager();
		Query result = em.createQuery("select a from Autor a");
		return result.getResultList();
		
	}

	@Override
	public Autor getAutorID(Long id) {
		EntityManager em = new JPAUtil().getEntityManager();
		Query q =  em.createQuery("select a from Autor a where id = :id");
		q.setParameter("id",id);
		Autor autor = (Autor) q.getSingleResult();
		
		
		return autor;
	}

}
