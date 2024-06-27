package jeting.model.services;

import jeting.model.entities.EnderecosEntidades;
import jeting.model.repositories.EnderecosRepository;

public class EnderecosServices {
	
	private EnderecosRepository enderecosRepository = new EnderecosRepository();
	
	public EnderecosEntidades cadastrarNovoEndereco(EnderecosEntidades endereco) {
		return (EnderecosEntidades) enderecosRepository.create(endereco);
	}
	
	public EnderecosEntidades atualizarEndereco(EnderecosEntidades endereco) {
		return (EnderecosEntidades) enderecosRepository.updateById(endereco.getId());
		}
	
	public EnderecosEntidades findById(Long id) {
		return (EnderecosEntidades) enderecosRepository.findById(id);
	}
	
	public void deleteById(Long id) {
		enderecosRepository.delete(id);
	}

}
