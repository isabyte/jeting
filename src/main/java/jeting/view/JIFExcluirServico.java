package jeting.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import jeting.controller.ServicosController;
import jeting.model.entities.ServicosEntidades;
import jeting.model.services.ServicosServices;

public class JIFExcluirServico extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	
	private static ServicosServices servicosServices = new ServicosServices();
	private static ServicosController servicosController = new ServicosController(servicosServices);
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JIFExcluirServico frame = new JIFExcluirServico();
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
	public JIFExcluirServico() {
		setClosable(true);
		setTitle("Excluir Serviço");
		setBounds(10, 10, 796, 605);
		getContentPane().setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(0, 0, 0));
		desktopPane.setBounds(10, 0, 748, 553);
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
		
		JLabel lblExcluirServico = new JLabel("Excluir serviço");
		lblExcluirServico.setForeground(Color.WHITE);
		lblExcluirServico.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblExcluirServico.setBackground(Color.WHITE);
		lblExcluirServico.setBounds(115, 47, 132, 78);
		desktopPane.add(lblExcluirServico);
		
		// CAMPOS
		JLabel lblServicoExcluir = new JLabel("ID do serviço a ser excluído");
		lblServicoExcluir.setForeground(Color.WHITE);
		lblServicoExcluir.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblServicoExcluir.setBounds(35, 141, 259, 28);
		desktopPane.add(lblServicoExcluir);
		
		JTextField txtServicoExcluir = new JTextField();
		txtServicoExcluir.setForeground(Color.WHITE);
		txtServicoExcluir.setColumns(10);
		txtServicoExcluir.setBorder(new LineBorder(new Color(138, 43, 226), 2));
		txtServicoExcluir.setBackground(Color.BLACK);
		txtServicoExcluir.setBounds(35, 179, 291, 28);
		desktopPane.add(txtServicoExcluir);
		
		// BOTÕES
		//PROCURAR
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Long servicoToSearch = Long.parseLong(txtServicoExcluir.getText());
				
				ServicosEntidades servicoExistente = servicosController.servicosServices.findById(servicoToSearch);
				
				if(servicoExistente == null) {
					JOptionPane.showMessageDialog(null, "Serviço não encontrado");
					return;
				}
				
				JOptionPane.showMessageDialog(null, "Serviço encontrado: " + servicoExistente.getNomeServico());
			}
		});
		btnProcurar.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btnProcurar.setBackground(new Color(138, 43, 226));
		btnProcurar.setBounds(339, 178, 114, 28);
		desktopPane.add(btnProcurar);
		
		// EXCLUIR
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Long servicoToDelete = Long.parseLong(txtServicoExcluir.getText());

					ServicosEntidades servicoExistente = servicosController.servicosServices.findById(servicoToDelete);
					if (servicoExistente == null) {
						JOptionPane.showMessageDialog(null, "Serviço não encontrado");
						return;
					}
					
					int dialogExcluir = JOptionPane.showConfirmDialog (null, "Tem certeza que deseja excluir " + servicoExistente.getNomeServico() + "? Esta ação não pode ser desfeita", "Excluir", JOptionPane.YES_NO_OPTION);

					if(dialogExcluir == JOptionPane.YES_OPTION) {
						servicosController.servicosServices.deleteById(servicoToDelete);
						JOptionPane.showMessageDialog(null, "Serviço excluído com sucesso");
					}
				}
			});
		btnExcluir.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btnExcluir.setBounds(326, 428, 114, 28);
		btnExcluir.setBackground(new Color(138, 43, 226));
		desktopPane.add(btnExcluir);
		
	}

}
