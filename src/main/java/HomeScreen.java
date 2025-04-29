import javax.swing.*;
import java.awt.*;

public class HomeScreen {
    public HomeScreen(Worker worker, RestaurantSystem system) {
        JFrame frame = new JFrame(worker.getRole() + " Home");
        JLabel label = new JLabel("Welcome, " + worker.getName());
        JPanel panel = new JPanel();
        panel.add(label);
        frame.add(panel);
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}