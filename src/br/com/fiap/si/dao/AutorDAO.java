package br.com.fiap.si.dao;

import java.util.List;

import br.com.fiap.si.modelo.Autor;

public interface AutorDAO {
	
	public void saveAutor(Autor autor);
	
	public void updateAutor(Autor autor);
	
	public void deleteAutor(Autor autor);
	
	public List<Autor> selectAutor();
	
	public Autor getAutorID(Long id);

}
