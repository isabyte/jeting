package jeting.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import jeting.controller.ClientesController;
import jeting.controller.EnderecosController;
import jeting.model.entities.ClientesEntidades;
import jeting.model.entities.EnderecosEntidades;
import jeting.model.services.ClientesServices;
import jeting.model.services.EnderecosServices;

public class FuncoesClientes {

private static Scanner scanner = new Scanner(System.in);
	
	private static ClientesServices clientesServices = new ClientesServices();
	private static ClientesController clientesController = new ClientesController(clientesServices);
	private static EnderecosServices enderecosServices = new EnderecosServices();
	private static EnderecosController enderecosController = new EnderecosController(enderecosServices);

	public void menuClientes() {
		boolean menu = true;
		
		while(menu) {
			System.out.println("\n-- Clientes --");
			System.out.println("Escolha uma opção:");
			System.out.println("1- Visualizar todos os clientes");
			System.out.println("2- Cadastrar novo cliente");
			System.out.println("3- Atualizar cliente");
			System.out.println("4- Excluir cliente");
			System.out.println("0- Voltar");
			
			int opcao = scanner.nextInt();
			scanner.nextLine();
			
			switch(opcao) {
			case 1:
				System.out.println("-- Listar clientes--");
				listarClientes();
				break;
			case 2:
				System.out.println("-- Cadastrar novo cliente --");
				cadastrarCliente();
				break;
			case 3:
				System.out.println("-- Atualizar novo cliente --");
				atualizarCliente();
				break;
			case 4:
				System.out.println("-- Excluir cliente --");
				excluirClientes();
				break;
			case 0:
				System.out.println("Voltando ao menu principal");
				menu = false;
				break;
			default:
					System.out.println("Opção inválida. Tente novamente.");
			}
		}
	}	
	
	private static void listarClientes() {
		List<ClientesEntidades> clientes = clientesController.findAll();
		for(ClientesEntidades cliente : clientes) {
			System.out.println(
					"ID: " + cliente.getId() +
					" - "+ cliente.getNome() +
					" - CPF/CNPJ: " + cliente.getCpfCnpj() +
					" - Telefone: " + cliente.getTelefone() +
					" - E-mail: " + cliente.getEmail());
			for(EnderecosEntidades x: cliente.getEndereco()) {
				System.out.println("Endereço: " + x.getLogradouro() +
						", " + x.getNumero() +
						", " + x.getComplemento() +
						", " + x.getBairro() +
						". " + x.getCidade() +
						", " + x.getEstado());
			}
		}
	}

	
	private static void excluirClientes() {
		System.out.print("ID do cliente a ser excluído: ");
		Long id = scanner.nextLong();
		scanner.nextLine();

		ClientesEntidades clienteExistente = clientesController.clientesServices.findById(id);
		if (clienteExistente == null) {
			System.out.println("Cliente não encontrado");
			return;
		}

		clientesController.clientesServices.deleteById(id);
		System.out.println("Cliente excluído com sucesso");
	}
	
	
	private static void atualizarCliente() {
		
		System.out.print("ID do Cliente a ser atualizado: ");
		Long id = scanner.nextLong();

        ClientesEntidades clienteExistente = clientesController.clientesServices.findById(id);
        if (clienteExistente == null) {
            System.out.println("Cliente não encontrado");
            return;
        }

        ClientesDTO clientesDTO = new ClientesDTO();

        scanner.nextLine();
        System.out.print("Novo nome: ");
        clientesDTO.setNome(scanner.nextLine());

        System.out.print("Novo CPF/CNPJ: ");
        clientesDTO.setCpfCnpj(scanner.nextLine());

        System.out.print("Novo e-mail: ");
        clientesDTO.setEmail(scanner.nextLine());

        System.out.print("Novo telefone: ");
        clientesDTO.setTelefone(scanner.nextLine());

        ClientesEntidades clienteAtualizado = new ClientesEntidades();
        clienteAtualizado.setId(id);
        clienteAtualizado.setNome(clientesDTO.getNome());
        clienteAtualizado.setCpfCnpj(clientesDTO.getCpfCnpj());
        clienteAtualizado.setEmail(clientesDTO.getEmail());
        clienteAtualizado.setTelefone(clientesDTO.getTelefone());

        clienteAtualizado = clientesController.clientesServices.atualizarCliente(clienteAtualizado);
        if (clienteAtualizado != null) {
            System.out.println("Cliente atualizado com sucesso");
        } else {
            System.out.println("Erro ao atualizar");
        }
    }	  
	
	private static void cadastrarCliente() {
		ClientesDTO clientesDTO = new ClientesDTO();
    	
    	System.out.println("Nome do cliente:");
    	clientesDTO.setNome(scanner.nextLine());
    	
    	System.out.println("CPF/CNPJ do cliente:");
    	clientesDTO.setCpfCnpj(scanner.nextLine());
    	
    	System.out.println("Telefone do cliente:");
    	clientesDTO.setTelefone(scanner.nextLine());
    	
    	System.out.println("E-mail do cliente:");
    	clientesDTO.setEmail(scanner.nextLine());
    	
    	//novo objeto enderecosDTO
    	EnderecosDTO enderecosDTO = new EnderecosDTO();
    	
    	System.out.println("Nome da rua:");
    	enderecosDTO.setLogradouro(scanner.nextLine());
    	
    	System.out.println("Número:");
    	enderecosDTO.setNumero(scanner.nextInt());
    	scanner.nextLine();
    	
    	System.out.println("Complemento:");
    	enderecosDTO.setComplemento(scanner.nextLine());
    	
    	System.out.println("Bairro:");
    	enderecosDTO.setBairro(scanner.nextLine());
    	
    	System.out.println("Cidade:");
    	enderecosDTO.setCidade(scanner.nextLine());
    	
    	System.out.println("Estado:");
    	enderecosDTO.setEstado(scanner.nextLine());
    	
    	System.out.println("País:");
    	enderecosDTO.setPais(scanner.nextLine());
    	
    	System.out.println("CEP:");
    	enderecosDTO.setCep(scanner.nextLine());
    	
    	ClientesEntidades novoCliente = clientesController.cadastrarCliente(clientesDTO);
    	
    	enderecosDTO.setCliente(novoCliente);
    	
    	EnderecosEntidades novoEndereco = enderecosController.cadastrarEndereco(enderecosDTO);

    	List<EnderecosEntidades> listaEnderecos = new ArrayList<EnderecosEntidades>();
		listaEnderecos.add(novoEndereco);
		
		novoCliente.setEndereco(listaEnderecos);
    	
    	
    	System.out.println("Cliente cadastrado com sucesso! ID: " + novoCliente.getId());
	}
}
