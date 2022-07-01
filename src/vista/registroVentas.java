package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import data.Planta;
import data.PlantaDAO;
import data.VentaDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class registroVentas extends JInternalFrame {
	private JTextField textId_empleado;
	private JTextField textId_planta;
	private JTextField textCantidad;
	private JTextField textSubtotal;
	private JTextField textTotal;
	private JTextField textNombre_planta;
	private JTextField textPrecio;
	private JTextField textComprador;
	private JTextField textDni;
	private JTextField textIgv;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registroVentas frame = new registroVentas();
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
	public registroVentas() {
		setTitle("Registro de ventas");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setBounds(100, 100, 536, 492);
		getContentPane().setLayout(null);
		
		JLabel lblRegistroDeVentas = new JLabel("Registro de ventas");
		lblRegistroDeVentas.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblRegistroDeVentas.setBounds(10, 11, 232, 46);
		getContentPane().add(lblRegistroDeVentas);
		
		JLabel lblCodigoDeEmpleado = new JLabel("C\u00F3digo de empleado:");
		lblCodigoDeEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodigoDeEmpleado.setBounds(20, 68, 135, 29);
		getContentPane().add(lblCodigoDeEmpleado);
		
		JLabel lblCodigoDePlanta = new JLabel("C\u00F3digo de planta:");
		lblCodigoDePlanta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodigoDePlanta.setBounds(287, 68, 109, 29);
		getContentPane().add(lblCodigoDePlanta);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCantidad.setBounds(20, 207, 68, 29);
		getContentPane().add(lblCantidad);
		
		JLabel lblSubtotal = new JLabel("Subtotal");
		lblSubtotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSubtotal.setBounds(20, 253, 51, 29);
		getContentPane().add(lblSubtotal);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTotal.setBounds(20, 293, 51, 29);
		getContentPane().add(lblTotal);
		
		textId_empleado = new JTextField();
		textId_empleado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textId_empleado.setColumns(10);
		textId_empleado.setBounds(165, 74, 104, 20);
		getContentPane().add(textId_empleado);
		
		textId_planta = new JTextField();

		textId_planta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textId_planta.setColumns(10);
		textId_planta.setBounds(406, 72, 98, 20);
		getContentPane().add(textId_planta);
		
		textCantidad = new JTextField();

		textCantidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textCantidad.setColumns(10);
		textCantidad.setBounds(165, 211, 104, 20);
		getContentPane().add(textCantidad);
		
		textSubtotal = new JTextField();
		textSubtotal.setEditable(false);
		textSubtotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textSubtotal.setColumns(10);
		textSubtotal.setBounds(165, 259, 104, 20);
		getContentPane().add(textSubtotal);
		
		textTotal = new JTextField();
		textTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textTotal.setColumns(10);
		textTotal.setBounds(165, 299, 104, 20);
		getContentPane().add(textTotal);
		
		textNombre_planta = new JTextField();
		textNombre_planta.setEditable(false);
		textNombre_planta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textNombre_planta.setColumns(10);
		textNombre_planta.setBounds(312, 106, 192, 20);
		getContentPane().add(textNombre_planta);
		
		textPrecio = new JTextField();
		textPrecio.setEditable(false);
		textPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPrecio.setColumns(10);
		textPrecio.setBounds(347, 211, 104, 20);
		getContentPane().add(textPrecio);
		
		JLabel lblPrecio = new JLabel("DNI:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrecio.setBounds(20, 167, 68, 29);
		getContentPane().add(lblPrecio);
		
		JLabel lblComprador = new JLabel("Comprador:");
		lblComprador.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblComprador.setBounds(20, 127, 81, 29);
		getContentPane().add(lblComprador);
		
		textComprador = new JTextField();
		textComprador.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textComprador.setColumns(10);
		textComprador.setBounds(165, 133, 339, 20);
		getContentPane().add(textComprador);
		
		JLabel lblPrecio_1 = new JLabel("Precio");
		lblPrecio_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrecio_1.setBounds(290, 207, 68, 29);
		getContentPane().add(lblPrecio_1);
		
		textDni = new JTextField();
		textDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textDni.setColumns(10);
		textDni.setBounds(165, 173, 104, 20);
		getContentPane().add(textDni);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				int cod_e = Integer.parseInt(textId_empleado.getText());
				int cod_p = Integer.parseInt(textId_planta.getText());
				String com = textComprador.getText();
				String dni = textDni.getText();
				int cant = Integer.parseInt(textCantidad.getText());
				Double igv = Double.parseDouble(textIgv.getText());
				Double total = Double.parseDouble(textTotal.getText());

				VentaDAO vd=new VentaDAO(cod_e,cod_p,com,dni,cod_p,cant,igv,total);
				vd.registro();
				JOptionPane.showMessageDialog(null, "Venta registrada");
				limpiar();
				}
			catch(Exception er) {
				JOptionPane.showMessageDialog(null, "Error en una celda");
				}
			}
		});
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRegistrar.setBounds(109, 370, 104, 29);
		getContentPane().add(btnRegistrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelar.setBounds(290, 370, 104, 29);
		getContentPane().add(btnCancelar);
		
		JLabel lblIgv = new JLabel("IGV:");
		lblIgv.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIgv.setBounds(287, 253, 51, 29);
		getContentPane().add(lblIgv);
		
		textIgv = new JTextField();
		textIgv.setEditable(false);
		textIgv.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textIgv.setColumns(10);
		textIgv.setBounds(347, 259, 104, 20);
		getContentPane().add(textIgv);
		
		textId_planta.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				int cod_p = Integer.parseInt(textId_planta.getText());
				PlantaDAO pd=new PlantaDAO();
				List<Planta> lista=pd.consulta(cod_p);
				Object[] ob=new Object[2];
				
				ob[0]= lista.get(0).getNombre();
				ob[1]= String.valueOf(lista.get(0).getPrecio());
				
				
				textPrecio.setText((String) ob[1]);
				textNombre_planta.setText((String) ob[0]);
			}
		});
		textCantidad.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				int pre =Integer.parseInt(textPrecio.getText());
				int cant = Integer.parseInt(textCantidad.getText());
				Double igv = pre*cant*0.18;
				textSubtotal.setText(String.valueOf(pre*cant));
				textIgv.setText(Double.toString(Math.round(igv*100.0)/100.0));
				textTotal.setText(Double.toString((pre*cant)+igv));
			}
		});
	
	}
	void limpiar() {
		textId_empleado.setText(null);
		textId_planta.setText(null);
		textNombre_planta.setText(null);
		textComprador.setText(null);
		textDni.setText(null);
		textPrecio.setText(null);
		textCantidad.setText(null);
		textSubtotal.setText(null);
		textTotal.setText(null);
	}
}
