package valami;

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;

public class JButtonTextChangeTest extends JFrame {

    private JTextField textField;
    private final JLabel label;
    public int size = 8;
  public final JButton[][] grid = new JButton[size][size];
    public Model model;

    public JButtonTextChangeTest() {
        this.size = 8;
        model = new Model(size);
        

        setTitle("Sudoku");
        setSize(400, 450);

        JPanel top = new JPanel();
        label = new JLabel();
        updateLabelText();

        JButton newGameButton = new JButton();
        newGameButton.setText("Új játék");
        newGameButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                newGame();
            }
        });

        top.add(label);
        top.add(newGameButton);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(size, size));

        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                addButton(mainPanel, i, j);
                grid[i][j].setBackground(Color.GRAY);

                //grid[i][j].setText(model.getNumber(i, j)+ " (i: " + String.valueOf(i) + " j:" + String.valueOf(j) + ") " );    
                if (model.getNumber(i, j) == FieldValue.WHITEHORSE) {
                    grid[i][j].setIcon(new ImageIcon(getClass().getResource("smallwhite.png")));
                }
                if (model.getNumber(i, j) == FieldValue.WHITEHORSE) {
                    grid[i][j].setIcon(new ImageIcon(getClass().getResource("smallwhite.png")));
                }

                if (model.getNumber(i, j) == FieldValue.BLACKHORSE) {
                    grid[i][j].setIcon(new ImageIcon(getClass().getResource("rsz_2smallbalck.png")));
                }
                if (model.getNumber(i, j) == FieldValue.BLACKHORSE) {
                    grid[i][j].setIcon(new ImageIcon(getClass().getResource("rsz_2smallbalck.png")));
                }

            }
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(new BorderLayout());

        getContentPane().add(top, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new JButtonTextChangeTest();
    }

    private void addButton(final JPanel mainPanel, final int i, final int j) {
      // JButton[][] grid = new JButton[size][size];
      //  grid[i][j] = new JButton();  
// JButton[][] grid = new JButton[size][size];      
      grid[i][j] = new JButton();
        mainPanel.add(grid[i][j]);

        grid[i][j].addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Ez a klikk: 1  " + model.getNumber(i, j)  + "grid:" + grid[0][0]);
                model.step(i, j);
                System.out.println("Ez a klikk: 2  " + model.getNumber(i, j));
                updateGrid();
                updateLabelText();

                FieldValue winner = model.findWinner();
                if (winner == FieldValue.BLACKHORSE) {
                    //showGameOverMessage(winner);
                }
                if (winner == FieldValue.WHITEHORSE) {
                  //  showGameOverMessage(winner);
                }

            }

            private void updateGrid() {

                for (int i = 0; i < size; ++i) {
                    for (int j = 0; j < size; ++j) {

                        if (model.getNumber(i, j) == FieldValue.WHITEHORSE) {
                            grid[i][j].setBackground(null);
                            grid[i][j].setIcon(new ImageIcon(getClass().getResource("smallwhite.png")));
                            grid[i][j].setEnabled(true);
                        }
                        if (model.getNumber(i, j) == FieldValue.WHITE) {
                            grid[i][j].setBackground(Color.WHITE);
                            grid[i][j].setIcon(null);
                        }
                        if (model.getNumber(i, j) == FieldValue.BLACKHORSE) {
                            grid[i][j].setBackground(null);
                            grid[i][j].setIcon(new ImageIcon(getClass().getResource("rsz_2smallbalck.png")));
                        }
                        if (model.getNumber(i, j) == FieldValue.GREEN) {
                            grid[i][j].setEnabled(true);
                            grid[i][j].setBackground(Color.GREEN);
                        }
                        if (model.getNumber(i, j) == FieldValue.EMPTY) {
                            grid[i][j].setBackground(Color.GRAY);
                            grid[i][j].setIcon(null);
                        }
                        if (model.getNumber(i, j) == FieldValue.BLACK) {
                            grid[i][j].setIcon(null);
                            grid[i][j].setBackground(Color.BLACK);
                        }
                        //grid[i][j].setText(model.getNumber(i, j)+ " (i: " + String.valueOf(i) + " j:" + String.valueOf(j) + ") " );    

                    }
                }

            }


        });

    }

    private void newGame() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(size, size));
        model = new Model(size);
        updateLabelText();
        /*    Window newWindow;
                newWindow = new Window(size, mainPanel);
        newWindow.setVisible(true);
        
        this.dispose();
        mainPanel.getWindowList().remove(this);  
             
         */

    }

    private void updateLabelText() {
        label.setText("Aktuális játékos: " + model.getCurrentPlayer());
    }
}
