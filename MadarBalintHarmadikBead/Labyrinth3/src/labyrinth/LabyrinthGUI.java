package labyrinth;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.lang.String;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;

import java.util.Timer;
import java.util.logging.Logger;
import javax.naming.Name;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;



public class LabyrinthGUI {

    private JFrame frame;
    private GameEngine gameArea;
    private String PlayerName;
    
        //Table
    private static ArrayList<String> Name = new ArrayList();
    private static ArrayList<String> Time = new ArrayList();
    private static ArrayList<String> Score = new ArrayList();
    List<String> columns = new ArrayList<String>();
    List<String[]> values = new ArrayList<String[]>();

    public LabyrinthGUI(String PlayerName) throws SQLException {
        frame = new JFrame("Labirintus");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menub = new JMenuBar();
        JMenu mNewGame = new JMenu("Dolgok");
        JMenuItem ng = new JMenuItem("Új játék");
        JMenuItem top10 = new JMenuItem("Top 10");

        menub.add(mNewGame);
        menub.add(top10);
        mNewGame.add(ng);
        mNewGame.add(top10);

        this.frame.setJMenuBar(menub);

  gameArea = new GameEngine(PlayerName);

        JLabel IdoLabel = new JLabel("Eltelt idő: 00:00");

        final javax.swing.Timer t = new javax.swing.Timer(1000, new ActionListener() {
            int time = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                time++;

                IdoLabel.setText("Eltelt idő: " + format(time / 60) + ":" + format(time % 60));
                if (time == 0) {
                    final javax.swing.Timer timer = (javax.swing.Timer) e.getSource();
                    timer.stop();
                }
            }
        });
        
        ng.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    
             frame.dispose();
                 MainMenu mainMenu = new MainMenu();
        
         
            }



            
        });

        top10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    

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
                    Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
        
         
            }



            
        });

        frame.add(IdoLabel, BorderLayout.NORTH);

        t.start();
        frame.getContentPane().add(gameArea);

        frame.setPreferredSize(new Dimension(800, 600));
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);

        URL iconURL = getClass().getResource("icon.jpg");
        ImageIcon icon = new ImageIcon(iconURL);
        frame.setIconImage(icon.getImage());

    }

    private static String format(int i) {
        String result = String.valueOf(i);
        if (result.length() == 1) {
            result = "0" + result;
        }
        return result;
    }

    public String getPlayerName() {
        return PlayerName;
    }
    
}
