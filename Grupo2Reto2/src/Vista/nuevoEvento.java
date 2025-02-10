package Vista;

import java.awt.Color;
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

import Modelo.Gestor;
import Modelo.Pais;
import Modelo.Viaje;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import com.toedter.components.JLocaleChooser;
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
	private JComboBox cbAeropuertoDV;
	private JComboBox cbAropuertoOV;


	/**
	 * Create the frame.
	 */
	public nuevoEvento(Agencia agencia) {
		
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
		
		JLabel lblNombreEvento = new JLabel("Nombre del evento");
		lblNombreEvento.setFont(new Font("Yu Gothic", Font.PLAIN, 22));
		lblNombreEvento.setBounds(354, 79, 201, 36);
		contentPane.add(lblNombreEvento);
		
		txtNombreEvento = new JTextField();
		txtNombreEvento.setBounds(554, 83, 118, 20);
		contentPane.add(txtNombreEvento);
		txtNombreEvento.setColumns(10);
		
		JLabel lblTipoEvento = new JLabel("Tipo del evento");
		lblTipoEvento.setFont(new Font("Yu Gothic", Font.PLAIN, 22));
		lblTipoEvento.setBounds(42, 74, 181, 46);
		contentPane.add(lblTipoEvento);
		
		cbTipoEvento = new JComboBox();
		cbTipoEvento.setModel(new DefaultComboBoxModel(new String[] {"", "Vuelo", "Alojamiento", "Otros"}));
		cbTipoEvento.setBounds(217, 83, 118, 22);
		contentPane.add(cbTipoEvento);
		
		JPanel otros = new JPanel();
		otros.setBounds(0, 133, 776, 443);
		contentPane.add(otros);
		otros.setLayout(null);
		
		JPanel Alojamiento = new JPanel();
		Alojamiento.setBounds(-52, 5, 776, 432);
		otros.add(Alojamiento);
		Alojamiento.setLayout(null);
		
		JPanel vuelo = new JPanel();
		vuelo.setBounds(0, 132, 766, 411);
		contentPane.add(vuelo);
		vuelo.setLayout(null);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validarEvento();
			}
		});
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
		
		JPanel panelColoreable = new JPanel();
		panelColoreable.setBounds(-1, -1, 777, 54);
		contentPane.add(panelColoreable);
		panelColoreable.setBackground(rellenarColor(agencia));
		
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
		
		
		
	}
	
	public void verAlojamiento(JPanel Alojamiento) {
		
		JLabel lblTipoHabitacion = new JLabel("Tipo del evento");
		lblTipoHabitacion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTipoHabitacion.setBounds(60, 25, 118, 28);
		Alojamiento.add(lblTipoHabitacion);
		
		JComboBox cbTipoEvento_1 = new JComboBox();
		cbTipoEvento_1.setBounds(224, 29, 118, 22);
		Alojamiento.add(cbTipoEvento_1);
		
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
		btnBuscarAlojamiento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBuscarAlojamiento.setBounds(60, 211, 282, 23);
		Alojamiento.add(btnBuscarAlojamiento);
		
		JDateChooser dcFechaAlojamiento = new JDateChooser();
		dcFechaAlojamiento.setBounds(224, 142, 118, 20);
		Alojamiento.add(dcFechaAlojamiento);
	
		
		
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
		
		JComboBox cbTrayecto = new JComboBox();
		
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
		txtCodigoVuelo.setVisible(false);
		
		txtHorario = new JTextField();
		txtHorario.setColumns(10);
		txtHorario.setBounds(225, 322, 118, 20);
		vuelo.add(txtHorario);
		
		txtDuracion = new JTextField();
		txtDuracion.setColumns(10);
		txtDuracion.setBounds(225, 361, 118, 20);
		vuelo.add(txtDuracion);
		
		JComboBox cbAerolinea = new JComboBox();
		cbAerolinea.setModel(new DefaultComboBoxModel(new String[] {"",}));
		cbAerolinea.setBounds(225, 245, 118, 22);
		vuelo.add(cbAerolinea);
		rellenarAerolinea(cbAerolinea);
		
		JButton btnBuscarViaje = new JButton("BuscarViaje");
		btnBuscarViaje.setBounds(397, 15, 210, 23);
		vuelo.add(btnBuscarViaje);
		
		JLabel lblAeropuertoOV = new JLabel("Aeropuerto Origen");
		lblAeropuertoOV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAeropuertoOV.setBounds(397, 59, 118, 28);
		vuelo.add(lblAeropuertoOV);
		
		
		JLabel lblAeropuertoDV = new JLabel("Aeropuerto Destino");
		lblAeropuertoDV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAeropuertoDV.setBounds(397, 110, 118, 28);
		vuelo.add(lblAeropuertoDV);
		
		
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
		
		
		
		cbAropuertoOV = new JComboBox();
		cbAropuertoOV.setBounds(576, 63, 118, 22);
		vuelo.add(cbAropuertoOV);
		rellenarAeropuerto(cbAropuertoOV);
		
		
		cbAeropuertoDV = new JComboBox();
		cbAeropuertoDV.setBounds(576, 114, 118, 22);
		vuelo.add(cbAeropuertoDV);
		rellenarAeropuerto(cbAeropuertoDV);
		
		txtCodigoVueloV = new JTextField();
		txtCodigoVueloV.setColumns(10);
		txtCodigoVueloV.setBounds(576, 205, 118, 20);
		vuelo.add(txtCodigoVueloV);
		
		
		JComboBox cbAerolineaV = new JComboBox();
		cbAerolineaV.setModel(new DefaultComboBoxModel(new String[] {"",}));
		cbAerolineaV.setBounds(576, 243, 118, 22);
		vuelo.add(cbAerolineaV);
		rellenarAerolinea(cbAerolineaV);
		
		
		txtHorarioV = new JTextField();
		txtHorarioV.setColumns(10);
		txtHorarioV.setBounds(576, 322, 118, 20);
		vuelo.add(txtHorarioV);
		
		
		txtDuracionV = new JTextField();
		txtDuracionV.setColumns(10);
		txtDuracionV.setBounds(576, 361, 118, 20);
		vuelo.add(txtDuracionV);
		
		
		JDateChooser dcVuelo = new JDateChooser();
		dcVuelo.setBounds(225, 161, 118, 20);
		vuelo.add(dcVuelo);
		
		JDateChooser dcVueloVuelta = new JDateChooser();
		dcVueloVuelta.setBounds(576, 161, 118, 20);
		vuelo.add(dcVueloVuelta);
		

		cbAropuertoOV.setSelectedItem(cbAeropuertoD);
		cbAeropuertoDV.setSelectedItem(cbAropuertoO);
		
		lblAeropuertoOV.setVisible(false);
		lblFechaVuelta.setVisible(false);
		lblAeropuertoDV.setVisible(false);
		lblCodigoVueloV.setVisible(false);
		lblAerolineaV.setVisible(false);
		lblDuracionV.setVisible(false);
		lblHorarioV.setVisible(false);
		txtCodigoVueloV.setVisible(false);
		txtCodigoVuelo.setVisible(false);
		txtDuracionV.setVisible(false);
		txtCodigoVueloV.setVisible(false);
		txtHorarioV.setVisible(false);
		cbAropuertoOV.setVisible(false);
		cbAeropuertoDV.setVisible(false);
		cbAerolineaV.setVisible(false);
		dcVueloVuelta.setVisible(false);
		cbTrayecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbTrayecto.getSelectedItem().equals("Ida y vuelta")) {
					lblAeropuertoOV.setVisible(true);
					lblFechaVuelta.setVisible(true);
					lblAeropuertoDV.setVisible(true);
					lblCodigoVueloV.setVisible(true);
					lblAerolineaV.setVisible(true);
					lblDuracionV.setVisible(true);
					lblHorarioV.setVisible(true);
					txtCodigoVueloV.setVisible(true);
					txtCodigoVuelo.setVisible(true);
					txtDuracionV.setVisible(true);
					txtCodigoVueloV.setVisible(true);
					txtHorarioV.setVisible(true);
					cbAropuertoOV.setVisible(true);
					cbAeropuertoDV.setVisible(true);
					cbAerolineaV.setVisible(true);
					dcVueloVuelta.setVisible(true);
					
				}
				else {
					lblAeropuertoOV.setVisible(false);
					lblFechaVuelta.setVisible(false);
					lblAeropuertoDV.setVisible(false);
					lblCodigoVueloV.setVisible(false);
					lblAerolineaV.setVisible(false);
					lblDuracionV.setVisible(false);
					lblHorarioV.setVisible(false);
					txtCodigoVueloV.setVisible(false);
					txtCodigoVuelo.setVisible(false);
					txtDuracionV.setVisible(false);
					txtCodigoVueloV.setVisible(false);
					txtHorarioV.setVisible(false);
					cbAropuertoOV.setVisible(false);
					cbAeropuertoDV.setVisible(false);
					cbAerolineaV.setVisible(false);
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
		 
		 JDateChooser dcFechaOtros = new JDateChooser();
			dcFechaOtros.setBounds(224, 201, 118, 20);
			otros.add(dcFechaOtros);
}
	
	
	
	public boolean validarEvento() {
		boolean valido = true;
		  if (txtNombreEvento.getText().trim().isEmpty()) {
	            JOptionPane.showMessageDialog(null, "El nombre del evento no puede estar vacío","ERROR", JOptionPane.ERROR_MESSAGE);
	            valido = false;
	        }
	        if (cbTipoEvento.getSelectedIndex() == 0) {
	            JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de evento","ERROR", JOptionPane.ERROR_MESSAGE);
	            valido = false;
	        }
		
	return valido;	
	}
	
	public boolean validarVuelo() {
		boolean valido = true;
	
		
	
		
		
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

	public Color rellenarColor(Agencia agencia) {
		String colorMarca = agencia.getColorMarca();
		try {
			return Color.decode(colorMarca); // Convierte el código hexadecimal a un Color
		} catch (NumberFormatException e) {
			return Color.BLACK; // Color por defecto si el formato no es válido
		}
	}
	public void setBorder(Object object) {
		// TODO Auto-generated method stub
		
	}
	
}