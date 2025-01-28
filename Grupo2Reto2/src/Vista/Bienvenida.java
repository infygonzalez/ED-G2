package Vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Bienvenida extends JFrame {
    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Bienvenida frame = new Bienvenida();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Bienvenida() {
        // Configuración de la ventana principal
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1920, 1080);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null); // Usar layout null para posicionar manualmente
        setContentPane(contentPane);

        // Botón con imagen de fondo
        JButton btnNewButton = new JButton("");
        btnNewButton.setIcon(new ImageIcon(Bienvenida.class.getResource("/img/fondoJFrame.jpg")));
        btnNewButton.setBounds(0, 0, screenSize.width, screenSize.height);
        contentPane.add(btnNewButton);

        // Listener para abrir la ventana Login
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirVentanaLogin();
                dispose();
            }
        });
    }

    // Método para abrir la ventana Login
    private void abrirVentanaLogin() {
        Login loginWindow = new Login();
        loginWindow.setVisible(true);
    }
}
