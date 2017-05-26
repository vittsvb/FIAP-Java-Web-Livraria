package br.com.fiap.si.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.fiap.si.dao.LivroDAOImpl;
import br.com.fiap.si.dao.UsuarioDAOImpl;
import br.com.fiap.si.modelo.Categoria;
import br.com.fiap.si.modelo.Item;
import br.com.fiap.si.modelo.Livro;
import br.com.fiap.si.modelo.Usuario;

@ManagedBean
@SessionScoped
public class ItemMB {

	private Item item;
	private List<Item> items;
	private Usuario user;
	
	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public ItemMB() {
		
		item = new Item();
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
		user = (Usuario) session.getAttribute("usuario");
		LivroDAOImpl dao = new LivroDAOImpl();
		items = dao.returnlistuser(user);
	}


	public String addListaDesejos() {
		if (user.getLogin() != null) {
			LivroDAOImpl dao = new LivroDAOImpl();
			UsuarioDAOImpl usudao = new UsuarioDAOImpl();
			Usuario usuario = usudao.login(user.getLogin(),user.getSenha());

			item.setUsuario(usuario);
			
			dao.insertListOf(item);
			items = dao.returnlistuser(user);
			return null;
		}
		return "loginUsuario";
	}

	public String deletar() {

		return null;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

}
