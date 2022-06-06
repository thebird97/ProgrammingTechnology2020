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

    private int     érték;
    private JLabel  felirat;

    public Gomb()
    {
        addWindowListener(kilépés);
        setLayout(new BorderLayout());
        JPanel  gombok = new JPanel(new FlowLayout());
        felirat = new JLabel("Kattintások száma: 0");
        gombok.add(new JButton(kattintásakció));
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

    private AbstractAction  kattintásakció = new AbstractAction("Kattintás")
    {
        public void actionPerformed(ActionEvent e)
        {
            érték++;
            felirat.setText("Kattintások száma: " + érték);
        }
    };
}
