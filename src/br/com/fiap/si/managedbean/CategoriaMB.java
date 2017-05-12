package br.com.fiap.si.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import br.com.fiap.si.dao.CategoriaDAOImpl;
import br.com.fiap.si.modelo.Categoria;

@SessionScoped
@ManagedBean
public class CategoriaMB {

	private Categoria categoria;
	private List<Categoria> listCategoria;
	private String erro;

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getListCategoria() {
		return listCategoria;
	}

	public void setListCategoria(List<Categoria> listCategoria) {
		this.listCategoria = listCategoria;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public CategoriaMB() {
		categoria = new Categoria();
		CategoriaDAOImpl dao = new CategoriaDAOImpl();
        //listCategoria = dao.selectCategoria();
		listCategoria = null;
	}

	public String inserir() {
		
			CategoriaDAOImpl dao = new CategoriaDAOImpl();
			dao.saveCategoria(categoria);
			return listar();
		
	}

	public String atualizar() {
			CategoriaDAOImpl dao = new CategoriaDAOImpl();
			dao.updateCategoria(categoria);
			return listar();
	}

	public String deletar() {
		CategoriaDAOImpl dao = new CategoriaDAOImpl();
		dao.deleteCategoria(categoria);
		return listar();
		
	}

	public String abrirCadastro() {

		
			categoria.setCategoria(null);
			categoria.setId(null);
			return "cadastroCategoria";
		
	}

	public String abrirEditar() {

		
			try {
				CategoriaDAOImpl dao = new CategoriaDAOImpl();
				categoria = dao.getCategoriaID(categoria.getId());
				System.out.println(categoria.getId() +" - "+categoria.getCategoria());
				return "cadastroCategoria";
			} catch (Exception e) {
				erro = e.getMessage();
				return "erro";
			}
		

	}

	public String listar() {
	
			CategoriaDAOImpl dao = new CategoriaDAOImpl();
			listCategoria = dao.selectCategoria();
			return "visualizarCategoria";

	}


}
