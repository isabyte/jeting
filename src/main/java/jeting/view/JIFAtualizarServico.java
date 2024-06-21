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

import jeting.controller.ServicosController;
import jeting.model.entities.ServicosEntidades;
import jeting.model.services.ServicosServices;

public class JIFAtualizarServico extends JInternalFrame {

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
					JIFAtualizarServico frame = new JIFAtualizarServico();
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
	public JIFAtualizarServico() {
		setClosable(true);
		setTitle("Atualizar Serviço");
		setBounds(10, 10, 798, 673);
		getContentPane().setLayout(null);
		
		// DESKTOP PANE
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(0, 0, 0));
		desktopPane.setBounds(10, 0, 758, 621);
		getContentPane().add(desktopPane);
		
		// FONTES
		Font fontePadrao = new Font("MS Sans Serif", Font.PLAIN, 18);
		Font fonteJeting = new Font("Impact", Font.BOLD, 50);
		
		// CORES
		Color violetColor = new Color(138, 43, 226);
		
		// LOGO
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

		JLabel lblAtualizarServico = new JLabel("Atualizar Serviço");
		lblAtualizarServico.setForeground(new Color(255, 255, 255));
		lblAtualizarServico.setBackground(new Color(255, 255, 255));
		lblAtualizarServico.setBounds(313, 63, 156, 78);
		lblAtualizarServico.setFont(fontePadrao);
		desktopPane.add(lblAtualizarServico);
		
		// CAMPOS
		JLabel lblServicoAtualizar = new JLabel("ID do serviço a ser atualizado");
		lblServicoAtualizar.setForeground(Color.WHITE);
		lblServicoAtualizar.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblServicoAtualizar.setBounds(35, 141, 259, 28);
		desktopPane.add(lblServicoAtualizar);
		
		JTextField txtServicoAtualizar = new JTextField();
		txtServicoAtualizar.setForeground(Color.WHITE);
		txtServicoAtualizar.setColumns(10);
		txtServicoAtualizar.setBorder(BorderFactory.createLineBorder(violetColor, 2));
		txtServicoAtualizar.setBackground(Color.BLACK);
		txtServicoAtualizar.setBounds(35, 179, 291, 28);
		desktopPane.add(txtServicoAtualizar);
		
		JLabel lblNomeAtualizado = new JLabel("Novo nome do serviço");
		lblNomeAtualizado.setForeground(new Color(255, 255, 255));
		lblNomeAtualizado.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblNomeAtualizado.setBounds(35, 230, 193, 28);
		desktopPane.add(lblNomeAtualizado);
		
		JTextField txtNomeAtualizado = new JTextField();
		txtNomeAtualizado.setForeground(new Color(255, 255, 255));
		txtNomeAtualizado.setBackground(new Color(0, 0, 0));
		txtNomeAtualizado.setColumns(10);
		txtNomeAtualizado.setBorder(BorderFactory.createLineBorder(violetColor, 2));
		txtNomeAtualizado.setBounds(35, 268, 300, 28);
		desktopPane.add(txtNomeAtualizado);
		
		JLabel lblDescricaoAtualizada = new JLabel("Nova descrição");
		lblDescricaoAtualizada.setForeground(new Color(255, 255, 255));
		lblDescricaoAtualizada.setFont(fontePadrao);
		lblDescricaoAtualizada.setBounds(35, 319, 152, 28);
		desktopPane.add(lblDescricaoAtualizada);

		JTextField txtDescricaoAtualizada = new JTextField();
		txtDescricaoAtualizada.setForeground(new Color(255, 255, 255));
		txtDescricaoAtualizada.setBackground(new Color(0, 0, 0));
		txtDescricaoAtualizada.setColumns(10);
		txtDescricaoAtualizada.setBounds(35, 359, 300, 84);
		txtDescricaoAtualizada.setBorder(BorderFactory.createLineBorder(violetColor, 2));
		desktopPane.add(txtDescricaoAtualizada);
		
		JLabel lblValorAtualizado = new JLabel("Novo valor");
		lblValorAtualizado.setForeground(new Color(255, 255, 255));
		lblValorAtualizado.setFont(fontePadrao);
		lblValorAtualizado.setBounds(35, 460, 114, 28);
		desktopPane.add(lblValorAtualizado);

		JTextField txtValorAtualizado = new JTextField();
		txtValorAtualizado.setForeground(new Color(255, 255, 255));
		txtValorAtualizado.setBackground(new Color(0, 0, 0));
		txtValorAtualizado.setColumns(10);
		txtValorAtualizado.setBorder(BorderFactory.createLineBorder(violetColor, 2));
		txtValorAtualizado.setBounds(35, 500, 300, 28);
		desktopPane.add(txtValorAtualizado);
		
		// BOTÕES
		// PROCURAR
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Long ServicoToUpdate = Long.parseLong(txtServicoAtualizar.getText());
				
				ServicosEntidades servicoExistente = servicosController.servicosServices.findById(ServicoToUpdate);
				
				if(servicoExistente == null) {
					JOptionPane.showMessageDialog(null, "Serviço não encontrado");
					return;
				}
				
				txtNomeAtualizado.setText(servicoExistente.getNomeServico());
				txtDescricaoAtualizada.setText(servicoExistente.getDescricao());
				txtValorAtualizado.setText(Float.toString(servicoExistente.getValor()));
				
			}
		});
		btnProcurar.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btnProcurar.setBackground(new Color(138, 43, 226));
		btnProcurar.setBounds(339, 178, 114, 28);
		desktopPane.add(btnProcurar);
		
		// SALVAR
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Long ServicoToUpdate = Long.parseLong(txtServicoAtualizar.getText());
				
				ServicosEntidades servicoExistente = servicosController.servicosServices.findById(ServicoToUpdate);
				
				if(servicoExistente == null) {
					JOptionPane.showMessageDialog(null, "ERRO: o serviço a ser atualizado não existe");
					return;
				}
				
				ServicosDTO servicosDTO = new ServicosDTO();
				
				String nomeAtualizado = txtNomeAtualizado.getText();
				String descricaoAtualizada = txtDescricaoAtualizada.getText();
				Float valorAtualizado = Float.parseFloat(txtValorAtualizado.getText());
				
				servicosDTO.setNomeServico(nomeAtualizado);
				servicosDTO.setDescricao(descricaoAtualizada);
				servicosDTO.setValor(valorAtualizado);
				
				ServicosEntidades servicoAtualizado = servicosController.atualizarServico(servicosDTO, ServicoToUpdate);
				
				servicoAtualizado = servicosController.servicosServices.atualizarServico(servicoAtualizado);
				
				if(servicoAtualizado != null) {
					JOptionPane.showMessageDialog(null, "Serviço atualizado com sucesso!");
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar serviço");
				}
			}
		});
		btnSalvar.setForeground(Color.BLACK);
		btnSalvar.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnSalvar.setBackground(new Color(138, 43, 226));
		btnSalvar.setBounds(612, 562, 114, 28);
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
		btnCancelar.setBounds(486, 562, 114, 28);
		desktopPane.add(btnCancelar);

	}

}
