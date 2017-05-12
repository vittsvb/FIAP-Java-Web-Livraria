package br.com.fiap.si.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.fiap.si.modelo.Autor;
import br.com.fiap.si.modelo.Livro;
import br.com.fiap.si.util.JPAUtil;

public class LivroDAOImpl implements LivroDAO {

	@Override
	public void saveLivro(Livro livro) {
		EntityManager em = new JPAUtil().getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(livro);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		
	}

	@Override
	public void updateLivro(Livro livro) {
		EntityManager em = new JPAUtil().getEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(livro);
			em.getTransaction().commit();
		} catch (Exception e) {

			em.getTransaction().rollback();
			
		}

	}

	@Override
	public void deleteLivro(Livro livro) {
		EntityManager em = new JPAUtil().getEntityManager();
		try{
			em.getTransaction().begin();
			
			em.remove(livro);
			
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		

	}

	@Override
	public List<Livro> selectLivro() {
		List<Livro> lista;
		EntityManager em = new JPAUtil().getEntityManager();
		Query result = em.createQuery("select l from Livro l");
		return result.getResultList();
	}

	@Override
	public Livro getLivroID(Long id) {
		EntityManager em = new JPAUtil().getEntityManager();
		Query q =  em.createQuery("select l from Livro l where id = :id");
		q.setParameter("id",id);
		Livro livro = (Livro) q.getSingleResult();
		
		
		return livro;
	}

}
