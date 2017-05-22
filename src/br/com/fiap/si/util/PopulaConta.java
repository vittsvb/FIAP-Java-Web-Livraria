package br.com.fiap.si.util;


import javax.persistence.EntityManager;

import br.com.fiap.si.modelo.Autor;
import br.com.fiap.si.modelo.Categoria;
import br.com.fiap.si.modelo.Livro;

public class PopulaConta {

	public static void main(String[] args) {

//		EntityManager manager = new JPAUtil().getEntityManager();
//
//		manager.getTransaction().begin();
//
//		Usuario conta1 = new Usuario();
//		Usuario conta2 = new Usuario();
//		Usuario conta3 = new Usuario();
//		Usuario conta4 = new Usuario();
//		Usuario conta5 = new Usuario();
//
//
//		// persistindo as contas
//		manager.persist(conta1);
//		manager.persist(conta2);
//		manager.persist(conta3);
//		manager.persist(conta4);
//		manager.persist(conta5);
//
//		manager.getTransaction().commit();
//
//		manager.close();
		
		
		
		//testeLivroCategoria();
		testeLivroAutor();
		
		

	}

	private static void testeLivroAutor(){
		EntityManager entityManager = new JPAUtil().getEntityManager();
		
		entityManager.getTransaction().begin();
		Livro livro = new Livro();
		livro.setId(1);
		livro.setNome("testeautor");
		Categoria categoria = new Categoria();
		categoria.setId(1l);
		categoria.setCategoria("seguraaa");
		livro.setCategoria(categoria);
		Autor autor  = new Autor();
		autor.setCpf("0934820948");
		autor.setNome("vilas ruins");
		livro.setAutor(autor);
		
		
		entityManager.persist(livro);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		
		
	}
	
	private static void testeLivroCategoria() {
		EntityManager entityManager = new JPAUtil().getEntityManager();
		
		entityManager.getTransaction().begin();
		
		Livro livro = new Livro();
		livro.setId(1);
		livro.setNome("vitor");
		Categoria categoria = new Categoria();
		categoria.setId(1l);
		categoria.setCategoria("sasasa");
		
		livro.setCategoria(categoria);
		
		
		
		entityManager.merge(livro);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
	}
}
