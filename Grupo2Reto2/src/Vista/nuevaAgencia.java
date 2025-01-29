package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class nuevaAgencia extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					nuevaAgencia frame = new nuevaAgencia();
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
	public nuevaAgencia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 500, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreAgencia = new JLabel("Nombre Agencia");
		lblNombreAgencia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombreAgencia.setBounds(50, 65, 112, 14);
		contentPane.add(lblNombreAgencia);
		
		textField = new JTextField();
		textField.setBounds(172, 63, 178, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Color de marca");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(50, 122, 112, 14);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(172, 120, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNumeroEmp = new JLabel("Numero de empleados");
		lblNumeroEmp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNumeroEmp.setBounds(50, 187, 146, 14);
		contentPane.add(lblNumeroEmp);
		
		JComboBox cbNumeroEmpleado = new JComboBox();
		cbNumeroEmpleado.setBounds(206, 184, 144, 22);
		contentPane.add(cbNumeroEmpleado);
		
		JLabel lblTipoAgencia = new JLabel("Tipo de Agencia");
		lblTipoAgencia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTipoAgencia.setBounds(50, 261, 112, 14);
		contentPane.add(lblTipoAgencia);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(206, 258, 144, 22);
		contentPane.add(comboBox);
		
		JLabel lbLogo = new JLabel("Logo");
		lbLogo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbLogo.setBounds(50, 344, 86, 14);
		contentPane.add(lbLogo);
		
		textField_2 = new JTextField();
		textField_2.setBounds(172, 341, 178, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(50, 474, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCancelar.setBounds(261, 475, 89, 23);
		contentPane.add(btnCancelar);
		
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login loginWindow = new Login();
                loginWindow.setVisible(true);
			}
		});
	}

}
