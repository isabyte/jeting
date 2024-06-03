// objeto a ser passado para a camada controller

package jeting.view;

import java.util.List;

import jeting.model.entities.EnderecosEntidades;

public class ClientesDTO {
	
	private String nome;
	private String cpf_cnpj;
	private String telefone;
	private String email;
	private List<EnderecosEntidades> endereco;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf_cnpj() {
		return cpf_cnpj;
	}
	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
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
