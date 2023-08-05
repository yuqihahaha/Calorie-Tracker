package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalorieAppUI extends JFrame implements ActionListener {
    private MainPanel mp;
    private GreetingPanel gp;
    private JMenuItem loadFile;
    private JMenuItem saveFile;
    private JMenuItem exitFile;

    // Constructs main window
    // EFFECTS: sets up window in main menu display
    public CalorieAppUI() {
        super("Calorie Tracker & Calculator");
        setSize(new Dimension(800, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(false);
        mp  = new MainPanel();
        gp = new GreetingPanel();
        add(mp);
        add(gp, BorderLayout.NORTH);
        pack();
        centreOnScreen();

        addMenu();

        setVisible(true);
    }

    private void addMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        JSeparator sep = new JSeparator();

        loadFile = new JMenuItem("Load");
        saveFile = new JMenuItem("Save");
        exitFile = new JMenuItem("Exit");

        loadFile.addActionListener(this);
        saveFile.addActionListener(this);
        exitFile.addActionListener(this);

        fileMenu.add(loadFile);
        fileMenu.add(saveFile);
        fileMenu.add(sep);
        fileMenu.add(exitFile);

        setJMenuBar(menuBar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loadFile) {
            System.out.println("load");
        }
        if (e.getSource() == saveFile) {
            System.out.println("save");
        }
        if (e.getSource() == exitFile) {
            System.out.println("exit");
        }
    }


    // MODIFIES: this
    // EFFECTS: set the frame at the center of the desktop
    private void centreOnScreen() {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screen.width - getWidth()) / 2, (screen.height - getHeight()) / 2);
    }


    public static void main(String[] args) {
        new CalorieAppUI();
    }
}
