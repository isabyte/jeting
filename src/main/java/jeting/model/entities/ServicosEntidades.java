package jeting.model.entities;

public class ServicosEntidades {
	Long id;
	String nomeServico;
	Float valor;
	String descricao;
	
	public ServicosEntidades() {

	}

	public ServicosEntidades(Long id, String nomeServico, Float valor, String descricao) {
		super();
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
