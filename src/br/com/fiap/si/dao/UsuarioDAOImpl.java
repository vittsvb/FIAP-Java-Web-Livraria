package br.com.fiap.si.dao;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.fiap.si.modelo.Categoria;
import br.com.fiap.si.modelo.Usuario;
import br.com.fiap.si.util.JPAUtil;

public class UsuarioDAOImpl implements UsuarioDAO {

	@Override
	public boolean saveUser(Usuario usuario) {
		EntityManager em = new JPAUtil().getEntityManager();
		boolean valid;
		try {
			em.getTransaction().begin();

			em.persist(usuario);
			
			em.getTransaction().commit();
			valid = true;
		} catch (Exception e) {
			em.getTransaction().rollback();
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("O Nome de usuário já esta sendo usado"));
			valid = false;
		}
		return valid;
	}

	@Override
	public void updateUser(Usuario usuario) {
		EntityManager em = new JPAUtil().getEntityManager();
		try {
			em.getTransaction().begin();

			em.merge(usuario);
			
			em.getTransaction().commit();

		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

		
	

	@Override
	public void deleteUser(Usuario usuario) {
		EntityManager em = new JPAUtil().getEntityManager();
		try {
			em.getTransaction().begin();

			em.remove(usuario);
			
			em.getTransaction().commit();

		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}


	@Override
	public Usuario login(String login, String senha) {
		try{
			EntityManager em = new JPAUtil().getEntityManager();
		
			Query q = em.createQuery("select u from Usuario u where login = :login and senha = :senha");
		
			q.setParameter("login", login);
			q.setParameter("senha", senha);
		
			Usuario usuario = (Usuario) q.getSingleResult();

			return usuario;
		}
		catch(NoResultException e){
			return null;
		}
	}
	

}
