package Vista;

import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.toedter.calendar.JCalendar;

import Modelo.Aerolinea;
import Modelo.Aeropuerto;
import Modelo.Agencia;
import Modelo.Alojamiento;
import Modelo.Gestor;
import Modelo.Otros;
import Modelo.Pais;
import Modelo.Viaje;
import Modelo.Vuelo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import com.toedter.components.JLocaleChooser;

import Controlador.Controlador;

import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;

public class nuevoEvento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombreEvento;
	private JTextField txtCodigoVuelo;
	private JTextField txtPrecio;
	private JTextField txtHorario;
	private JTextField txtDuracion;
	private JTextField txtCodigoVueloV;
	private JTextField txtHorarioV;
	private JTextField txtDuracionV;
	private JTextField txtCiudad;
	private JTextField txtPrecioAlo;
	private JTextField txtDescripcionOtros;
	private JTextField txtPrecioOtros;
	private JComboBox cbTipoEvento;
	private JComboBox cbAropuertoO;
	private JComboBox cbAeropuertoD;
	private JPanel vuelo_1;
	private JComboBox cbTrayecto;
	private JDateChooser dcVuelo;
	private JDateChooser dcVueloVuelta;
	private JDateChooser dcFechaAlojamiento;
	private JComboBox cbTipoHabitacion;
	private JDateChooser dcFechaOtros;
	private JComboBox cbAerolineaV_1;
	private JComboBox cbAerolinea;
	private Controlador controlador = new Controlador();
	private JDateChooser dcFechaAlojamientoSalida;


	/**
	 * Create the frame.
	 */
	public nuevoEvento(Agencia agencia,Viaje viaje) {
			
			
		
		   JCalendar calendar = new JCalendar();
           int año = calendar.getCalendar().get(Calendar.YEAR);
           int mes = calendar.getCalendar().get(Calendar.MONTH);
           int dia = calendar.getCalendar().get(Calendar.DAY_OF_MONTH);
           String fecha = dia+"-"+mes+"-"+año;

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 696);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel vuelo = new JPanel();
		vuelo.setBounds(0, 132, 766, 411);
		contentPane.add(vuelo);
		vuelo.setLayout(null);
		
		
		
			
		
		
		JPanel Alojamiento = new JPanel();
		Alojamiento.setBounds(0, 147, 776, 432);
		contentPane.add(Alojamiento);
		Alojamiento.setLayout(null);
		
		
		JLabel lblNombreEvento = new JLabel("Nombre del evento");
		lblNombreEvento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombreEvento.setBounds(61, 40, 118, 28);
		contentPane.add(lblNombreEvento);
		
		txtNombreEvento = new JTextField();
		txtNombreEvento.setBounds(223, 45, 118, 20);
		contentPane.add(txtNombreEvento);
		txtNombreEvento.setColumns(10);
		
		JLabel lblTipoEvento = new JLabel("Tipo del evento");
		lblTipoEvento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTipoEvento.setBounds(61, 94, 118, 28);
		contentPane.add(lblTipoEvento);
		
		cbTipoEvento = new JComboBox();
		cbTipoEvento.setModel(new DefaultComboBoxModel(new String[] {"", "Vuelo", "Alojamiento", "Otros"}));
		cbTipoEvento.setBounds(223, 98, 118, 22);
		contentPane.add(cbTipoEvento);
		
		JPanel otros = new JPanel();
		otros.setBounds(0, 133, 776, 443);
		contentPane.add(otros);
		otros.setLayout(null);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGuardar.setBounds(252, 624, 89, 23);
		contentPane.add(btnGuardar);
		

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal menuPrincipal = new MenuPrincipal(agencia);
				 menuPrincipal.setVisible(true);
				 dispose();
				
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCancelar.setBounds(421, 624, 89, 23);
		contentPane.add(btnCancelar);
		
		cbTipoEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(cbTipoEvento.getSelectedItem().equals("Vuelo")) {
					 verVuelo(vuelo);
					 vuelo.setVisible(true);
					
				}else {
					vuelo.setVisible(false);
				}
				
				if("Alojamiento".equals(cbTipoEvento.getSelectedItem())) {
					 verAlojamiento(Alojamiento);
					 Alojamiento.setVisible(true);
				}
				else {
					Alojamiento.setVisible(false);
				}
				if(cbTipoEvento.getSelectedItem().equals("Otros")) {
					 verOtros(otros);
					 otros.setVisible(true);
					
				}else {
					otros.setVisible(false);
				}

				
			}
		});
		
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validarEvento(viaje,agencia);
				
			}
		});
		
		
	}
	
	public void verAlojamiento(JPanel Alojamiento) {
		
		JLabel lblTipoHabitacion = new JLabel("Tipo Habitacion");
		lblTipoHabitacion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTipoHabitacion.setBounds(60, 25, 118, 28);
		Alojamiento.add(lblTipoHabitacion);
		
		cbTipoHabitacion = new JComboBox();
		cbTipoHabitacion.setModel(new DefaultComboBoxModel(new String[] {"", "DB", "DUI", "SIN", "TPL"}));
		cbTipoHabitacion.setBounds(224, 29, 118, 22);
		Alojamiento.add(cbTipoHabitacion);
		
		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCiudad.setBounds(60, 64, 118, 28);
		Alojamiento.add(lblCiudad);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrecio.setBounds(60, 103, 118, 28);
		Alojamiento.add(lblPrecio);
		
		JLabel lblFechaEntrada = new JLabel("Fecha de entrada");
		lblFechaEntrada.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFechaEntrada.setBounds(60, 142, 118, 28);
		Alojamiento.add(lblFechaEntrada);
		
		txtCiudad = new JTextField();
		txtCiudad.setColumns(10);
		txtCiudad.setBounds(224, 69, 118, 20);
		Alojamiento.add(txtCiudad);
		
		txtPrecioAlo = new JTextField();
		txtPrecioAlo.setColumns(10);
		txtPrecioAlo.setBounds(224, 103, 118, 20);
		Alojamiento.add(txtPrecioAlo);
		
		JButton btnBuscarAlojamiento = new JButton("Buscar alojamiento");
		btnBuscarAlojamiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
                    Desktop desktop = Desktop.getDesktop();
                    desktop.browse(new URI("https://www.booking.com/"));
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al abrir el enlace", "Error", JOptionPane.ERROR_MESSAGE);
                }
				
			}
		});
		btnBuscarAlojamiento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBuscarAlojamiento.setBounds(463, 28, 285, 43);
		Alojamiento.add(btnBuscarAlojamiento);
		
		dcFechaAlojamiento = new JDateChooser();
		dcFechaAlojamiento.setBounds(224, 142, 118, 20);
		Alojamiento.add(dcFechaAlojamiento);
		

		JLabel lblFechaSalida = new JLabel("Fecha de entrada");
		lblFechaSalida.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFechaSalida.setBounds(60, 181, 118, 28);
		Alojamiento.add(lblFechaSalida);
		
		dcFechaAlojamientoSalida = new JDateChooser();
		dcFechaAlojamientoSalida.setBounds(224, 181, 118, 20);
		Alojamiento.add(dcFechaAlojamientoSalida);
	
		
		
	}
	
	public void verVuelo(JPanel vuelo) {
		
		JLabel lblTrayecto = new JLabel("Trayecto");
		lblTrayecto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTrayecto.setBounds(61, 11, 118, 28);
		vuelo.add(lblTrayecto);
		
		JLabel lblAeropuertoO = new JLabel("Aeropuerto Origen");
		lblAeropuertoO.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAeropuertoO.setBounds(61, 59, 118, 28);
		vuelo.add(lblAeropuertoO);
		
		JLabel lblAeropuertoD = new JLabel("Aeropuerto Destino");
		lblAeropuertoD.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAeropuertoD.setBounds(61, 110, 118, 28);
		vuelo.add(lblAeropuertoD);
		
		JLabel lblFechaIda = new JLabel("Fecha ida");
		lblFechaIda.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFechaIda.setBounds(61, 161, 118, 28);
		vuelo.add(lblFechaIda);
		
		JLabel lblCodigoVuelo = new JLabel("CodigoVuelo");
		lblCodigoVuelo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodigoVuelo.setBounds(61, 200, 118, 28);
		vuelo.add(lblCodigoVuelo);
		
		JLabel lblAerolinea = new JLabel("Aerolinea");
		lblAerolinea.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAerolinea.setBounds(61, 239, 118, 28);
		vuelo.add(lblAerolinea);
		
		cbTrayecto = new JComboBox();
		
		cbTrayecto.setModel(new DefaultComboBoxModel(new String[] {"", "Ida", "Ida y vuelta"}));
		cbTrayecto.setBounds(225, 15, 118, 22);
		vuelo.add(cbTrayecto);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrecio.setBounds(61, 278, 118, 28);
		vuelo.add(lblPrecio);
		
		JLabel lblHorario = new JLabel("Horario salida");
		lblHorario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHorario.setBounds(61, 317, 118, 28);
		vuelo.add(lblHorario);
		
		JLabel lblDuracion = new JLabel("Duracion");
		lblDuracion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDuracion.setBounds(61, 356, 118, 28);
		vuelo.add(lblDuracion);
		
		cbAropuertoO = new JComboBox();
		cbAropuertoO.setModel(new DefaultComboBoxModel(new String[] {"",}));
		cbAropuertoO.setBounds(225, 63, 118, 22);
		vuelo.add(cbAropuertoO);
		rellenarAeropuerto(cbAropuertoO);
		
		cbAeropuertoD = new JComboBox();
		cbAeropuertoD.setModel(new DefaultComboBoxModel(new String[] {"",}));
		cbAeropuertoD.setBounds(225, 114, 118, 22);
		vuelo.add(cbAeropuertoD);
		rellenarAeropuerto(cbAeropuertoD);
		
		txtCodigoVuelo = new JTextField();
		txtCodigoVuelo.setColumns(10);
		txtCodigoVuelo.setBounds(225, 205, 118, 20);
		vuelo.add(txtCodigoVuelo);
		
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(225, 283, 118, 20);
		vuelo.add(txtPrecio);
		
		txtHorario = new JTextField();
		txtHorario.setColumns(10);
		txtHorario.setBounds(225, 322, 118, 20);
		vuelo.add(txtHorario);
		
		txtDuracion = new JTextField();
		txtDuracion.setColumns(10);
		txtDuracion.setBounds(225, 361, 118, 20);
		vuelo.add(txtDuracion);
		
		cbAerolinea = new JComboBox();
		cbAerolinea.setModel(new DefaultComboBoxModel(new String[] {"",}));
		cbAerolinea.setBounds(225, 245, 118, 22);
		vuelo.add(cbAerolinea);
		rellenarAerolinea(cbAerolinea);
		
		JButton btnBuscarViaje = new JButton("BuscarViaje");
		btnBuscarViaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
                Desktop desktop = Desktop.getDesktop();
                desktop.browse(new URI("https://www.skyscanner.es/"));
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al abrir el enlace", "Error", JOptionPane.ERROR_MESSAGE);
            }
        
				
			}
		});
		btnBuscarViaje.setBounds(397, 41, 222, 46);
		vuelo.add(btnBuscarViaje);
		
		
		JLabel lblFechaVuelta = new JLabel("Fecha ida");
		lblFechaVuelta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFechaVuelta.setBounds(397, 161, 118, 28);
		vuelo.add(lblFechaVuelta);
		
		
		JLabel lblCodigoVueloV = new JLabel("CodigoVuelo");
		lblCodigoVueloV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodigoVueloV.setBounds(397, 200, 118, 28);
		vuelo.add(lblCodigoVueloV);
		
		JLabel lblAerolineaV = new JLabel("Aerolinea");
		lblAerolineaV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAerolineaV.setBounds(397, 239, 118, 28);
		vuelo.add(lblAerolineaV);
		
		
		JLabel lblHorarioV = new JLabel("Horario salida");
		lblHorarioV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHorarioV.setBounds(397, 317, 118, 28);
		vuelo.add(lblHorarioV);
		
		
		JLabel lblDuracionV = new JLabel("Duracion");
		lblDuracionV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDuracionV.setBounds(397, 356, 118, 28);
		vuelo.add(lblDuracionV);
		
		txtCodigoVueloV = new JTextField();
		txtCodigoVueloV.setColumns(10);
		txtCodigoVueloV.setBounds(576, 205, 118, 20);
		vuelo.add(txtCodigoVueloV);
		
		
		cbAerolineaV_1 = new JComboBox();
		cbAerolineaV_1.setBounds(576, 243, 118, 22);
		vuelo.add(cbAerolineaV_1);
		rellenarAerolinea(cbAerolineaV_1);
		
		txtHorarioV = new JTextField();
		txtHorarioV.setColumns(10);
		txtHorarioV.setBounds(576, 322, 118, 20);
		vuelo.add(txtHorarioV);
		
		
		txtDuracionV = new JTextField();
		txtDuracionV.setColumns(10);
		txtDuracionV.setBounds(576, 361, 118, 20);
		vuelo.add(txtDuracionV);
		
		
		dcVuelo = new JDateChooser();
		dcVuelo.setBounds(225, 161, 118, 20);
		vuelo.add(dcVuelo);
		
		dcVueloVuelta = new JDateChooser();
		dcVueloVuelta.setBounds(576, 161, 118, 20);
		vuelo.add(dcVueloVuelta);
		lblFechaVuelta.setVisible(false);
		lblCodigoVueloV.setVisible(false);
		lblAerolineaV.setVisible(false);
		lblDuracionV.setVisible(false);
		lblHorarioV.setVisible(false);
		txtCodigoVueloV.setVisible(false);
		txtDuracionV.setVisible(false);
		txtCodigoVueloV.setVisible(false);
		txtHorarioV.setVisible(false);
		cbAerolineaV_1.setVisible(false);
		dcVueloVuelta.setVisible(false);
		cbTrayecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbTrayecto.getSelectedItem().equals("Ida y vuelta")) {
					lblFechaVuelta.setVisible(true);
					lblCodigoVueloV.setVisible(true);
					lblAerolineaV.setVisible(true);
					lblDuracionV.setVisible(true);
					lblHorarioV.setVisible(true);
					txtCodigoVueloV.setVisible(true);
					txtDuracionV.setVisible(true);
					txtHorarioV.setVisible(true);
					cbAerolineaV_1.setVisible(true);
					dcVueloVuelta.setVisible(true);
					
				}
				else {
					lblFechaVuelta.setVisible(false);
					lblCodigoVueloV.setVisible(false);
					lblAerolineaV.setVisible(false);
					lblDuracionV.setVisible(false);
					lblHorarioV.setVisible(false);
					txtCodigoVueloV.setVisible(false);
					txtDuracionV.setVisible(false);
					txtCodigoVueloV.setVisible(false);
					txtHorarioV.setVisible(false);
					cbAerolineaV_1.setVisible(false);
					dcVueloVuelta.setVisible(false);
				}
				
			}
		});
		
	}
	
	public void verOtros(JPanel otros) {
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		 lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 lblDescripcion.setBounds(61, 32, 118, 28);
		 otros.add(lblDescripcion);
		 
		 txtDescripcionOtros = new JTextField();
		 txtDescripcionOtros.setColumns(10);
		 txtDescripcionOtros.setBounds(224, 37, 223, 89);
		 otros.add(txtDescripcionOtros);
		 
		 JLabel lblPrecio = new JLabel("Precio");
		 lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 lblPrecio.setBounds(61, 141, 118, 28);
		 otros.add(lblPrecio);
		 
		 txtPrecioOtros = new JTextField();
		 txtPrecioOtros.setColumns(10);
		 txtPrecioOtros.setBounds(224, 146, 118, 20);
		 otros.add(txtPrecioOtros);
		 
		 JLabel lblFecha = new JLabel("Fecha");
		 lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 lblFecha.setBounds(61, 193, 118, 28);
		 otros.add(lblFecha);
		 
		 dcFechaOtros = new JDateChooser();
		 dcFechaOtros.setBounds(224, 201, 118, 20);
		 otros.add(dcFechaOtros);
}
	
	
	
	public boolean validarEvento(Viaje viaje,Agencia agencia) {
		boolean valido = true;
		  if (txtNombreEvento.getText().length() < 1 || txtNombreEvento.getText().length() > 255  == true) {
	            JOptionPane.showMessageDialog(null, "El nombre del evento no puede estar vacío","ERROR", JOptionPane.ERROR_MESSAGE);
	            valido = false;
	        }
	        if (cbTipoEvento.getSelectedItem() == "") {
	            JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de evento","ERROR", JOptionPane.ERROR_MESSAGE);
	            valido = false;
	        }
	        
	        if(valido==true) {
	        	if(cbTipoEvento.getSelectedItem().equals("Vuelo")) {
	        		Vuelo vueloida=validarVuelo(viaje,agencia);
	        		if(cbTrayecto.getSelectedItem().equals("Ida y vuelta")) {
	        			validarVueloV(viaje,vueloida);
					}
	        	}
	        	
	        	else if(cbTipoEvento.getSelectedItem().equals("Alojamiento")) {
	        		validarAlojamiento(viaje, agencia);
	        	}
	        	
	        	else if(cbTipoEvento.getSelectedItem().equals("Otros")) {
	        		validarOtros(viaje, agencia);
	        	}
	        	
	        }
	        
		
	return valido;	
	}
	
	public Vuelo validarVuelo(Viaje viaje, Agencia agencia) {
		boolean valido = true;
		Vuelo vuelo = new Vuelo();
		String fechaVuelo;
		ArrayList<Aerolinea>aerolineas = controlador.mostrarAerolineas();
		ArrayList<Aeropuerto>aeropuertos = controlador.mostrarAeropuertos();
	
		if (cbTrayecto.getSelectedItem() == "" ) {
		    JOptionPane.showMessageDialog(this, "Seleccione el tipo trayecto", "Error", JOptionPane.ERROR_MESSAGE);
		    valido = false;
		}
		if(cbAropuertoO.getSelectedItem() == "" ) {
			JOptionPane.showMessageDialog(this, "Seleccione el aropuerto de origen", "Error", JOptionPane.ERROR_MESSAGE);
		    valido = false;
		}
		if(cbAeropuertoD.getSelectedItem() == "" ) {
			JOptionPane.showMessageDialog(this, "Seleccione el aeropuerto de destino", "Error", JOptionPane.ERROR_MESSAGE);
		    valido = false;
		}
		  if(cbAropuertoO.getSelectedItem() == cbAeropuertoD.getSelectedItem() ) {
				JOptionPane.showMessageDialog(this, "Selecciona aeropuertos diferentes", "Error", JOptionPane.ERROR_MESSAGE);
			    valido = false;
			}
		if(cbAerolinea.getSelectedItem()=="") {
			JOptionPane.showMessageDialog(this, "Seleccione la aerolinea", "Error", JOptionPane.ERROR_MESSAGE);
		    valido = false;
		}
		
		if(txtCodigoVuelo.getText().length() < 1 && txtCodigoVuelo.getText().length()<25  == true) {
			JOptionPane.showMessageDialog(this, "Codigo de vuelo no valido", "Error", JOptionPane.ERROR_MESSAGE);
		    valido = false;
		}
		
		if(txtDuracion.getText().length() < 1 ) {
			JOptionPane.showMessageDialog(this, "Duracion incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
		    valido = false;
		}

		if(txtHorario.getText().length() < 1 || txtHorario.getText().length()>255  == true) {
			JOptionPane.showMessageDialog(this, "Introduce un horario de salida", "Error", JOptionPane.ERROR_MESSAGE);
		    valido = false;
		}
		
		if(txtPrecio.getText()=="" ) {
			JOptionPane.showMessageDialog(this, "Introduce el precio", "Error", JOptionPane.ERROR_MESSAGE);
		    valido = false;
		}
		
		if (dcVuelo == null) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar la fecha del vuelo.", "ERROR", JOptionPane.ERROR_MESSAGE);
            valido=false;
        }
		
		if(valido==true) {
			fechaVuelo=convertirFechaADatabaseFormat(dcVuelo.getDate());
			vuelo.setCodigoVuelo(txtCodigoVuelo.getText());
			vuelo.setPrecio(txtPrecio.getText());
			vuelo.setFecha(fechaVuelo);
			vuelo.setHora(txtHorario.getText());
			vuelo.setDuracion(txtDuracion.getText());
			
			
			
			for(Aerolinea aero : aerolineas) {
    			if(aero.getDescripcionAerolinea().equals(cbAerolinea.getSelectedItem())) {
		    		vuelo.setAerolinea(aero);
		    		
    			}
			}
			for(Aeropuerto aeropuert : aeropuertos) {
    			if(aeropuert.getLugarAero().equals(cbAropuertoO.getSelectedItem())) {
		    		vuelo.setAeropuertoOrigen(aeropuert);
		    		
    			}
			}
			for(Aeropuerto aeropuer : aeropuertos) {
    			if(aeropuer.getLugarAero().equals(cbAeropuertoD.getSelectedItem())) {
		    		vuelo.setAeropuertoDestino(aeropuer);
		    		
    			}
			}
			vuelo.setVueloIda(null);
    			vuelo.setViaje(viaje);
    			controlador.crearVuelo(vuelo);
		}

		return vuelo;
	
	}
	
	public boolean validarVueloV(Viaje viaje,Vuelo vuelo) {
		ArrayList<Aerolinea>aerolineas = controlador.mostrarAerolineas();
		ArrayList<Aeropuerto>aeropuertos = controlador.mostrarAeropuertos();
		Vuelo vueloV = new Vuelo();
		boolean valido = true;
		String fechaVueloV;
	
		
		
		if(cbAerolineaV_1.getSelectedItem()=="") {
			JOptionPane.showMessageDialog(this, "Seleccione la aerolinea de vuelta", "Error", JOptionPane.ERROR_MESSAGE);
		    valido = false;
		}
		
		if(txtCodigoVueloV.getText().length() < 1 || txtCodigoVueloV.getText().length()>25  == true) {
			JOptionPane.showMessageDialog(this, "Codigo de vuelo no valido", "Error", JOptionPane.ERROR_MESSAGE);
		    valido = false;
		}
		
		if(txtDuracionV.getText()=="" ) {
			JOptionPane.showMessageDialog(this, "Duracion incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
		    valido = false;
		}

		if(txtHorarioV.getText()=="" ) {
			JOptionPane.showMessageDialog(this, "Introduce una hora de salida", "Error", JOptionPane.ERROR_MESSAGE);
		    valido = false;
		}
			
        if (dcVuelo.getDate().before(dcVueloVuelta.getDate())!=true) {
            JOptionPane.showMessageDialog(null, "La fecha de vuelta no puede ser antes de la fecha de ida.", "ERROR", JOptionPane.ERROR_MESSAGE);
           valido=false;
        }
		
		
        if(valido==true) {
			fechaVueloV=convertirFechaADatabaseFormat(dcVueloVuelta.getDate());
			vueloV.setCodigoVuelo(txtCodigoVueloV.getText());
			vueloV.setPrecio(txtPrecio.getText());
			vueloV.setFecha(fechaVueloV);
			vueloV.setHora(txtHorarioV.getText());
			vueloV.setDuracion(txtDuracionV.getText());
			
			for(Aerolinea aero : aerolineas) {
    			if(aero.getDescripcionAerolinea().equals(cbAerolinea.getSelectedItem())) {
    				vueloV.setAerolinea(aero);
    				
    				}
				}
			}
 
		for(Aeropuerto aeropuert : aeropuertos) {
			if(aeropuert.getLugarAero().equals(cbAropuertoO.getSelectedItem())) {
	    		vueloV.setAeropuertoDestino(aeropuert);
			}
			}
			
		for(Aeropuerto aeropuer : aeropuertos) {
			if(aeropuer.getLugarAero().equals(cbAeropuertoD.getSelectedItem())) {
		    	vueloV.setAeropuertoOrigen(aeropuer);
				}
		}
			vuelo.setIdEvento(controlador.maximoEvento());
			System.out.println(controlador.maximoEvento());
			vueloV.setVueloIda(vuelo);
    		vueloV.setViaje(viaje);
    		controlador.crearVuelo(vueloV);
        
        if(valido==true) {
			JOptionPane.showMessageDialog(null, "Vuelo creado correctamente");
		}
		return valido;	
	}
	
	
	
	public boolean validarAlojamiento(Viaje viaje,Agencia agencia){
		
		Alojamiento alojamiento = new Alojamiento();
		String fechaAlo,fechaAlo1;
		boolean valido = true;
		
		if(cbTipoHabitacion.getSelectedItem()=="") {
			JOptionPane.showMessageDialog(this, "Seleccione el tipo de habitacion", "Error", JOptionPane.ERROR_MESSAGE);
		    valido = false;
		}
		
		if(txtCiudad.getText().length() < 1 || txtCiudad.getText().length()>50  == true) {
			JOptionPane.showMessageDialog(this, "Nombre de la ciudad invalido", "Error", JOptionPane.ERROR_MESSAGE);
		    valido = false;
		}
		if(txtPrecioAlo.getText()=="") {
			JOptionPane.showMessageDialog(this, "Introduce un precio", "Error", JOptionPane.ERROR_MESSAGE);
		    valido = false;
		}
		
		if (dcFechaAlojamiento.getDate()==null) {
	            JOptionPane.showMessageDialog(null, "Introduce una fecha.", "ERROR", JOptionPane.ERROR_MESSAGE);
	           valido=false;
	        }
		
		if (dcFechaAlojamientoSalida.getDate().before(dcFechaAlojamiento.getDate())) {
            JOptionPane.showMessageDialog(null, "La fecha de vuelta no puede ser antes de la fecha de ida.", "ERROR", JOptionPane.ERROR_MESSAGE);
           valido=false;
        }
		
		if(valido == true) {
			fechaAlo=convertirFechaADatabaseFormat(dcFechaAlojamiento.getDate());
			fechaAlo1=convertirFechaADatabaseFormat(dcFechaAlojamientoSalida.getDate());
			alojamiento.setNombreHotel(txtNombreEvento.getText());
			alojamiento.setCiudad(txtCiudad.getText());
			alojamiento.setPrecio(txtPrecioAlo.getText());
			alojamiento.setFecEntrada(fechaAlo);
			alojamiento.setFecSalida(fechaAlo1);
			alojamiento.setTipoHab(cbTipoHabitacion.getSelectedItem()+"");
			alojamiento.setViaje(viaje);
			controlador.crearAlojamiento(alojamiento);
			
			
		}
		
		if(valido==true) {
			JOptionPane.showMessageDialog(null, "Viaje creado correctamente");
		}
		
		
		
		return valido;
	}
	
	public boolean validarOtros(Viaje viaje,Agencia agencia){
		
		Otros otros = new Otros();
		String fechaOtr;
		
		boolean valido = true;
		
		if(txtDescripcionOtros.getText().length()<1 || txtDescripcionOtros.getText().length()>255  == true) {
			JOptionPane.showMessageDialog(this, "Introduzca una descripcion", "Error", JOptionPane.ERROR_MESSAGE);
		    valido = false;
		}
		
		if(txtPrecioOtros.getText().length()<1) {
			JOptionPane.showMessageDialog(this, "Introduce un precio", "Error", JOptionPane.ERROR_MESSAGE);
		    valido = false;
		}
		if(dcFechaOtros.getDate()==null) {
			JOptionPane.showMessageDialog(this, "Introduce una fecha", "Error", JOptionPane.ERROR_MESSAGE);
		    valido = false;
		}
		
		if(valido==true) {
			fechaOtr=convertirFechaADatabaseFormat(dcFechaOtros.getDate());
			otros.setNombreEvento(txtNombreEvento.getText());
			otros.setDescripcion(txtDescripcionOtros.getText());
			otros.setPrecio(txtPrecioOtros.getText());
			otros.setFecha(fechaOtr);
			otros.setViaje(viaje);
			controlador.crearOtros(otros);
		}
		
		if(valido==true) {
			JOptionPane.showMessageDialog(null, "Viaje creado correctamente");
			MenuPrincipal menuPrincipal = new MenuPrincipal(agencia);
			 menuPrincipal.setVisible(true);
			 dispose();
		}
		
		return valido;
	}
	
	public void rellenarAerolinea(JComboBox cbAerolineaV) {

		Gestor gestorEventos = new Gestor();
		ArrayList<Aerolinea> aerolienas = gestorEventos.mostrarAerolineas();
        for (Aerolinea aerolinea : aerolienas) {
        	cbAerolineaV.addItem(aerolinea.getDescripcionAerolinea()); 
        }
}
	
	
	
	public void rellenarAeropuerto(JComboBox cbAeropuerto) {

		Gestor gestorEventos = new Gestor();
		ArrayList<Aeropuerto> aeropuertos = gestorEventos.mostrarAeropuertos();
        for (Aeropuerto aeropuerto : aeropuertos) {
        	cbAeropuerto.addItem(aeropuerto.getLugarAero()); 
        }
       
}
	
	public String convertirFechaADatabaseFormat(java.util.Date date) {
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.format(date);
        }
        return null; 
    }
}