package ui;

import model.Event;
import model.EventLog;
import model.Wishlist;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

// Represents the main window when calorie tracker and calculator is operated.
public class CalorieAppUI extends JFrame implements ActionListener {
    public static final String JSON_STORE = "./data/wishlist.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private MainPanel mp;
    private GreetingPanel gp;
    private JMenuItem loadFile;
    private JMenuItem saveFile;
    private JMenuItem exitFile;
    private Wishlist myWishlist;

    // Written with reference to B02-SpaceInvaderBase
    // Written with reference to https://www.google.com/search?rlz=1C1CHZN_enCA971CA972&sxsrf=AB5stBgt4ddKbLNnceLbmjUXon
    // F3Xp81Tw:1691346409425&q=joptionpane+java&tbm=vid&source=lnms&sa=X&ved=2ahUKEwjssLKv1MiAAxUSHzQIHbOEDkgQ0pQJegQIC
    // xAB&biw=1536&bih=899&dpr=1#fpstate=ive&vld=cid:13965a6e,vid:BuW7y21FcYI
    // EFFECTS: constructs main window, sets up window in main menu display
    public CalorieAppUI() {
        super("Calorie Tracker & Calculator");
        setSize(new Dimension(800, 600));

        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        myWishlist = new Wishlist("my wishlist");

        mp  = new MainPanel(myWishlist);
        gp = new GreetingPanel();
        add(mp);
        add(gp, BorderLayout.NORTH);
        pack();
        centreOnScreen();

        addMenu();

        setVisible(true);

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        startPopUpMessage();
        closeWindow();
    }

    // MODIFIES: this
    // EFFECTS: display the starter dialog of loading up the data
    private void startPopUpMessage() {
        String[] responses = {"Load my wishlist", "Create new wishlist", "Cancel"};
        ImageIcon loadIcon = new ImageIcon("C:\\Users\\yuqiz\\project_u5e3y\\data\\load.png");

        int answer = JOptionPane.showOptionDialog(null,
                "Do you want to load your wishlist from last time?",
                "Load",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                loadIcon,
                responses,
                0);

        if (answer == 0) {
            loadWorkRoom();
        }
    }

    // Written with reference to https://www.google.com/search?rlz=1C1CHZN_enCA971CA972&sxsrf=AB5stBjq4egYFaHmHhTFLpT0
    // e6UnBj80nQ:1691351213225&q=joptionpane+when+close+the+application&tbm=vid&source=lnms&sa=X&ved=2ahUKEwjmtYSi5siAA
    // xX3ODQIHdfDDaUQ0pQJegQIDBAB&biw=1536&bih=899&dpr=1#fpstate=ive&vld=cid:5f4c37f0,vid:GTFQi5McbzE
    // MODIFIES: this
    // EFFECTS: listener for the exit program button
    private void closeWindow() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closePopUpMessage();
            }
        }
        );
    }

    public void printLog(EventLog el) {
        for (Event next: el) {
            System.out.println(next.toString() + "\n\n");
        }
    }

    // MODIFIES: this
    // EFFECTS: display the saving option dialog of exiting the program
    private void closePopUpMessage() {
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
            saveWorkRoom();
            printLog(EventLog.getInstance());
            System.exit(0);
        }
        if (answer == 1) {
            printLog(EventLog.getInstance());
            System.exit(0);
        }
    }

    // Written with reference to https://www.google.com/search?rlz=1C1CHZN_enCA971CA972&sxsrf=AB5stBij9yvRVbNTjjzC_3XDF6
    // ReL2Opvw:1691452396546&q=how+to+add+jmenubar+in+java&tbm=vid&source=lnms&sa=X&ved=2ahUKEwiLooCa38uAAxWHMDQIHXvRAF
    // 8Q0pQJegQIChAB&biw=1536&bih=899&dpr=1#fpstate=ive&vld=cid:f89bd136,vid:dwLkDGm5EBc
    // EFFECTS: Adds menu bar, that includes load and save file and exit application.
    //          Also adds listener for these buttons.
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

    // EFFECTS: represents actions (load, save, exit) to be taken when user click associate button
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loadFile) {
            loadWorkRoom();
        }
        if (e.getSource() == saveFile) {
            saveWorkRoom();
        }
        if (e.getSource() == exitFile) {
            closePopUpMessage();
        }
    }


    // MODIFIES: this
    // EFFECTS: set the frame at the center of the desktop
    private void centreOnScreen() {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screen.width - getWidth()) / 2, (screen.height - getHeight()) / 2);
    }

    // Written with reference to JsonSerializationDemo
    // EFFECTS: saves the wishlist to file
    private void saveWorkRoom() {
        try {
            jsonWriter.open();
            jsonWriter.write(myWishlist);
            jsonWriter.close();
            System.out.println("Saved " + myWishlist.getName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // Written with reference to JsonSerializationDemo
    // MODIFIES: this
    // EFFECTS: loads wishlist from file
    private void loadWorkRoom() {
        try {
            myWishlist = jsonReader.read();
            mp.setWishlist(myWishlist);
            System.out.println("Loaded " + myWishlist.getName() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    // EFFECTS: run the application
    public static void main(String[] args) {
        new CalorieAppUI();
    }
}
