package jeting.model.services;

import java.util.List;

import jeting.model.entities.ServicosEntidades;
import jeting.model.repositories.ServicosRepository;

public class ServicosServices {

	private ServicosRepository servicosRepository = new ServicosRepository();
	
	public ServicosEntidades cadastrarNovoServico(ServicosEntidades servico) {
		return (ServicosEntidades) servicosRepository.create(servico);
	}
	
	public ServicosEntidades atualizarServico(ServicosEntidades servico) {
		ServicosEntidades servicoExistente = (ServicosEntidades) servicosRepository.findById(servico.getId());
		if(servicoExistente == null) {
			return null;
		}
		servicoExistente.setNomeServico (servico.getNomeServico());
		servicoExistente.setDescricao(servico.getDescricao());
		servicoExistente.setValor(servico.getValor());
		return servico;
		}
	
	public ServicosEntidades findById(Long id) {
		return (ServicosEntidades) servicosRepository.findById(id);
	}
	
	public void deleteById(Long id) {
		servicosRepository.delete(id);
	}
	
	public List<ServicosEntidades> findAll() {
		return servicosRepository.findAll();
	}

}