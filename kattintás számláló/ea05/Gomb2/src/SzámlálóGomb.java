import javax.swing.*;
import java.awt.event.*;

public class SzámlálóGomb extends JButton implements ActionListener
{
    private int     érték;

    public SzámlálóGomb()
    {
        super("Kattintás: 0");
        érték = 0;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        érték++;
        setText("Kattintás: " + érték);
    }
}
