package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;

import Modelo.Agencia;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import com.toedter.components.JLocaleChooser;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;

public class nuevoEvento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
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


	/**
	 * Create the frame.
	 */
	public nuevoEvento(Agencia agencia) {
		
		   JCalendar calendar = new JCalendar();
           int año = calendar.getCalendar().get(Calendar.YEAR);
           int mes = calendar.getCalendar().get(Calendar.MONTH);
           int dia = calendar.getCalendar().get(Calendar.DAY_OF_MONTH);
           String fecha = dia+"-"+mes+"-"+año;
           System.out.print(fecha);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 696);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre del evento");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(61, 40, 118, 28);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(223, 45, 118, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblTipoEvento = new JLabel("Tipo del evento");
		lblTipoEvento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTipoEvento.setBounds(61, 94, 118, 28);
		contentPane.add(lblTipoEvento);
		
		JComboBox cbTipoEvento = new JComboBox();
		cbTipoEvento.setModel(new DefaultComboBoxModel(new String[] {"", "Vuelo", "Alojamiento", "Otros"}));
		cbTipoEvento.setBounds(223, 98, 118, 22);
		contentPane.add(cbTipoEvento);
		
		JPanel Alojamiento = new JPanel();
		Alojamiento.setBounds(0, 147, 776, 432);
		contentPane.add(Alojamiento);
		Alojamiento.setLayout(null);
		
		JPanel otros = new JPanel();
		otros.setBounds(0, 133, 776, 443);
		contentPane.add(otros);
		otros.setLayout(null);
		
		JPanel vuelo = new JPanel();
		vuelo.setBounds(0, 132, 766, 411);
		contentPane.add(vuelo);
		vuelo.setLayout(null);
		
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
		
		
		verVuelo(vuelo);
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
		
		JComboBox cbAropuertoO = new JComboBox();
		cbAropuertoO.setModel(new DefaultComboBoxModel(new String[] {"", "Alicante ", "Asturias ", "barcelona", "Córdoba ", "Gerona ", "Granada ", "Ibiza ", "La Coruña LCG", "Lanzarote ", "Madrid", "MAHON", "Murcia ", "Pamplona ", "Salamanca ", "Santa Cruz de la Palma ", "Santiago de Compostela ", "Valencia ", "Vigo ", "Zaragoza", "Badajoz ", "Bilbao", "VITORIA", "Tenerife Norte ", "Tenerife Sur ", "SANTANDER", "SAN SEBASTIAN", "REUS", "PALMA DE MALLORCA", "MALAGA", "JEREZ DE LA FRONTERA", "GRAN CANARIA ", "FUERTEVENTURA", "HIERRO ", "LA GOMERA", "Montreal, Québec ", " CANADA Ottawa, Ontario YOW", "CANADA Toronto, Ontario YTO", "CANADA VANCOUVER  ", "Boston ", "Houston ", "Miami", "LOS ANGELES", "Nueva York ", "DETROIT", "Philadelphia PHL ", "SAN FRANCISCO", "Seattle ", "WASHINGTON", " REPUBLICA DOMINICANA (Santo Domingo) ", "JAMAICA (kingston)", "Buenos Aires ", "BRASIL (Rio de Janeiro )", " BRASIL (Sao Paulo )", "COLOMBIA Bogotá ", "PERU ( Lima)", "VENEZUELA ( CARACAS)", "AUSTRIA (Viena )", "REPUBLICA CHECA (Praga )", "FINLANDIA (Helsinki )", "FRANCIA (lyon)", "FRANCIA,París (aeropuerto Charles de Gaulle)", "FRANCIA ,Le Bourget,", "FRANCIA (ORLY)", "FRANCIA (Marsella)", "ALEMANIA (Berlín )", "ALEMANIA (Dusseldorf )", "ALEMANIA (Frankfurt )", "ALEMANIA (Munich )", "ALEMANIA (hamburgo)", "GRECIA ( Atenas)", "IRLANDA (DUBLIN)", " ITALIA (Milán )", "BOSTON", "DETROIT", " San Francisco", " México D.F.", "MÉXICO (ACAPULCO)", "BRASIL (brasilia)", "Washington", "ALEMANIA (Stuttgart) ", "SAN FRANCISCO", "DINAMARCA ", "BELGICA (Bruselas )", "HOLANDA Amsterdam ", "NORUEGA (oslo)", "POLONIA (Varsovia ) WAW ", "PORTUGAL (lisboa)", "SUECIA (Estocolmo)", " RUSIA (Moscú ) MOW ", "SUIZA (Ginebra )", "SUIZA (Zurich)", "TURQUIA (ESTAMBUL)", "LONDRES (GATWICK)", "LONDRES Heathrow", "LONDRES ( Stanted)", " EGIPTO El Cairo ", "KENIA ( Nairobi)", " MARRUECOS (Casablanca) ", "MARRUECOS (Marrakech)", "Túnez ", "JORDANIA (Ammán ) AMM", "TAILANDIA Bagkok ", " AUSTRALIA Melbourne ", "AUSTRALIA (SIYNEY)"}));
		cbAropuertoO.setBounds(225, 63, 118, 22);
		vuelo.add(cbAropuertoO);
		
		JComboBox cbAeropuertoD = new JComboBox();
		cbAeropuertoD.setModel(new DefaultComboBoxModel(new String[] {"", "Alicante ", "Asturias ", "barcelona", "Córdoba ", "Gerona ", "Granada ", "Ibiza ", "La Coruña LCG", "Lanzarote ", "Madrid", "MAHON", "Murcia ", "Pamplona ", "Salamanca ", "Santa Cruz de la Palma ", "Santiago de Compostela ", "Valencia ", "Vigo ", "Zaragoza", "Badajoz ", "Bilbao", "VITORIA", "Tenerife Norte ", "Tenerife Sur ", "SANTANDER", "SAN SEBASTIAN", "REUS", "PALMA DE MALLORCA", "MALAGA", "JEREZ DE LA FRONTERA", "GRAN CANARIA ", "FUERTEVENTURA", "HIERRO ", "LA GOMERA", "Montreal, Québec ", " CANADA Ottawa, Ontario YOW", "CANADA Toronto, Ontario YTO", "CANADA VANCOUVER  ", "Boston ", "Houston ", "Miami", "LOS ANGELES", "Nueva York ", "DETROIT", "Philadelphia PHL ", "SAN FRANCISCO", "Seattle ", "WASHINGTON", " REPUBLICA DOMINICANA (Santo Domingo) ", "JAMAICA (kingston)", "Buenos Aires ", "BRASIL (Rio de Janeiro )", " BRASIL (Sao Paulo )", "COLOMBIA Bogotá ", "PERU ( Lima)", "VENEZUELA ( CARACAS)", "AUSTRIA (Viena )", "REPUBLICA CHECA (Praga )", "FINLANDIA (Helsinki )", "FRANCIA (lyon)", "FRANCIA,París (aeropuerto Charles de Gaulle)", "FRANCIA ,Le Bourget,", "FRANCIA (ORLY)", "FRANCIA (Marsella)", "ALEMANIA (Berlín )", "ALEMANIA (Dusseldorf )", "ALEMANIA (Frankfurt )", "ALEMANIA (Munich )", "ALEMANIA (hamburgo)", "GRECIA ( Atenas)", "IRLANDA (DUBLIN)", " ITALIA (Milán )", "BOSTON", "DETROIT", " San Francisco", " México D.F.", "MÉXICO (ACAPULCO)", "BRASIL (brasilia)", "Washington", "ALEMANIA (Stuttgart) ", "SAN FRANCISCO", "DINAMARCA ", "BELGICA (Bruselas )", "HOLANDA Amsterdam ", "NORUEGA (oslo)", "POLONIA (Varsovia ) WAW ", "PORTUGAL (lisboa)", "SUECIA (Estocolmo)", " RUSIA (Moscú ) MOW ", "SUIZA (Ginebra )", "SUIZA (Zurich)", "TURQUIA (ESTAMBUL)", "LONDRES (GATWICK)", "LONDRES Heathrow", "LONDRES ( Stanted)", " EGIPTO El Cairo ", "KENIA ( Nairobi)", " MARRUECOS (Casablanca) ", "MARRUECOS (Marrakech)", "Túnez ", "JORDANIA (Ammán ) AMM", "TAILANDIA Bagkok ", " AUSTRALIA Melbourne ", "AUSTRALIA (SIYNEY)"}));
		cbAeropuertoD.setBounds(225, 114, 118, 22);
		vuelo.add(cbAeropuertoD);
		
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
		cbAerolinea.setModel(new DefaultComboBoxModel(new String[] {"", "Aerolínea Vueling SA", "RYNAIR", "World2Fly", "Air France ", "KLM", "KLM Cityhopper", "TAP Portugal", "World 2 Fly Portugal, S.A.", "Finnair ", "Brussels Airlines", "Condor Flugdienst GmbH", "Lufthansa", "Lufthansa CityLine GmbH", "TUIfly Gmbh", "TUIfly Nordic AB", "Croatia Airlines d.d.", "Air Nostrum, Lineas aereas del Mediterra neo SA", "SATA (Air Acores)", "SATA Internacional - Azores Airlines, S.A.", "Air Europa Lineas Aereas, S.A.", "British Airways PLC", "BA Euroflyer Limited dba British Airways", "Virgin Atlantic Airways Ltd", "Norse Atlantic Airways AS", "Challenge Airlines (BE) S.A.", "Virgin Atlantic Airways Ltd", "EASYJET UK LIMITED", "Easyjet Switzerland S.A", "Edelweiss Air AG", "Air Greenland", "SWISS Internation Air Lines Ltd", "Turkish Airlines Inc", "Pegasus Airlines", "Malta Air Travel Ltd dba Malta MedAir", "Alitalia", "American Airlines", "BSA - Aerolinhas Brasileiras S.A dba LATAM Cargo Br", "Tam Linhas Aereas SA dba Latam Airlines Brasil", "Delta Air Lines Inc", "United Airlines Inc", "China United Airlines", "AVIANCA-Ecuador dba AVIANCA", "Aerovias del Continente Americano S.A. AVIANCA", "Egyptair", "Aerovias de Mexico SA de CV dba AeroMexico", "Aerolineas Argentinas S.A.", "Air Transat", "Alia - The Royal Jordanian Airlines dba Royal Jordanian", "Qatar Airways Group Q.C.S.C dba Qatar Airways"}));
		cbAerolinea.setBounds(225, 245, 118, 22);
		vuelo.add(cbAerolinea);
		
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
		
		
		
		JComboBox cbAropuertoOV = new JComboBox();
		cbAropuertoOV.setBounds(576, 63, 118, 22);
		vuelo.add(cbAropuertoOV);
		
		
		
		JComboBox cbAeropuertoDV = new JComboBox();
		cbAeropuertoDV.setBounds(576, 114, 118, 22);
		vuelo.add(cbAeropuertoDV);
		
		
		txtCodigoVueloV = new JTextField();
		txtCodigoVueloV.setColumns(10);
		txtCodigoVueloV.setBounds(576, 205, 118, 20);
		vuelo.add(txtCodigoVueloV);
		
		
		JComboBox cbAerolineaV = new JComboBox();
		cbAerolineaV.setModel(new DefaultComboBoxModel(new String[] {"", "Aerolínea Vueling SA", "RYNAIR", "World2Fly", "Air France ", "KLM", "KLM Cityhopper", "TAP Portugal", "World 2 Fly Portugal, S.A.", "Finnair ", "Brussels Airlines", "Condor Flugdienst GmbH", "Lufthansa", "Lufthansa CityLine GmbH", "TUIfly Gmbh", "TUIfly Nordic AB", "Croatia Airlines d.d.", "Air Nostrum, Lineas aereas del Mediterra neo SA", "SATA (Air Acores)", "SATA Internacional - Azores Airlines, S.A.", "Air Europa Lineas Aereas, S.A.", "British Airways PLC", "BA Euroflyer Limited dba British Airways", "Virgin Atlantic Airways Ltd", "Norse Atlantic Airways AS", "Challenge Airlines (BE) S.A.", "Virgin Atlantic Airways Ltd", "EASYJET UK LIMITED", "Easyjet Switzerland S.A", "Edelweiss Air AG", "Air Greenland", "SWISS Internation Air Lines Ltd", "Turkish Airlines Inc", "Pegasus Airlines", "Malta Air Travel Ltd dba Malta MedAir", "Alitalia", "American Airlines", "BSA - Aerolinhas Brasileiras S.A dba LATAM Cargo Br", "Tam Linhas Aereas SA dba Latam Airlines Brasil", "Delta Air Lines Inc", "United Airlines Inc", "China United Airlines", "AVIANCA-Ecuador dba AVIANCA", "Aerovias del Continente Americano S.A. AVIANCA", "Egyptair", "Aerovias de Mexico SA de CV dba AeroMexico", "Aerolineas Argentinas S.A.", "Air Transat", "Alia - The Royal Jordanian Airlines dba Royal Jordanian", "Qatar Airways Group Q.C.S.C dba Qatar Airways"}));
		cbAerolineaV.setBounds(576, 243, 118, 22);
		vuelo.add(cbAerolineaV);
		
		
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
}