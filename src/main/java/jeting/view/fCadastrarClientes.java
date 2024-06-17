package jeting.view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Canvas;

public class fCadastrarClientes extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField tfEmail;
	private JTextField tfTelefone;
	private JTextField tfNome;

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

	/**
	 * Create the frame.
	 */
	public fCadastrarClientes() {
		setClosable(true);
		setTitle("Cadastro de Clientes");
		setBounds(10, 10, 932, 572);
		getContentPane().setLayout(null);

		Font fontePadrao = new Font("MS Sans Serif", Font.PLAIN, 24);
		Font fonteJeting= new Font("Impact", Font.BOLD, 74);


		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(236, 217, 255));
		desktopPane.setBounds(-29, -10, 1135, 866);
		getContentPane().add(desktopPane);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(fontePadrao);
		lblNome.setBounds(561, 174, 114, 28);
		desktopPane.add(lblNome);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(fontePadrao);
		lblTelefone.setBounds(561, 421, 163, 28);
		desktopPane.add(lblTelefone);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(fontePadrao);
		lblEmail.setBounds(561, 296, 114, 28);
		desktopPane.add(lblEmail);

		tfEmail = new JTextField();
		tfEmail.setBounds(561, 333, 432, 38);
		tfEmail.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
		desktopPane.add(tfEmail);
		tfEmail.setColumns(10);

		tfTelefone = new JTextField();
		tfTelefone.setColumns(10);
		tfTelefone.setBounds(561, 459, 432, 38);
		tfTelefone.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
		desktopPane.add(tfTelefone);

		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(561, 212, 432, 38);
		tfNome.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
		desktopPane.add(tfNome);
		
		JButton btnSalvarCadastro = new JButton("Salvar");
		btnSalvarCadastro.setBounds(643, 574, 141, 28);
		btnSalvarCadastro.setFont(fontePadrao);
		desktopPane.add(btnSalvarCadastro);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(804, 574, 141, 28);
		btnCancelar.setFont(fontePadrao);
		desktopPane.add(btnCancelar);
		
		JLabel lblJ = new JLabel("J");
		lblJ.setBounds(80, 261, 60, 84);
		lblJ.setFont(fonteJeting);
		desktopPane.add(lblJ);
		
		JLabel lblE = new JLabel("e");
		lblE.setBounds(134, 264, 60, 78);
		lblE.setFont(fonteJeting);
		desktopPane.add(lblE);
		
		JLabel lblT = new JLabel("t");
		lblT.setBounds(204, 264, 60, 78);
		lblT.setFont(fonteJeting);
		desktopPane.add(lblT);
		
		JLabel lblI = new JLabel("i");
		lblI.setBounds(266, 264, 60, 78);
		lblI.setFont(fonteJeting);
		desktopPane.add(lblI);
		
		JLabel lblN = new JLabel("n");
		lblN.setBounds(325, 259, 60, 89);
		lblN.setFont(fonteJeting);
		desktopPane.add(lblN);
		
		JLabel lblG = new JLabel("g");
		lblG.setBounds(395, 259, 60, 83);
		lblG.setFont(fonteJeting);
		desktopPane.add(lblG);
		
		JLabel lblCadastro = new JLabel("Cadastro de Clientes");
		lblCadastro.setBounds(136, 373, 249, 78);
		lblCadastro.setFont(fontePadrao);
		desktopPane.add(lblCadastro);
		
		Canvas canvas = new Canvas();
		canvas.setBackground(new Color(104, 0, 208));
		canvas.setBounds(66, 364, 389, 5);
		desktopPane.add(canvas);
		

	}
}
