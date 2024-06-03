// pega dados da view (dto) e interage com a model (services)

package jeting.controller;

import java.util.List;

import jeting.model.entities.ClientesEntidades;
import jeting.model.services.ClientesServices;
import jeting.view.ClientesDTO;

public class ClientesController {
	
	public ClientesServices clientesServices;
	
	public ClientesController(ClientesServices clientesServices) {
		this.clientesServices = clientesServices;
	}
	
	public ClientesEntidades cadastrarCliente(ClientesDTO clientesDTO) {
		ClientesEntidades novoCliente = new ClientesEntidades();
		novoCliente.setNome(clientesDTO.getNome());
		novoCliente.setCpfCnpj(clientesDTO.getCpf_cnpj());
		novoCliente.setTelefone(clientesDTO.getTelefone());
		novoCliente.setEmail(clientesDTO.getEmail());
		novoCliente.setEndereco(clientesDTO.getEndereco());
		return clientesServices.cadastrarNovoCliente(novoCliente);
	}
	
	public List<ClientesEntidades> findAll() {
		return clientesServices.findAll();
	}
	
	public void excluirCliente(Long id) {
		ClientesEntidades clienteAExcluir = clientesServices.findById(id);
		if(clienteAExcluir == null) {
			System.out.println("Cliente não encontrado");
			return;
		}
		clientesServices.deleteById(id);
		System.out.println("Cliente excluído com sucesso");
	}

}
