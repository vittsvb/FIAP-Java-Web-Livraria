package br.com.fiap.si.dao;

import javax.persistence.EntityManager;

import br.com.fiap.si.modelo.Usuario;
import br.com.fiap.si.util.JPAUtil;

public class UsuarioDAOImpl implements UsuarioDAO {

	@Override
	public void saveUser(Usuario usuario) {
		EntityManager em = new JPAUtil().getEntityManager();
		try {
			em.getTransaction().begin();

			em.persist(usuario);

		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

}
