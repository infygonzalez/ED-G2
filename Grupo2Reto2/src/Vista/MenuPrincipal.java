package Vista;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Controlador.Controlador;
import Modelo.Agencia;
import Modelo.Alojamiento;
import Modelo.Otros;
import Modelo.Pais;
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
	private JTable tablaViajes;
	private JScrollPane spEventos;
	private JTable tablaEventos;
	private Controlador controlador=new Controlador();
	private JLabel lblViajes;
	private JLabel lblEventos;
	private JScrollPane spViajes;

	
	public MenuPrincipal(Agencia agencia) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 961, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		spViajes = new JScrollPane();
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
		 modelo.addColumn("Pais");
		 
		 tablaViajes = new JTable(modelo);
		 tablaViajes.setDefaultEditor(Object.class, null);
		 spViajes.setViewportView(tablaViajes);
		 
		
			
		 modelo1 = new DefaultTableModel();
		 modelo1.addColumn("Nombre");
		 modelo1.addColumn("Tipo");
		 modelo1.addColumn("Fecha");
		 modelo1.addColumn("Precio");
		
		tablaEventos = new JTable(modelo1);
		tablaEventos.setDefaultEditor(Object.class, null);
		spEventos.setViewportView(tablaEventos);
		
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
		
		JButton btnEliminarViaje = new JButton("New button");
		btnEliminarViaje.setBounds(538, 68, 89, 23);
		contentPane.add(btnEliminarViaje);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(538, 284, 89, 23);
		contentPane.add(btnNewButton_1);
		
		tablaViajes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			    public void valueChanged(ListSelectionEvent event) {
			    	Viaje viajeSeleccionado = viajeSeleccionado(agencia);
	                if (viajeSeleccionado != null) {
	                    btnEliminarViaje.setVisible(true);
	                    rellenarEventos(viajeSeleccionado);
	                }
	                }
			    });
	            		
		rellenarViajes(agencia);
		
		
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
	
	public Viaje viajeSeleccionado(Agencia agencia) {
        if (tablaViajes.getSelectedRow() != -1) {
            String ViajeIDSeleccionado = tablaViajes.getValueAt(tablaViajes.getSelectedRow(),0).toString();
            ArrayList<Viaje> viajes = agencia.getViajes();
            for (int i = 0; i < viajes.size(); i++) {
                if (viajes.get(i).getIdViaje().equals(ViajeIDSeleccionado)) {
                    return viajes.get(i);
                }
            }
        }
        return null;
    }
	private void rellenarViajes(Agencia agencia) {
		 modelo.setRowCount(0);
		 ArrayList<Pais> paises = controlador.mostrarPais();
		 ArrayList<Viaje> viajes = controlador.mostrarViajes(agencia,paises);
		 for(Viaje viaje :viajes ) {
			 String[] fila= new String[7];
			 fila[0]= viaje.getIdViaje();
			 fila[1]= viaje.getDescripcion();
			 fila[2]= viaje.getTipoViaje();
			 fila[3]= viaje.getFechaIda();
			 fila[4]= viaje.getFechaVuelta();
			 fila[5]= viaje.getDuracion();
			 fila[6]= viaje.getPais().getDescripPais();
			 modelo.addRow(fila); 
		 }
	}
		
		 private void rellenarEventos(Viaje viaje) {
			 modelo1.setRowCount(0);
			 ArrayList<Vuelo> vuelos = viaje.getVuelo();
			 ArrayList<Alojamiento> alojamientos = viaje.getAlojamiento();
			 ArrayList<Otros> otros = viaje.getOtros();
			 for(int i=0;i<vuelos.size();i++) {
				 String[] fila= new String[4];
				 fila[0]= vuelos.get(i).getNombreEvento();
				 fila[1]= "Vuelo";
				 fila[2]= vuelos.get(i).getFecha();
				 fila[3]= vuelos.get(i).getPrecio();
				 modelo1.addRow(fila);
			 }
			 
			 for(int i=0;i<alojamientos.size();i++) {
				 String[] fila= new String[4];
				 fila[0]= alojamientos.get(i).getNombreEvento();
				 fila[1]= "Alojamiento";
				 fila[2]= alojamientos.get(i).getFecha();
				 fila[3]= alojamientos.get(i).getPrecio();
				 modelo1.addRow(fila);
			 }
			 for(int i=0;i<otros.size();i++) {
				 String[] fila= new String[4];
				 fila[0]= otros.get(i).getNombreEvento();
				 fila[1]= "Otros";
				 fila[2]= otros.get(i).getFecha();
				 fila[3]= otros.get(i).getPrecio();
				 modelo1.addRow(fila);
			 }
		 }	 
}

