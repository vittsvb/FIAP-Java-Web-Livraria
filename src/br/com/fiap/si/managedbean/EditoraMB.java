package br.com.fiap.si.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.fiap.si.dao.EditoraDAOImpl;
import br.com.fiap.si.modelo.Editora;


@SessionScoped
@ManagedBean
public class EditoraMB {
	private Editora editora;
	private List<Editora> listEditora;
	private String erro;
	
	public Editora getEditora() {
		return editora;
	}
	public void setEditora(Editora editora) {
		this.editora = editora;
	}
	public List<Editora> getListEditora() {
		return listEditora;
	}
	public void setListEditora(List<Editora> listEditora) {
		this.listEditora = listEditora;
	}
	public String getErro() {
		return erro;
	}
	public void setErro(String erro) {
		this.erro = erro;
	}
	
	public EditoraMB() {
		editora = new Editora();
		EditoraDAOImpl dao = new EditoraDAOImpl();
	    //listEditora = dao.selectEditora();
		listEditora = null;
	}

	public String inserir(){
			
		EditoraDAOImpl dao = new EditoraDAOImpl();
		dao.saveEditora(editora);
		return listar();
		
	}
	public String atualizar(){
		
			EditoraDAOImpl dao = new EditoraDAOImpl();
			dao.updateEditora(editora);
			return listar();
		
	}

	public String deletar(){
		
			EditoraDAOImpl dao = new EditoraDAOImpl();
			dao.deleteEditora(editora);
			return listar();
		
	}
	public String abrirCadastro(){
		
		try{
			editora.setNome(null);
			editora.setCnpj(null);
			editora.setId(null);
			return "cadastroEditora";
		}
		catch(Exception e){
			erro = e.getMessage();
			return "erro";
		}
		
		
	}
	public String abrirEditar(){
		
		try{
			EditoraDAOImpl dao = new EditoraDAOImpl();
			editora = dao.getEditoraID(editora.getId());
			
			return "cadastroEditora";
		}
		catch(Exception e){
			erro = e.getMessage();
			return "erro";
		}
		
		
	}
	public String listar(){
		
			EditoraDAOImpl dao = new EditoraDAOImpl();
			listEditora = dao.selectEditora();
			return "visualizarEditora";
		
	}
	
}
