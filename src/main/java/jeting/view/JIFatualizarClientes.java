package jeting.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import jeting.controller.ClientesController;
import jeting.model.entities.ClientesEntidades;
import jeting.model.services.ClientesServices;

public class JIFatualizarClientes extends JInternalFrame {

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
					JIFatualizarClientes frame = new JIFatualizarClientes();
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
	public JIFatualizarClientes() {
		setClosable(true);
		setTitle("Cadastro de Clientes");
		setBounds(10, 10, 796, 605);
		getContentPane().setLayout(null);

		// FONTES
		Font fontePadrao = new Font("MS Sans Serif", Font.PLAIN, 18);
		Font fonteJeting = new Font("Impact", Font.BOLD, 50);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(0, 0, 0));
		desktopPane.setBounds(10, 0, 748, 553);
		getContentPane().add(desktopPane);

		// CORES
		Color violetColor = new Color(138, 43, 226);

		// ENTRADAS DE USUÁRIOS
		JTextField txtNomeAtualizado = new JTextField();
		txtNomeAtualizado.setForeground(new Color(255, 255, 255));
		txtNomeAtualizado.setBackground(new Color(0, 0, 0));
		txtNomeAtualizado.setColumns(10);
		txtNomeAtualizado.setBorder(BorderFactory.createLineBorder(violetColor, 2));
		txtNomeAtualizado.setBounds(30, 181, 300, 28);
		desktopPane.add(txtNomeAtualizado);

		JLabel lblNomeAtualizado = new JLabel("Novo Nome");
		lblNomeAtualizado.setForeground(new Color(255, 255, 255));
		lblNomeAtualizado.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblNomeAtualizado.setBounds(30, 143, 114, 28);
		desktopPane.add(lblNomeAtualizado);

		JTextField txtCpfCnpjAtualizado = new JTextField();
		txtCpfCnpjAtualizado.setForeground(new Color(255, 255, 255));
		txtCpfCnpjAtualizado.setBackground(new Color(0, 0, 0));
		txtCpfCnpjAtualizado.setColumns(10);
		txtCpfCnpjAtualizado.setBounds(30, 257, 300, 28);
		txtCpfCnpjAtualizado.setBorder(BorderFactory.createLineBorder(violetColor, 2));
		desktopPane.add(txtCpfCnpjAtualizado);

		JLabel lblCpfCnpjAtualizado = new JLabel("Novo Cpf/Cnpj");
		lblCpfCnpjAtualizado.setForeground(new Color(255, 255, 255));
		lblCpfCnpjAtualizado.setFont(fontePadrao);
		lblCpfCnpjAtualizado.setBounds(30, 219, 152, 28);
		desktopPane.add(lblCpfCnpjAtualizado);

		JTextField txtTelefoneAtualizado = new JTextField();
		txtTelefoneAtualizado.setForeground(new Color(255, 255, 255));
		txtTelefoneAtualizado.setBackground(new Color(0, 0, 0));
		txtTelefoneAtualizado.setColumns(10);
		txtTelefoneAtualizado.setBorder(BorderFactory.createLineBorder(violetColor, 2));
		txtTelefoneAtualizado.setBounds(30, 412, 300, 28);
		desktopPane.add(txtTelefoneAtualizado);

		JLabel lblEmailAtualizado = new JLabel("Novo Email");
		lblEmailAtualizado.setForeground(new Color(255, 255, 255));
		lblEmailAtualizado.setFont(fontePadrao);
		lblEmailAtualizado.setBounds(30, 295, 114, 28);
		desktopPane.add(lblEmailAtualizado);

		JLabel lblTelefoneAtualizado = new JLabel("Novo Telefone");
		lblTelefoneAtualizado.setForeground(new Color(255, 255, 255));
		lblTelefoneAtualizado.setFont(fontePadrao);
		lblTelefoneAtualizado.setBounds(30, 372, 163, 28);
		desktopPane.add(lblTelefoneAtualizado);

		JTextField txtEmailAtualizado = new JTextField();
		txtEmailAtualizado.setForeground(new Color(255, 255, 255));
		txtEmailAtualizado.setBackground(new Color(0, 0, 0));
		txtEmailAtualizado.setColumns(10);
		txtEmailAtualizado.setBorder(BorderFactory.createLineBorder(violetColor, 2));
		txtEmailAtualizado.setBounds(30, 333, 300, 28);
		desktopPane.add(txtEmailAtualizado);
		
		JLabel lblClienteIdAatualizar = new JLabel(" ID do Cliente a ser atualizado");
		lblClienteIdAatualizar.setForeground(Color.WHITE);
		lblClienteIdAatualizar.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblClienteIdAatualizar.setBounds(408, 269, 259, 28);
		desktopPane.add(lblClienteIdAatualizar);
		
		JTextField txtClienteIdAtualizar = new JTextField();
		txtClienteIdAtualizar.setForeground(Color.WHITE);
		txtClienteIdAtualizar.setColumns(10);
		txtClienteIdAtualizar.setBackground(Color.BLACK);
		txtClienteIdAtualizar.setBounds(409, 307, 152, 28);
		desktopPane.add(txtClienteIdAtualizar);
		
		JButton btnProcurar_1 = new JButton("Procurar");
		btnProcurar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Long clienteAtualizado = Long.parseLong(txtClienteIdAtualizar.getText());
				
				ClientesEntidades clienteExistente = clientesController.clientesServices.findById(clienteAtualizado);
				
				if(clienteExistente == null) {
					JOptionPane.showMessageDialog(null, "Cliente não contrado");
					return;
				}
				
				txtNomeAtualizado.setText(clienteExistente.getNome());
				txtCpfCnpjAtualizado.setText(clienteExistente.getCpfCnpj());
				txtTelefoneAtualizado.setText(clienteExistente.getTelefone());
				txtEmailAtualizado.setText(clienteExistente.getEmail());
			}
		});
		btnProcurar_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btnProcurar_1.setBackground(new Color(138, 43, 226));
		btnProcurar_1.setBounds(581, 307, 114, 28);
		desktopPane.add(btnProcurar_1);

		// BOTÕES
		JButton btnAtualizarCadastro = new JButton("Atualizar");
		btnAtualizarCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Long AtualizarID = Long.parseLong(txtClienteIdAtualizar.getText());
				
				ClientesEntidades clienteExistente = clientesController.clientesServices.findById(AtualizarID);
		        if (clienteExistente == null) {
		            System.out.println("Cliente não encontrado");
		            return;
		        }
		        
		        ClientesDTO clientesDTO = new ClientesDTO();
		        
		    	String nome = txtNomeAtualizado.getText();
				String cpfCnpj = txtCpfCnpjAtualizado.getText();
				String email = txtEmailAtualizado.getText();
				String telefone = txtTelefoneAtualizado.getText();
				
				clientesDTO.setNome(nome);
				clientesDTO.setCpfCnpj(cpfCnpj);
				clientesDTO.setEmail(email);
				clientesDTO.setTelefone(telefone);
				
				ClientesEntidades clienteAtualizado = clientesController.atualizarCliente(clientesDTO, AtualizarID);
		        
		        clienteAtualizado = clientesController.clientesServices.atualizarCliente(clienteAtualizado);
		        if (clienteAtualizado != null) {
		            JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");
		        } else {
		            JOptionPane.showMessageDialog(null, "Erro ao atualizar.");
		        }
		        
		        
			}
		});
		btnAtualizarCadastro.setBackground(violetColor);
		btnAtualizarCadastro.setForeground(new Color(0, 0, 0));
		btnAtualizarCadastro.setBounds(227, 492, 114, 28);
		btnAtualizarCadastro.setFont(fontePadrao);
		desktopPane.add(btnAtualizarCadastro);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dialogButton = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja cancelar? Todos os dados serão perdidos.", "Cancelar",
						JOptionPane.YES_NO_OPTION);

				if (dialogButton == JOptionPane.YES_OPTION) {
					dispose();
				}
			}
		});
		btnCancelar.setBackground(violetColor);
		btnCancelar.setBounds(409, 492, 114, 28);
		btnCancelar.setFont(fontePadrao);
		desktopPane.add(btnCancelar);

		// JETING CUSTOMIZADO / LOGO
		JLabel lblJ = new JLabel("J");
		lblJ.setForeground(new Color(128, 0, 255));
		lblJ.setBackground(new Color(0, 0, 0));
		lblJ.setBounds(249, 24, 60, 84);
		lblJ.setFont(fonteJeting);
		desktopPane.add(lblJ);

		JLabel lblE = new JLabel("e");
		lblE.setForeground(new Color(128, 0, 255));
		lblE.setBackground(new Color(255, 255, 255));
		lblE.setBounds(275, 27, 60, 78);
		lblE.setFont(fonteJeting);
		desktopPane.add(lblE);

		JLabel lblT = new JLabel("t");
		lblT.setForeground(new Color(128, 0, 255));
		lblT.setBounds(313, 27, 60, 78);
		lblT.setFont(fonteJeting);
		desktopPane.add(lblT);

		JLabel lblI = new JLabel("i");
		lblI.setForeground(new Color(128, 0, 255));
		lblI.setBounds(339, 27, 60, 78);
		lblI.setFont(fonteJeting);
		desktopPane.add(lblI);

		JLabel lblN = new JLabel("n");
		lblN.setForeground(new Color(128, 0, 255));
		lblN.setBounds(364, 22, 60, 89);
		lblN.setFont(fonteJeting);
		desktopPane.add(lblN);

		JLabel lblG = new JLabel("g");
		lblG.setForeground(new Color(128, 0, 255));
		lblG.setBounds(398, 25, 60, 83);
		lblG.setFont(fonteJeting);
		desktopPane.add(lblG);

		JLabel lblCadastro = new JLabel("Atualizar Clientes");
		lblCadastro.setForeground(new Color(255, 255, 255));
		lblCadastro.setBackground(new Color(255, 255, 255));
		lblCadastro.setBounds(313, 63, 187, 78);
		lblCadastro.setFont(fontePadrao);
		desktopPane.add(lblCadastro);
		
		

	}
}
