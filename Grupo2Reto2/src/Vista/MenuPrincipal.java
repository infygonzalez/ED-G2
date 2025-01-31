package Vista;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controlador.Controlador;
import Modelo.Alojamiento;
import Modelo.Otros;
import Modelo.Viaje;
import Modelo.Vuelo;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultTableModel modelo;
	private DefaultTableModel modelo1;
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
		setBounds(100, 100, 961, 580);
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
		 modelo.addColumn("Serv no inc.");
		 
		 table = new JTable(modelo);
		 table.setDefaultEditor(Object.class, null);
		 spViajes.setViewportView(table);
		 
		 
			
		 modelo1 = new DefaultTableModel();
		 modelo1.addColumn("Nombre");
		 modelo1.addColumn("Tipo");
		 modelo1.addColumn("Fecha");
		 modelo1.addColumn("Precio");
			
		table_1 = new JTable(modelo1);
		table_1.setDefaultEditor(Object.class, null);
		spEventos.setViewportView(table_1);
		
		lblViajes = new JLabel("Viajes");
		lblViajes.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblViajes.setBounds(289, 43, 85, 48);
		contentPane.add(lblViajes);
		
		lblEventos = new JLabel("Eventos");
		lblViajes.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEventos.setBounds(284, 268, 106, 39);
		contentPane.add(lblEventos);
		
		JButton btnNuevoViaje = new JButton("Nuevo Viaje");
		btnNuevoViaje.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNuevoViaje.setBounds(821, 159, 114, 48);
		contentPane.add(btnNuevoViaje);
		
		JButton btnNuevoEvento = new JButton("Nuevo Evento");
		btnNuevoEvento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNuevoEvento.setBounds(821, 364, 114, 48);
		contentPane.add(btnNuevoEvento);
		
		JLabel lblNombreAgencia = new JLabel("");
		lblNombreAgencia.setBounds(856, 11, 79, 30);
		contentPane.add(lblNombreAgencia);
		
		JLabel lblCerrarSesiopn = new JLabel("Cerrar Sesion");
		lblCerrarSesiopn.setForeground(new Color(255, 0, 0));
		lblCerrarSesiopn.setBounds(856, 43, 79, 14);
		contentPane.add(lblCerrarSesiopn);
			
		rellenarViajes();
		rellenarEventos();
		
		lblCerrarSesiopn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login loginWindow = new Login();
                loginWindow.setVisible(true);
        		dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCerrarSesiopn.setFont(new Font("Tahoma", Font.BOLD, 11));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblCerrarSesiopn.setFont(new Font("Tahoma", Font.PLAIN, 11));
			}
		});
		
	}
	
	
	private void rellenarViajes() {
		 modelo.setRowCount(0);
		 ArrayList<Viaje> viajes = controlador.mostrarViajes();
		 for(Viaje viaje :viajes ) {
			 String[] fila= new String[7];
			 fila[0]= viaje.getNombreViaje();
			 fila[1]= viaje.getDescripcion();
			 fila[2]= viaje.getTipoViaje();
			 fila[3]= viaje.getFechaIda();
			 fila[4]= viaje.getFechaVuelta();
			 fila[5]= viaje.getDuracion();
			 fila[6]= viaje.getDescServicio();
			 System.out.println(viaje.getIdViaje());
			 modelo.addRow(fila);
			 
		 }
	}
		
		 private void rellenarEventos() {
			 modelo1.setRowCount(0);
			 //ArrayList<Vuelo> vuelos = controlador.mostrarVuelos();
			 ArrayList<Alojamiento> alojamientos = controlador.mostrarAlojamientos();
			 ArrayList<Otros> otros = controlador.mostrarOtros();
			 /*for(Vuelo vuelo :vuelos ) {
				 String[] fila= new String[4];
				 fila[0]= vuelo.getNombreEvento();
				 fila[1]= "Vuelo";
				 fila[2]= vuelo.getFecha();
				 fila[3]= vuelo.getPrecio();
				 modelo1.addRow(fila);
			 }*/
			 for(Alojamiento alojamiento :alojamientos ) {
				 String[] fila= new String[4];
				 fila[0]= alojamiento.getNombreEvento();
				 fila[1]= "Alojamiento";
				 fila[2]= alojamiento.getFecha();
				 fila[3]= alojamiento.getPrecio();
				 modelo1.addRow(fila);
			 }
			 for(Otros otro :otros ) {
				 String[] fila= new String[4];
				 fila[0]= otro.getNombreEvento();
				 fila[1]= "Otros";
				 fila[2]= otro.getFecha();
				 fila[3]= otro.getPrecio();
				 modelo1.addRow(fila);
			 }
			 
		 
		 
		 
	 
	}
}
