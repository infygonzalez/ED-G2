package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Controlador.Controlador;
import Modelo.Agencia;
import Modelo.Gestor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.Color;

public class nuevaAgencia extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtAgencia;
	private JTextField txtColorMarca;
	private JTextField txtLogo;
	private JTextField txtClave;
	private JComboBox cbTipoAgencia;
	private JComboBox cbNumeroEmpleados;
	private Controlador controlador=new Controlador();
	private JPanel pColor;

	


	public nuevaAgencia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 433, 600);
		contentPane = new JPanel() {
		 protected void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        Image backgroundImage = new ImageIcon(getClass().getResource("/img/nuevaagencia.jpg")).getImage();
		        g.drawImage(backgroundImage, 0, 0, this); 
		    }
		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreAgencia = new JLabel("Nombre Agencia");
		lblNombreAgencia.setForeground(new Color(255, 255, 255));
		lblNombreAgencia.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		lblNombreAgencia.setBounds(50, 65, 112, 22);
		contentPane.add(lblNombreAgencia);
		
		txtAgencia = new JTextField();
		txtAgencia.setBounds(172, 63, 178, 20);
		contentPane.add(txtAgencia);
		txtAgencia.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Color de marca");
		lblNewLabel.setForeground(new Color(255, 255, 255));

        
       
       
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		lblNewLabel.setBounds(50, 122, 112, 22);
		contentPane.add(lblNewLabel);
		
		txtColorMarca = new JTextField();
		txtColorMarca.setBounds(172, 120, 86, 20);
		contentPane.add(txtColorMarca);
		txtColorMarca.setColumns(10);
		
		
		JLabel lblNumeroEmp = new JLabel("Numero de empleados");
		lblNumeroEmp.setForeground(new Color(255, 255, 255));
		lblNumeroEmp.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		lblNumeroEmp.setBounds(50, 179, 146, 22);
		contentPane.add(lblNumeroEmp);
		
		cbNumeroEmpleados = new JComboBox();
		cbNumeroEmpleados.setModel(new DefaultComboBoxModel(new String[] {"", "Entre 2 y 10 empleados", "Entre 10 y 100 empleados", "Entre 100 y 1000 empleados"}));
		cbNumeroEmpleados.setBounds(206, 184, 144, 22);
		contentPane.add(cbNumeroEmpleados);
		
		JLabel lblTipoAgencia = new JLabel("Tipo de Agencia");
		lblTipoAgencia.setForeground(new Color(255, 255, 255));
		lblTipoAgencia.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		lblTipoAgencia.setBounds(50, 236, 112, 33);
		contentPane.add(lblTipoAgencia);
		
		cbTipoAgencia = new JComboBox();
		cbTipoAgencia.setModel(new DefaultComboBoxModel(new String[] {"", "Mayorista", "Minorista", "Mayorista-Minorista"}));
		cbTipoAgencia.setBounds(206, 238, 144, 22);
		contentPane.add(cbTipoAgencia);
		
		JLabel lbLogo = new JLabel("Logo");
		lbLogo.setForeground(new Color(255, 255, 255));
		lbLogo.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		lbLogo.setBounds(50, 280, 86, 33);
		contentPane.add(lbLogo);
		
		txtLogo = new JTextField();
		txtLogo.setBounds(172, 283, 178, 20);
		contentPane.add(txtLogo);
		txtLogo.setColumns(10);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		btnNewButton.setBounds(224, 433, 146, 55);
		btnNewButton.setBackground(new Color(0, 0, 0, 100));
		btnNewButton.setOpaque(false);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBorder(null);
		btnNewButton.setBorder(new LineBorder(new Color(255, 255, 255, 255), 3, true));
		contentPane.add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		btnCancelar.setBounds(50, 433, 138, 55);
		btnCancelar.setBackground(new Color(0, 0, 0, 100));
		btnCancelar.setOpaque(false);
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setBorder(null);
		btnCancelar.setBorder(new LineBorder(new Color(255, 255, 255, 255), 3, true));
		contentPane.add(btnCancelar);
		
		pColor = new JPanel();
		pColor.setBackground(new Color(255, 255, 255));
		pColor.setBounds(317, 122, 33, 20);
		contentPane.add(pColor);
		
		JLabel lblClave = new JLabel("Introduce la clave");
		lblClave.setForeground(new Color(255, 255, 255));
		lblClave.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		lblClave.setBounds(50, 324, 112, 33);
		contentPane.add(lblClave);
		
		txtClave = new JTextField();
		txtClave.setBounds(264, 327, 86, 20);
		contentPane.add(txtClave);
		txtClave.setColumns(10);

		txtColorMarca.getDocument().addDocumentListener(new DocumentListener() {
	            @Override
	            public void insertUpdate(DocumentEvent e) {
	                actualizarColor();
	            }

	            @Override
	            public void removeUpdate(DocumentEvent e) {
	                actualizarColor();
	            }

	            @Override
	            public void changedUpdate(DocumentEvent e) {
	                actualizarColor();
	            }
	            
	            private void actualizarColor() {
	                String hexColor = txtColorMarca.getText().trim();

	                    try { 
	                    	pColor.setBackground(Color.decode(hexColor));
	                    } catch (Exception ex) {
	                       
	                    	pColor.setBackground(Color.WHITE);
	                    }
	            }
	        });
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login loginWindow = new Login();
                loginWindow.setVisible(true);
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validarAgencia()==true) {
				JOptionPane.showMessageDialog(null, "Agencia correctamente creada");
				dispose();
				Login loginWindow = new Login();
                loginWindow.setVisible(true);
				}
			}
		});
	}
	public boolean validarAgencia() {
		Agencia agencia= new Agencia();
		boolean valido=true;
		String nombre = txtAgencia.getText();
		String color = txtColorMarca.getText();
		String empleados = cbNumeroEmpleados.getSelectedItem()+"";
		String tipo = cbTipoAgencia.getSelectedItem()+"";
		String logo = txtLogo.getText();
		String clave = txtClave.getText();
		
		if(nombre.length()<1 || nombre.length()>25 == true) {
			JOptionPane.showMessageDialog(null, "Nombre incorrecto", "ERROR", JOptionPane.ERROR_MESSAGE);
			valido= false;
		}
		if(color.length()!= 7) {
			JOptionPane.showMessageDialog(null, "Color incorrecto", "ERROR", JOptionPane.ERROR_MESSAGE);
			valido= false;
		}
		if(empleados.length()==0) {
			JOptionPane.showMessageDialog(null, "Opción de número de empleados incorrecta", "ERROR", JOptionPane.ERROR_MESSAGE);
			valido= false;
		}
		if(tipo.length()==0) {
			JOptionPane.showMessageDialog(null, "Tipo de agencia incorrecta", "ERROR", JOptionPane.ERROR_MESSAGE);
			valido= false;
		}
		if(logo.length()<1 || nombre.length()>1000 == true) {
			JOptionPane.showMessageDialog(null, "Fallo en URL del logo", "ERROR", JOptionPane.ERROR_MESSAGE);
			valido= false;
		}
		if(clave.length()<1 || nombre.length()>24 == true) {
			JOptionPane.showMessageDialog(null, "Clave fuera de límites (24 carácteres)", "ERROR", JOptionPane.ERROR_MESSAGE);
			valido= false;
		}
		if (valido == true) {
		agencia.setNombre(nombre);
		agencia.setColorMarca(color);
		agencia.setNumeroEmpleados(empleados);
		agencia.setTipoAgencia(tipo);
		agencia.setLogo(logo);
		agencia.setClave(clave);
		controlador.crearAgencia(agencia);
		}

		return valido;
		
	}
	
	
	
}
