package jeting.controller;

import java.util.List;

import jeting.model.entities.ServicosEntidades;
import jeting.model.services.ServicosServices;
import jeting.view.ServicosDTO;

public class ServicosController {

public ServicosServices servicosServices;
	
	public ServicosController(ServicosServices servicosServices) {
		this.servicosServices = servicosServices;
	}
	
	public ServicosEntidades cadastrarServico(ServicosDTO servicosDTO) {
		ServicosEntidades novoServico = new ServicosEntidades();
		novoServico.setNomeServico(servicosDTO.getNomeServico());
		novoServico.setDescricao(servicosDTO.getDescricao());
		novoServico.setValor(servicosDTO.getValor());
		return servicosServices.cadastrarNovoServico(novoServico);
	}
	
	public ServicosEntidades atualizarServicoById(Long id, ServicosDTO servicosDTO) {
		ServicosEntidades servicoExistente = servicosServices.findById(id);
		if (servicoExistente == null) {
			System.out.println("Serviço não encontrado");
			return null;
		}
		
		ServicosEntidades servicoAtualizado = new ServicosEntidades();
		
		servicoAtualizado.setNomeServico(servicosDTO.getNomeServico());
		servicoAtualizado.setDescricao(servicosDTO.getDescricao());
		servicoAtualizado.setValor(servicosDTO.getValor());
		
		return servicosServices.atualizarServico(servicoAtualizado);
	}
	
	public List<ServicosEntidades> findAll() {
		return servicosServices.findAll();
	}
	
	public void excluirServico(Long id) {
		ServicosEntidades servicoAExcluir = servicosServices.findById(id);
		if(servicoAExcluir == null) {
			System.out.println("Cliente não encontrado");
			return;
		}
		servicosServices.deleteById(id);
		System.out.println("Cliente excluído com sucesso");
	}
}