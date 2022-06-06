import javax.swing.*;
import java.awt.Toolkit;

public class Gomb extends JFrame
{
    public static void main(String[] args)
    {
        new Gomb();
    }

    public Gomb()
    {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(new SzámlálóGomb());
        java.net.URL    url = Gomb.class.getResource("gomb.png");
        setIconImage(Toolkit.getDefaultToolkit().getImage(url));
        setTitle("Számláló");
        setSize(200, 70);
        setVisible(true);
    }
}
