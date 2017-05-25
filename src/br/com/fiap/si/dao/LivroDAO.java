package br.com.fiap.si.dao;

import java.util.List;

import br.com.fiap.si.modelo.Autor;
import br.com.fiap.si.modelo.Item;
import br.com.fiap.si.modelo.Livro;

public interface LivroDAO {
	
	public void saveLivro (Livro livro);
	
	public void updateLivro (Livro livro);
	
	public void deleteLivro (Livro livro);
	
	public List<Livro> selectLivro();
	
	public Livro getLivroID(Integer id);
	
	public void insertListOf(Item item);
	
	public void deleteListOf(Item item);
}
