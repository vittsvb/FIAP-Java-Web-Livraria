package br.com.fiap.si.dao;

import java.util.List;

import br.com.fiap.si.modelo.Editora;

public interface EditoraDAO {
	
	public void saveEditora(Editora editora);
	
	public void updateEditora(Editora editora);
	
	public void deleteEditora(Editora editora);
	
	public List<Editora> selectEditora();
	
	public Editora getEditoraID(Long id);


}
