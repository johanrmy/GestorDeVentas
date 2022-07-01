package vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import java.awt.GridLayout;
import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.Color;

public class MainApp extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	private registroPlantas p=new registroPlantas();
	private registroEmpleados em=new registroEmpleados();
	private registroVentas vm=new registroVentas();
	private Mantenimiento_plantas bp=new Mantenimiento_plantas();
	private Mantenimiento_empleados be=new Mantenimiento_empleados();
	private Mantenimiento_ventas bv=new Mantenimiento_ventas();
	private reporte_general rg=new reporte_general();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp frame = new MainApp();
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
	public MainApp() {

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1069, 849);
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Registro");
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Registro de plantas");
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.setVisible(true);
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon("C:\\Users\\Johan\\eclipseWorkspace\\ProyectoFinal\\src\\icons\\planta.png"));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Registro de empleados");
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				em.setVisible(true);
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon("C:\\Users\\Johan\\eclipseWorkspace\\ProyectoFinal\\src\\icons\\empleado.png"));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Registro de ventas");
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vm.setVisible(true);
			}
		});
		mntmNewMenuItem_2.setIcon(new ImageIcon("C:\\Users\\Johan\\eclipseWorkspace\\ProyectoFinal\\src\\icons\\venta.png"));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("Mantenimiento");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Mantenimiento de plantas");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bp.setVisible(true);
			}
		});
		mntmNewMenuItem_3.setIcon(new ImageIcon("C:\\Users\\Johan\\eclipseWorkspace\\ProyectoFinal\\src\\icons\\busqueda_plantas.png"));
		mntmNewMenuItem_3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Mantenimiento de empleados");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				be.setVisible(true);
			}
		});
		mntmNewMenuItem_4.setIcon(new ImageIcon("C:\\Users\\Johan\\eclipseWorkspace\\ProyectoFinal\\src\\icons\\busqueda_empleados.png"));
		mntmNewMenuItem_4.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Mantenimiento de ventas");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bv.setVisible(true);
			}
		});
		mntmNewMenuItem_5.setIcon(new ImageIcon("C:\\Users\\Johan\\eclipseWorkspace\\ProyectoFinal\\src\\icons\\busqueda_ventas.png"));
		mntmNewMenuItem_5.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_2 = new JMenu("Reportes");
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Reporte general");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rg.setVisible(true);
			}
		});
		mntmNewMenuItem_8.setIcon(new ImageIcon("C:\\Users\\Johan\\eclipseWorkspace\\ProyectoFinal\\src\\icons\\reporte.png"));
		mnNewMenu_2.add(mntmNewMenuItem_8);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JDesktopPane ventanaMain = new JDesktopPane();
		ventanaMain.setBackground(new Color(46, 139, 87));
		contentPane.add(ventanaMain);
		ventanaMain.setLayout(null);
		p.setLocation(0, 11);
		ventanaMain.add(p);
		em.setLocation(221, 11);
		ventanaMain.add(em);
		vm.setLocation(89, 11);
		ventanaMain.add(vm);
		ventanaMain.add(bp);
		ventanaMain.add(be);
		ventanaMain.add(bv);
		ventanaMain.add(rg);

		

	}
}
