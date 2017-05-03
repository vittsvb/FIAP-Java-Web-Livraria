package br.com.fiap.si.util;


import javax.persistence.EntityManager;

import br.com.fiap.si.modelo.Usuario;

public class PopulaConta {

	public static void main(String[] args) {

		EntityManager manager = new JPAUtil().getEntityManager();

		manager.getTransaction().begin();

		Usuario conta1 = new Usuario();
		Usuario conta2 = new Usuario();
		Usuario conta3 = new Usuario();
		Usuario conta4 = new Usuario();
		Usuario conta5 = new Usuario();


		// persistindo as contas
		manager.persist(conta1);
		manager.persist(conta2);
		manager.persist(conta3);
		manager.persist(conta4);
		manager.persist(conta5);

		manager.getTransaction().commit();

		manager.close();

	}
}
