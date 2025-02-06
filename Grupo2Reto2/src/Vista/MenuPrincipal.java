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
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private JButton btnGenerarOferta;
	private JButton btnEliminarViaje;
	private JButton btnEliminarEvento;
	private JButton btnNuevoEvento;
	

	
	public MenuPrincipal(Agencia agencia) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 961, 617);
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
		btnNuevoViaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 dispose();
					nuevoViaje nuevoViaje = new nuevoViaje(agencia);
					 nuevoViaje.setVisible(true);
			}
		});
		btnNuevoViaje.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNuevoViaje.setBounds(821, 159, 114, 48);
		contentPane.add(btnNuevoViaje);
		
		btnNuevoEvento = new JButton("Nuevo Evento");
		btnNuevoEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				nuevoEvento nuevoEvento = new nuevoEvento(agencia);
				nuevoEvento.setVisible(true);
				
			}
		});
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
		
		btnEliminarViaje = new JButton("Eliminar Viaje");
		btnEliminarViaje.setBounds(503, 61, 130, 30);
		contentPane.add(btnEliminarViaje);
    	btnEliminarViaje.setVisible(false);
    	spEventos.setVisible(false);
    	tablaEventos.setVisible(false);
    	lblEventos.setVisible(false);
    	btnNuevoEvento.setVisible(false);
    	
		
		btnEliminarEvento = new JButton("Eliminar Evento");
		btnEliminarEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrarEvento(agencia);
			}
		});
		btnEliminarEvento.setBounds(503, 277, 132, 30);
		contentPane.add(btnEliminarEvento);
		btnEliminarEvento.setVisible(false);
		
		btnGenerarOferta = new JButton("GenerarOferta");
		btnGenerarOferta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGenerarOferta.setBounds(10, 514, 255, 53);
		contentPane.add(btnGenerarOferta);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(10, 11, 106, 80);
		contentPane.add(lblLogo);
		
		/*String logoUrl = agencia.getLogo();
        URL imgUrl = null;
        try {
            imgUrl = new URL(logoUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        ImageIcon image = new ImageIcon(imgUrl);
        Image img = image.getImage();  
        Image resizedImg = img.getScaledInstance(163, 149, Image.SCALE_SMOOTH);  

        lblLogo = new JLabel(new ImageIcon(resizedImg));  
        lblLogo.setBounds(10, 142, 163, 149);  
        contentPane.add(lblLogo);

        contentPane.revalidate();  
        contentPane.repaint();  */  
		
		tablaViajes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			    public void valueChanged(ListSelectionEvent event) {
			    	Viaje viajeSeleccionado = viajeSeleccionado(agencia);
	                if (viajeSeleccionado != null) {
	                	btnEliminarViaje.setVisible(true);
	                	spEventos.setVisible(true);
	                	tablaEventos.setVisible(true);
	                	lblEventos.setVisible(true);
	                	btnNuevoEvento.setVisible(true);
	                    rellenarEventos(viajeSeleccionado);
	                }
	                }
			    });
		tablaEventos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    public void valueChanged(ListSelectionEvent event) {
		    	Viaje viajeSeleccionado = viajeSeleccionado(agencia);
                if (viajeSeleccionado != null) {
                	btnEliminarEvento.setVisible(true);
                    
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
		
		btnEliminarViaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrarViaje(agencia);
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
	public void rellenarViajes(Agencia agencia) {
		 modelo.setRowCount(0);
		 ArrayList<Pais> paises = controlador.mostrarPais();
		 ArrayList<Viaje> viajes = controlador.mostrarViajes(agencia,paises);
		 agencia.setViajes(viajes);
		 for(Viaje viaje :viajes ) {
			 String[] fila= new String[7];
			 viaje.setAlojamiento(controlador.mostrarAlojamientos(viaje));
			 viaje.setVuelo(controlador.mostrarVuelos(viaje));
			 viaje.setOtros(controlador.mostrarOtros(viaje));
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
				 fila[0]= vuelos.get(i).getIdEvento();
				 fila[1]= "Vuelo";
				 fila[2]= vuelos.get(i).getFecha();
				 fila[3]= vuelos.get(i).getPrecio();
				 modelo1.addRow(fila);
			 }
			 
			 for(int i=0;i<alojamientos.size();i++) {
				 String[] fila= new String[4];
				 fila[0]= alojamientos.get(i).getIdEvento();
				 fila[1]= "Alojamiento";
				 fila[2]= alojamientos.get(i).getFecha();
				 fila[3]= alojamientos.get(i).getPrecio();
				 modelo1.addRow(fila);
			 }
			 for(int i=0;i<otros.size();i++) {
				 String[] fila= new String[4];
				 fila[0]= otros.get(i).getIdEvento();
				 fila[1]= "Otros";
				 fila[2]= otros.get(i).getFecha();
				 fila[3]= otros.get(i).getPrecio();
				 modelo1.addRow(fila);
			 }
		 }
		 
		 
		 public void borrarViaje(Agencia agencia ) {
			 if(controlador.borrarViaje(viajeSeleccionado(agencia))==true) {
				 JOptionPane.showMessageDialog(null, "Eliminado", agencia.getNombre(),JOptionPane.INFORMATION_MESSAGE);
				 rellenarViajes(agencia);
				 modelo1.setRowCount(0);
				 btnEliminarViaje.setVisible(false);
				 btnEliminarEvento.setVisible(false);
				 
			 }
		 }
		 
		 public void borrarEvento(Agencia agencia) {
			 boolean valido = false;
			 if(tablaEventos.getSelectedRow()!=-1 ) {
				 String eventoSeleccionadoId = tablaEventos.getValueAt(tablaEventos.getSelectedRow(), 0).toString();
			 
				 if(tablaEventos.getSelectedRow()!=-1 ) {
						String eventoSeleccionadoTipo = tablaEventos.getValueAt(tablaEventos.getSelectedRow(), 1).toString();
					 if(eventoSeleccionadoTipo=="Vuelo") {
					 ArrayList<Vuelo> vuelos= viajeSeleccionado(agencia).getVuelo();
						for(int i =0;i<vuelos.size();i++) {
							
							if(vuelos.get(i).getIdEvento().equals(eventoSeleccionadoId)) {
								valido=controlador.eliminarVuelo(vuelos.get(i));
							}
						}
				 }
					 else if(eventoSeleccionadoTipo=="Alojamiento") {
						 ArrayList<Alojamiento> alojamientos= viajeSeleccionado(agencia).getAlojamiento();
							for(int i =0;i<alojamientos.size();i++) {
								
								if(alojamientos.get(i).getIdEvento().equals(eventoSeleccionadoId)) {
									valido=controlador.eliminarAlojamiento(alojamientos.get(i));
								}
							}
					 }
					 else if(eventoSeleccionadoTipo=="Otros") {
						 ArrayList<Otros> otros= viajeSeleccionado(agencia).getOtros();
							for(int i =0;i<otros.size();i++) {
								
								if(otros.get(i).getIdEvento().equals(eventoSeleccionadoId)) {
									valido=controlador.eliminarOtros(otros.get(i));
								}
							}
					 }
					 
	 
			 }
				 if(valido==true) {
					 JOptionPane.showMessageDialog(null, "Eliminado", agencia.getNombre(),JOptionPane.INFORMATION_MESSAGE);
					 rellenarViajes(agencia);
					 modelo1.setRowCount(0);
					 btnEliminarViaje.setVisible(false);
					 btnEliminarEvento.setVisible(false);
				 }
			 }
	 }
 }
