import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
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
        setLayout(new BorderLayout());
        JPanel  gombok = new JPanel(new FlowLayout());
        JLabel  felirat = new JLabel("Kattintások száma: 0");
        gombok.add(new SzámlálóGomb(felirat));
        gombok.add(new JButton(kilépésakció));
        add("Center", felirat);
        add("South", gombok);
        java.net.URL    url = Gomb.class.getResource("gomb.png");
        setIconImage(Toolkit.getDefaultToolkit().getImage(url));
        setTitle("Számláló");
        pack();
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
