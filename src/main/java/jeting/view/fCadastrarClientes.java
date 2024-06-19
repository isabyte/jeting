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
import jeting.controller.EnderecosController;
import jeting.model.entities.ClientesEntidades;
import jeting.model.entities.EnderecosEntidades;
import jeting.model.services.ClientesServices;
import jeting.model.services.EnderecosServices;

import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Canvas;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class fCadastrarClientes extends JInternalFrame {

	private static ClientesServices clientesServices = new ClientesServices();
	private static ClientesController clientesController = new ClientesController(clientesServices);
	private static EnderecosServices enderecosServices = new EnderecosServices();
	private static EnderecosController enderecosController = new EnderecosController(enderecosServices);

	private static final long serialVersionUID = 1L;
	private JTextField txtCpfCnpj;
	private JTextField txtTelefone;
	private JTextField txtEmail;
	private JTextField txtNome;
	private JTextField txtCep;
	private JTextField txtLogradouro;
	private JTextField txtNumero;
	private JTextField txtComplemento;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtEstado;
	private JTextField txtPais;

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
		setBounds(10, 10, 1031, 665);
		getContentPane().setLayout(null);

		// FONTES
		Font fontePadrao = new Font("MS Sans Serif", Font.PLAIN, 18);
		Font fonteJeting = new Font("Impact", Font.BOLD, 50);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(128, 128, 128));
		desktopPane.setBounds(0, 0, 1005, 625);
		getContentPane().add(desktopPane);

		// CORES
		Color violetColor = new Color(138, 43, 226);

		// ENTRADAS DE USUÁRIOS
		txtNome = new JTextField();
		txtNome.setForeground(new Color(255, 255, 255));
		txtNome.setBackground(new Color(0, 0, 0));
		txtNome.setColumns(10);
		txtNome.setBorder(BorderFactory.createLineBorder(violetColor, 2));
		txtNome.setBounds(16, 211, 300, 28);
		desktopPane.add(txtNome);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblNome.setBounds(16, 173, 114, 28);
		desktopPane.add(lblNome);

		txtCpfCnpj = new JTextField();
		txtCpfCnpj.setForeground(new Color(255, 255, 255));
		txtCpfCnpj.setBackground(new Color(0, 0, 0));
		txtCpfCnpj.setColumns(10);
		txtCpfCnpj.setBounds(15, 284, 300, 28);
		txtCpfCnpj.setBorder(BorderFactory.createLineBorder(violetColor, 2));
		desktopPane.add(txtCpfCnpj);

		JLabel lblCpfCnpj = new JLabel("Cpf/Cnpj");
		lblCpfCnpj.setForeground(new Color(255, 255, 255));
		lblCpfCnpj.setFont(fontePadrao);
		lblCpfCnpj.setBounds(15, 248, 114, 28);
		desktopPane.add(lblCpfCnpj);

		txtTelefone = new JTextField();
		txtTelefone.setForeground(new Color(255, 255, 255));
		txtTelefone.setBackground(new Color(0, 0, 0));
		txtTelefone.setColumns(10);
		txtTelefone.setBorder(BorderFactory.createLineBorder(violetColor, 2));
		txtTelefone.setBounds(15, 411, 300, 28);
		desktopPane.add(txtTelefone);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(fontePadrao);
		lblEmail.setBounds(15, 316, 114, 28);
		desktopPane.add(lblEmail);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setForeground(new Color(255, 255, 255));
		lblTelefone.setFont(fontePadrao);
		lblTelefone.setBounds(15, 382, 163, 28);
		desktopPane.add(lblTelefone);

		txtEmail = new JTextField();
		txtEmail.setForeground(new Color(255, 255, 255));
		txtEmail.setBackground(new Color(0, 0, 0));
		txtEmail.setColumns(10);
		txtEmail.setBorder(BorderFactory.createLineBorder(violetColor, 2));
		txtEmail.setBounds(15, 346, 300, 28);
		desktopPane.add(txtEmail);

		JLabel lblCep = new JLabel("CEP");
		lblCep.setForeground(Color.WHITE);
		lblCep.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblCep.setBounds(378, 19, 114, 28);
		desktopPane.add(lblCep);

		txtCep = new JTextField();
		txtCep.setForeground(Color.WHITE);
		txtCep.setColumns(10);
		txtCep.setBackground(Color.BLACK);
		txtCep.setBounds(378, 48, 300, 28);
		desktopPane.add(txtCep);

		JLabel lblLogradouro = new JLabel("Logradouro");
		lblLogradouro.setForeground(Color.WHITE);
		lblLogradouro.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblLogradouro.setBounds(378, 85, 114, 28);
		desktopPane.add(lblLogradouro);

		txtLogradouro = new JTextField();
		txtLogradouro.setForeground(Color.WHITE);
		txtLogradouro.setColumns(10);
		txtLogradouro.setBackground(Color.BLACK);
		txtLogradouro.setBounds(378, 121, 300, 28);
		desktopPane.add(txtLogradouro);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setForeground(Color.WHITE);
		lblBairro.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblBairro.setBounds(378, 316, 114, 28);
		desktopPane.add(lblBairro);

		txtBairro = new JTextField();
		txtBairro.setForeground(Color.WHITE);
		txtBairro.setColumns(10);
		txtBairro.setBackground(Color.BLACK);
		txtBairro.setBounds(378, 346, 300, 28);
		desktopPane.add(txtBairro);

		JLabel lblNumero = new JLabel("Número");
		lblNumero.setForeground(Color.WHITE);
		lblNumero.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblNumero.setBounds(378, 153, 114, 28);
		desktopPane.add(lblNumero);

		txtNumero = new JTextField();
		txtNumero.setForeground(Color.WHITE);
		txtNumero.setColumns(10);
		txtNumero.setBackground(Color.BLACK);
		txtNumero.setBounds(378, 183, 300, 28);
		desktopPane.add(txtNumero);

		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setForeground(Color.WHITE);
		lblComplemento.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblComplemento.setBounds(378, 219, 114, 28);
		desktopPane.add(lblComplemento);

		txtComplemento = new JTextField();
		txtComplemento.setForeground(Color.WHITE);
		txtComplemento.setColumns(10);
		txtComplemento.setBackground(Color.BLACK);
		txtComplemento.setBounds(378, 248, 300, 28);
		desktopPane.add(txtComplemento);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setForeground(Color.WHITE);
		lblCidade.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblCidade.setBounds(378, 382, 114, 28);
		desktopPane.add(lblCidade);

		txtCidade = new JTextField();
		txtCidade.setForeground(Color.WHITE);
		txtCidade.setColumns(10);
		txtCidade.setBackground(Color.BLACK);
		txtCidade.setBounds(378, 415, 300, 28);
		desktopPane.add(txtCidade);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setForeground(Color.WHITE);
		lblEstado.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblEstado.setBounds(378, 469, 114, 28);
		desktopPane.add(lblEstado);

		txtEstado = new JTextField();
		txtEstado.setForeground(Color.WHITE);
		txtEstado.setColumns(10);
		txtEstado.setBackground(Color.BLACK);
		txtEstado.setBounds(378, 495, 300, 28);
		desktopPane.add(txtEstado);

		JLabel lblPais = new JLabel("País");
		lblPais.setForeground(Color.WHITE);
		lblPais.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblPais.setBounds(16, 469, 114, 28);
		desktopPane.add(lblPais);

		txtPais = new JTextField();
		txtPais.setForeground(Color.WHITE);
		txtPais.setColumns(10);
		txtPais.setBackground(Color.BLACK);
		txtPais.setBounds(16, 495, 300, 28);
		desktopPane.add(txtPais);

		// BOTÕES
		JButton btnSalvarCadastro = new JButton("Salvar");
		btnSalvarCadastro.setBackground(violetColor);
		btnSalvarCadastro.setForeground(new Color(0, 0, 0));
		btnSalvarCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ClientesDTO clientesDTO = new ClientesDTO();

				String nome = txtNome.getText();
				String cpfCnpj = txtCpfCnpj.getText();
				String email = txtEmail.getText();
				String telefone = txtTelefone.getText();
				String cep = txtCep.getText();
				String logradouro = txtLogradouro.getText();
				String complemento = txtComplemento.getText();
				String bairro = txtBairro.getText();
				String cidade = txtCidade.getText();
				String estado = txtEstado.getText();
				String pais = txtPais.getText();
				int numero = Integer.parseInt(txtNumero.getText());

				// setando clientes
				clientesDTO.setNome(nome);
				clientesDTO.setCpfCnpj(cpfCnpj);
				clientesDTO.setEmail(email);
				clientesDTO.setTelefone(telefone);

				EnderecosDTO enderecosDTO = new EnderecosDTO();

				// setando endereços
				enderecosDTO.setCep(cep);
				enderecosDTO.setLogradouro(logradouro);
				enderecosDTO.setNumero(numero);
				enderecosDTO.setComplemento(complemento);
				enderecosDTO.setBairro(bairro);
				enderecosDTO.setPais(pais);
				enderecosDTO.setCidade(cidade);
				enderecosDTO.setEstado(estado);
				enderecosDTO.setCidade(cidade);
				enderecosDTO.setPais(pais);

				EnderecosEntidades novoEndereco = enderecosController.cadastrarEndereco(enderecosDTO);
				
				ClientesEntidades novoCliente = clientesController.cadastrarCliente(clientesDTO);


				enderecosDTO.setCliente(novoCliente);


				List<EnderecosEntidades> listaEnderecos = new ArrayList<EnderecosEntidades>();
				listaEnderecos.add(novoEndereco);

				novoCliente.setEndereco(listaEnderecos);

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

		// JETING CUSTOMIZADO / LOGO
		JLabel lblJ = new JLabel("J");
		lblJ.setForeground(new Color(128, 0, 255));
		lblJ.setBackground(new Color(0, 0, 0));
		lblJ.setBounds(48, 2, 60, 84);
		lblJ.setFont(fonteJeting);
		desktopPane.add(lblJ);

		JLabel lblE = new JLabel("e");
		lblE.setForeground(new Color(128, 0, 255));
		lblE.setBackground(new Color(255, 255, 255));
		lblE.setBounds(74, 5, 60, 78);
		lblE.setFont(fonteJeting);
		desktopPane.add(lblE);

		JLabel lblT = new JLabel("t");
		lblT.setForeground(new Color(128, 0, 255));
		lblT.setBounds(112, 5, 60, 78);
		lblT.setFont(fonteJeting);
		desktopPane.add(lblT);

		JLabel lblI = new JLabel("i");
		lblI.setForeground(new Color(128, 0, 255));
		lblI.setBounds(138, 5, 60, 78);
		lblI.setFont(fonteJeting);
		desktopPane.add(lblI);

		JLabel lblN = new JLabel("n");
		lblN.setForeground(new Color(128, 0, 255));
		lblN.setBounds(163, 0, 60, 89);
		lblN.setFont(fonteJeting);
		desktopPane.add(lblN);

		JLabel lblG = new JLabel("g");
		lblG.setForeground(new Color(128, 0, 255));
		lblG.setBounds(197, 3, 60, 83);
		lblG.setFont(fonteJeting);
		desktopPane.add(lblG);

		JLabel lblCadastro = new JLabel("Cadastro de Clientes");
		lblCadastro.setForeground(new Color(255, 255, 255));
		lblCadastro.setBackground(new Color(255, 255, 255));
		lblCadastro.setBounds(48, 93, 187, 78);
		lblCadastro.setFont(fontePadrao);
		desktopPane.add(lblCadastro);

		Canvas canvas = new Canvas();
		canvas.setBackground(new Color(255, 255, 255));
		canvas.setBounds(10, 95, 247, 5);
		desktopPane.add(canvas);

	}
}
