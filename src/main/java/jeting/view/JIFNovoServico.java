package jeting.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

import jeting.controller.ServicosController;
import jeting.model.entities.ServicosEntidades;
import jeting.model.services.ServicosServices;

import javax.swing.JTextArea;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class JIFNovoServico extends JInternalFrame {
	
	private static ServicosServices servicosServices = new ServicosServices();
	private static ServicosController servicosController = new ServicosController(servicosServices);

	private static final long serialVersionUID = 1L;
	private JTextField txtNomeServico;
	private JTextField txtValor;
	private JTextField txtDescricao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JIFNovoServico frame = new JIFNovoServico();
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
	public JIFNovoServico() {
		setClosable(true);
		setTitle("Novo serviço");
		setBounds(100, 100, 549, 582);
		getContentPane().setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(0, 0, 0));
		desktopPane.setBounds(6, 6, 513, 524);
		getContentPane().add(desktopPane);
		
		// LOGO
		JLabel lblJ = new JLabel("J");
		lblJ.setForeground(new Color(128, 0, 255));
		lblJ.setFont(new Font("Impact", Font.BOLD, 50));
		lblJ.setBackground(Color.BLACK);
		lblJ.setBounds(51, 8, 60, 84);
		desktopPane.add(lblJ);
		
		JLabel lblE = new JLabel("e");
		lblE.setForeground(new Color(128, 0, 255));
		lblE.setFont(new Font("Impact", Font.BOLD, 50));
		lblE.setBackground(Color.WHITE);
		lblE.setBounds(77, 11, 60, 78);
		desktopPane.add(lblE);
		
		JLabel lblT = new JLabel("t");
		lblT.setForeground(new Color(128, 0, 255));
		lblT.setFont(new Font("Impact", Font.BOLD, 50));
		lblT.setBounds(115, 11, 60, 78);
		desktopPane.add(lblT);
		
		JLabel lblI = new JLabel("i");
		lblI.setForeground(new Color(128, 0, 255));
		lblI.setFont(new Font("Impact", Font.BOLD, 50));
		lblI.setBounds(141, 11, 60, 78);
		desktopPane.add(lblI);
		
		JLabel lblN = new JLabel("n");
		lblN.setForeground(new Color(128, 0, 255));
		lblN.setFont(new Font("Impact", Font.BOLD, 50));
		lblN.setBounds(166, 6, 60, 89);
		desktopPane.add(lblN);
		
		JLabel lblG = new JLabel("g");
		lblG.setForeground(new Color(128, 0, 255));
		lblG.setFont(new Font("Impact", Font.BOLD, 50));
		lblG.setBounds(200, 9, 60, 83);
		desktopPane.add(lblG);
		
		JLabel lblNovoServio = new JLabel("Novo serviço");
		lblNovoServio.setForeground(Color.WHITE);
		lblNovoServio.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNovoServio.setBackground(Color.WHITE);
		lblNovoServio.setBounds(115, 47, 118, 78);
		desktopPane.add(lblNovoServio);
		
		// CAMPOS
		JLabel lblNomeServico = new JLabel("Nome do serviço");
		lblNomeServico.setForeground(Color.WHITE);
		lblNomeServico.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblNomeServico.setBounds(16, 125, 151, 28);
		desktopPane.add(lblNomeServico);
		
		txtNomeServico = new JTextField();
		txtNomeServico.setForeground(new Color(255, 255, 255));
		txtNomeServico.setColumns(10);
		txtNomeServico.setBackground(new Color(0, 0, 0));
		txtNomeServico.setBorder(new LineBorder(new Color(138, 43, 226), 2));
		txtNomeServico.setBounds(16, 163, 300, 28);
		desktopPane.add(txtNomeServico);
		
		JLabel lblDescricao = new JLabel("Descrição");
		lblDescricao.setForeground(Color.WHITE);
		lblDescricao.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblDescricao.setBounds(16, 213, 151, 28);
		desktopPane.add(lblDescricao);
		
		txtDescricao = new JTextField();
		txtDescricao.setForeground(new Color(255, 255, 255));
		txtDescricao.setColumns(10);
		txtDescricao.setBackground(new Color(0, 0, 0));
		txtDescricao.setBorder(new LineBorder(new Color(138, 43, 226), 2));
		txtDescricao.setBounds(16, 253, 300, 84);
		desktopPane.add(txtDescricao);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setForeground(Color.WHITE);
		lblValor.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblValor.setBounds(16, 358, 52, 28);
		desktopPane.add(lblValor);
		
		txtValor = new JTextField();
		txtValor.setForeground(new Color(255, 255, 255));
		txtValor.setColumns(10);
		txtValor.setBackground(new Color(0, 0, 0));
		txtValor.setBorder(new LineBorder(new Color(138, 43, 226), 2));
		txtValor.setBounds(16, 398, 300, 28);
		desktopPane.add(txtValor);
		
		// BOTÕES
		// SALVAR
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ServicosDTO servicosDTO = new ServicosDTO();
				
				String nomeServico = txtNomeServico.getText();
				String descricao = txtDescricao.getText();
				Float valor = Float.parseFloat(txtValor.getText());
				
				servicosDTO.setNomeServico(nomeServico);
				servicosDTO.setDescricao(descricao);
				servicosDTO.setValor(valor);
				
				if(servicosController.cadastrarServico(servicosDTO) != null) {
					JOptionPane.showMessageDialog(null, "Serviço cadastrado com sucesso!");
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar serviço");
				}
			}
		});
		btnSalvar.setForeground(Color.BLACK);
		btnSalvar.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnSalvar.setBackground(new Color(138, 43, 226));
		btnSalvar.setBounds(393, 477, 114, 28);
		desktopPane.add(btnSalvar);
		
		// CANCELAR
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dialogButton = JOptionPane.showConfirmDialog (null, "Tem certeza que deseja cancelar? Todos os dados serão perdidos", "Cancelar", JOptionPane.YES_NO_OPTION);

				if(dialogButton == JOptionPane.YES_OPTION) {
					dispose();
				}
				
			}
		});
		btnCancelar.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnCancelar.setBackground(new Color(138, 43, 226));
		btnCancelar.setBounds(267, 477, 114, 28);
		desktopPane.add(btnCancelar);

	}
}
