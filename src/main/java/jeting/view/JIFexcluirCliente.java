package jeting.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import jeting.controller.ClientesController;
import jeting.model.entities.ClientesEntidades;
import jeting.model.services.ClientesServices;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JIFexcluirCliente extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	
	private static ClientesServices clientesServices = new ClientesServices();
	private static ClientesController clientesController = new ClientesController(clientesServices);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JIFexcluirCliente frame = new JIFexcluirCliente();
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
	public JIFexcluirCliente() {
		
		setClosable(true);
		setTitle("Cadastro de Clientes");
		setBounds(10, 10, 796, 605);
		getContentPane().setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(0, 0, 0));
		desktopPane.setBounds(10, 0, 748, 553);
		getContentPane().add(desktopPane);
		
		// CORES
		Color violetColor = new Color(138, 43, 226);
		
		// FONTES
		Font fontePadrao = new Font("MS Sans Serif", Font.PLAIN, 18);
		Font fonteJeting = new Font("Impact", Font.BOLD, 78);
		
		// LABELS 
		JLabel lblExcluirID = new JLabel(" ID do Clientes a ser excluído");
		lblExcluirID.setForeground(new Color(255, 255, 255));
		lblExcluirID.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblExcluirID.setBounds(43, 207, 259, 28);
		desktopPane.add(lblExcluirID);

		
		JTextField txtExcluirID = new JTextField();
		txtExcluirID.setForeground(new Color(255, 255, 255));
		txtExcluirID.setBackground(new Color(0, 0, 0));
		txtExcluirID.setColumns(10);
		txtExcluirID.setBounds(46, 249, 300, 28);
		txtExcluirID.setBorder(BorderFactory.createLineBorder(violetColor, 2));
		desktopPane.add(txtExcluirID);
		
		// JETING CUSTOMIZADO / LOGO
				JLabel lblJ = new JLabel("J");
				lblJ.setForeground(new Color(128, 0, 255));
				lblJ.setBackground(new Color(0, 0, 0));
				lblJ.setBounds(53, 10, 60, 84);
				lblJ.setFont(fonteJeting);
				desktopPane.add(lblJ);

				JLabel lblE = new JLabel("e");
				lblE.setForeground(new Color(128, 0, 255));
				lblE.setBackground(new Color(255, 255, 255));
				lblE.setBounds(91, 16, 60, 78);
				lblE.setFont(fonteJeting);
				desktopPane.add(lblE);

				JLabel lblT = new JLabel("t");
				lblT.setForeground(new Color(128, 0, 255));
				lblT.setBounds(147, 19, 60, 78);
				lblT.setFont(fonteJeting);
				desktopPane.add(lblT);

				JLabel lblI = new JLabel("i");
				lblI.setForeground(new Color(128, 0, 255));
				lblI.setBounds(194, 21, 60, 78);
				lblI.setFont(fonteJeting);
				desktopPane.add(lblI);

				JLabel lblN = new JLabel("n");
				lblN.setForeground(new Color(128, 0, 255));
				lblN.setBounds(234, 18, 60, 89);
				lblN.setFont(fonteJeting);
				desktopPane.add(lblN);

				JLabel lblG = new JLabel("g");
				lblG.setForeground(new Color(128, 0, 255));
				lblG.setBounds(294, 19, 60, 83);
				lblG.setFont(fonteJeting);
				desktopPane.add(lblG);

				JLabel lblCadastro = new JLabel("Exclusão de Clientes");
				lblCadastro.setForeground(new Color(255, 255, 255));
				lblCadastro.setBackground(new Color(255, 255, 255));
				lblCadastro.setBounds(213, 86, 187, 78);
				lblCadastro.setFont(fontePadrao);
				desktopPane.add(lblCadastro);
				
				JLabel lblCliente = new JLabel("---- Cliente Encontrado ----");
				lblCliente.setForeground(Color.WHITE);
				lblCliente.setFont(new Font("SansSerif", Font.PLAIN, 18));
				lblCliente.setBounds(88, 333, 214, 28);
				desktopPane.add(lblCliente);
				
				JLabel lblClienteEcontrado = new JLabel("cliente cixivneafi");
				lblClienteEcontrado.setForeground(Color.WHITE);
				lblClienteEcontrado.setFont(new Font("SansSerif", Font.PLAIN, 18));
				lblClienteEcontrado.setBounds(10, 371, 362, 28);
				desktopPane.add(lblClienteEcontrado);
		
		
				//BOTOES
				JButton btnProcurar = new JButton("Procurar");
				btnProcurar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnProcurar.setBackground(violetColor);
				btnProcurar.setBounds(147, 428, 114, 28);
				btnProcurar.setFont(fontePadrao);
				desktopPane.add(btnProcurar);
				
				JButton btnExcluir = new JButton("Excluir");
				btnExcluir.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							//função de excluir cliente
							Long excluirID = Long.parseLong(txtExcluirID.getText());

							ClientesEntidades clienteExistente = clientesController.clientesServices.findById(excluirID);
							if (clienteExistente == null) {
								System.out.println("Cliente não encontrado");
								return;
							}

							clientesController.clientesServices.deleteById(excluirID);
							System.out.println("Cliente excluído com sucesso");
						}
					});
				btnExcluir.setBackground(violetColor);
				btnExcluir.setBounds(326, 428, 114, 28);
				btnExcluir.setFont(fontePadrao);
				desktopPane.add(btnExcluir);
				
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnCancelar.setBackground(violetColor);
				btnCancelar.setBounds(25, 428, 114, 28);
				btnCancelar.setFont(fontePadrao);
				desktopPane.add(btnCancelar);

	}
}
