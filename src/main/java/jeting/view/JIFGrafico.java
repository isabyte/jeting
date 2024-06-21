package jeting.view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JInternalFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import jeting.controller.ClientesController;
import jeting.controller.ServicosController;
import jeting.model.services.ClientesServices;
import jeting.model.services.ServicosServices;

public class JIFGrafico extends JInternalFrame {
	
	private static ClientesServices clientesServices = new ClientesServices();
	private static ClientesController clientesController = new ClientesController(clientesServices);
	private static ServicosServices servicosServices = new ServicosServices();
	private static ServicosController servicosController = new ServicosController(servicosServices);

	private static final long serialVersionUID = 1L;
	
	/**
	 * Create the frame.
	 */
	public JIFGrafico() {
		setBounds(0, 0, 800, 650);
		CategoryDataset dataset = createDataset();
		JFreeChart chart = createChart(dataset);
		
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.WHITE);
		add(chartPanel);
		
		pack();
		setTitle("Dados");

	}

	private JFreeChart createChart(CategoryDataset dataset) {
		JFreeChart barChart = ChartFactory.createBarChart(
				"Estatísticas Jeting",
				null,
				"Quantidade",
				dataset,
				PlotOrientation.VERTICAL,
				false,
				true,
				false);
		
		return barChart;
	}

	private CategoryDataset createDataset() {
		Long quantClientes = clientesController.countClientes();
		Long quantServicos = servicosController.countServicos();
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue(quantClientes, "Número total de clientes", "Clientes");
		dataset.setValue(quantServicos, "Número total de serviços oferecidos", "Serviços");
		
		return dataset;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JIFGrafico frame = new JIFGrafico();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



}
