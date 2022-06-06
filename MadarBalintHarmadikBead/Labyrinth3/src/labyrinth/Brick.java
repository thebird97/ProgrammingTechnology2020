package labyrinth;

import java.awt.Image;

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
