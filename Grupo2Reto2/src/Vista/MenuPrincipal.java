package Vista;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controlador.Controlador;
import Modelo.Viaje;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;

public class MenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultTableModel modelo;
	private JTable table;
	private JScrollPane spEventos;
	private JTable table_1;
	private Controlador controlador=new Controlador();
	private JLabel lblViajes;
	private JLabel lblEventos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane spViajes = new JScrollPane();
		spViajes.setBounds(10, 102, 625, 155);
		contentPane.add(spViajes);
		
		
		
		spEventos = new JScrollPane();
		spEventos.setBounds(10, 318, 625, 155);
		contentPane.add(spEventos);
		
		
		 modelo = new DefaultTableModel();
		 modelo.addColumn("Nombre");;
		 modelo.addColumn("Descripcion");
		 modelo.addColumn("Tipo");
		 modelo.addColumn("Fecha ida");
		 modelo.addColumn("Fecha vuelta");
		 modelo.addColumn("Duracion");
		 modelo.addColumn("Servicios no incluidos");
		 
		 table = new JTable(modelo);
		spViajes.setViewportView(table);
		 
		 
			
			
			
			table_1 = new JTable();
		spEventos.setViewportView(table_1);
		
		lblViajes = new JLabel("Viajes");
		lblViajes.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblViajes.setBounds(289, 43, 85, 48);
		contentPane.add(lblViajes);
		
		lblEventos = new JLabel("Eventos");
		lblEventos.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEventos.setBounds(284, 268, 106, 39);
		contentPane.add(lblEventos);
			
	}
	
	
	private void rellenarViajes() {
		 Viaje viaje = new Viaje(); 
		 modelo.setRowCount(0);
		 ArrayList<Viaje> viajes = controlador.mostrarViajes();
		 for(Viaje viaje1 :viajes ) {
			 String[] fila= new String[7];
			 fila[0]= viaje1.getNombreViaje();
			 fila[1]= viaje1.getDescripcion();
			 fila[2]= viaje1.getTipoViaje();
			 fila[3]= viaje1.getFechaIda();
			 fila[4]= viaje1.getFechaVuelta();
			 fila[5]= viaje1.getDuracion();
			 fila[6]= viaje1.getDescServicio();
			 
			 modelo.addRow(fila);
			 
		 }
		 
		 
		 
	 }
}
