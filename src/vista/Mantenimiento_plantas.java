package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.border.MatteBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import data.Planta;
import data.PlantaDAO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.JComboBox;

public class Mantenimiento_plantas extends JInternalFrame {
	private JTextField textNombre;
	private JTextField textNombre_c;
	private JTextField textColor;
	private JTextField textLugar;
	private JTable table;
	private JTextField textID;
	int id;
	private JTextField textPrecio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mantenimiento_plantas frame = new Mantenimiento_plantas();
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
	public Mantenimiento_plantas() {
		setTitle("Mantenimiento de plantas");
		PlantaDAO pd=new PlantaDAO();
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setBounds(100, 100, 566, 580);
		getContentPane().setLayout(null);
		
		JLabel lblBsquedaDePlantas = new JLabel("Mantenimiento de plantas");
		lblBsquedaDePlantas.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblBsquedaDePlantas.setBounds(10, 11, 260, 46);
		getContentPane().add(lblBsquedaDePlantas);
		
		JButton btnConsulta = new JButton("Consulta");
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel mm = (DefaultTableModel)table.getModel();
				clear(mm);
				List<Planta> lista=pd.consulta();
				Object[] ob=new Object[7];
				
				for(int i=0;i<lista.size();i++) {
					ob[0]= lista.get(i).getId_planta();
					ob[1]= lista.get(i).getNombre();
					ob[2]= lista.get(i).getNombre_cientifico();
					ob[3]= lista.get(i).getColor();
					ob[4]= lista.get(i).getLugar();
					ob[5]= lista.get(i).getTipo();
					ob[6]= lista.get(i).getPrecio();
					mm.addRow(ob);
					table.setModel(mm);
				}
			}
		});
		btnConsulta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConsulta.setBounds(376, 154, 104, 29);
		getContentPane().add(btnConsulta);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("ID:");
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_2_1.setBounds(33, 285, 26, 17);
		getContentPane().add(lblNewLabel_1_1_2_1);
		
		textID = new JTextField();
		textID.setColumns(10);
		textID.setBounds(61, 285, 63, 20);
		getContentPane().add(textID);
		
		JLabel lblNewLabel_1_1_2_2 = new JLabel("Tipo:");
		lblNewLabel_1_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_2_2.setBounds(40, 236, 91, 17);
		getContentPane().add(lblNewLabel_1_1_2_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.setBounds(93, 234, 85, 22);
		getContentPane().add(comboBox);
		comboBox.addItem("Seleccionar");
		comboBox.addItem("Interior");
		comboBox.addItem("Exterior");
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(40, 68, 65, 14);
		getContentPane().add(lblNewLabel_1);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(164, 68, 151, 20);
		getContentPane().add(textNombre);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre Cient\u00EDfico:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(40, 111, 128, 14);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Color:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(40, 151, 91, 14);
		getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Lugar:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_2.setBounds(40, 190, 91, 17);
		getContentPane().add(lblNewLabel_1_1_2);
		
		textNombre_c = new JTextField();
		textNombre_c.setColumns(10);
		textNombre_c.setBounds(164, 110, 151, 20);
		getContentPane().add(textNombre_c);
		
		textColor = new JTextField();
		textColor.setColumns(10);
		textColor.setBounds(164, 150, 151, 20);
		getContentPane().add(textColor);
		
		textLugar = new JTextField();
		textLugar.setColumns(10);
		textLugar.setBounds(164, 190, 151, 20);
		getContentPane().add(textLugar);
		
		JLabel lblNewLabel_1_1_2_3 = new JLabel("Precio");
		lblNewLabel_1_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_2_3.setBounds(199, 239, 46, 17);
		getContentPane().add(lblNewLabel_1_1_2_3);
		
		textPrecio = new JTextField();
		textPrecio.setColumns(10);
		textPrecio.setBounds(252, 236, 63, 20);
		getContentPane().add(textPrecio);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel mm = (DefaultTableModel)table.getModel();
				id = Integer.parseInt(textID.getText());
				try {
					pd.eliminar(id);
					JOptionPane.showMessageDialog(null, "Registro "+id+" eliminado");
					clear(mm);
					List<Planta> lista=pd.consulta();
					Object[] ob=new Object[7];
					
					for(int i=0;i<lista.size();i++) {
						ob[0]= lista.get(i).getId_planta();
						ob[1]= lista.get(i).getNombre();
						ob[2]= lista.get(i).getNombre_cientifico();
						ob[3]= lista.get(i).getColor();
						ob[4]= lista.get(i).getLugar();
						ob[5]= lista.get(i).getTipo();
						ob[6]= lista.get(i).getPrecio();
						mm.addRow(ob);
						table.setModel(mm);
					}	
				}catch(Exception er) {
					JOptionPane.showMessageDialog(null, "Registro "+id+" no encontrado");
				}
			}
		});
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEliminar.setBounds(376, 66, 104, 29);
		getContentPane().add(btnEliminar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel mm = (DefaultTableModel)table.getModel();
				String nom=textNombre.getText();
				String nom_c=textNombre_c.getText();
				String color=textColor.getText();
				String lugar=textLugar.getText();
				int precio= Integer.parseInt(textPrecio.getText());
				String tipo;
				if (comboBox.getSelectedItem()=="Interior") {
					tipo = "0";
				}
				else{
					tipo = "1";
					}
			
				PlantaDAO pdd=new PlantaDAO(nom,nom_c,color,lugar,tipo,precio);
				pdd.actualizacion(id);	
				clear(mm);
				List<Planta> lista=pd.consulta();
				Object[] ob=new Object[7];
				
				for(int i=0;i<lista.size();i++) {
					ob[0]= lista.get(i).getId_planta();
					ob[1]= lista.get(i).getNombre();
					ob[2]= lista.get(i).getNombre_cientifico();
					ob[3]= lista.get(i).getColor();
					ob[4]= lista.get(i).getLugar();
					ob[5]= lista.get(i).getTipo();
					ob[6]= lista.get(i).getPrecio();
					mm.addRow(ob);
					table.setModel(mm);
				}	
			}
		});
		btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnActualizar.setBounds(376, 109, 104, 29);
		getContentPane().add(btnActualizar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel mm = (DefaultTableModel)table.getModel();
				id = Integer.parseInt(textID.getText());
				try {	
					clear(mm);
					List<Planta> lista=pd.consulta(id);
					Object[] ob=new Object[7];
					
					ob[0]= lista.get(0).getId_planta();
					ob[1]= lista.get(0).getNombre();
					ob[2]= lista.get(0).getNombre_cientifico();
					ob[3]= lista.get(0).getColor();
					ob[4]= lista.get(0).getLugar();
					ob[5]= lista.get(0).getTipo();
					ob[6]= lista.get(0).getPrecio();
					mm.addRow(ob);
					table.setModel(mm);
					
				}catch(Exception er) {
					JOptionPane.showMessageDialog(null, "ID no encontrado");
				}	
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBuscar.setBounds(134, 279, 104, 29);
		getContentPane().add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			}
		});
		scrollPane.setBounds(10, 319, 541, 222);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				
				id = Integer.parseInt(table.getValueAt(row, 0).toString());
				String nom = table.getValueAt(row, 1).toString();
				String nom_c = table.getValueAt(row, 2).toString();
				String color = table.getValueAt(row, 3).toString();
				String lugar = table.getValueAt(row, 4).toString();
				String tipo = table.getValueAt(row, 5).toString();
				String precio = table.getValueAt(row, 6).toString();

				textNombre.setText(nom);
				textNombre_c.setText(nom_c);
				textColor.setText(color);
				textLugar.setText(lugar);
				textPrecio.setText(precio);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				 "ID", "Nombre", "Nombre cientif\u00EDco", "Color", "Lugar", "Tipo","Precio"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textNombre.setText(null);
				textNombre_c.setText(null);
				textColor.setText(null);
				textLugar.setText(null);
				textPrecio.setText(null);
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelar.setBounds(376, 227, 104, 29);
		getContentPane().add(btnCancelar);
		

	}
	void clear(DefaultTableModel mm) {
		for(int i=0;i<mm.getRowCount();i++) {
			mm.removeRow(i);
			i=i-1;
		}
	}
}
