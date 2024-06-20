package jeting.view;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import jeting.controller.ClientesController;
import jeting.model.entities.ClientesEntidades;
import jeting.model.services.ClientesServices;

public class JIFlistarClientes extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel modelo;
	private static ClientesServices clientesServices = new ClientesServices();
	private static ClientesController clientesController = new ClientesController(clientesServices);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JIFlistarClientes frame = new JIFlistarClientes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JIFlistarClientes() {
		setClosable(true);
		setTitle("Lista de Clientes");
		setBounds(100, 100, 600, 400);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 564, 339);
		getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		modelo = new DefaultTableModel(new Object[][] {},
				new String[] { "Nome", "CPF / CNPJ", "Telefone", "Email", "Endereço" });
		table.setModel(modelo);

		preencherTabela();

	}

	private void preencherTabela() {

		List<ClientesEntidades> clientes = clientesController.findAll();

		for (ClientesEntidades cliente : clientes) {
			StringBuilder endereco = new StringBuilder();
			/*
			 * for (EnderecosEntidades x : cliente.getEndereco()) {
			 * endereco.append(x.getLogradouro()).append(", ")
			 * .append(x.getNumero()).append(", ") .append(x.getComplemento()).append(", ")
			 * .append(x.getBairro()).append(". ") .append(x.getCidade()).append(", ")
			 * .append(x.getEstado()); }
			 */
			modelo.addRow(new Object[] { cliente.getNome(), cliente.getCpfCnpj(), cliente.getTelefone(),
					cliente.getEmail(), endereco.toString() });
		}
	}
}