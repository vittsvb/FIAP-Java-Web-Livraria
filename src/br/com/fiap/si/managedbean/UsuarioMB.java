package br.com.fiap.si.managedbean;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;

import br.com.fiap.si.dao.UsuarioDAOImpl;
import br.com.fiap.si.modelo.Usuario;

@ManagedBean
@SessionScoped
public class UsuarioMB {

	private Usuario usuario;
	private String erro;

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public UsuarioMB() {
		usuario = new Usuario();

	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String login() {
		String retorno;
		UsuarioDAOImpl dao = new UsuarioDAOImpl();

		usuario = dao.login(usuario.getLogin(), usuario.getSenha());

		if (usuario != null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
			session.setAttribute("usuario", usuario);
			if (usuario.isAdm())
				retorno = "Adm/menuAdmin";
			else
				retorno = "catalogo";

		} else {
			FacesContext context = FacesContext.getCurrentInstance();
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			context.addMessage(null, new FacesMessage("Usuário ou senha incorretos"));
			retorno = "loginUsuario";
		}

		return retorno;
	}

	public String inserir() {
		boolean valid;
		String retorno = null;
		UsuarioDAOImpl dao = new UsuarioDAOImpl();
		valid = dao.saveUser(usuario);
		usuario = new Usuario();
		
		if(valid == false){
			retorno = "cadastroUsuario";

		}else{
			retorno = "loginUsuario";
		}

		return retorno;
	}

	public String sair() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().remove("#{usuarioMB}");
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.invalidate();
		return "../catalogo.xhtml?faces-redirect=true";
	}

	public String abrirEditar() {

		try {
			usuario.setAdm(false);
			usuario.setCep(null);
			usuario.setCpfCnpj(null);
			usuario.setEstado(null);
			usuario.setId(null);
			usuario.setIdade(null);
			usuario.setLogin(null);
			usuario.setLogradouro(null);
			usuario.setNome(null);
			usuario.setSenha(null);
			return "cadastroUsuario";
		} catch (Exception e) {
			erro = e.getMessage();
			return "erro";
		}
	}
}
