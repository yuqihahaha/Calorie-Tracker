package ui;

import javax.swing.*;
import java.awt.*;

// Represents the panel in which the greeting is displayed.
public class GreetingPanel extends JPanel {

    // EFFECTS: sets the background color and draws the initial labels
    public GreetingPanel() {
        setBackground(Color.WHITE);

        JLabel greeting = new JLabel("Welcome, " + System.getProperty("user.name") + "!");
        JLabel description = new JLabel("Estimate your total daily Calorie and achieve your fitness goal.");


        greeting.setBounds(300, 300, 200, 70);
        greeting.setForeground(Color.decode("#84a5b8"));
        greeting.setFont((new Font("TimesRoman", Font.BOLD, 22)));
        add(greeting, BorderLayout.NORTH);

        description.setFont((new Font("TimesRoman", Font.BOLD, 12)));
        description.setForeground(Color.decode("#466d82"));
        add(Box.createHorizontalStrut(5));
        add(description, BorderLayout.SOUTH);
    }
}
