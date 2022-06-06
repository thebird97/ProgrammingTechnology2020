/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labyrinth;

import java.awt.Image;

/**
 *
 * @author bli
 */
public class Brick extends Sprite {
    
    public Brick(int x, int y, int width, int height, Image image) {
        super(x, y, width, height, image);
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getWidth() {
        return width;
    }
@Override
    public int getHeight() {
        return height;
    }


}
