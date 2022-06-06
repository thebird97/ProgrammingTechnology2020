/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labyrinth;

import java.awt.Dimension;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.lang.String;

/**
 *
 * @author bli
 */
public class LabyrinthGUI {


    private JFrame frame;
    private GameEngine gameArea;
    private String PlayerName;

    public LabyrinthGUI(String PlayerName) {
        frame = new JFrame("Labirinth");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     

        
        gameArea = new GameEngine(PlayerName);
        frame.getContentPane().add(gameArea);
        
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        
          URL iconURL = getClass().getResource("icon.jpg");
        ImageIcon icon = new ImageIcon(iconURL);
        frame.setIconImage(icon.getImage());
    }
    
    
}
