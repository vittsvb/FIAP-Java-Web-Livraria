package br.com.fiap.si.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.fiap.si.dao.CategoriaDAOImpl;
import br.com.fiap.si.dao.LivroDAOImpl;
import br.com.fiap.si.modelo.Categoria;
import br.com.fiap.si.modelo.Livro;
@ManagedBean
@SessionScoped
public class LivroMB {
	
	private Livro livro;
	private List<Livro> listLivro;
	private String erro;
	Categoria categoria;
	int teste;
	
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
		
		LivroDAOImpl dao = new LivroDAOImpl();
		
		listLivro = dao.selectLivro();
//		CategoriaDAOImpl catdao = new CategoriaDAOImpl();
//		categoria = catdao.getCategoriaID(3l);	
	}
	public String inserir(){
		
		LivroDAOImpl dao = new LivroDAOImpl();
		dao.saveLivro(livro);
		
		return listar();
	}
	public String atualizar(){
		
		LivroDAOImpl dao = new LivroDAOImpl();
		dao.updateLivro(livro);
		
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
		
		return "visualizarLivro";
	}
	@PostConstruct
	public String abrirEditar(){
		LivroDAOImpl dao = new LivroDAOImpl();
		livro = dao.getLivroID(livro.getId());
		
		teste = 1;
		
		return "cadastroLivro";
	}
	
	public int getTeste() {
		return teste;
	}
	public void setTeste(int teste) {
		this.teste = teste;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public void setListLivro(List<Livro> listLivro) {
		this.listLivro = listLivro;
	}
	public String abrirCadastro(){
		
		livro = null;
		livro = new Livro();
		
		return "cadastroLivro";
	}
	
	
	
}
