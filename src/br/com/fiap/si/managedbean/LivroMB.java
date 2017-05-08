package br.com.fiap.si.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.fiap.si.dao.LivroDAOImpl;
import br.com.fiap.si.modelo.Livro;
@ManagedBean
@SessionScoped
public class LivroMB {
	
	private Livro livro;
	private List<Livro> listLivro;
	private String erro;
	
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public List<Livro> getListLivro() {
		return listLivro;
	}
	public String getErro() {
		return erro;
	}
	public LivroMB(){
		livro = new Livro();
		listLivro = new ArrayList();
	}
	public String inserir(){
		
		LivroDAOImpl dao = new LivroDAOImpl();
		dao.saveLivro(livro);
		
		return listar();
	}
	public String atualizar(){
		
		LivroDAOImpl dao = new LivroDAOImpl();
		dao.saveLivro(livro);
		
		return listar();
	}
	public String deletar(){
		
		LivroDAOImpl dao = new LivroDAOImpl();
		dao.deleteLivro(livro);
		
		return listar();
	}
	public String listar() {
		
		LivroDAOImpl dao = new LivroDAOImpl();
		listLivro = dao.selectLivro();
		
		return "visualizarlivro";
	}
	
	
}
