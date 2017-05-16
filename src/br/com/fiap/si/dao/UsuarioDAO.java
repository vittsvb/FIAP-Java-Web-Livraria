package br.com.fiap.si.dao;

import br.com.fiap.si.modelo.Usuario;

public interface UsuarioDAO {

	public void saveUser(Usuario usuario);
	
	public void updateUser(Usuario usuario);
	
	public void deleteUser(Usuario usuario);
	
	public Usuario login(String login, String senha);
	
}
