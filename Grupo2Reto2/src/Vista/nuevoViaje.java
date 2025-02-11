package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

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
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;

import Controlador.Controlador;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.beans.PropertyChangeEvent;

public class nuevoViaje extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombreViaje;
	private JLabel lblInicioViaje;
	private JLabel lblFinViaje;
	private JLabel lblDuracion;
	private JLabel lblPais;
	private JLabel lblDescrip;
	private JTextPane textDescrip;
	private JTextPane textServicios;
	private JDateChooser dcInicioViaje;
	private JTextField txtDuracion;
	private JDateChooser dcFinViaje;
	private JComboBox cbPais;
	private JComboBox cbTipoViaje;
	private Controlador controlador = new Controlador();

	public nuevoViaje(Agencia agencia) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 700, 821);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreViaje = new JLabel("Nombre del viaje");
		lblNombreViaje.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombreViaje.setBounds(77, 84, 118, 14);
		contentPane.add(lblNombreViaje);
		
		textNombreViaje = new JTextField();
		textNombreViaje.setBounds(250, 82, 179, 20);
		contentPane.add(textNombreViaje);
		textNombreViaje.setColumns(10);
		
		JLabel lblTipoViaje = new JLabel("Tipo de viaje");
		lblTipoViaje.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTipoViaje.setBounds(77, 144, 118, 14);
		contentPane.add(lblTipoViaje);
		
		lblInicioViaje = new JLabel("Inicio del viaje");
		lblInicioViaje.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInicioViaje.setBounds(77, 207, 118, 14);
		contentPane.add(lblInicioViaje);
		
		lblFinViaje = new JLabel("Fin del viaje");
		lblFinViaje.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFinViaje.setBounds(77, 269, 118, 14);
		contentPane.add(lblFinViaje);
		
		lblDuracion = new JLabel("Duracion");
		lblDuracion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDuracion.setBounds(77, 332, 118, 14);
		contentPane.add(lblDuracion);
		
		lblPais = new JLabel("Pais");
		lblPais.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPais.setBounds(77, 398, 118, 14);
		contentPane.add(lblPais);
		
		lblDescrip = new JLabel("Descripcion");
		lblDescrip.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDescrip.setBounds(77, 467, 118, 14);
		contentPane.add(lblDescrip);
		
		JLabel lblServiciosNoInclu = new JLabel("Servicios no incl.");
		lblServiciosNoInclu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblServiciosNoInclu.setBounds(77, 631, 118, 14);
		contentPane.add(lblServiciosNoInclu);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCancelar.setBounds(442, 748, 89, 23);
		contentPane.add(btnCancelar);
		
		textDescrip = new JTextPane();
		textDescrip.setBounds(250, 440, 281, 103);
		contentPane.add(textDescrip);
		
		textServicios = new JTextPane();
		textServicios.setBounds(250, 604, 281, 96);
		contentPane.add(textServicios);
		
		cbPais = new JComboBox();
		cbPais.setModel(new DefaultComboBoxModel(new String[] {"",}));
		cbPais.setBounds(250, 395, 179, 22);
		contentPane.add(cbPais);
		
		dcInicioViaje = new JDateChooser();
		dcInicioViaje.setBounds(250, 207, 179, 20);
		contentPane.add(dcInicioViaje);
		
		dcFinViaje = new JDateChooser();
		dcFinViaje.setBounds(250, 269, 179, 20);
		contentPane.add(dcFinViaje);
		
		txtDuracion = new JTextField();
		txtDuracion.setBounds(250, 330, 179, 20);
		contentPane.add(txtDuracion);
		txtDuracion.setColumns(10);
		
		
		 /*LocalDate inicio = dcInicioViaje.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
         LocalDate fin = dcFinViaje.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
         long dias = ChronoUnit.DAYS.between(inicio, fin);
         
         txtDuracion.getDocument().addDocumentListener(new DocumentListener() {
             @Override
             public void insertUpdate(DocumentEvent e) {
            	 txtDuracion.setText(dias+"");
             }

             @Override
             public void removeUpdate(DocumentEvent e) {
            	 txtDuracion.setText(dias+"");
             }

             @Override
             public void changedUpdate(DocumentEvent e) {
            	 txtDuracion.setText(dias+"");
             }
         });
*/

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validarViaje(agencia);
				JOptionPane.showMessageDialog(null, "Viaje creado correctamente");
				MenuPrincipal menuPrincipal = new MenuPrincipal(agencia);
				 menuPrincipal.setVisible(true);
				 dispose();
				
			}
		});
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGuardar.setBounds(212, 749, 89, 23);
		contentPane.add(btnGuardar);

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal menuPrincipal = new MenuPrincipal(agencia);
				 menuPrincipal.setVisible(true);
				 dispose();
			}
		});
		
		
		llenarComboBoxPaises(cbPais);
		
		cbTipoViaje = new JComboBox();
		cbTipoViaje.setModel(new DefaultComboBoxModel(new String[] {"", "Novios", "Senior", "Grupos", "Grandes viajes", "Combinado", "Escapadas", "Familias con niños menores"}));
		cbTipoViaje.setBounds(250, 141, 179, 22);
		contentPane.add(cbTipoViaje);
	}
	
	
	
	public boolean validarViaje(Agencia agencia) {
		Viaje viaje = new Viaje();
		boolean valido=true;
		 String nombreViaje=textNombreViaje.getText();
		 String descripcion=textDescrip.getText();
		 String tipoViaje=cbTipoViaje.getSelectedItem()+"";
		 Date fechaIda = dcInicioViaje.getDate();
		 Date fechaVuelta= dcFinViaje.getDate();
		 String duracion = txtDuracion.getText();
		 String descripcionServicio = textServicios.getText();
		 String pais = cbPais.getSelectedItem()+"";
		 ArrayList<Pais>paises = new ArrayList<Pais>();
		 String fechaIda1;
		 String fechaVuelta1;
		 paises=controlador.mostrarPais();

			if(nombreViaje.length()<1 || nombreViaje.length()>25 == true) {
				JOptionPane.showMessageDialog(null, "Nombre incorrecto", "ERROR", JOptionPane.ERROR_MESSAGE);
				valido= false;
			}
			if(tipoViaje== "") {
				JOptionPane.showMessageDialog(null, "Tipo incorrecto", "ERROR", JOptionPane.ERROR_MESSAGE);
				valido= false;
			}
			if(descripcion.length()<1 || descripcion.length()>255 == true) {
				JOptionPane.showMessageDialog(null, "Descripcion incorrecta", "ERROR", JOptionPane.ERROR_MESSAGE);
				valido= false;
			}
			
			if(duracion.length()<1 || duracion.length()>25 == true) {
				JOptionPane.showMessageDialog(null, "Duracion incorrecta", "ERROR", JOptionPane.ERROR_MESSAGE);
				valido= false;
			}
	
			if(descripcionServicio.length()<1 || descripcionServicio.length()>255 == true) {
				JOptionPane.showMessageDialog(null, "Descripcion del servicio incorrecta", "ERROR", JOptionPane.ERROR_MESSAGE);
				valido= false;
			}
		
			  if (fechaIda == null || fechaVuelta == null) {
		            JOptionPane.showMessageDialog(null, "Debe seleccionar ambas fechas.", "ERROR", JOptionPane.ERROR_MESSAGE);
		            return false;
		        }

		        if (fechaIda.before(fechaIda)) {
		            JOptionPane.showMessageDialog(null, "La fecha de ida no puede ser en el pasado.", "ERROR", JOptionPane.ERROR_MESSAGE);
		            return false;
		        }

		        if (fechaVuelta.before(fechaIda)) {
		            JOptionPane.showMessageDialog(null, "La fecha de vuelta no puede ser antes de la fecha de ida.", "ERROR", JOptionPane.ERROR_MESSAGE);
		            return false;
		        }
		        
		        if (pais =="") {
		            JOptionPane.showMessageDialog(null, "SELECCIONE UN PAIS", "ERROR", JOptionPane.ERROR_MESSAGE);
		            return false;
		        }
		        if (valido == true) {
		        	fechaIda1=convertirFechaADatabaseFormat(fechaIda);
		        	fechaVuelta1=convertirFechaADatabaseFormat(fechaIda);
		    		viaje.setNombreViaje(nombreViaje);
		    		viaje.setDescripcion(descripcion);
		    		viaje.setTipoViaje(tipoViaje);
		    		viaje.setFechaIda(fechaIda1);
		    		viaje.setFechaVuelta(fechaVuelta1);
		    		viaje.setDuracion(duracion);
		    		viaje.setDescServicio(descripcionServicio);
		    		viaje.setAgencia(agencia);
		    		for(Pais pais2 : paises) {
		    			if(pais2.getDescripPais().equals(cbPais.getSelectedItem())) {
				    		viaje.setPais(pais2);
		    			}
		    		}
		    		controlador.crearViaje(viaje);
		    				    		}
	
		 return valido;
	}
	
	public  void llenarComboBoxPaises(JComboBox<String> cbPais) {
		cbPais.removeAllItems();
		Gestor gestorViajes = new Gestor();
		ArrayList<Pais> paises = gestorViajes.mostrarPais();
        for (Pais pais : paises) {
        	cbPais.addItem(pais.getDescripPais()); 
        }
    }
	
	private String convertirFechaADatabaseFormat(java.util.Date date) {
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.format(date);
        }
        return null; 
    }
}


