

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Rec extends JFrame {

    public Rec() {
        super("rectangle");
        setPreferredSize(new java.awt.Dimension(400, 400));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel pane = new Pan();
        add(pane);

        pack();
        setVisible(true);

    }

    public static void main(String[] args) {
        new Rec();
    }

}

class Pan extends JPanel {

    private Point origin;
    private Point end;
    private Point endFinal;

    public Pan() {
        MouseAdapter adapter = new Lis();
        addMouseMotionListener(adapter);
        addMouseListener(adapter);
    }

    class Lis extends MouseAdapter {
        public void mouseDragged(MouseEvent e) {
            end = e.getPoint();
            repaint();
        }

        public void mousePressed(MouseEvent e) {
            origin = e.getPoint();
        }

        public void mouseReleased(MouseEvent e, Graphics g) {
            endFinal = e.getPoint();
            g.clearRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.RED);
            int x1 = (int) (origin.getX());
            int y1 = (int) (origin.getY());
            int x2 = (int) (endFinal.getX());
            int y2 = (int) (endFinal.getY());
            g.drawRect(x1, y1, x2 - x1, y2 - y1);
        }

    }

    @Override
    public void paint(Graphics g) {
        g.clearRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.RED);
        if (origin != null) {

            int tmp;

            int x1 = (int) (origin.getX());
            int y1 = (int) (origin.getY());
            int x2 = (int) (end.getX());
            int y2 = (int) (end.getY());

            if (x1 > x2) {
                tmp = x1;
                x1 = x2;
                x2 = tmp;
            }
            if (y1 > y2) {
                tmp = y1;
                y1 = y2;
                y2 = tmp;
            }

            g.drawRect(x1, y1, x2 - x1, y2 - y1);
        }

    }

}