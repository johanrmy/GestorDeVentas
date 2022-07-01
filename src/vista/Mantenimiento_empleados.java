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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import data.Empleado;
import data.EmpleadoDAO;
import data.Planta;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mantenimiento_empleados extends JInternalFrame {
	private JTable table;
	private JTextField textId_empleado;
	private JTextField textApellidos;
	private JTextField textNombres;
	private JTextField textDireccion;
	private JTextField textTelefono;
	private JTextField textSueldo;
	int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mantenimiento_empleados frame = new Mantenimiento_empleados();
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
	public Mantenimiento_empleados() {
		setTitle("Mantenimiento de empleados");
		EmpleadoDAO ed=new EmpleadoDAO();
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 580, 561);
		getContentPane().setLayout(null);
		
		JLabel lblBsquedaDeEmpleados = new JLabel("Mantenimiento de empleados");
		lblBsquedaDeEmpleados.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblBsquedaDeEmpleados.setBounds(10, 11, 305, 46);
		getContentPane().add(lblBsquedaDeEmpleados);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel mm = (DefaultTableModel)table.getModel();
				id = Integer.parseInt(textId_empleado.getText());
				try {	
					clear(mm);
					List<Empleado> lista=ed.consulta(id);
					Object[] ob=new Object[9];
					
					ob[0]= lista.get(0).getId_empleado();
					ob[1]= lista.get(0).getApellidos();
					ob[2]= lista.get(0).getNombres();
					ob[3]= lista.get(0).getDni();
					ob[4]= lista.get(0).getFecha_nacimiento();
					ob[5]= lista.get(0).getDireccion();
					ob[6]= lista.get(0).getTelefono();
					ob[7]= lista.get(0).getPuesto();
					ob[8]= lista.get(0).getSueldo();
					mm.addRow(ob);
					table.setModel(mm);
					
				}catch(Exception er) {
					JOptionPane.showMessageDialog(null, "ID no encontrado");
				}
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBuscar.setBounds(143, 256, 104, 29);
		getContentPane().add(btnBuscar);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(109, 201, 111, 22);
		getContentPane().add(comboBox);
		comboBox.addItem("Seleccionar");
		comboBox.addItem("Vendedor");
		comboBox.addItem("Administrador");
		comboBox.addItem("Limpieza");
		comboBox.addItem("Gerente");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 306, 561, 214);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				
				id = Integer.parseInt(table.getValueAt(row, 0).toString());
				String ape = table.getValueAt(row, 1).toString();
				String nom = table.getValueAt(row, 2).toString();
				String dir = table.getValueAt(row, 5).toString();
				String telf = table.getValueAt(row, 6).toString();
				String puesto = table.getValueAt(row, 7).toString();
				String sueldo = table.getValueAt(row, 8).toString();
				textApellidos.setText(ape);
				textNombres.setText(nom);
				textDireccion.setText(dir);
				textTelefono.setText(telf);
				textSueldo.setText(sueldo);
				comboBox.setSelectedItem(puesto);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id_empleado", "Apellidos", "Nombres", "DNI", "fecha_nacimiento", "Direcci\u00F3n", "Tel\u00E9fono", "Puesto", "Sueldo"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel mm = (DefaultTableModel)table.getModel();
				id = Integer.parseInt(textId_empleado.getText());
				try {
				ed.eliminar(id);
				JOptionPane.showMessageDialog(null, "Registro "+id+" eliminado");
				clear(mm);
				List<Empleado> lista=ed.consulta();
				Object[] ob=new Object[9];
				
				for(int i=0;i<lista.size();i++) {
					ob[0]= lista.get(i).getId_empleado();
					ob[1]= lista.get(i).getApellidos();
					ob[2]= lista.get(i).getNombres();
					ob[3]= lista.get(i).getDni();
					ob[4]= lista.get(i).getFecha_nacimiento();
					ob[5]= lista.get(i).getDireccion();
					ob[6]= lista.get(i).getTelefono();
					ob[7]= lista.get(i).getPuesto();
					ob[8]= lista.get(i).getSueldo();
					mm.addRow(ob);
					table.setModel(mm);
					}
				}catch(Exception er) {
					JOptionPane.showMessageDialog(null, "Registro "+id+" no encontrado");
				}
			}
		});
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEliminar.setBounds(407, 64, 104, 29);
		getContentPane().add(btnEliminar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel mm = (DefaultTableModel)table.getModel();
				String ape = textApellidos.getText();
				String nom = textNombres.getText();
				String dir = textDireccion.getText();
				String telf = textTelefono.getText();
				String puesto = (String)comboBox.getSelectedItem();
				int sueldo = Integer.parseInt(textSueldo.getText());
				
				EmpleadoDAO edd=new EmpleadoDAO(ape,nom,null,null,dir,telf,puesto,sueldo);
				edd.actualizacion(id);
				clear(mm);
				List<Empleado> lista=ed.consulta();
				Object[] ob=new Object[9];
				
				for(int i=0;i<lista.size();i++) {
					ob[0]= lista.get(i).getId_empleado();
					ob[1]= lista.get(i).getApellidos();
					ob[2]= lista.get(i).getNombres();
					ob[3]= lista.get(i).getDni();
					ob[4]= lista.get(i).getFecha_nacimiento();
					ob[5]= lista.get(i).getDireccion();
					ob[6]= lista.get(i).getTelefono();
					ob[7]= lista.get(i).getPuesto();
					ob[8]= lista.get(i).getSueldo();
					mm.addRow(ob);
					table.setModel(mm);
				}
			}
		});
		btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnActualizar.setBounds(407, 104, 104, 29);
		getContentPane().add(btnActualizar);
		
		JButton btnBuscar_1 = new JButton("Consulta");
		btnBuscar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel mm = (DefaultTableModel)table.getModel();
				clear(mm);
				List<Empleado> lista=ed.consulta();
				Object[] ob=new Object[9];
				
				for(int i=0;i<lista.size();i++) {
					ob[0]= lista.get(i).getId_empleado();
					ob[1]= lista.get(i).getApellidos();
					ob[2]= lista.get(i).getNombres();
					ob[3]= lista.get(i).getDni();
					ob[4]= lista.get(i).getFecha_nacimiento();
					ob[5]= lista.get(i).getDireccion();
					ob[6]= lista.get(i).getTelefono();
					ob[7]= lista.get(i).getPuesto();
					ob[8]= lista.get(i).getSueldo();
					mm.addRow(ob);
					table.setModel(mm);
				}
			}
		});
		btnBuscar_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBuscar_1.setBounds(407, 146, 104, 29);
		getContentPane().add(btnBuscar_1);
		
		JButton btnBuscar_3_1 = new JButton("Cancelar");
		btnBuscar_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textApellidos.setText(null);
				textNombres.setText(null);
				textDireccion.setText(null);
				textTelefono.setText(null);
				textSueldo.setText(null);
			}
		});
		btnBuscar_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBuscar_3_1.setBounds(407, 225, 104, 29);
		getContentPane().add(btnBuscar_3_1);
		
		textId_empleado = new JTextField();
		textId_empleado.setColumns(10);
		textId_empleado.setBounds(70, 262, 63, 20);
		getContentPane().add(textId_empleado);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("ID:");
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_2_1.setBounds(34, 265, 26, 17);
		getContentPane().add(lblNewLabel_1_1_2_1);
		
		JLabel lblNewLabel_1 = new JLabel("Apellidos:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(34, 73, 65, 14);
		getContentPane().add(lblNewLabel_1);
		
		textApellidos = new JTextField();
		textApellidos.setColumns(10);
		textApellidos.setBounds(109, 70, 206, 20);
		getContentPane().add(textApellidos);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombres:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(34, 104, 65, 14);
		getContentPane().add(lblNewLabel_1_1);
		
		textNombres = new JTextField();
		textNombres.setColumns(10);
		textNombres.setBounds(109, 103, 206, 20);
		getContentPane().add(textNombres);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Direcci\u00F3n:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(34, 135, 65, 14);
		getContentPane().add(lblNewLabel_1_1_1);
		
		textDireccion = new JTextField();
		textDireccion.setColumns(10);
		textDireccion.setBounds(109, 134, 206, 20);
		getContentPane().add(textDireccion);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Tel\u00E9fono:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(34, 171, 65, 14);
		getContentPane().add(lblNewLabel_1_1_1_1);
		
		textTelefono = new JTextField();
		textTelefono.setColumns(10);
		textTelefono.setBounds(109, 170, 111, 20);
		getContentPane().add(textTelefono);
	
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Puesto:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_1.setBounds(34, 203, 65, 14);
		getContentPane().add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Sueldo:");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_1_1.setBounds(231, 206, 65, 14);
		getContentPane().add(lblNewLabel_1_1_1_1_1_1);
		
		textSueldo = new JTextField();
		textSueldo.setColumns(10);
		textSueldo.setBounds(287, 203, 77, 20);
		getContentPane().add(textSueldo);

	}
	void clear(DefaultTableModel mm) {
		for(int i=0;i<mm.getRowCount();i++) {
			mm.removeRow(i);
			i=i-1;
		}
	}
}
