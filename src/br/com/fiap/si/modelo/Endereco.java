package br.com.fiap.si.modelo;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Table(name="endereco")
@Entity
public class Endereco {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	private int id;
	private String logradouro;
	private int cep;
	private String cidade;
	private String estado;
	
	
	
	
	
	public Endereco(int id, String logradouro, int cep, String cidade, String estado) {
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
	}
	
	
	
	public Endereco() {
		super();
		// TODO Auto-generated constructor stub
	}



	
	public void setId(int id) {
		this.id = id;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	

	

	
}
