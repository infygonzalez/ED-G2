package Vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
        setBounds(0, 0, 1080, 600);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Pulse para continuar");
        lblNewLabel.setBounds(293, 230, 434, 198);
        lblNewLabel.setForeground(new Color(0, 0, 0));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 40));
        contentPane.add(lblNewLabel);
        
        ImageIcon image = new ImageIcon(getClass().getResource("/img/fondoBienvenida.jpeg"));
        
        JLabel lblNewLabel_1 = new JLabel( new ImageIcon(image.getImage().getScaledInstance(1080, 600, Image.SCALE_DEFAULT)));
        lblNewLabel_1.setBounds(0, 0, 1080, 600);
        lblNewLabel_1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		Login loginWindow = new Login();
                loginWindow.setVisible(true);
        		dispose();
        		
        	}
        });
        contentPane.add(lblNewLabel_1);
       
    }


    private void abrirVentanaLogin() {
        Login loginWindow = new Login();
        loginWindow.setVisible(true);
    }
}
