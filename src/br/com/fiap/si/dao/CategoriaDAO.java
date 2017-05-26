package br.com.fiap.si.dao;

import java.util.List;

import br.com.fiap.si.modelo.Categoria;

public interface CategoriaDAO {

	public boolean saveCategoria(Categoria categoria);

	public void updateCategoria(Categoria categoria);

	public void deleteCategoria(Categoria categoria);

	public List<Categoria> selectCategoria();

	public Categoria getCategoriaID(Long id);

}
