package br.com.fiap.si.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.fiap.si.modelo.Autor;
import br.com.fiap.si.modelo.Categoria;
import br.com.fiap.si.modelo.Editora;
import br.com.fiap.si.util.JPAUtil;

public class EditoraDAOImpl implements EditoraDAO{

	@Override
	public void saveEditora(Editora editora) {
		EntityManager em = new JPAUtil().getEntityManager();
		try {
			em.getTransaction().begin();
			
			em.persist(editora);
			
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		
	}

	@Override
	public void updateEditora(Editora editora) {
		EntityManager em = new JPAUtil().getEntityManager();
		try{
			em.getTransaction().begin();
			
			em.merge(editora);
			
			em.getTransaction().commit();
			
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		
	}

	@Override
	public void deleteEditora(Editora editora) {
		EntityManager em = new JPAUtil().getEntityManager();
		try{
			em.getTransaction().begin();
			
			Editora attached = em.merge(editora);
			em.remove(attached);
			
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		
	}

	@Override
	public List<Editora> selectEditora() {
		List<Editora> lista;
		EntityManager em = new JPAUtil().getEntityManager();
		lista = em.createQuery("select e from Editora e").getResultList();
		return lista;
		
	}
	
	@Override
	public Editora getEditoraID(Long id) {
		EntityManager em = new JPAUtil().getEntityManager();
		Query q =  em.createQuery("select e from Editora e where id = :id");
		q.setParameter("id",id);
		Editora editora = (Editora) q.getSingleResult();
		
		
		return editora;
	}

}
