package jeting.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "servicos")
public class ServicosEntidades {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column(name = "nome_servico", nullable = false)
	String nomeServico;
	
	@Column(name = "valor", nullable = false)
	Float valor;
	
	@Column(name = "descricao", nullable = false)
	String descricao;
	
	public ServicosEntidades() {

	}

	public ServicosEntidades(Long id, String nomeServico, Float valor, String descricao) {
		this.id = id;
		this.nomeServico = nomeServico;
		this.valor = valor;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeServico() {
		return nomeServico;
	}

	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
