package jeting.model.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="clientes")
public class ClientesEntidades {
	
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name="cpf_cnpj", nullable = false)
	private String cpfCnpj;
	
	@Column(name= "email", nullable = false)
	private String email;
	
	@Column(name= "telefone", nullable = false)
	private String telefone;
	
	@OneToMany(mappedBy="cliente", cascade = CascadeType.ALL)
	private List<EnderecosEntidades> endereco;
	
	
	public ClientesEntidades() {
		
	}
	
	
	public ClientesEntidades(Long id, String nome, String cpfCnpj, String email, String telefone, List<EnderecosEntidades> endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpfCnpj = cpfCnpj;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public List<EnderecosEntidades> getEndereco() {
		return endereco;
	}


	public void setEndereco(List<EnderecosEntidades> endereco) {
		this.endereco = endereco;
	}
}
