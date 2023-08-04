package ui;

import javax.swing.*;
import java.awt.*;

public class CalorieAppUI extends JFrame {
    private JPanel mainPanel;

    public CalorieAppUI() {
        super("Calorie Tracker & Calculator");
    }

    public void createGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        mainPanel  = createMainPanel();
        mainPanelGreet();

    }

    // MODIFIES: this
    // EFFECTS: creates the main panel of the program
    private JPanel createMainPanel() {
        JPanel mp = new JPanel();
        mp.setBackground(Color.decode("#d3ede1"));
        mp.setBorder(BorderFactory.createLineBorder(Color.black));
        mp.setLayout(new GridLayout(0, 1, 0, 20));
        return mp;
    }

    private void mainPanelGreet() {
        JLabel greeting = new JLabel("Welcome!");
        JLabel description = new JLabel("Estimate the number of calorie to help achieve your fitness goal.");

        JPanel greetingPanel = new JPanel();
        greetingPanel.setLayout(new BorderLayout());
    }

    public static void main(String[] args) {
        new CalorieAppUI();
    }
}