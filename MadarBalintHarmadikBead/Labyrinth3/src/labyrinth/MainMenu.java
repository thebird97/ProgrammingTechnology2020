package labyrinth;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Madár Bálint
 */
public class MainMenu {

    JFrame Menu = new JFrame("Labyrinth");
    JLabel Jatekosnev = new JLabel("Játékos neve: ");
    public JTextField PlayerName = new JTextField("");
    ArrayList<String> mapList = new ArrayList<String>();
    JComboBox<String> lvlList;

    JButton Start = new JButton("Játék indítás");
    JButton ScroreBoard = new JButton("10 legjobb játékos");

    int menuWidth = 100; //A szélessége egy elemnek
    int menuHeight = 30;//A magassága egy elemnek
    int DOWNY = 30; //Mennyivel menjen lejebb egy elem
    int WIDTH = 490;
    int HEIGHT = 250;

    final int LabelPosition_X = 10;
    final int LabelPosition_Y = 30;

    final int TextFieldPosition_X = menuWidth + DOWNY;
    final int TextFieldPosition_Y = DOWNY;

    final int ComboPostion_X = 10;
    final int ComboPosition_Y = DOWNY + DOWNY + DOWNY;

    final int MapMakerButtonPostiton_X = 120 + 35;
    final int MapMakerButtonPostiton_Y = DOWNY + DOWNY + DOWNY;

    final int StartGameButtonPostion_X = 10;
    final int StartGameButtonPostion_Y = DOWNY + DOWNY + DOWNY + DOWNY + DOWNY;

    //Table
    private static ArrayList<String> Name = new ArrayList();
    private static ArrayList<String> Time = new ArrayList();
    private static ArrayList<String> Score = new ArrayList();
    List<String> columns = new ArrayList<String>();
    List<String[]> values = new ArrayList<String[]>();

    public MainMenu() {

        //Menu Variables
        Menu.setResizable(false);
        Menu.setSize(WIDTH, HEIGHT);
        Menu.setLayout(null);
        Menu.setLocationRelativeTo(null);
        Menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //JLabel
        Jatekosnev.setSize(menuWidth, menuHeight);
        Jatekosnev.setLocation(LabelPosition_X, LabelPosition_Y);
        Menu.add(Jatekosnev);
        Menu.setVisible(true);

        //PLayer name inputbox
        PlayerName.setSize(menuWidth + 100, menuHeight);
        PlayerName.setLocation(TextFieldPosition_X, TextFieldPosition_Y);
        Menu.add(PlayerName);
        Menu.setVisible(true);

        ///Satrt Game Button
        Start.setSize(menuWidth + 50, menuHeight);
        Start.setLocation(StartGameButtonPostion_X, StartGameButtonPostion_Y);
        Menu.add(Start);
        Start.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {

                if (PlayerName.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Kérlek írd be a játékos nevet!", "Empty player name", 1);
                } else {
                    //new Maze(lvlList.getSelectedItem().toString());
                    Menu.setVisible(false);
                    try {
                        LabyrinthGUI gui = new LabyrinthGUI(PlayerName.getText());
                    } catch (SQLException ex) {
                        Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }

        });

        ///ScroreBoard Game Button
        ScroreBoard.setSize(menuWidth + 50, menuHeight);
        ScroreBoard.setLocation(StartGameButtonPostion_X + menuWidth + 50 + menuWidth, StartGameButtonPostion_Y);
        Menu.add(ScroreBoard);
        ScroreBoard.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {

                try {
                    HighScores highScores = new HighScores(10);
                    System.out.println(highScores.getHighScores());
                    System.out.println(highScores.getNames());
                    System.out.println(highScores.getOnlyHighScores());
                    System.out.println(highScores.getDates());

                    //Tábla létrehozás
                    columns.add("Név");
                    columns.add("Időpont");
                    columns.add("Pontszám");

                    Name = highScores.getNames();
                    Time = highScores.getDates();
                    Score = highScores.getOnlyHighScores();

                    for (int z = 0; z < Name.size(); z++) {

                        System.out.println(Name.get(z) + Time.get(z) + Score.get(z));
                        values.add(new String[]{"" + Name.get(z) + "", "" + Time.get(z) + "", "" + Score.get(z) + ""});

                    }

                    JFrame frame = new JFrame("Scoreboard");
                    TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][]{}), columns.toArray());
                    JTable table = new JTable(tableModel);
                    frame.setLayout(new BorderLayout());
                    frame.add(new JScrollPane(table), BorderLayout.CENTER);

                    frame.add(table.getTableHeader(), BorderLayout.NORTH);

                    frame.setVisible(true);
                    frame.setSize(300, 300);
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.pack();
                    frame.setVisible(true);

                } catch (SQLException ex) {
                    Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });

        URL iconURL = getClass().getResource("icon.jpg");
        ImageIcon icon = new ImageIcon(iconURL);
        Menu.setIconImage(icon.getImage());
    }

    public JTextField getPlayerName() {
        return PlayerName;
    }

}
