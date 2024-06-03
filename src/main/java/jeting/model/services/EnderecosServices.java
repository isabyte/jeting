package jeting.model.services;

import jeting.model.entities.EnderecosEntidades;
import jeting.model.repositories.EnderecosRepository;

public class EnderecosServices {
	
	private EnderecosRepository enderecosRepository = new EnderecosRepository();
	
	public EnderecosEntidades cadastrarNovoEndereco(EnderecosEntidades endereco) {
		return (EnderecosEntidades) enderecosRepository.create(endereco);
	}
	
	public EnderecosEntidades atualizarEndereco(EnderecosEntidades endereco) {
		EnderecosEntidades enderecoExistente = (EnderecosEntidades) enderecosRepository.findById(endereco.getId());
		if(enderecoExistente == null) {
			return null;
		}
		enderecoExistente.setLogradouro(endereco.getLogradouro());
		enderecoExistente.setNumero(endereco.getNumero());
		enderecoExistente.setComplemento(endereco.getComplemento());
		enderecoExistente.setBairro(endereco.getBairro());
		enderecoExistente.setCidade(endereco.getCidade());
		enderecoExistente.setEstado(endereco.getEstado());
		enderecoExistente.setPais(endereco.getPais());
		enderecoExistente.setCep(endereco.getCep());
		return endereco;
		}
	
	public EnderecosEntidades findById(Long id) {
		return (EnderecosEntidades) enderecosRepository.findById(id);
	}
	
	public void deleteById(Long id) {
		enderecosRepository.delete(id);
	}

}
