package br.com.fiap.si.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.fiap.si.modelo.Item;
import br.com.fiap.si.modelo.Livro;
import br.com.fiap.si.modelo.Usuario;
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
			
			Livro attached = em.merge(livro);
			em.remove(attached);
			
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		

	}

	@Override
	public List<Livro> selectLivro() {
		EntityManager em = new JPAUtil().getEntityManager();
		Query result = em.createQuery("select l from Livro l");
		return result.getResultList();
	}

	@Override
	public Livro getLivroID(Integer id) {
		EntityManager em = new JPAUtil().getEntityManager();
		Query q =  em.createQuery("select l from Livro l where id = :id");
		q.setParameter("id",id);
		Livro livro = (Livro) q.getSingleResult();
		
		
		return livro;
	}

	@Override
	public void insertListOf(Item item) {

		EntityManager em = new JPAUtil().getEntityManager();
		
		try{
			em.getTransaction().begin();
			em.persist(item);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		
		
	}

	@Override
	public void deleteListOf(Item item) {
		EntityManager em = new JPAUtil().getEntityManager();
		try{
			em.getTransaction().begin();
			
			Item attached = em.merge(item);
			em.remove(attached);
			
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		
	}
	@Override
	public List<Item> returnlistuser(Usuario user){
		List<Item> items = new ArrayList();
		try{
		
			EntityManager em = new JPAUtil().getEntityManager();
			Query q = em.createQuery("select i from Item i where usuario = :user");
			q.setParameter("user",user);
			items = q.getResultList();
			return items;
		}
		catch(NoResultException e){
			return items;
		}
		
		
	}

	
	
	
}
