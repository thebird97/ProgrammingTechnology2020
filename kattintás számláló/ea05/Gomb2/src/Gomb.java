import javax.swing.*;
import java.awt.event.*;
import java.awt.Toolkit;

public class Gomb extends JFrame
{
    public static void main(String[] args)
    {
        new Gomb();
    }

    public Gomb()
    {
        addWindowListener(kilépés);
        setLayout(new java.awt.FlowLayout());
        add(new SzámlálóGomb());
        add(new JButton(kilépésakció));
        java.net.URL    url = Gomb.class.getResource("gomb.png");
        setIconImage(Toolkit.getDefaultToolkit().getImage(url));
        setTitle("Számláló");
        setSize(200, 70);
        setVisible(true);
    }

    private void kilép()
    {
        System.exit(0);
    }
    
    private WindowAdapter   kilépés = new WindowAdapter()
    {
        @Override
        public void windowClosing(WindowEvent e)
        {
            kilép();
        }
    };

    private AbstractAction  kilépésakció = new AbstractAction("Kilépés")
    {
        public void actionPerformed(ActionEvent e)
        {
            kilép();
        }
    };
}
