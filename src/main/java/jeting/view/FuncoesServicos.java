package jeting.view;

import java.util.List;
import java.util.Scanner;

import jeting.controller.ServicosController;
import jeting.model.entities.ServicosEntidades;
import jeting.model.services.ServicosServices;

public class FuncoesServicos {

	private static Scanner scanner = new Scanner(System.in);
	private static ServicosServices servicosServices = new ServicosServices();
	private static ServicosController servicosController = new ServicosController(servicosServices);
	
	public void menuServicos() {
		
		boolean menu = true;
		
		while(menu) {
			System.out.println("\n-- Serviços --");
			System.out.println("Escolha uma opção:");
			System.out.println("1- Visualizar todos os serviços");
			System.out.println("2- Cadastrar novo serviço");
			System.out.println("3- Atualizar serviço");
			System.out.println("4- Excluir serviço");
			System.out.println("0- Voltar");
			
			int opcao = scanner.nextInt();
			scanner.nextLine();
			
			switch(opcao) {
			case 1:
				listarServicos();
				break;

			case 2:
				cadastrarServico();
				break;

			case 3:
				atualizarServico();
				break;

			case 4:
				excluirServico();
				break;

			case 0:
				System.out.println("Voltando ao menu principal");
				menu = false;
				break;
			default:
				System.out.println("Opção inválida.");
			}
		}
	}

	private static void excluirServico() {
		System.out.print("ID do Servico a ser excluído: ");
		Long id = scanner.nextLong();
		scanner.nextLine();

		ServicosEntidades servicoExistente = servicosController.servicosServices.findById(id);
		if (servicoExistente == null) {
			System.out.println("ID não encontrado");
			return;
		}

		servicosController.servicosServices.deleteById(id);
		System.out.println("Serviço excluído com sucesso");
	}

	private static void atualizarServico() {
		System.out.print("ID do serviço a ser atualizado: ");
		Long id = scanner.nextLong();
		scanner.nextLine();

		ServicosEntidades clienteExistente = servicosController.servicosServices.findById(id);
		if (clienteExistente == null) {
			System.out.println("ID não encontrado");
			return;
		}

		ServicosDTO servicosDTO = new ServicosDTO();

		System.out.print("Novo nome do serviço: ");
		servicosDTO.setNomeServico(scanner.nextLine());

		System.out.print("Nova descrição: ");
		servicosDTO.setDescricao(scanner.nextLine());

		System.out.print("Novo valor: ");
		servicosDTO.setValor(scanner.nextFloat());

		/*
		ServicosEntidades servicoAtualizado = new ServicosEntidades();
		servicoAtualizado.setId(id);
		servicoAtualizado.setNomeServico(servicosDTO.getNomeServico());
		servicoAtualizado.setDescricao(servicosDTO.getDescricao());
		servicoAtualizado.setValor(servicosDTO.getValor());
		*/
		ServicosEntidades servicoAtualizado = servicosController.atualizarServico(servicosDTO, id);

		
		servicoAtualizado = servicosController.servicosServices.atualizarServico(servicoAtualizado);
		
		if (servicoAtualizado != null) {
			System.out.println("Serviço atualizado com sucesso");
		} else {
			System.out.println("Erro ao atualizar");
		}
		
		
	}

	private static void listarServicos() {
		List<ServicosEntidades> servicos = servicosController.findAll();
		for (ServicosEntidades servico : servicos) {
			System.out.println(servico.getId() + " - " + servico.getNomeServico() + " - " + servico.getDescricao() + " - R$ "
					+ servico.getValor());
		}
	}

	private static void cadastrarServico() {
		ServicosDTO servicosDTO = new ServicosDTO();

		System.out.print("Nome do serviço: ");
		servicosDTO.setNomeServico(scanner.nextLine());

		System.out.print("Descrição do serviço: ");
		servicosDTO.setDescricao(scanner.nextLine());

		System.out.print("Valor do serviço: ");
		servicosDTO.setValor(scanner.nextFloat());

		ServicosEntidades novoServico = servicosController.cadastrarServico(servicosDTO);
		System.out.println("Serviço adicionado com sucesso. ID: " + novoServico.getId());
	}

}