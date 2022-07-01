package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import data.EmpleadoDAO;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class registroEmpleados extends JInternalFrame {
	private JTextField textApellidos;
	private JTextField textNombres;
	private JTextField textDni;
	private JTextField textFecha_n;
	private JTextField textDireccion;
	private JTextField textTelefono;
	private JTextField textSueldo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registroEmpleados frame = new registroEmpleados();
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
	public registroEmpleados() {
		setTitle("Registro de empleados");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 536, 492);
		getContentPane().setLayout(null);
		
		JLabel lblRegistroDeEmpleados = new JLabel("Registro de empleados");
		lblRegistroDeEmpleados.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblRegistroDeEmpleados.setBounds(10, 11, 232, 46);
		getContentPane().add(lblRegistroDeEmpleados);
		
		JLabel lblNewLabel = new JLabel("Apellidos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(45, 68, 51, 29);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNombres = new JLabel("Nombres");
		lblNombres.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombres.setBounds(45, 120, 67, 29);
		getContentPane().add(lblNombres);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDni.setBounds(45, 167, 51, 29);
		getContentPane().add(lblDni);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFechaDeNacimiento.setBounds(219, 167, 135, 29);
		getContentPane().add(lblFechaDeNacimiento);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDireccin.setBounds(45, 221, 77, 29);
		getContentPane().add(lblDireccin);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelfono.setBounds(45, 261, 59, 29);
		getContentPane().add(lblTelfono);
		
		textApellidos = new JTextField();
		textApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textApellidos.setBounds(122, 74, 284, 20);
		getContentPane().add(textApellidos);
		textApellidos.setColumns(10);
		
		textNombres = new JTextField();
		textNombres.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textNombres.setColumns(10);
		textNombres.setBounds(122, 124, 284, 20);
		getContentPane().add(textNombres);
		
		JLabel lblPuesto = new JLabel("Puesto");
		lblPuesto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPuesto.setBounds(45, 315, 77, 29);
		getContentPane().add(lblPuesto);
		
		JLabel lblSueldo = new JLabel("Sueldo");
		lblSueldo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSueldo.setBounds(226, 315, 51, 29);
		getContentPane().add(lblSueldo);
		
		textDni = new JTextField();
		textDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textDni.setColumns(10);
		textDni.setBounds(87, 173, 104, 20);
		getContentPane().add(textDni);
		
		textFecha_n = new JTextField();
		textFecha_n.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFecha_n.setColumns(10);
		textFecha_n.setBounds(364, 173, 104, 20);
		getContentPane().add(textFecha_n);
		
		textDireccion = new JTextField();
		textDireccion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textDireccion.setColumns(10);
		textDireccion.setBounds(122, 225, 301, 20);
		getContentPane().add(textDireccion);
		
		textTelefono = new JTextField();
		textTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textTelefono.setColumns(10);
		textTelefono.setBounds(122, 265, 120, 20);
		getContentPane().add(textTelefono);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setBounds(110, 318, 93, 22);
		getContentPane().add(comboBox);
		comboBox.addItem("Vendedor");
		comboBox.addItem("Administrador");
		comboBox.addItem("Limpieza");
		comboBox.addItem("Gerente");
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ape = textApellidos.getText();
				String nom = textNombres.getText();
				String dni = textDni.getText();
				String fecha = textFecha_n.getText();
				String dir = textDireccion.getText();
				String telf = textTelefono.getText();
				String puesto = (String)comboBox.getSelectedItem();
				int sueldo = Integer.parseInt(textSueldo.getText());
				
				try {
					EmpleadoDAO em=new EmpleadoDAO(ape,nom,dni,fecha,dir,telf,puesto,sueldo);
					em.registro();
					JOptionPane.showMessageDialog(null, "Registro exitoso");
					textApellidos.setText(null);
					textNombres.setText(null);
					textDni.setText(null);
					textFecha_n.setText(null);
					textDireccion.setText(null);
					textTelefono.setText(null);
					comboBox.setSelectedItem(null);
					textSueldo.setText(null);
				}catch (Exception er) {
					JOptionPane.showMessageDialog(null, "Error al registrar");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(122, 400, 104, 29);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textApellidos.setText(null);
				textNombres.setText(null);
				textDni.setText(null);
				textFecha_n.setText(null);
				textDireccion.setText(null);
				textTelefono.setText(null);
				comboBox.setSelectedItem(null);
				textSueldo.setText(null);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(302, 400, 104, 29);
		getContentPane().add(btnNewButton_1);
		
		textSueldo = new JTextField();
		textSueldo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textSueldo.setColumns(10);
		textSueldo.setBounds(279, 321, 77, 20);
		getContentPane().add(textSueldo);
	}
}
