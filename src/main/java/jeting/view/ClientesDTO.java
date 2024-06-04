// objeto a ser passado para a camada controller

package jeting.view;

import java.util.List;

import jeting.model.entities.EnderecosEntidades;

public class ClientesDTO {
	
	private String nome;
	private String cpfCnpj;
	private String telefone;
	private String email;
	private List<EnderecosEntidades> endereco;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(String cpf_cnpj) {
		this.cpfCnpj = cpf_cnpj;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<EnderecosEntidades> getEndereco() {
		return endereco;
	}
	public void setEndereco(List<EnderecosEntidades> endereco) {
		this.endereco = endereco;
	}

}
