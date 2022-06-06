package labyrinth;

import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import javax.swing.ImageIcon;

public class Level {

    private final int BRICK_WIDTH = 30;
    private final int BRICK_HEIGHT = 30;
    ArrayList<Brick> bricks;
    int brickpiece = 0;

    public Level(String levelPath) throws IOException {
        loadLevel(levelPath);
    }

    public void loadLevel(String levelPath) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(levelPath));
        bricks = new ArrayList<>();
        int y = 0;

        String line;
        while ((line = br.readLine()) != null) {
            int x = 0;
            for (char blockType : line.toCharArray()) {
                if (Character.isDigit(blockType)) {
                    Image image = new ImageIcon("data/images/brick0" + blockType + ".png").getImage();
                    bricks.add(new Brick(x * BRICK_WIDTH, y * BRICK_HEIGHT, BRICK_WIDTH, BRICK_HEIGHT, image));
                    brickpiece++;
                }
                x++;
            }
            y++;
        }
    }

    public boolean collides(Dragon ball) {
        Brick collidedWith = null;
        for (Brick brick : bricks) {
            if (ball.collides(brick)) {
                collidedWith = brick;
                break;
            }
        }
        if (collidedWith != null) {
            //  bricks.remove(collidedWith);
            return true;
        } else {
            return false;
        }
    }

    public boolean collidesPlayer(Player ball) {
        Brick collidedWith = null;
        for (Brick brick : bricks) {
            if (ball.collides(brick)) {
                collidedWith = brick;
                break;
            }
        }
        if (collidedWith != null) {

            return true;
        } else {
            return false;
        }
    }

    public int getBrickpiece() {
        return brickpiece;
    }

    public int getBrickGetY(int in) {

        return bricks.get(in).getY();

    }

    public int getBrickGetX(int in) {

        return bricks.get(in).getX();

    }

    public int getBRICK_WIDTH() {
        return BRICK_WIDTH;
    }

    public int getBRICK_HEIGHT() {
        return BRICK_HEIGHT;
    }

    public ArrayList<Brick> getBricks() {
        return bricks;
    }

    public void draw(Graphics g) {
        for (Brick brick : bricks) {
            brick.draw(g);
        }
    }

    boolean isVisible() {
        
        return true;
    }

}
