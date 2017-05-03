package br.com.fiap.si.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.fiap.si.bean.Funcionario;
import br.com.fiap.si.dao.FuncionarioDAO;

@ManagedBean
@SessionScoped
public class FuncionarioMB {

	private Funcionario funcionario;
	
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	private List<Funcionario> listaFuncionarios;
	private String erro;
	
	public List<Funcionario> getListaFuncionarios() {
		return listaFuncionarios;
	}

	public String getErro() {
		return erro;
	}

	public FuncionarioMB(){
		funcionario = new Funcionario();
		listaFuncionarios = new ArrayList<Funcionario>();
	}
	
	public String incluir(){
		
		try{
			FuncionarioDAO dao = new FuncionarioDAO();
			dao.insert(funcionario);
			
			return listar();
		}
		catch(Exception e){
			erro = e.getMessage();
			return "erro";
		}
	}
	
	public String editar(){
		
		try{
			FuncionarioDAO dao = new FuncionarioDAO();
			dao.udpate(funcionario);
			
			return listar();
		}
		catch(Exception e){
			erro = e.getMessage();
			return "erro";
		}
	}
	
	public String listar(){
		try{
			FuncionarioDAO dao = new FuncionarioDAO();
			listaFuncionarios = dao.getAll();
			
			return "visualizar";
		}
		catch(Exception e){
			erro = e.getMessage();
			return "erro";
		}
	}
	
	public String pesquisar(){
		try{
			FuncionarioDAO dao = new FuncionarioDAO();
			
			if(!funcionario.getCpf().equals(""))
				listaFuncionarios = dao.getFuncionarioByPk(funcionario.getCpf());
			else if(!funcionario.getNome().equals(""))
				listaFuncionarios = dao.getFuncionarioByNome(funcionario.getNome());
			else
				listaFuncionarios = dao.getAll();
			
			return "visualizar";
		}
		catch(Exception e){
			erro = e.getMessage();
			return "erro";
		}
	}
	
	public String excluir(){
		try{
			FuncionarioDAO dao = new FuncionarioDAO();
			dao.delete(funcionario.getCpf());
			
			return listar();
		}
		catch(Exception e){
			erro = e.getMessage();
			return "erro";
		}
	}

	public String abrirCadastroEditar(){
		try{
			FuncionarioDAO dao = new FuncionarioDAO();
			funcionario = dao.getFuncionarioByPk(funcionario.getCpf()).get(0);
			
			return "cadastro";
		}
		catch(Exception e){
			erro = e.getMessage();
			return "erro";
		}
	}

	public String abrirCadastroIncluir(){
		try{
			funcionario.setCpf(null);
			funcionario.setNome(null);
			funcionario.setSalario(null);
			
			return "cadastro";
		}
		catch(Exception e){
			erro = e.getMessage();
			return "erro";
		}
	}
	
	
	public String abrirPesquisar(){
		try{
			funcionario.setCpf(null);
			funcionario.setNome(null);
			funcionario.setSalario(null);
			
			return "pesquisar";
		}
		catch(Exception e){
			erro = e.getMessage();
			return "erro";
		}
	}
}
