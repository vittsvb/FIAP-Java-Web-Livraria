package br.com.fiap.si.managedbean;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.servlet.annotation.MultipartConfig;

import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import br.com.fiap.si.dao.CategoriaDAOImpl;
import br.com.fiap.si.dao.LivroDAOImpl;
import br.com.fiap.si.modelo.Categoria;
import br.com.fiap.si.modelo.Livro;
@ManagedBean
@SessionScoped
public class LivroMB {
	
	private Livro livro;
	private List<Livro> listLivro;
	private String erro;
	Categoria categoria;
	UploadedFile file;
	private StreamedContent productImage;
//	public StreamedContent getProductImage() {
//		FacesContext context = FacesContext.getCurrentInstance();
//		 
//		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
//			return new DefaultStreamedContent();
//		}
// 
//		else {
// 
//			int id = Integer.parseInt(context.getExternalContext().getRequestParameterMap().get("pid"));
//			
//			LivroDAOImpl dao = new LivroDAOImpl();
//			byte[] image = dao.getLivroID(id).getImagem();
// 
//			return new DefaultStreamedContent(new ByteArrayInputStream(image));
// 
//		}
//	}
	public void setProductImage(StreamedContent productImage) {
		this.productImage = productImage;
	}
	
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public List<Livro> getListLivro() {
		return listLivro;
	}
	public String getErro() {
		return erro;
	}
	public LivroMB(){
		livro = new Livro();
		
		LivroDAOImpl dao = new LivroDAOImpl();
		
		listLivro = dao.selectLivro();
//		CategoriaDAOImpl catdao = new CategoriaDAOImpl();
//		categoria = catdao.getCategoriaID(3l);	
	}
	public String inserir() throws IOException{
		
//		livro.setImagem(IOUtils.toByteArray(file.getInputstream()));
		LivroDAOImpl dao = new LivroDAOImpl();
		dao.saveLivro(livro);
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("sucesso"));
		
		return listar();
	}
	public String atualizar(){
		
		LivroDAOImpl dao = new LivroDAOImpl();
		dao.updateLivro(livro);
		
		return listar();
	}
	public String deletar(){
		
		LivroDAOImpl dao = new LivroDAOImpl();
		dao.deleteLivro(livro);
		
		return listar();
	}
	public String listar() {
		
		LivroDAOImpl dao = new LivroDAOImpl();
		listLivro = dao.selectLivro();
		
		return "visualizarLivro";
	}
	
	public String abrirEditar(){
		
		LivroDAOImpl dao = new LivroDAOImpl();
		livro = dao.getLivroID(livro.getId());
	
		
		return "cadastroLivro";
	}
	

	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public void setListLivro(List<Livro> listLivro) {
		this.listLivro = listLivro;
	}
	public String abrirCadastro(){
		
		livro = null;
		livro = new Livro();
		
		return "cadastroLivro";
	}
	 public UploadedFile getFile() {
		return file;
	}
	public void setFile(UploadedFile file) {
		this.file = file;
	}
	public void processFileUpload(FileUploadEvent uploadEvent) {
		 
	        try {
	        	file= uploadEvent.getFile();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	 
	    }
	
	
}
