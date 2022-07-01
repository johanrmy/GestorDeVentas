package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import data.PlantaDAO;

import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class registroPlantas extends JInternalFrame {
	private JTextField textNombre_c;
	private JTextField textNombre;
	private JTextField textColor;
	private JTextField textLugar;
	ButtonGroup grupo=new ButtonGroup();
	private JTextField textPrecio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registroPlantas frame = new registroPlantas();
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
	public registroPlantas() {
		setTitle("Registro de plantas");
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 582, 491);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro de plantas");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(10, 11, 199, 46);
		getContentPane().add(lblNewLabel);
		
		textNombre_c = new JTextField();
		textNombre_c.setBounds(228, 119, 151, 20);
		getContentPane().add(textNombre_c);
		textNombre_c.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setBounds(228, 64, 151, 20);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		textColor = new JTextField();
		textColor.setBounds(228, 174, 151, 20);
		getContentPane().add(textColor);
		textColor.setColumns(10);
		
		textLugar = new JTextField();
		textLugar.setBounds(228, 236, 151, 20);
		getContentPane().add(textLugar);
		textLugar.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(78, 67, 65, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre Cient\u00EDfico:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(78, 122, 128, 14);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Color:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(78, 175, 91, 14);
		getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Lugar:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_2.setBounds(78, 236, 91, 17);
		getContentPane().add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Tipo:");
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_3.setBounds(78, 293, 91, 17);
		getContentPane().add(lblNewLabel_1_1_3);
		
		JRadioButton rdbtnInterior = new JRadioButton("Interior");
		rdbtnInterior.setBounds(228, 292, 109, 23);
		getContentPane().add(rdbtnInterior);
		
		JRadioButton rdbtnExterior = new JRadioButton("Exterior");
		rdbtnExterior.setBounds(341, 292, 109, 23);
		getContentPane().add(rdbtnExterior);
		
		grupo.add(rdbtnExterior);
		grupo.add(rdbtnInterior);
		
		JLabel lblNewLabel_1_1_3_1 = new JLabel("Precio:");
		lblNewLabel_1_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_3_1.setBounds(78, 339, 91, 17);
		getContentPane().add(lblNewLabel_1_1_3_1);
		
		textPrecio = new JTextField();
		textPrecio.setColumns(10);
		textPrecio.setBounds(228, 339, 151, 20);
		getContentPane().add(textPrecio);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom=textNombre.getText();
				String nom_c=textNombre_c.getText();
				String color=textColor.getText();
				String lugar=textLugar.getText();
				String tipo = null;
				int precio = Integer.parseInt(textPrecio.getText());
				if (rdbtnExterior.isSelected()) {
					tipo="1";
				}else if(rdbtnInterior.isSelected()) {
					tipo="0";
				}
				try {
					PlantaDAO pd=new PlantaDAO(nom,nom_c,color,lugar,tipo,precio);
					pd.registro();
					JOptionPane.showMessageDialog(null, "Registro exitoso");
					textNombre.setText(null);
					textNombre_c.setText(null);
					textColor.setText(null);
					textLugar.setText(null);
					textPrecio.setText(null);
					grupo.clearSelection();

				}catch(Exception error){
					JOptionPane.showMessageDialog(null, "Error al registrar");
				}

			}
		});
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegistrar.setBounds(172, 401, 89, 31);
		getContentPane().add(btnRegistrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textNombre.setText(null);
				textNombre_c.setText(null);
				textColor.setText(null);
				textLugar.setText(null);
				grupo.clearSelection();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(325, 401, 89, 31);
		getContentPane().add(btnCancelar);
		

	}
}
