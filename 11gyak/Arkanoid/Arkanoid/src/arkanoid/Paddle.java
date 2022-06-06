/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arkanoid;

import java.awt.Image;

/**
 *
 * @author bli
 */
public class Paddle extends Sprite {

    private int velx;
     private int vely;

    public Paddle(int x, int y, int width, int height, Image image) {
        super(x, y, width, height, image);
    }

    public void move() {
        if ((velx < 0 && x > 0) || (velx > 0 && x + width <= 800)) {
            x += velx;
           // y+=velx;
            
        }
        
          if ((vely < 0 && y > 0) || (vely > 0 && y + height <= 500)) {
            y += vely;
                       
        }

       
    }

    public int getVelx() {
        return velx;
    }
        public int getVelY() {
        return vely;
    }
    public void setVelx(int velx) {
        this.velx = velx;
    }
    
    
     public void setVelY(int vely) {
        this.vely = vely;
    }
}
