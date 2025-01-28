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
      
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1920, 1080);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null); 
        setContentPane(contentPane);

     
        JButton btnNewButton = new JButton("");
        btnNewButton.setIcon(new ImageIcon(Bienvenida.class.getResource("/img/fondoJFrame.jpg")));
        btnNewButton.setBounds(0, 0, screenSize.width, screenSize.height);
        contentPane.add(btnNewButton);

       
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirVentanaLogin();
                dispose();
            }
        });
    }


    private void abrirVentanaLogin() {
        Login loginWindow = new Login();
        loginWindow.setVisible(true);
    }
}
