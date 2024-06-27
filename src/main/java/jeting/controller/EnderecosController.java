package jeting.controller;

import jeting.model.entities.EnderecosEntidades;
import jeting.model.services.EnderecosServices;
import jeting.view.EnderecosDTO;

public class EnderecosController {
	
	public EnderecosServices enderecosServices;
	
	public EnderecosController(EnderecosServices enderecosServices) {
		this.enderecosServices = enderecosServices;
	}
	
	public EnderecosEntidades cadastrarEndereco(EnderecosDTO enderecosDTO) {
		EnderecosEntidades novoEndereco = new EnderecosEntidades();
		novoEndereco.setLogradouro(enderecosDTO.getLogradouro());
		novoEndereco.setNumero(enderecosDTO.getNumero());
		novoEndereco.setComplemento(enderecosDTO.getComplemento());
		novoEndereco.setBairro(enderecosDTO.getBairro());
		novoEndereco.setCidade(enderecosDTO.getCidade());
		novoEndereco.setEstado(enderecosDTO.getEstado());
		novoEndereco.setPais(enderecosDTO.getPais());
		novoEndereco.setCep(enderecosDTO.getCep());
		novoEndereco.setCliente(enderecosDTO.getCliente());		
		enderecosServices.cadastrarNovoEndereco(novoEndereco);
		
		return novoEndereco;
	}
	
	public EnderecosEntidades atualizarEndereco(EnderecosDTO enderecosDTO) {
		EnderecosEntidades enderecoExistente = new EnderecosEntidades();
		enderecoExistente.setLogradouro(enderecosDTO.getLogradouro());
		enderecoExistente.setNumero(enderecosDTO.getNumero());
		enderecoExistente.setComplemento(enderecosDTO.getComplemento());
		enderecoExistente.setBairro(enderecosDTO.getBairro());
		enderecoExistente.setCidade(enderecosDTO.getCidade());
		enderecoExistente.setEstado(enderecosDTO.getEstado());
		enderecoExistente.setPais(enderecosDTO.getPais());
		enderecoExistente.setCep(enderecosDTO.getCep());
		
		return enderecoExistente;
	}

}
