package labyrinth;

import java.awt.Image;

public class Player extends Sprite {

    private int velx;
    private int vely;

    public Player(int x, int y, int width, int height, Image image) {
        super(x, y, width, height, image);
    }

    public void move() {
        if ((velx < 0 && x > 0) || (velx > 0 && x + width <= 800)) {
            x += velx;
            // y+=velx;

        }

        if ((vely < 0 && y > 0) || (vely > 0 && y + height <= 540)) {
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
