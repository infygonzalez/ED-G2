package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
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
	private JTextField textContraseña;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
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
		
		textContraseña = new JTextField();
		textContraseña.setBounds(252, 152, 125, 20);
		contentPane.add(textContraseña);
		textContraseña.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Introduce el usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsuario.setBounds(74, 112, 157, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContraseña = new JLabel("Introduce la contraseña:");
		lblContraseña.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblContraseña.setBounds(54, 152, 177, 14);
		contentPane.add(lblContraseña);
		
		JButton btnNewButton = new JButton("Iniciar Sesion");
		btnNewButton.setBounds(90, 212, 105, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNuevaAgencia = new JButton("Nueva agencia");
		btnNuevaAgencia.setBounds(233, 212, 105, 23);
		contentPane.add(btnNuevaAgencia);
		
		JLabel lblError = new JLabel("Usuario o Contraseña equivocada");
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setBounds(113, 187, 225, 14);
		contentPane.add(lblError);
		lblError.setVisible(false);
		
		
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtUsuario.getText().equals("admin")&& textContraseña.getText().equals("admin")) {
					
				}
				else{
					lblError.setVisible(true);
					txtUsuario.setText("");
					textContraseña.setText("");
					
				}
			}});
		
		
	}
}
