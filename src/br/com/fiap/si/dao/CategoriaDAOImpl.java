package br.com.fiap.si.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.fiap.si.modelo.Categoria;
import br.com.fiap.si.util.JPAUtil;

public class CategoriaDAOImpl implements CategoriaDAO {

	@Override
	public void saveCategoria(Categoria categoria) {
		EntityManager em = new JPAUtil().getEntityManager();
		try {
			em.getTransaction().begin();

			em.persist(categoria);

			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	@Override
	public void updateCategoria(Categoria categoria) {
		EntityManager em = new JPAUtil().getEntityManager();
		try {
			em.getTransaction().begin();

			em.merge(categoria);

			em.getTransaction().commit();

		} catch (Exception e) {
			em.getTransaction().rollback();
		}

	}

	@Override
	public void deleteCategoria(Categoria categoria) {
		EntityManager em = new JPAUtil().getEntityManager();
		try {
			em.getTransaction().begin();

			em.remove(categoria);

			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}

	}

	@Override
	public List<Categoria> selectCategoria() {
		List<Categoria> lista;
		EntityManager em = new JPAUtil().getEntityManager();
		lista = em.createQuery("select * from categoria").getResultList();
		return lista;

	}

	@Override
	public Categoria getCategoriaID(Long id) {
		EntityManager em = new JPAUtil().getEntityManager();
		Query q = em.createQuery("select * from categoria where id = :id");
		q.setParameter("id", id);
		Categoria categoria = (Categoria) q.getSingleResult();

		return categoria;
	}

}
