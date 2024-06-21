import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    private JLabel labelNombre;
    private JTextField textFieldNombre;
    private JLabel labelContraseña;
    private JPasswordField passwordField;
    private JButton btnOk;
    private JButton btnBorrar;
    private JPanel panel1;
    private JTextField textField2;

    public LoginForm() {
        initComponents();
        setupListeners();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Login");

        // Configurar componentes
        labelNombre = new JLabel("Nombre:");
        textFieldNombre = new JTextField(20);

        labelContraseña = new JLabel("Contraseña:");
        passwordField = new JPasswordField(20);

        btnOk = new JButton("OK");
        btnBorrar = new JButton("BORRAR");


        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);


        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(labelNombre, constraints);

        constraints.gridx = 1;
        panel.add(textFieldNombre, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(labelContraseña, constraints);

        constraints.gridx = 1;
        panel.add(passwordField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(btnOk, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(btnBorrar, constraints);


        add(panel);

        pack();
        setLocationRelativeTo(null);
    }

    private void setupListeners() {
        // Listener para el botón OK
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = textFieldNombre.getText();
                String contraseña = new String(passwordField.getPassword());


                if (nombre.equals("Christian") && contraseña.equals("Holiwi")) {
                    JOptionPane.showMessageDialog(LoginForm.this, "Inicio de sesión exitoso", "Login", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(LoginForm.this, "Nombre de usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Listener para el botón BORRAR
        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldNombre.setText("");
                passwordField.setText("");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginForm loginForm = new LoginForm();
            loginForm.setVisible(true);
        });
    }
}
