package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class nuevoViaje extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombreViaje;
	private JComboBox comboBox;
	private JLabel lblInicioViaje;
	private JLabel lblFinViaje;
	private JLabel lblDuracion;
	private JLabel lblPais;
	private JLabel lblDescrip;
	private JTextPane textDescrip;
	private JTextPane textServicios;
	private JLabel lblErrorNombre;
	private JLabel lblErrorDescrip;
	private JLabel lblErrorServ;
	private JLabel lblErrorNombre_4;

	public nuevoViaje() {
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
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Simple"}));
		comboBox.setToolTipText("\r\n");
		comboBox.setBounds(250, 141, 179, 22);
		contentPane.add(comboBox);
		
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
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGuardar.setBounds(501, 748, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCancelar.setBounds(171, 748, 89, 23);
		contentPane.add(btnCancelar);
		
		textDescrip = new JTextPane();
		textDescrip.setBounds(250, 440, 281, 103);
		contentPane.add(textDescrip);
		
		textServicios = new JTextPane();
		textServicios.setBounds(250, 604, 281, 96);
		contentPane.add(textServicios);
		
		lblErrorNombre = new JLabel("Nombre no valido");
		lblErrorNombre.setForeground(new Color(255, 0, 0));
		lblErrorNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblErrorNombre.setBounds(501, 85, 137, 14);
		contentPane.add(lblErrorNombre);
		lblErrorNombre.setVisible(false);
		
		lblErrorDescrip = new JLabel("Demasiado largo");
		lblErrorDescrip.setForeground(Color.RED);
		lblErrorDescrip.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblErrorDescrip.setBounds(541, 484, 137, 14);
		contentPane.add(lblErrorDescrip);
		lblErrorDescrip.setVisible(false);
		
		lblErrorServ = new JLabel("Demasido largo");
		lblErrorServ.setForeground(Color.RED);
		lblErrorServ.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblErrorServ.setBounds(541, 648, 137, 14);
		contentPane.add(lblErrorServ);
		lblErrorServ.setVisible(false);
		
		lblErrorNombre_4 = new JLabel("Nombre no valido");
		lblErrorNombre_4.setForeground(Color.RED);
		lblErrorNombre_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblErrorNombre_4.setBounds(501, 270, 137, 14);
		contentPane.add(lblErrorNombre_4);
		lblErrorNombre_4.setVisible(false);

		
		
		
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validacionTexto(textDescrip.getText(),255)==false && 
						validacionTexto(textServicios.getText(),255)==false &&
						validacionTexto(textNombreViaje.getText(),70)) {
					
				}
				
			}
		});
		
		
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal menuPrincipal = new MenuPrincipal(agencia);
				 menuPrincipal.setVisible(true);
				 dispose();
			}
		});
	}
	
	public boolean validacionTexto(String texto, int numeroCaracteres) {
	    if (texto.length() > numeroCaracteres) {
	        lblErrorDescrip.setVisible(true);
	        return false;
	    } else {
	        return true;
	    }
		}
}

