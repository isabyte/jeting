// lógica de negócio, interage com os repositories

package jeting.model.services;

import java.util.List;

import jeting.model.entities.ClientesEntidades;
import jeting.model.repositories.ClientesRepository;

public class ClientesServices {
	
	private ClientesRepository clientesRepository = new ClientesRepository();
	
	public ClientesEntidades cadastrarNovoCliente(ClientesEntidades cliente) {
		return (ClientesEntidades) clientesRepository.create(cliente);
	}
	
	public ClientesEntidades atualizarCliente(ClientesEntidades cliente) {
		return (ClientesEntidades) clientesRepository.updateById(cliente);
		/*ClientesEntidades clienteExistente = (ClientesEntidades) clientesRepository.findById(cliente.getId());
		if(clienteExistente == null) {
			return null;
		}
		clienteExistente.setNome(cliente.getNome());
		clienteExistente.setCpfCnpj(cliente.getCpfCnpj());
		clienteExistente.setTelefone(cliente.getTelefone());
		clienteExistente.setEmail(cliente.getEmail());
		return cliente;
		}*/
	}
	
	public ClientesEntidades findById(Long id) {
		return (ClientesEntidades) clientesRepository.findById(id);
	}
	
	public void deleteById(Long id) {
		clientesRepository.delete(id);
	}
	
	public List<ClientesEntidades> findAll() {
		return clientesRepository.findAll();
	}
	
	public Long countClientes() {
		return clientesRepository.countClientes();
	}

}
