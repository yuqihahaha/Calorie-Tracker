package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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

        mp  = new MainPanel();
        gp = new GreetingPanel();
        add(mp);
        add(gp, BorderLayout.NORTH);
        pack();
        centreOnScreen();

        addMenu();

        setVisible(true);

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        startPopUpMessage();
        closePopUpMessage();
    }

    private void startPopUpMessage() {
        String[] responses = {"Load my wishlist", "Create new wishlist", "Cancel"};
        ImageIcon loadIcon = new ImageIcon("C:\\Users\\yuqiz\\project_u5e3y\\src\\main\\picture\\load.png");

        int answer = JOptionPane.showOptionDialog(null,
                "Do you want to load your wishlist from last time?",
                "Load",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                loadIcon,
                responses,
                0);

        if (answer == 0) {
            System.out.println("wishlist has been loaded");
        }
    }

    private void closePopUpMessage() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                String[] responses = {"Save my wishlist", "Quit without saving"};
                int answer = JOptionPane.showOptionDialog(null,
                        "Want to save before close the app?",
                        "Save",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        responses,
                        0);

                if (answer == 0) {
                    System.out.println("wishlist saved");
                    e.getWindow().dispose();
                }
                if (answer == 1) {
                    System.out.println("quit");
                    e.getWindow().dispose();
                }
            }
        });
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
