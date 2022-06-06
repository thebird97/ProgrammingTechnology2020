/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labyrinth;



import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RescaleOp;
import java.io.IOException;
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Logger;


public class GameEngine extends JPanel {

    private final int FPS = 240;
    private final int PADDLE_Y = 550;
    private final int PADDLE_WIDTH = 30;
    private final int PADDLE_HEIGHT = 30;
    private final int PADDLE_MOVEMENT = 1;
    private final int BALL_RADIUS = 20;

    private boolean paused = false;
    private Image background;
    private int levelNum = 0;
    private Level level;
    private Dragon dragon;
    private Player player;
    private Timer newFrameTimer;
    private final String PlayerName;

    public int score = 0;

    public GameEngine(String PlayerName) {

        super();
        background = new ImageIcon("data/images/background.jpg").getImage();
        this.getInputMap().put(KeyStroke.getKeyStroke("A"), "pressed left");
        this.getActionMap().put("pressed left", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                player.setVelx(-PADDLE_MOVEMENT);

            }
        });

        this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, true), "leftreleased");
        this.getActionMap().put("leftreleased", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                player.setVelx(0);

            }
        });

        this.getInputMap().put(KeyStroke.getKeyStroke("D"), "pressed right");
        this.getActionMap().put("pressed right", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                player.setVelx(PADDLE_MOVEMENT);

            }
        });
        this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, true), "releasedright");
        this.getActionMap().put("releasedright", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                player.setVelx(0);

            }
        });

        //UP
        this.getInputMap().put(KeyStroke.getKeyStroke("W"), "pressed up");
        this.getActionMap().put("pressed up", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                player.setVelY(-PADDLE_MOVEMENT);
                System.out.println(player.getX() + " " + player.getY());

            }
        });

        this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, true), "releasedup");
        this.getActionMap().put("releasedup", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                player.setVelY(0);
                System.out.println(player.getX() + " " + player.getY());

            }
        });

        this.getInputMap().put(KeyStroke.getKeyStroke("S"), "pressed down");
        this.getActionMap().put("pressed down", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                player.setVelY(PADDLE_MOVEMENT);
                System.out.println(player.getX() + " " + player.getY());

            }
        });

        this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, true), "realeseddown");
        this.getActionMap().put("realeseddown", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                player.setVelY(0);
                System.out.println(player.getX() + " " + player.getY());

            }
        });

        this.getInputMap().put(KeyStroke.getKeyStroke("ESCAPE"), "escape");
        this.getActionMap().put("escape", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                paused = !paused;
            }
        });
        restart();
        newFrameTimer = new Timer(1000 / FPS, new NewFrameListener());
        newFrameTimer.start();
        this.PlayerName = PlayerName;
    }

    public void restart() {
        try {
            level = new Level("data/levels/level0" + levelNum + ".txt");
        } catch (IOException ex) {
            Logger.getLogger(GameEngine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        Image paddleImage = new ImageIcon("data/images/player.png").getImage();
        player = new Player(10, PADDLE_Y, PADDLE_WIDTH, PADDLE_HEIGHT, paddleImage);
        Image ballImage = new ImageIcon("data/images/ball.png").getImage();
        dragon = new Dragon(300, 300, BALL_RADIUS, BALL_RADIUS, ballImage);
    }
//x+y y+2 karakter középpontja
    //köszönöm 

    //egész képet teszek rá ami nem áttetsző
    //és egy áttetsző kör
    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);

        level.draw(grphcs);

        dragon.draw(grphcs);
// grphcs.drawImage(background, 0, 0, 800, 600, null);

        // grphcs.drawImage(background, 0, 0, 800, 600,    100, 100, 100, 100, this);
        player.draw(grphcs);
//this.setBackground(new Color(0, 0, 0, 0));

    }

    private boolean isOver() {

        return player.getY() == 0;

    }

    class NewFrameListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (!paused) {
                //System.out.println("velx: " + ball.getVelx() + " " + ball.getVely());

                dragon.moveX();
                dragon.moveY();
                if (level.collides(dragon)) {
                    dragon.invertVelX();
                }
                if (!dragon.moveY()) {
                    levelNum = 0;
                    restart();
                }
                if (level.collides(dragon)) {
                    dragon.invertVelY();

                }
                if (player.collides(dragon)) {
                    // ball.invertVelY();
                    System.out.println("GAME OVER! " + PlayerName);
                    JOptionPane.showMessageDialog(null, "Játék vége! " + PlayerName + " pontszám: " + score, "Játék vége!", 1);
                    try {
                        HighScores highScores = new HighScores(10);
                        System.out.println(highScores.getHighScores()); 
                        System.out.println(highScores.getNames() + " " + highScores.getOnlyHighScores());
                    } catch (SQLException ex) {
                        Logger.getLogger(GameEngine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    }
                    restart();

                }
                if (level.collidesPlayer(player)) {

                    int Yteteje = player.getY() - PADDLE_HEIGHT + PADDLE_MOVEMENT;
                    int YAlja = player.getY() + PADDLE_HEIGHT - PADDLE_MOVEMENT;

                    int XJOBB = player.getX() - PADDLE_WIDTH + PADDLE_MOVEMENT;

                    int XBALL = player.getX() + PADDLE_WIDTH - PADDLE_MOVEMENT;
                    for (int i = 0; i < level.brickpiece; i++) {
                        if (level.getBrickGetX(i) + PADDLE_WIDTH == XJOBB) {
                            //System.out.println("X BAL egyenlő");
                            player.setVelx(1);
                        }
                        if (level.getBrickGetX(i) - PADDLE_WIDTH == XBALL) {
                            //   System.out.println("X JOBB egyenlő");
                            player.setVelx(-1);
                        }
                        if (level.getBrickGetY(i) + PADDLE_HEIGHT == Yteteje) {
                            // System.out.println("Y egynlő barbár tető");
                            player.setVelY(1);
                            // paddle.setVelY(-PADDLE_MOVEMENT);
                        }
                        if (level.getBrickGetY(i) + PADDLE_HEIGHT == YAlja) {
                            //System.out.println("Y egynlő barbár alja");
                            player.setVelY(-1);
                            /// paddle.setVelY(-PADDLE_MOVEMENT);
                        }

                    }

                }

                player.move();
            }

            if (isOver()) {
                System.out.println("overlefut");
                score = score + 1;
                levelNum = (levelNum + 1);
                restart();
            }
            repaint();
        }

    }

}
