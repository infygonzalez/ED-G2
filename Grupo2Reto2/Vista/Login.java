package Vista;

import java.awt.EventQueue;

import Modelo.Agencia;
import Modelo.GestorAgencia;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField textClave;
	private Controlador controlador=new Controlador();

	
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(252, 109, 125, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		textClave = new JTextField();
		textClave.setBounds(252, 152, 125, 20);
		contentPane.add(textClave);
		textClave.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Introduce el usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsuario.setBounds(74, 112, 157, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblClave = new JLabel("Introduce la contraseña:");
		lblClave.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblClave.setBounds(54, 152, 177, 14);
		contentPane.add(lblClave);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.setBounds(90, 212, 105, 23);
		contentPane.add(btnIniciarSesion);
		
		JButton btnNuevaAgencia = new JButton("Nueva agencia");
		btnNuevaAgencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 dispose();
				nuevaAgencia nuevaAgencia = new nuevaAgencia();
				 nuevaAgencia.setVisible(true);
				
				
			}
		});
		btnNuevaAgencia.setBounds(233, 212, 105, 23);
		contentPane.add(btnNuevaAgencia);
		
		JLabel lblError = new JLabel("Usuario o Contraseña equivocada");
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setBounds(120, 187, 217, 14);
		contentPane.add(lblError);
		lblError.setVisible(false);
		
		
		
		
		
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
		
		
	}
}
