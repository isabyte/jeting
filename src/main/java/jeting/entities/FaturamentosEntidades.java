package jeting.entities;

import java.util.Date;

public class FaturamentosEntidades {
	Long id;
	Date dataPagamento;
	Float valor;
	boolean statusPagamento;
	
	public FaturamentosEntidades() {
		
	}

	public FaturamentosEntidades(Long id, Date dataPagamento, Float valor, boolean statusPagamento) {
		super();
		this.id = id;
		this.dataPagamento = dataPagamento;
		this.valor = valor;
		this.statusPagamento = statusPagamento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public boolean isStatusPagamento() {
		return statusPagamento;
	}

	public void setStatusPagamento(boolean statusPagamento) {
		this.statusPagamento = statusPagamento;
	}
	
}
