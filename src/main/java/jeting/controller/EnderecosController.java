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

}
