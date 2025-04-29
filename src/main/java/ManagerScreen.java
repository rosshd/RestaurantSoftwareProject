import javax.swing.*;
import java.awt.*;

public class ManagerScreen extends JFrame {
    public ManagerScreen(String managerName) {
        setTitle("Manager Home - " + managerName);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        add(new JLabel("Manager Options:", SwingConstants.CENTER));
        add(new JButton("Modify Users"));
        add(new JButton("Modify Tables"));
        add(new JButton("View Reports"));

        setLocationRelativeTo(null);
        setVisible(true);
    }
}