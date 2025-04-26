package com.restaurant.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private JPanel mainPanel;
    private JButton orderButton;
    private JButton menuButton;
    private JLabel titleLabel;

    public GUI() {
        setTitle("Restaurant App");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();

        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showOrderGUI();
            }
        });

        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMenu();
            }
        });
    }

    private void showOrderGUI() {
        JOptionPane.showMessageDialog(this, "Order window is now open.");
    }

    private void showMenu() {
        JOptionPane.showMessageDialog(this, "Menu window is now open.");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
}