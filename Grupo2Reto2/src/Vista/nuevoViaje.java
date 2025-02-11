package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Modelo.Agencia;
import Modelo.Gestor;
import Modelo.Pais;
import Modelo.Viaje;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
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
import java.net.MalformedURLException;
import java.net.URL;
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
	private JPanel coloreablePanel;
	private Controlador controlador = new Controlador();

	public nuevoViaje(Agencia agencia) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 556, 740);
		contentPane = new JPanel() {
		    private Image backgroundImage = new ImageIcon(getClass().getResource("/img/nuevaagencia.jpg")).getImage();

	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
	        }
	    };

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreViaje = new JLabel("Nombre del viaje");
		lblNombreViaje.setForeground(new Color(255, 255, 255));
		lblNombreViaje.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		lblNombreViaje.setBounds(77, 108, 118, 27);
		contentPane.add(lblNombreViaje);
		
		textNombreViaje = new JTextField();
		textNombreViaje.setBounds(212, 108, 179, 20);
		contentPane.add(textNombreViaje);
		textNombreViaje.setColumns(10);
		
		JLabel lblTipoViaje = new JLabel("Tipo de viaje");
		lblTipoViaje.setForeground(new Color(255, 255, 255));
		lblTipoViaje.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		lblTipoViaje.setBounds(77, 146, 118, 38);
		contentPane.add(lblTipoViaje);
		
		lblInicioViaje = new JLabel("Inicio del viaje");
		lblInicioViaje.setForeground(new Color(255, 255, 255));
		lblInicioViaje.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		lblInicioViaje.setBounds(77, 191, 118, 36);
		contentPane.add(lblInicioViaje);
		
		lblFinViaje = new JLabel("Fin del viaje");
		lblFinViaje.setForeground(new Color(255, 255, 255));
		lblFinViaje.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		lblFinViaje.setBounds(77, 238, 118, 31);
		contentPane.add(lblFinViaje);
		
		lblDuracion = new JLabel("Duracion");
		lblDuracion.setForeground(new Color(255, 255, 255));
		lblDuracion.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		lblDuracion.setBounds(77, 280, 118, 36);
		contentPane.add(lblDuracion);
		
		lblPais = new JLabel("Pais");
		lblPais.setForeground(new Color(255, 255, 255));
		lblPais.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		lblPais.setBounds(77, 327, 118, 38);
		contentPane.add(lblPais);
		
		lblDescrip = new JLabel("Descripcion");
		lblDescrip.setForeground(new Color(255, 255, 255));
		lblDescrip.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		lblDescrip.setBounds(77, 376, 118, 41);
		contentPane.add(lblDescrip);
		
		JLabel lblServiciosNoInclu = new JLabel("Servicios no incl.");
		lblServiciosNoInclu.setForeground(new Color(255, 255, 255));
		lblServiciosNoInclu.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		lblServiciosNoInclu.setBounds(77, 499, 118, 41);
		contentPane.add(lblServiciosNoInclu);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		btnCancelar.setBackground(new Color(0, 0, 0, 100));
		btnCancelar.setOpaque(false);
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setBorder(null);
		btnCancelar.setBorder(new LineBorder(new Color(255, 255, 255, 255), 3, true));
		btnCancelar.setBounds(391, 638, 102, 38);
		contentPane.add(btnCancelar);
		
		textDescrip = new JTextPane();
		textDescrip.setBounds(212, 376, 281, 103);
		contentPane.add(textDescrip);
		
		textServicios = new JTextPane();
		textServicios.setBounds(212, 499, 281, 96);
		contentPane.add(textServicios);
		
		cbPais = new JComboBox();
		cbPais.setModel(new DefaultComboBoxModel(new String[] {"",}));
		cbPais.setBounds(212, 332, 179, 22);
		contentPane.add(cbPais);
		
		dcInicioViaje = new JDateChooser();
		dcInicioViaje.setBounds(212, 195, 179, 20);
		contentPane.add(dcInicioViaje);
		
		dcFinViaje = new JDateChooser();
		dcFinViaje.setBounds(212, 238, 179, 20);
		contentPane.add(dcFinViaje);
		
		txtDuracion = new JTextField();
		txtDuracion.setBounds(212, 285, 179, 20);
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
		btnGuardar.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		btnGuardar.setBackground(new Color(0, 0, 0, 100));
		btnGuardar.setOpaque(false);
		btnGuardar.setForeground(new Color(255, 255, 255));
		btnGuardar.setBorder(null);
		btnGuardar.setBorder(new LineBorder(new Color(255, 255, 255, 255), 3, true));
		btnGuardar.setBounds(77, 638, 102, 38);
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
		cbTipoViaje.setBounds(212, 151, 179, 22);
		contentPane.add(cbTipoViaje);
		
		coloreablePanel = new JPanel();
		coloreablePanel.setBounds(0, 0, 540, 60);
		contentPane.add(coloreablePanel);
		coloreablePanel.setLayout(null);
		coloreablePanel.setBackground(rellenarColor(agencia));
		
		String logoUrl = agencia.getLogo();
        URL imgUrl = null;
        try {
            imgUrl = new URL(logoUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        
		ImageIcon image = new ImageIcon(imgUrl);
        Image img = image.getImage();  
        Image resizedImg = img.getScaledInstance(55, 55, Image.SCALE_SMOOTH);
        
        JLabel lblLogo = new JLabel(new ImageIcon(resizedImg));  
		lblLogo.setBounds(0, 0, 60, 60);
        coloreablePanel.add(lblLogo);

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
	public void llenarComboBoxPaises(JComboBox<String> cbPais) {
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
	public Color rellenarColor(Agencia agencia) {
		String colorMarca = agencia.getColorMarca();
		try {
			return Color.decode(colorMarca);
		} catch (NumberFormatException e) {
			return Color.BLACK; 
		}
	}
}


