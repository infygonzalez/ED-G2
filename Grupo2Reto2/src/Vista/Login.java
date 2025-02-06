package Vista;

import java.awt.EventQueue;

import Modelo.Agencia;
import Modelo.GestorAgencia;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Controlador.Controlador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField textClave;
	private Controlador controlador=new Controlador();

	
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 778, 514);
		contentPane = new JPanel() {
	    private Image backgroundImage = new ImageIcon(getClass().getResource("/img/fondologin.jpg")).getImage();

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    };
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 113, 762, 225);
		contentPane.add(panel);
				panel.setLayout(null);
		
		
				
				JLabel lblUsuario = new JLabel("Introduce el usuario:");
				lblUsuario.setBackground(new Color(0, 0, 0));
				lblUsuario.setBounds(141, 63, 207, 36);
				panel.add(lblUsuario);
				lblUsuario.setForeground(new Color(0, 0, 0));
				lblUsuario.setFont(new Font("Yu Gothic", Font.PLAIN, 22));
				
				JLabel lblClave = new JLabel("Introduce la contraseña:");
				lblClave.setBounds(138, 110, 277, 46);
				panel.add(lblClave);
				lblClave.setForeground(new Color(0, 0, 0));
				lblClave.setFont(new Font("Yu Gothic", Font.PLAIN, 22));
				
				txtUsuario = new JTextField();
				txtUsuario.setBounds(392, 69, 125, 20);
				panel.add(txtUsuario);
				txtUsuario.setColumns(10);
				txtUsuario.setBackground(new Color(0, 0, 0, 100));  
				txtUsuario.setOpaque(false);  
				txtUsuario.setForeground(new Color(0, 0, 0));  
				txtUsuario.setBorder(null);  
				txtUsuario.setBorder(new LineBorder(new Color(0 , 0 , 0, 150 ), 2, true));
				
						
						textClave = new JTextField();
						textClave.setBounds(392, 121, 125, 20);
						panel.add(textClave);
						textClave.setColumns(10);
						textClave.setBackground(new Color(0, 0, 0, 100));
						textClave.setOpaque(false);  
						textClave.setForeground(new Color(0, 0, 0));  
						textClave.setBorder(null);  
						textClave.setBorder(new LineBorder(new Color(0 , 0 , 0, 150 ), 2, true));
						
						JButton btnIniciarSesion = new JButton("Iniciar Sesion");
						btnIniciarSesion.setBounds(191, 164, 135, 46);
						panel.add(btnIniciarSesion);
						btnIniciarSesion.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
						btnIniciarSesion.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
						         if (txtUsuario.getText().equals("") && textClave.getText().equals("")) {
	                    JOptionPane.showMessageDialog(null, "Nombre de agencia y contraseña incorrectos.", "Error",
	                            JOptionPane.ERROR_MESSAGE);

	                } else if (txtUsuario.getText().equals("")) {
	                    JOptionPane.showMessageDialog(null, "Nombre de agencia incorrecto.", "Error",
	                            JOptionPane.ERROR_MESSAGE);
	                } else if (textClave.getText().equals("")) {
	                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta.", "Error", JOptionPane.ERROR_MESSAGE);
	                } else {
	                    Agencia agenciaLogin = controlador.login(txtUsuario.getText(), textClave.getText());
	                    if (agenciaLogin == null) {
	                        JOptionPane.showMessageDialog(null, "Nombre de agencia y contraseña incorrectos.", "Error",
	                                JOptionPane.ERROR_MESSAGE);
	                    } else {
	                        MenuPrincipal ventana = new MenuPrincipal(agenciaLogin);
	                        ventana.setVisible(true);
	                        dispose();
	                    }
	                }
							}
						});
						btnIniciarSesion.setBackground(new Color(0, 0, 0, 100));
						btnIniciarSesion.setOpaque(false);  
						btnIniciarSesion.setForeground(new Color(0, 0, 0));  
						btnIniciarSesion.setBorder(null);  
						btnIniciarSesion.setBorder(new LineBorder(new Color(0 , 0 , 0, 150 ), 2, true));
						
						JButton btnNuevaAgencia = new JButton("Nueva agencia");
						btnNuevaAgencia.setBounds(336, 164, 141, 46);
						panel.add(btnNuevaAgencia);
						btnNuevaAgencia.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
						btnNuevaAgencia.setBackground(new Color(0, 0, 0, 100));
						btnNuevaAgencia.setOpaque(false);  
						btnNuevaAgencia.setForeground(new Color(0, 0, 0));  
						btnNuevaAgencia.setBorder(null);  
						btnNuevaAgencia.setBorder(new LineBorder(new Color(0 , 0 , 0, 150 ), 2, true));
						btnNuevaAgencia.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								 dispose();
								nuevaAgencia nuevaAgencia = new nuevaAgencia();
								 nuevaAgencia.setVisible(true);
								
								
							}
						});
		
		
		
		
		
	
		
		
	}
}
