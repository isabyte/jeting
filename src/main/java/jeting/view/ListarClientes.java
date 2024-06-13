package jeting.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTable;

public class ListarClientes extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarClientes frame = new ListarClientes();
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
	public ListarClientes() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBounds(49, 28, 289, 189);
		getContentPane().add(table);

	}
}