package br.com.fiap.si.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.fiap.si.dao.CategoriaDAOImpl;
import br.com.fiap.si.modelo.Categoria;

@ViewScoped
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
		listCategoria = new ArrayList<>();
	}

	public String inserir() {
		try {
			CategoriaDAOImpl dao = new CategoriaDAOImpl();
			dao.saveCategoria(categoria);
			return listar();
		} catch (Exception e) {
			erro = e.getMessage();
			return "erro";
		}
	}

	public String atualizar() {
		try {
			CategoriaDAOImpl dao = new CategoriaDAOImpl();
			dao.updateCategoria(categoria);
			return listar();
		} catch (Exception e) {
			erro = e.getMessage();
			return "erro";
		}
	}

	public String deletar() {
		try {
			CategoriaDAOImpl dao = new CategoriaDAOImpl();
			dao.deleteCategoria(categoria);
			return listar();
		} catch (Exception e) {
			erro = e.getMessage();
			return "erro";
		}
	}

	public String abrirCadastro() {

		try {
			categoria.setCategoria(null);
			categoria.setId(null);
			return "cadastroCategoria";
		} catch (Exception e) {
			erro = e.getMessage();
			return "erro";
		}

	}

	public String abrirEditar() {

		try {
			CategoriaDAOImpl dao = new CategoriaDAOImpl();
			categoria = dao.getCategoriaID(categoria.getId());

			return "cadastroCategoria";
		} catch (Exception e) {
			erro = e.getMessage();
			return "erro";
		}

	}

	public String listar() {
		try {
			CategoriaDAOImpl dao = new CategoriaDAOImpl();
			listCategoria = dao.selectCategoria();
			return "visualizarCategoria";

		} catch (Exception e) {
			erro = e.getMessage();
			return "erro";
		}

	}
	
	public String teste(){
		erro="Sucesso";
		System.out.println("ENTROU");
		return "sucesso";
	}

}
