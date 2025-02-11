package Vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controlador.Controlador;
import Modelo.Agencia;

public class nuevaAgencia extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtAgencia, txtColorMarca, txtLogo, txtClave;
    private JComboBox<String> cbTipoAgencia, cbNumeroEmpleados;
    private Controlador controlador = new Controlador();
    private JPanel pColor;

    public nuevaAgencia() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 500, 600);
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

        agregarComponentes();
    }

    private void agregarComponentes() {
        JLabel lblNombreAgencia = new JLabel("Nombre Agencia");
        configurarLabel(lblNombreAgencia, 50, 65);
        contentPane.add(lblNombreAgencia);

        txtAgencia = new JTextField();
        configurarTextField(txtAgencia, 172, 63);
        contentPane.add(txtAgencia);

        JLabel lblColorMarca = new JLabel("Color de marca");
        configurarLabel(lblColorMarca, 50, 122);
        contentPane.add(lblColorMarca);

        txtColorMarca = new JTextField();
        configurarTextField(txtColorMarca, 172, 120);
        contentPane.add(txtColorMarca);

        pColor = new JPanel();
        pColor.setBackground(Color.WHITE);
        pColor.setBounds(360, 120, 33, 20);
        contentPane.add(pColor);

        JLabel lblNumeroEmp = new JLabel("Número de empleados");
        configurarLabel(lblNumeroEmp, 50, 187);
        contentPane.add(lblNumeroEmp);

        cbNumeroEmpleados = new JComboBox<>(new String[]{"", "Entre 2 y 10 empleados", "Entre 10 y 100 empleados", "Entre 100 y 1000 empleados"});
        cbNumeroEmpleados.setBounds(206, 184, 144, 22);
        contentPane.add(cbNumeroEmpleados);

        JLabel lblTipoAgencia = new JLabel("Tipo de Agencia");
        configurarLabel(lblTipoAgencia, 50, 261);
        contentPane.add(lblTipoAgencia);

        cbTipoAgencia = new JComboBox<>(new String[]{"", "Mayorista", "Minorista", "Mayorista-Minorista"});
        cbTipoAgencia.setBounds(206, 258, 144, 22);
        contentPane.add(cbTipoAgencia);

        JLabel lblLogo = new JLabel("Logo");
        configurarLabel(lblLogo, 50, 344);
        contentPane.add(lblLogo);

        txtLogo = new JTextField();
        configurarTextField(txtLogo, 172, 341);
        contentPane.add(txtLogo);

        JLabel lblClave = new JLabel("Introduce la clave");
        configurarLabel(lblClave, 50, 409);
        contentPane.add(lblClave);

        txtClave = new JTextField();
        configurarTextField(txtClave, 172, 406);
        contentPane.add(txtClave);

        JButton btnGuardar = crearBoton("Guardar", 293, 459);
        btnGuardar.addActionListener(e -> guardarAgencia());
        contentPane.add(btnGuardar);

        JButton btnCancelar = crearBoton("Cancelar", 50, 459);
        btnCancelar.addActionListener(e -> cancelar());
        contentPane.add(btnCancelar);

        txtColorMarca.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { actualizarColor(); }
            @Override
            public void removeUpdate(DocumentEvent e) { actualizarColor(); }
            @Override
            public void changedUpdate(DocumentEvent e) { actualizarColor(); }
        });
    }

    private void configurarLabel(JLabel label, int x, int y) {
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Yu Gothic", Font.BOLD, 13));
        label.setBounds(x, y, 150, 22);
    }

    private void configurarTextField(JTextField textField, int x, int y) {
        textField.setBounds(x, y, 178, 20);
        textField.setColumns(10);
    }

    private JButton crearBoton(String texto, int x, int y) {
        JButton button = new JButton(texto);
        button.setFont(new Font("Yu Gothic", Font.BOLD, 16));
        button.setBounds(x, y, 100, 33);
        button.setBackground(new Color(0, 0, 0, 100));
        button.setOpaque(false);
        button.setForeground(Color.WHITE);
        button.setBorder(new LineBorder(Color.WHITE, 3, true));
        return button;
    }

    private void actualizarColor() {
        try {
            pColor.setBackground(Color.decode(txtColorMarca.getText().trim()));
        } catch (Exception e) {
            pColor.setBackground(Color.WHITE);
        }
    }

    private void cancelar() {
        dispose();
        new Login().setVisible(true);
    }

    private void guardarAgencia() {
        if (validarAgencia()) {
            JOptionPane.showMessageDialog(null, "Agencia correctamente creada");
            cancelar();
        }
    }

    private boolean validarAgencia() {
        Agencia agencia = new Agencia();
        boolean valido = true;

        String nombre = txtAgencia.getText().trim();
        String color = txtColorMarca.getText().trim();
        String empleados = cbNumeroEmpleados.getSelectedItem().toString();
        String tipo = cbTipoAgencia.getSelectedItem().toString();
        String logo = txtLogo.getText().trim();
        String clave = txtClave.getText().trim();

        if (nombre.isEmpty() || nombre.length() > 25) valido = mostrarError("Nombre incorrecto");
        if (color.length() != 7) valido = mostrarError("Color incorrecto");
        if (empleados.isEmpty()) valido = mostrarError("Número de empleados incorrecto");
        if (tipo.isEmpty()) valido = mostrarError("Tipo de agencia incorrecto");
        if (logo.isEmpty() || logo.length() > 1000) valido = mostrarError("URL de logo incorrecta");
        if (clave.isEmpty() || clave.length() > 24) valido = mostrarError("Clave fuera de límites");

        if (valido) {
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

    private boolean mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
        return false;
    }
}
