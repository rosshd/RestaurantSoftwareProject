import javax.swing.*;
import java.awt.*;

public class ClockInScreen extends JFrame {
    private String role;
    private String name;
    private int workerId;

    public ClockInScreen(String role, String name, int workerId) {
        this.role = role;
        this.name = name;
        this.workerId = workerId;

        setTitle("Clock In - " + role);
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel greeting = new JLabel("Welcome, " + name + " (" + role + ")", SwingConstants.CENTER);
        add(greeting, BorderLayout.CENTER);

        JButton clockInButton = new JButton("Clock In");
        add(clockInButton, BorderLayout.SOUTH);

        clockInButton.addActionListener(e -> launchRoleScreen());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void launchRoleScreen() {
        dispose();
        switch (role) {
            case "Server":
                new ServerScreen(name);
                break;
            case "Manager":
                new ManagerScreen(name);
                break;

            default:
                JOptionPane.showMessageDialog(this, "No screen for role: " + role);
        }
    }
}