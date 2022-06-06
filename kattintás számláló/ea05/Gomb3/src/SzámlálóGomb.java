import javax.swing.*;
import java.awt.event.*;

public class SzámlálóGomb extends JButton implements ActionListener
{
    private int     érték;
    private JLabel  felirat;

    public SzámlálóGomb(JLabel felirat)
    {
        super("Kattintás");
        érték = 0;  this.felirat = felirat;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        érték++;
        felirat.setText("Kattintások száma: " + érték);
    }
}
