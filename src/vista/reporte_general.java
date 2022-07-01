package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import data.Reportes;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JComboBox;

public class reporte_general extends JInternalFrame {
	private JTextField textReporteV;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reporte_general frame = new reporte_general();
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
	public reporte_general() {
		setTitle("Reporte general");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 536, 492);
		getContentPane().setLayout(null);
		
		JLabel lblReporteGeneral = new JLabel("Reporte general");
		lblReporteGeneral.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblReporteGeneral.setBounds(168, 11, 175, 46);
		getContentPane().add(lblReporteGeneral);
		
		JButton btnPrueba = new JButton("Plantas");
		btnPrueba.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPrueba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reportes r=new Reportes();
				r.reporte1("ReporteP", "select * from planta");
			}
		});
		btnPrueba.setBounds(47, 82, 110, 101);
		getContentPane().add(btnPrueba);
		
		JButton btnPrueba2 = new JButton("Empleados");
		btnPrueba2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPrueba2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reportes r=new Reportes();
				r.reporte1("ReporteE", "select * from empleado");
			}
		});
		btnPrueba2.setBounds(208, 82, 110, 101);
		getContentPane().add(btnPrueba2);
		
		JButton btnVentas = new JButton("Ventas");
		btnVentas.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Reportes r=new Reportes();
				r.reporte1("ReporteV", "select * from venta where id_venta=1");
			}catch(Exception er) {
				JOptionPane.showMessageDialog(null, "Error al generar reporte");
			}
				}
		});
		btnVentas.setBounds(369, 82, 110, 101);
		getContentPane().add(btnVentas);
		
		textReporteV = new JTextField();
		textReporteV.setColumns(10);
		textReporteV.setBounds(47, 375, 110, 29);
		getContentPane().add(textReporteV);
		
		
		JComboBox comboBoxE = new JComboBox();
		comboBoxE.setBounds(47, 314, 110, 22);
		getContentPane().add(comboBoxE);
		comboBoxE.addItem("Gerente");
		comboBoxE.addItem("Administrador");
		comboBoxE.addItem("Limpieza");
		comboBoxE.addItem("Vendedor");
		
		JComboBox comboBoxP = new JComboBox();
		comboBoxP.setBounds(47, 249, 110, 22);
		getContentPane().add(comboBoxP);
		comboBoxP.addItem("0 (Interior)");
		comboBoxP.addItem("1 (Exterior)");

		
		JButton btnNewButton = new JButton("Generar reporte");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reportes r=new Reportes();
				String cond = null;
				try {
				String cbox = (String)comboBoxP.getSelectedItem();
				if (cbox=="0 (Interior)") {
					cond = "0";
				}else {
					cond = "1";
				}
				
				r.reporte2("BusquedaP", "select * from planta where tipo=$P{tipo}","tipo",cond );
				clearField();
				comboBoxE.setSelectedItem(null);
				}catch(Exception er) {
					JOptionPane.showMessageDialog(null, "Error al generar reporte");
				}

			}
		});
		btnNewButton.setBounds(232, 245, 123, 29);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("generar reporte");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reportes r=new Reportes();
				try {
				String cond = (String)comboBoxE.getSelectedItem();
				r.reporte2("BusquedaE", "select * from empleado where puesto=$P{puesto}","puesto",cond);
				clearField();
				comboBoxE.setSelectedItem(null);
				comboBoxP.setSelectedItem(null);
				}catch(Exception er) {
					JOptionPane.showMessageDialog(null, "Error al generar reporte");
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setBounds(232, 310, 123, 29);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Generar reporte");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reportes r=new Reportes();
				try {
				int cond = Integer.parseInt(textReporteV.getText());
				r.reporte3("BusquedaV", "select * from venta where id_planta=$P{id_planta}",cond);
				clearField();
				comboBoxE.setSelectedItem(null);
				comboBoxP.setSelectedItem(null);
				}catch(Exception er) {
					JOptionPane.showMessageDialog(null, "ID de planta no encontrado");
				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_2.setBounds(232, 375, 123, 29);
		getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("B\u00FAsqueda de plantas por tipo");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(47, 220, 187, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblBsquedaPorId = new JLabel("B\u00FAsqueda de empleados por puesto");
		lblBsquedaPorId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBsquedaPorId.setBounds(47, 285, 226, 14);
		getContentPane().add(lblBsquedaPorId);
		
		JLabel lblBsquedaPorId_1 = new JLabel("Busqueda de venta por ID planta");
		lblBsquedaPorId_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBsquedaPorId_1.setBounds(47, 350, 204, 14);
		getContentPane().add(lblBsquedaPorId_1);
		

	}
	void clearField() {
		textReporteV.setText(null);
	}
}
