package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Agencia;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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


	/**
	 * Create the frame.
	 */
	public nuevoEvento(Agencia agencia) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 629);
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
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 132, 766, 411);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setVisible(false);
		
		JLabel lblTrayecto = new JLabel("Trayecto");
		lblTrayecto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTrayecto.setBounds(61, 11, 118, 28);
		panel.add(lblTrayecto);
		
		JLabel lblAeropuertoO = new JLabel("Aeropuerto Origen");
		lblAeropuertoO.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAeropuertoO.setBounds(61, 59, 118, 28);
		panel.add(lblAeropuertoO);
		
		JLabel lblAeropuertoD = new JLabel("Aeropuerto Destino");
		lblAeropuertoD.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAeropuertoD.setBounds(61, 110, 118, 28);
		panel.add(lblAeropuertoD);
		
		JLabel lblFechaIda = new JLabel("Fecha ida");
		lblFechaIda.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFechaIda.setBounds(61, 161, 118, 28);
		panel.add(lblFechaIda);
		
		JLabel lblCodigoVuelo = new JLabel("CodigoVuelo");
		lblCodigoVuelo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodigoVuelo.setBounds(61, 200, 118, 28);
		panel.add(lblCodigoVuelo);
		
		JLabel lblAerolinea = new JLabel("Aerolinea");
		lblAerolinea.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAerolinea.setBounds(61, 239, 118, 28);
		panel.add(lblAerolinea);
		
		JComboBox cbTrayecto = new JComboBox();
		cbTrayecto.setBounds(225, 15, 118, 22);
		panel.add(cbTrayecto);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrecio.setBounds(61, 278, 118, 28);
		panel.add(lblPrecio);
		
		JLabel lblHorario = new JLabel("Horario salida");
		lblHorario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHorario.setBounds(61, 317, 118, 28);
		panel.add(lblHorario);
		
		JLabel lblDuracion = new JLabel("Duracion");
		lblDuracion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDuracion.setBounds(61, 356, 118, 28);
		panel.add(lblDuracion);
		
		JComboBox cbAropuertoO = new JComboBox();
		cbAropuertoO.setBounds(225, 63, 118, 22);
		panel.add(cbAropuertoO);
		
		JComboBox cbAeropuertoD = new JComboBox();
		cbAeropuertoD.setBounds(225, 114, 118, 22);
		panel.add(cbAeropuertoD);
		
		txtCodigoVuelo = new JTextField();
		txtCodigoVuelo.setColumns(10);
		txtCodigoVuelo.setBounds(225, 205, 118, 20);
		panel.add(txtCodigoVuelo);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(225, 283, 118, 20);
		panel.add(txtPrecio);
		
		txtHorario = new JTextField();
		txtHorario.setColumns(10);
		txtHorario.setBounds(225, 322, 118, 20);
		panel.add(txtHorario);
		
		txtDuracion = new JTextField();
		txtDuracion.setColumns(10);
		txtDuracion.setBounds(225, 361, 118, 20);
		panel.add(txtDuracion);
		
		JComboBox cbAerolinea = new JComboBox();
		cbAerolinea.setModel(new DefaultComboBoxModel(new String[] {"", "Aerolínea Vueling SA", "RYNAIR", "World2Fly", "Air France ", "KLM", "KLM Cityhopper", "TAP Portugal", "World 2 Fly Portugal, S.A.", "Finnair ", "Brussels Airlines", "Condor Flugdienst GmbH", "Lufthansa", "Lufthansa CityLine GmbH", "TUIfly Gmbh", "TUIfly Nordic AB", "Croatia Airlines d.d.", "Air Nostrum, Lineas aereas del Mediterra neo SA", "SATA (Air Acores)", "SATA Internacional - Azores Airlines, S.A.", "Air Europa Lineas Aereas, S.A.", "British Airways PLC", "BA Euroflyer Limited dba British Airways", "Virgin Atlantic Airways Ltd", "Norse Atlantic Airways AS", "Challenge Airlines (BE) S.A.", "Virgin Atlantic Airways Ltd", "EASYJET UK LIMITED", "Easyjet Switzerland S.A", "Edelweiss Air AG", "Air Greenland", "SWISS Internation Air Lines Ltd", "Turkish Airlines Inc", "Pegasus Airlines", "Malta Air Travel Ltd dba Malta MedAir", "Alitalia", "American Airlines", "BSA - Aerolinhas Brasileiras S.A dba LATAM Cargo Br", "Tam Linhas Aereas SA dba Latam Airlines Brasil", "Delta Air Lines Inc", "United Airlines Inc", "China United Airlines", "AVIANCA-Ecuador dba AVIANCA", "Aerovias del Continente Americano S.A. AVIANCA", "Egyptair", "Aerovias de Mexico SA de CV dba AeroMexico", "Aerolineas Argentinas S.A.", "Air Transat", "Alia - The Royal Jordanian Airlines dba Royal Jordanian", "Qatar Airways Group Q.C.S.C dba Qatar Airways"}));
		cbAerolinea.setBounds(225, 245, 118, 22);
		panel.add(cbAerolinea);
		
		JButton btnBuscarViaje = new JButton("BuscarViaje");
		btnBuscarViaje.setBounds(397, 15, 210, 23);
		panel.add(btnBuscarViaje);
		
		JLabel lblAeropuertoOV = new JLabel("Aeropuerto Origen");
		lblAeropuertoOV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAeropuertoOV.setBounds(397, 59, 118, 28);
		panel.add(lblAeropuertoOV);
		
		JLabel lblAeropuertoDV = new JLabel("Aeropuerto Destino");
		lblAeropuertoDV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAeropuertoDV.setBounds(397, 110, 118, 28);
		panel.add(lblAeropuertoDV);
		
		JLabel lblFechaVuelta = new JLabel("Fecha ida");
		lblFechaVuelta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFechaVuelta.setBounds(397, 161, 118, 28);
		panel.add(lblFechaVuelta);
		
		JLabel lblCodigoVueloV = new JLabel("CodigoVuelo");
		lblCodigoVueloV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodigoVueloV.setBounds(397, 200, 118, 28);
		panel.add(lblCodigoVueloV);
		
		JLabel lblAerolineaV = new JLabel("Aerolinea");
		lblAerolineaV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAerolineaV.setBounds(397, 239, 118, 28);
		panel.add(lblAerolineaV);
		
		JLabel lblHorarioV = new JLabel("Horario salida");
		lblHorarioV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHorarioV.setBounds(397, 317, 118, 28);
		panel.add(lblHorarioV);
		
		JLabel lblDuracionV = new JLabel("Duracion");
		lblDuracionV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDuracionV.setBounds(397, 356, 118, 28);
		panel.add(lblDuracionV);
		
		JComboBox cbAropuertoOV = new JComboBox();
		cbAropuertoOV.setBounds(576, 63, 118, 22);
		panel.add(cbAropuertoOV);
		
		JComboBox cbAeropuertoDV = new JComboBox();
		cbAeropuertoDV.setBounds(576, 114, 118, 22);
		panel.add(cbAeropuertoDV);
		
		txtCodigoVueloV = new JTextField();
		txtCodigoVueloV.setColumns(10);
		txtCodigoVueloV.setBounds(576, 205, 118, 20);
		panel.add(txtCodigoVueloV);
		
		JComboBox cbAerolineaV = new JComboBox();
		cbAerolineaV.setBounds(576, 243, 118, 22);
		panel.add(cbAerolineaV);
		
		txtHorarioV = new JTextField();
		txtHorarioV.setColumns(10);
		txtHorarioV.setBounds(576, 322, 118, 20);
		panel.add(txtHorarioV);
		
		txtDuracionV = new JTextField();
		txtDuracionV.setColumns(10);
		txtDuracionV.setBounds(576, 361, 118, 20);
		panel.add(txtDuracionV);
		
		
	}
	
	
}
