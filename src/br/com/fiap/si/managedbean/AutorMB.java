package br.com.fiap.si.managedbean;

import java.util.ArrayList;
import java.util.List;


import javax.faces.bean.*;

import br.com.fiap.si.dao.AutorDAOImpl;
import br.com.fiap.si.modelo.Autor;


@SessionScoped
@ManagedBean
public class AutorMB {
	private Autor autor;
	private List<Autor> listAutor;
	private String erro;
	
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	public List<Autor> getListAutor() {
		return listAutor;
	}
	public void setListAutor(List<Autor> listAutor) {
		this.listAutor = listAutor;
	}
	public String getErro() {
		return erro;
	}
	public void setErro(String erro) {
		this.erro = erro;
	}
	
	public AutorMB() {
		autor = new Autor();
		AutorDAOImpl dao = new AutorDAOImpl();
	    //listAutor = dao.selectAutor();
		listAutor = null;
	}
	public String inserir(){
		try{
			AutorDAOImpl dao = new AutorDAOImpl();
			dao.saveAutor(autor);
			return listar();
		}catch (Exception e) {
			erro = e.getMessage();
			return "erro";
		}
	}
	public String atualizar(){
		try{
			AutorDAOImpl dao = new AutorDAOImpl();
			dao.updateAutor(autor);
			return listar();
		}catch (Exception e) {
			erro = e.getMessage();
			return "erro";
		}
	}

	public String deletar(){
		try{
			AutorDAOImpl dao = new AutorDAOImpl();
			autor = dao.getAutorID(autor.getId());	
			dao.deleteAutor(autor);
			return listar();
		}catch (Exception e) {
			erro = e.getMessage();
			return "erro";
		}
	}
	public String abrirCadastro(){
		
		try{
			autor.setNome(null);
			autor.setCpf(null);
			autor.setId(null);
			return "cadastroAutor";
		}
		catch(Exception e){
			erro = e.getMessage();
			return "erro";
		}
		
		
	}
	public String abrirEditar(){
		
		try{
			AutorDAOImpl dao = new AutorDAOImpl();
			autor = dao.getAutorID(autor.getId());
			
			return "cadastroAutor";
		}
		catch(Exception e){
			erro = e.getMessage();
			return "erro";
		}
		
		
	}
	public String listar(){
		try{
			AutorDAOImpl dao = new AutorDAOImpl();
			listAutor = dao.selectAutor();
			return "visualizarAutor";
		
		}
		catch (Exception e) {
			erro = e.getMessage();
			return "erro";
		}
	}
}
