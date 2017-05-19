package br.com.fiap.si.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.fiap.si.dao.UsuarioDAOImpl;
import br.com.fiap.si.modelo.Usuario;

@ManagedBean
@SessionScoped
public class UsuarioMB {

	private Usuario usuario;
	
	
	
	public UsuarioMB() {
		usuario = new Usuario();
	
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String login(){
		String retorno;
		UsuarioDAOImpl dao = new UsuarioDAOImpl();
		
		usuario = dao.login(usuario.getLogin(),usuario.getSenha());
		
		if(usuario != null){
			FacesContext facesContext = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
			session.setAttribute("usuario", usuario);
			if (usuario.isAdm())
				retorno = "Adm/menuAdmin";
			else 
				retorno = "Adm/menuAdmin";
		}
		else
			retorno = "loginUsuario";
		
		return retorno;
	}
	public String inserir(){
		
		UsuarioDAOImpl dao = new UsuarioDAOImpl();
		
		dao.saveUser(usuario);
		
		usuario = new Usuario();
		
		return "loginUsuario";
	}
}
