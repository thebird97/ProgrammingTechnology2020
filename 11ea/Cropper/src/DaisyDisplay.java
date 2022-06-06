import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class DaisyDisplay {

    DaisyDisplay() {
        JPanel gui = new JPanel(new BorderLayout(2,2));

        final BufferedImage daisy = new BufferedImage(
                200,200,BufferedImage.TYPE_INT_RGB);
        final JLabel daisyLabel = new JLabel(new ImageIcon(daisy));
        gui.add(daisyLabel,BorderLayout.CENTER);
        final Daisy daisyPainter = new Daisy();
        daisyPainter.setSize(200);
        final JLabel fps = new JLabel("FPS: ");
        gui.add(fps,BorderLayout.SOUTH);

        ActionListener animator = new ActionListener() {
            int counter = 0;
            long timeLast = 0;
            long timeNow = 0;
            public void actionPerformed(ActionEvent ae) {
                Graphics2D g = daisy.createGraphics();
                g.setColor(Color.GREEN.darker());
                g.fillRect(0, 0, 200, 200);

                daisyPainter.paint(g);

                g.dispose();
                daisyLabel.repaint();

                counter++;
                timeNow = System.currentTimeMillis();
                if (timeLast<timeNow-1000) {
                    fps.setText("FPS: " + counter);
                    counter = 0;
                    timeLast = timeNow;
                }
            }
        };
        Timer timer = new Timer(1,animator);
        timer.start();

        JOptionPane.showMessageDialog(null, gui);
        timer.stop();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DaisyDisplay();
            }
        });
    }
}

class Daisy {

    double size = 200;
    Point location;

    double offset = 0.0;

    public void paint(Graphics2D g) {
        Area daisyArea = getDaisyShape();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                RenderingHints.VALUE_ANTIALIAS_ON);

        offset += .02d;

        AffineTransform plain = g.getTransform();

        g.setTransform(AffineTransform.getRotateInstance(
                offset + (Math.PI*1/8),
                100,100));
        paintDaisyPart(g,daisyArea);

        g.setTransform(AffineTransform.getRotateInstance(
                offset + (Math.PI*3/8),
                100,100));
        paintDaisyPart(g,daisyArea);

        g.setTransform(AffineTransform.getRotateInstance(
                offset,
                100,100));
        paintDaisyPart(g,daisyArea);

        g.setTransform(AffineTransform.getRotateInstance(
                offset + (Math.PI*2/8),
                100,100));
        paintDaisyPart(g,daisyArea);

        g.setTransform(plain);
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public void paintDaisyPart(Graphics2D g, Area daisyArea) {
        g.setClip(daisyArea);

        g.setColor(Color.YELLOW);
        g.fillRect(0, 0, 200, 200);

        g.setColor(Color.YELLOW.darker());
        g.setClip(null);
        g.setStroke(new BasicStroke(3));
        g.draw(daisyArea);
    }

    public void setSize(double size) {
        this.size = size;
    }

    public Area getDaisyShape() {
        int diameter = (int)size*6/20;

        Ellipse2D.Double core = new Ellipse2D.Double(
                (size-diameter)/2,(size-diameter)/2,diameter,diameter);

        int pad = 10;
        int petalWidth = 50;
        int petalLength = 75;

        Area area = new Area(core);

        // left petal
        area.add(new Area(new Ellipse2D.Double(
                pad,(size-petalWidth)/2,petalLength,petalWidth)));
        // right petal
        area.add(new Area(new Ellipse2D.Double(
                (size-petalLength-pad),(size-petalWidth)/2,petalLength,petalWidth)));
        // top petal
        area.add(new Area(new Ellipse2D.Double(
                (size-petalWidth)/2,pad,petalWidth,petalLength)));
        // bottom petal
        area.add(new Area(new Ellipse2D.Double(
                (size-petalWidth)/2,(size-petalLength-pad),petalWidth,petalLength)));

        return area;
    }
}