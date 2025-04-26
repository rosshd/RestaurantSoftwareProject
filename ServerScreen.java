import javax.swing.*;
import java.awt.*;

public class ServerScreen extends JFrame {
    public ServerScreen(String serverName) {
        setTitle("Server Home - " + serverName);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel label = new JLabel("Server Options:");
        JButton takeOrderBtn = new JButton("Take Order");
        JButton closeOrderBtn = new JButton("Close Order");

        add(label);
        add(takeOrderBtn);
        add(closeOrderBtn);


        takeOrderBtn.addActionListener(e -> JOptionPane.showMessageDialog(this, "Take Order screen coming soon."));
        closeOrderBtn.addActionListener(e -> JOptionPane.showMessageDialog(this, "Close Order screen coming soon."));

        setLocationRelativeTo(null);
        setVisible(true);
    }
}