package jeting.view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JTextField;

import jeting.controller.ClientesController;
import jeting.model.entities.ClientesEntidades;
import jeting.model.services.ClientesServices;

import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Canvas;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class fCadastrarClientes extends JInternalFrame {
	
	private static ClientesServices clientesServices = new ClientesServices();
	private static ClientesController clientesController = new ClientesController(clientesServices);

	private static final long serialVersionUID = 1L;
	private JTextField txtCpfCnpj;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private JTextField txtNome;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fCadastrarClientes frame = new fCadastrarClientes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public fCadastrarClientes() {
		
		setClosable(true);
		setTitle("Cadastro de Clientes");
		setBounds(10, 10, 932, 572);
		getContentPane().setLayout(null);

		
		//FONTES
		Font fontePadrao = new Font("MS Sans Serif", Font.PLAIN, 18);
		Font fonteJeting= new Font("Impact", Font.BOLD, 50);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(128, 128, 128));
		desktopPane.setBounds(53, 19, 787, 515);
		getContentPane().add(desktopPane);
		
		//CORES
		Color violetColor = new Color(138, 43, 226);

		
		//ENTRADAS DE USUÁRIOS
		txtNome = new JTextField();
		txtNome.setForeground(new Color(255, 255, 255));
		txtNome.setBackground(new Color(0, 0, 0));
		txtNome.setColumns(10);
		txtNome.setBorder(BorderFactory.createLineBorder(violetColor, 2));
		txtNome.setBounds(15, 221, 300, 28);
		desktopPane.add(txtNome);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblNome.setBounds(14, 187, 114, 28);
		desktopPane.add(lblNome);
		
		txtCpfCnpj = new JTextField();
		txtCpfCnpj.setForeground(new Color(255, 255, 255));
		txtCpfCnpj.setBackground(new Color(0, 0, 0));
		txtCpfCnpj.setColumns(10);
		txtCpfCnpj.setBounds(14, 294, 300, 28);
		txtCpfCnpj.setBorder(BorderFactory.createLineBorder(violetColor, 2));
		desktopPane.add(txtCpfCnpj);
		
		JLabel lblCpfCnpj = new JLabel("Cpf/Cnpj");
		lblCpfCnpj.setForeground(new Color(255, 255, 255));
		lblCpfCnpj.setFont(fontePadrao);
		lblCpfCnpj.setBounds(14, 258, 114, 28);	
		desktopPane.add(lblCpfCnpj);
		
		txtEmail = new JTextField();
		txtEmail.setForeground(new Color(255, 255, 255));
		txtEmail.setBackground(new Color(0, 0, 0));
		txtEmail.setColumns(10);
		txtEmail.setBorder(BorderFactory.createLineBorder(violetColor, 2));
		txtEmail.setBounds(14, 421, 300, 28);
		desktopPane.add(txtEmail);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(fontePadrao);
		lblEmail.setBounds(14, 326, 114, 28);
		desktopPane.add(lblEmail);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setForeground(new Color(255, 255, 255));
		lblTelefone.setFont(fontePadrao);
		lblTelefone.setBounds(14, 392, 163, 28);
		desktopPane.add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setForeground(new Color(255, 255, 255));
		txtTelefone.setBackground(new Color(0, 0, 0));
		txtTelefone.setColumns(10);
		txtTelefone.setBorder(BorderFactory.createLineBorder(violetColor, 2));
		txtTelefone.setBounds(14, 356, 300, 28);
		desktopPane.add(txtTelefone);
		
		//BOTÕES
		ClientesDTO clientesDTO = new ClientesDTO();
		JButton btnSalvarCadastro = new JButton("Salvar");
		btnSalvarCadastro.setBackground(violetColor);
		btnSalvarCadastro.setForeground(new Color(0, 0, 0));
		btnSalvarCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String nome = txtNome.getText();
		        String cpfCnpj = txtCpfCnpj.getText();
		        String email = txtEmail.getText();
		        String telefone = txtTelefone.getText();
		        
		        clientesDTO.setNome(nome);
		        clientesDTO.setCpfCnpj(cpfCnpj);
		        clientesDTO.setEmail(email);
		        clientesDTO.setTelefone(telefone);
		        		        
		        ClientesEntidades novoCliente = clientesController.cadastrarCliente(clientesDTO);
	            
	            if (novoCliente != null) {
	                JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
	            } else {
	                JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente. Verifique os dados e tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
	            }
	         
			}
		});
		btnSalvarCadastro.setBounds(448, 451, 114, 28);
		btnSalvarCadastro.setFont(fontePadrao);
		desktopPane.add(btnSalvarCadastro);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(violetColor);
		btnCancelar.setBounds(581, 451, 114, 28);
		btnCancelar.setFont(fontePadrao);
		desktopPane.add(btnCancelar);
		
		
		//JETING CUSTOMIZADO / LOGO
		JLabel lblJ = new JLabel("J");
		lblJ.setForeground(new Color(128, 0, 255));
		lblJ.setBackground(new Color(0, 0, 0));
		lblJ.setBounds(47, 12, 60, 84);
		lblJ.setFont(fonteJeting);
		desktopPane.add(lblJ);
		
		JLabel lblE = new JLabel("e");
		lblE.setForeground(new Color(128, 0, 255));
		lblE.setBackground(new Color(255, 255, 255));
		lblE.setBounds(73, 15, 60, 78);
		lblE.setFont(fonteJeting);
		desktopPane.add(lblE);
		
		JLabel lblT = new JLabel("t");
		lblT.setForeground(new Color(128, 0, 255));
		lblT.setBounds(111, 15, 60, 78);
		lblT.setFont(fonteJeting);
		desktopPane.add(lblT);
		
		JLabel lblI = new JLabel("i");
		lblI.setForeground(new Color(128, 0, 255));
		lblI.setBounds(137, 15, 60, 78);
		lblI.setFont(fonteJeting);
		desktopPane.add(lblI);
		
		JLabel lblN = new JLabel("n");
		lblN.setForeground(new Color(128, 0, 255));
		lblN.setBounds(162, 10, 60, 89);
		lblN.setFont(fonteJeting);
		desktopPane.add(lblN);
		
		JLabel lblG = new JLabel("g");
		lblG.setForeground(new Color(128, 0, 255));
		lblG.setBounds(196, 13, 60, 83);
		lblG.setFont(fonteJeting);
		desktopPane.add(lblG);
		
		JLabel lblCadastro = new JLabel("Cadastro de Clientes");
		lblCadastro.setForeground(new Color(255, 255, 255));
		lblCadastro.setBackground(new Color(255, 255, 255));
		lblCadastro.setBounds(47, 103, 187, 78);
		lblCadastro.setFont(fontePadrao);
		desktopPane.add(lblCadastro);
		
		Canvas canvas = new Canvas();
		canvas.setBackground(new Color(255, 255, 255));
		canvas.setBounds(9, 105, 247, 5);
		desktopPane.add(canvas);
	
		

	}
}
