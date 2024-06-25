package jeting.view;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import jeting.controller.ServicosController;
import jeting.model.entities.ServicosEntidades;
import jeting.model.services.ServicosServices;

public class JIFListarServicos extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	
	private JTable table;
	private DefaultTableModel modelo;
	private static ServicosServices servicosServices = new ServicosServices();
	private static ServicosController servicosController = new ServicosController(servicosServices);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JIFListarServicos frame = new JIFListarServicos();
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
	public JIFListarServicos() {
		setClosable(true);
		setTitle("Serviços oferecidos");
		setBounds(100, 100, 600, 400);
		getContentPane().setLayout(null);

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 564, 339);
		getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		modelo = new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Nome", "Descrição", "Valor" });
		table.setModel(modelo);
		
		preencherTabela();
		
	}
	

	private void preencherTabela() {
		List<ServicosEntidades> servicos = servicosController.findAll();

		for (ServicosEntidades servico : servicos) {
			modelo.addRow(new Object[] { servico.getId(), servico.getNomeServico(), servico.getDescricao(), servico.getValor() });
		}
	}
}
