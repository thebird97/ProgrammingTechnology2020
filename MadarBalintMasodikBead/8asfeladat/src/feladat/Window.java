package feladat;

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Window extends BaseWindow {

    public int size;
    public Model model;
    public JLabel label;
    private MainWindow mainWindow;
    private JTextField textField;
    public JButton[][] grid;

    public Window(int size, MainWindow mainWindow) {
        this.grid = new JButton[size][size];
        this.size = size;
        this.mainWindow = mainWindow;
        mainWindow.getWindowList().add(this);
        model = new Model(size);

        setTitle("Lovagi játék");
        setSize(400, 450);
        JPanel top = new JPanel();
        label = new JLabel();

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

            }
        }
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(top, BorderLayout.NORTH);
        getContentPane().add(mainPanel, BorderLayout.CENTER);
    }

    private void addButton(JPanel panel, final int i,
            final int j) {

        grid[i][j] = new JButton();
        panel.add(grid[i][j]);

        grid[i][j].setBackground(Color.GRAY);

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

        grid[i][j].addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // System.out.println("Ez a klikk: 1  " + model.getNumber(i, j) + "ide " + grid[i][j]);
                model.step(i, j);
                //  System.out.println("Ez a klikk: 2  " + model.getNumber(i, j));
                updateGrid();
                updateLabelText();

                FieldValue winner = model.findWinner();
                if (winner == FieldValue.BLACKHORSE) {
                    showGameOverMessage(winner);
                }
                if (winner == FieldValue.WHITEHORSE) {
                    showGameOverMessage(winner);
                }
                if (winner == FieldValue.GREEN) {
                    showGameOverMessage(winner);
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
                        if (model.getNumber(i, j) == FieldValue.GREEN ||model.getNumber(i, j) == FieldValue.GW || model.getNumber(i, j) == FieldValue.GB ) {

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

                    }
                }

            }

            private void showGameOverMessage(FieldValue winner) {
                Component panel = null;
                if (winner == FieldValue.GREEN) {
                    JOptionPane.showMessageDialog(panel, "Játék vége! A tábla tele van! ");
                    newGame();
                } else {
                    JOptionPane.showMessageDialog(panel, "Játék vége! A nyertes: " + winner);
                    newGame();
                }
            }

        });

        panel.add(grid[i][j]);
    }

    
    
    private void newGame() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(size, size));
        model = new Model(size);
        updateLabelText();
    }

    private void updateLabelText() {
        label.setText("Aktuális játékos: " + model.getCurrentPlayer());
    }

}
