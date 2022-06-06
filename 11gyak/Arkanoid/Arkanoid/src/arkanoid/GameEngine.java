/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arkanoid;

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
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

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
    private Ball ball;
    private Paddle paddle;
    private Timer newFrameTimer;

    public GameEngine() {
        super();
        background = new ImageIcon("data/images/background.jpg").getImage();
        this.getInputMap().put(KeyStroke.getKeyStroke("A"), "pressed left");
        this.getActionMap().put("pressed left", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                paddle.setVelx(-PADDLE_MOVEMENT);

            }
        });

        this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, true), "leftreleased");
        this.getActionMap().put("leftreleased", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                paddle.setVelx(0);

            }
        });

        this.getInputMap().put(KeyStroke.getKeyStroke("D"), "pressed right");
        this.getActionMap().put("pressed right", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                paddle.setVelx(PADDLE_MOVEMENT);

            }
        });
        this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, true), "releasedright");
        this.getActionMap().put("releasedright", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                paddle.setVelx(0);

            }
        });

        //UP
        this.getInputMap().put(KeyStroke.getKeyStroke("W"), "pressed up");
        this.getActionMap().put("pressed up", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                paddle.setVelY(-PADDLE_MOVEMENT);
                System.out.println(paddle.getVelY() + " " + paddle.getY());

            }
        });

        this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, true), "releasedup");
        this.getActionMap().put("releasedup", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                paddle.setVelY(0);
                System.out.println(paddle.getVelY() + " " + paddle.getY());

            }
        });

        this.getInputMap().put(KeyStroke.getKeyStroke("S"), "pressed down");
        this.getActionMap().put("pressed down", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                paddle.setVelY(PADDLE_MOVEMENT);
                System.out.println(paddle.getVelY() + " " + paddle.getY());

            }
        });

        this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, true), "realeseddown");
        this.getActionMap().put("realeseddown", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                paddle.setVelY(0);
                System.out.println(paddle.getVelY() + " " + paddle.getY());

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
    }

    public void restart() {
        try {
            level = new Level("data/levels/level0" + levelNum + ".txt");
        } catch (IOException ex) {
            Logger.getLogger(GameEngine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        Image paddleImage = new ImageIcon("data/images/player.png").getImage();
        paddle = new Paddle(10, PADDLE_Y, PADDLE_WIDTH, PADDLE_HEIGHT, paddleImage);
        Image ballImage = new ImageIcon("data/images/ball.png").getImage();
        ball = new Ball(300, 300, BALL_RADIUS, BALL_RADIUS, ballImage);
    }
//x+y y+2 karakter középpontja
    //köszönöm 

    //egész képet teszek rá ami nem áttetsző
    //és egy áttetsző kör
    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
 
    level.draw(grphcs);
      
        ball.draw(grphcs);
// grphcs.drawImage(background, 0, 0, 800, 600, null);

 // grphcs.drawImage(background, 0, 0, 800, 600,    100, 100, 100, 100, this);
        paddle.draw(grphcs);
//this.setBackground(new Color(0, 0, 0, 0));

    }
    
    

    class NewFrameListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (!paused) {
                //System.out.println("velx: " + ball.getVelx() + " " + ball.getVely());

                ball.moveX();
                ball.moveY();
                if (level.collides(ball)) {
                    ball.invertVelX();
                }
                if (!ball.moveY()) {
                    levelNum = 0;
                    restart();
                }
                if (level.collides(ball)) {
                    ball.invertVelY();

                }
                if (paddle.collides(ball)) {
                    // ball.invertVelY();
                    System.out.println("GAME OVER!");
                    level.isOver();
                    //exit(0);
                }
                if (level.collidesPlayer(paddle)) {

                    int Yteteje = paddle.getY() - PADDLE_HEIGHT + PADDLE_MOVEMENT;
                    int YAlja = paddle.getY() + PADDLE_HEIGHT - PADDLE_MOVEMENT;

                    int XJOBB = paddle.getX() - PADDLE_WIDTH + PADDLE_MOVEMENT;

                    int XBALL = paddle.getX() + PADDLE_WIDTH - PADDLE_MOVEMENT;
                    for (int i = 0; i < level.brickpiece; i++) {
                        if (level.getBrickGetX(i) + PADDLE_WIDTH == XJOBB) {
                            //System.out.println("X BAL egyenlő");
                            paddle.setVelx(1);
                        }
                        if (level.getBrickGetX(i) - PADDLE_WIDTH == XBALL) {
                            //   System.out.println("X JOBB egyenlő");
                            paddle.setVelx(-1);
                        }
                        if (level.getBrickGetY(i) + PADDLE_HEIGHT == Yteteje) {
                            // System.out.println("Y egynlő barbár tető");
                            paddle.setVelY(1);
                            // paddle.setVelY(-PADDLE_MOVEMENT);
                        }
                        if (level.getBrickGetY(i) + PADDLE_HEIGHT == YAlja) {
                            System.out.println("Y egynlő barbár alja");
                            paddle.setVelY(-1);
                            /// paddle.setVelY(-PADDLE_MOVEMENT);
                        }

                    }

                }

                paddle.move();
            }
            if (level.isOver()) {
                levelNum = (levelNum + 1) % 2;
                restart();
            }
            repaint();
        }

    }
}
