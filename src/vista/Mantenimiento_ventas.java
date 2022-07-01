package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import data.Planta;
import data.PlantaDAO;
import data.Venta;
import data.VentaDAO;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mantenimiento_ventas extends JInternalFrame {
	private JTextField textId_planta;
	private JTextField textComprador;
	private JTextField textDni;
	private JTextField textCantidad;
	private JTextField textId;
	private JTable table;
	int id;
	int precio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mantenimiento_ventas frame = new Mantenimiento_ventas();
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
	public Mantenimiento_ventas() {
		setTitle("Mantenimiento de ventas");
		VentaDAO vd=new VentaDAO();
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 536, 492);
		getContentPane().setLayout(null);
		
		JLabel lblBsquedaDeVentas = new JLabel("Mantenimiento de ventas");
		lblBsquedaDeVentas.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblBsquedaDeVentas.setBounds(10, 11, 251, 46);
		getContentPane().add(lblBsquedaDeVentas);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearField();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelar.setBounds(374, 232, 104, 29);
		getContentPane().add(btnCancelar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel mm = (DefaultTableModel)table.getModel();
				int cod_p = Integer.parseInt(textId_planta.getText());
				String com = textComprador.getText();
				String dni = textDni.getText();
				int cant = Integer.parseInt(textCantidad.getText());
				double igv = precio*cant*0.18;
				double total = (precio*cant)+igv;
				
				VentaDAO vdd=new VentaDAO(0,cod_p,com,dni,0,cant,igv,total);
				vdd.actualizacion(id);
				clearTable(mm);
				
				List<Venta> lista=vd.consulta();
				Object[] ob=new Object[9];
				
				for(int i=0;i<lista.size();i++) {
					ob[0]= lista.get(i).getId_venta();
					ob[1]= lista.get(i).getId_empleado();
					ob[2]= lista.get(i).getId_planta();
					ob[3]= lista.get(i).getComprador();
					ob[4]= lista.get(i).getDni();
					ob[5]= lista.get(i).getPrecio();
					ob[6]= lista.get(i).getCantidad();
					ob[7]= lista.get(i).getIgv();
					ob[8]= lista.get(i).getTotal();
					mm.addRow(ob);
					table.setModel(mm);
				}
				
			}
		});
		btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnActualizar.setBounds(374, 106, 104, 29);
		getContentPane().add(btnActualizar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel mm = (DefaultTableModel)table.getModel();
				try {
					vd.eliminar(id);
					JOptionPane.showMessageDialog(null, "ID "+ id+ " eliminado");
					clearTable(mm);
					clearField();
					
					List<Venta> lista=vd.consulta();
					Object[] ob=new Object[9];
					for(int i=0;i<lista.size();i++) {
						ob[0]= lista.get(i).getId_venta();
						ob[1]= lista.get(i).getId_empleado();
						ob[2]= lista.get(i).getId_planta();
						ob[3]= lista.get(i).getComprador();
						ob[4]= lista.get(i).getDni();
						ob[5]= lista.get(i).getPrecio();
						ob[6]= lista.get(i).getCantidad();
						ob[7]= lista.get(i).getIgv();
						ob[8]= lista.get(i).getTotal();
						mm.addRow(ob);
						table.setModel(mm);
					}
				}catch(Exception er) {
					JOptionPane.showMessageDialog(null, "ID no encontrado");;
				}
			}
		});
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEliminar.setBounds(374, 66, 104, 29);
		getContentPane().add(btnEliminar);
		
		JButton btnConsulta = new JButton("Consulta");
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel mm = (DefaultTableModel)table.getModel();
				clearTable(mm);
				List<Venta> lista=vd.consulta();
				Object[] ob=new Object[9];
				
				for(int i=0;i<lista.size();i++) {
					ob[0]= lista.get(i).getId_venta();
					ob[1]= lista.get(i).getId_empleado();
					ob[2]= lista.get(i).getId_planta();
					ob[3]= lista.get(i).getComprador();
					ob[4]= lista.get(i).getDni();
					ob[5]= lista.get(i).getPrecio();
					ob[6]= lista.get(i).getCantidad();
					ob[7]= lista.get(i).getIgv();
					ob[8]= lista.get(i).getTotal();
					mm.addRow(ob);
					table.setModel(mm);
				}
			}
		});
		btnConsulta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConsulta.setBounds(374, 146, 104, 29);
		getContentPane().add(btnConsulta);
		
		JLabel lblNewLabel_1 = new JLabel("C\u00F3digo de planta:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(20, 68, 119, 20);
		getContentPane().add(lblNewLabel_1);
		
		textId_planta = new JTextField();
		textId_planta.setColumns(10);
		textId_planta.setBounds(149, 68, 97, 20);
		getContentPane().add(textId_planta);
		
		JLabel lblNewLabel_1_1 = new JLabel("Comprador:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(20, 106, 85, 20);
		getContentPane().add(lblNewLabel_1_1);
		
		textComprador = new JTextField();
		textComprador.setColumns(10);
		textComprador.setBounds(149, 106, 215, 20);
		getContentPane().add(textComprador);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("DNI:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(20, 146, 65, 14);
		getContentPane().add(lblNewLabel_1_1_1);
		
		textDni = new JTextField();
		textDni.setColumns(10);
		textDni.setBounds(149, 146, 97, 20);
		getContentPane().add(textDni);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Cantidad:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(20, 185, 65, 14);
		getContentPane().add(lblNewLabel_1_1_1_1);
		
		textCantidad = new JTextField();
		textCantidad.setColumns(10);
		textCantidad.setBounds(149, 184, 58, 20);
		getContentPane().add(textCantidad);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("ID:");
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_2_1.setBounds(20, 233, 26, 17);
		getContentPane().add(lblNewLabel_1_1_2_1);
		
		textId = new JTextField();
		textId.setColumns(10);
		textId.setBounds(56, 233, 63, 20);
		getContentPane().add(textId);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel mm = (DefaultTableModel)table.getModel();
				id = Integer.parseInt(textId.getText());
				vd.consulta(id);
				try {
					clearTable(mm);
					List<Venta> lista=vd.consulta();
					Object[] ob=new Object[9];
					
						ob[0]= lista.get(0).getId_venta();
						ob[1]= lista.get(0).getId_empleado();
						ob[2]= lista.get(0).getId_planta();
						ob[3]= lista.get(0).getComprador();
						ob[4]= lista.get(0).getDni();
						ob[5]= lista.get(0).getPrecio();
						ob[6]= lista.get(0).getCantidad();
						ob[7]= lista.get(0).getIgv();
						ob[8]= lista.get(0).getTotal();
						mm.addRow(ob);
						table.setModel(mm);
				}catch(Exception er) {
					JOptionPane.showMessageDialog(null, "ID no encontrado");
				}
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBuscar.setBounds(129, 232, 104, 29);
		getContentPane().add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 273, 514, 180);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				
				id = Integer.parseInt(table.getValueAt(row, 0).toString());
				String cod_p = table.getValueAt(row, 2).toString();
				String com = table.getValueAt(row, 3).toString();
				String dni = table.getValueAt(row, 4).toString();
				String cant = table.getValueAt(row, 6).toString();
				precio = Integer.parseInt(table.getValueAt(row, 5).toString());

				textId_planta.setText(cod_p);
				textComprador.setText(com);
				textDni.setText(dni);
				textCantidad.setText(cant);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID_venta", "ID_empleado", "ID_planta", "Comprador", "DNI", "Precio", "Cantidad", "IGV", "Total"
			}
		));
		scrollPane.setViewportView(table);

	}
	void clearField() {
		textId_planta.setText(null);
		textComprador.setText(null);
		textDni.setText(null);
		textCantidad.setText(null);
		textId.setText(null);
	}
	void clearTable(DefaultTableModel mm) {
		for(int i=0;i<mm.getRowCount();i++) {
			mm.removeRow(i);
			i=i-1;
		}
	}
}