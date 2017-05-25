package br.com.fiap.si.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.fiap.si.dao.LivroDAOImpl;
import br.com.fiap.si.modelo.Livro;
@ManagedBean
@SessionScoped
public class CarrinhoMB {
private Livro livro;
private List<Livro> listLivro;
private int qnt;


public Livro getLivro() {
return livro;
}

public void setLivro(Livro livro) {
this.livro = livro;
}

public List<Livro> getListLivro() {
return listLivro;
}

public void setListLivro(List<Livro> listLivro) {
this.listLivro = listLivro;
}

public int getQnt() {
return qnt;
}

public void setQnt(int qnt) {
this.qnt = qnt;
}

public CarrinhoMB(Livro livro, List<Livro> listLivro, int qnt) {
super();
this.livro = livro;
this.listLivro = listLivro;
this.qnt = qnt;
}

public String atualizar (){
	LivroDAOImpl dao = new LivroDAOImpl();
	dao.saveLivro(livro);
	return listar();
}



public String listar() {
LivroDAOImpl dao = new LivroDAOImpl();
listLivro = dao.selectLivro();
return "visualizarlivro";
}
}

