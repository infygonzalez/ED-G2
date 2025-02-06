package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Agencia;
import Modelo.GestorViajes;
import Modelo.Pais;
import Modelo.Viaje;
import Controlador.Controlador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;

import Controlador.Controlador;

public class nuevoViaje extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombreViaje;
	private JComboBox cbTipoViaje;
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
		
		cbTipoViaje = new JComboBox();
		cbTipoViaje.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbTipoViaje.setModel(new DefaultComboBoxModel(new String[] {"Simple"}));
		cbTipoViaje.setToolTipText("\r\n");
		cbTipoViaje.setBounds(250, 141, 179, 22);
		contentPane.add(cbTipoViaje);
		
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
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validarViaje();
				System.out.println();
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
	}
	
	
	
	public boolean validarViaje() {
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
		 

			if(nombreViaje.length()<1 || nombreViaje.length()>25 == true) {
				JOptionPane.showMessageDialog(null, "Nombre incorrecto", "ERROR", JOptionPane.ERROR_MESSAGE);
				valido= false;
			}
			if(tipoViaje!= null) {
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
				JOptionPane.showMessageDialog(null, "Descripcion incorrecta", "ERROR", JOptionPane.ERROR_MESSAGE);
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
		        
	
		 return valido;
	}
	
	public  void llenarComboBoxPaises(JComboBox<String> cbPais) {
		cbPais.removeAllItems();
		GestorViajes gestorViajes = new GestorViajes();
		ArrayList<Pais> paises = gestorViajes.mostrarPais();
        for (Pais pais : paises) {
        	cbPais.addItem(pais.getDescripPais()); 
        }
    }
	
	
		}



