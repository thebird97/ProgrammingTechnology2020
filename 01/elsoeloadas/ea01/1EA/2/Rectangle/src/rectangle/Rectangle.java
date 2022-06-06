/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rectangle;

/**
 *
 * @author zoltanpusztai
 */
public class Rectangle {

    private double x;
    private double y;
    private double width;
    private double height;

    public Rectangle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Rectangle(double width, double height) {
        this(0, 0, width, height);
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    public boolean isSegmentOf(Rectangle r) {

        if (isPointInside(r.x, r.y)
                || isPointInside(r.x + r.width, r.y)
                || isPointInside(r.x, r.y + r.height)
                || isPointInside(r.x + r.width, r.y + r.height)) {
            return true;
        }

        return false;
    }

    private boolean isPointInside(double px, double py) {
        if (px - x < width && px - x > 0
                && py - y < height && py - y > 0) {
            return true;
        }

        return false;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Rectangle r1 = new Rectangle(10, 10);
        Rectangle r2 = new Rectangle(-5.9, -5.9, 6, 6);

        System.out.println("Metszet? " + r1.isSegmentOf(r2));
    }

}
