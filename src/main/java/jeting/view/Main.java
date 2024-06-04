package jeting.view;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		boolean menu = true;

		while (menu) {
			System.out.println("\nBem-vindo. Escolha uma opção:");
			System.out.println("1- Clientes");
			System.out.println("2- Serviços");
			System.out.println("0- Sair");

			int opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {
			case 1:
				FuncoesClientes funcoesClientes = new FuncoesClientes();
				funcoesClientes.menuClientes();
				break;
			case 2:
				FuncoesServicos funcoesServicos = new FuncoesServicos();
				funcoesServicos.menuServicos();
				break;
			case 0:
				System.out.println("Encerrando sessão...");
				menu = false;
				break;
			}
		}
		scanner.close();
	}
}