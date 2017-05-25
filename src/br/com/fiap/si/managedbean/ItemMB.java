package br.com.fiap.si.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.fiap.si.dao.LivroDAOImpl;
import br.com.fiap.si.modelo.Categoria;
import br.com.fiap.si.modelo.Item;
import br.com.fiap.si.modelo.Livro;
@ManagedBean
@SessionScoped
public class ItemMB {
	
	private Item item ;
	private List<Item> items;
	private String erro;
	private Livro livro;
	int teste;
	
	
	
	public ItemMB(Item item, String erro, int teste) {
		super();
		this.item = item;
		this.erro = erro;
		this.teste = teste;
	}
	public ItemMB(){
	livro = new Livro();
	item = new Item();
		
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public String addListaDesejos(){
		LivroDAOImpl dao = new LivroDAOImpl();
		livro = dao.getLivroID(livro.getId());
		List<Livro> livros = new ArrayList<>();
		livros.add(livro);
		item.setLivro(livros);
		
		LivroDAOImpl daoImpl = new LivroDAOImpl();
		daoImpl.insertListOf(item);
		
		return null;
	}

		
	public String deletar(){
		
		
		return null;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
		
	
	
}
