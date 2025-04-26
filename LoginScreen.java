import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginScreen extends JFrame {
    private JTextField idField;
    private JButton loginButton;

    public LoginScreen() {
        setTitle("Restaurant System - Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));

        JLabel label = new JLabel("Enter Worker ID:", SwingConstants.CENTER);
        add(label);

        idField = new JTextField();
        add(idField);

        loginButton = new JButton("Login");
        add(loginButton);

        loginButton.addActionListener(e -> handleLogin());

        setLocationRelativeTo(null); // center on screen
        setVisible(true);
    }

    private void handleLogin() {
        String idText = idField.getText();
        try {
            int workerId = Integer.parseInt(idText);
            // Dummy login logic for now — expand later
            if (workerId == 1001) {
                new ClockInScreen("Server", "Anna", workerId);
            } else if (workerId == 2001) {
                new ClockInScreen("Manager", "Ross", workerId);
            } else {
                JOptionPane.showMessageDialog(this, "Worker not found.");
            }
            dispose(); // Close login screen
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid ID format.");
        }
    }
}