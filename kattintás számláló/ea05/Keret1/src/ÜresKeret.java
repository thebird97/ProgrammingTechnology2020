import javax.swing.*;
import java.awt.event.*;

public class ÜresKeret extends JFrame
{
    public ÜresKeret()
    {
        addWindowListener(kilépéskezelő);
        //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Üres keret");
        setSize(200, 60);
        setVisible(true);
    }

    private WindowAdapter   kilépéskezelő = new WindowAdapter()
    {
        @Override
        public void windowClosing(WindowEvent e)
        {
            System.exit(0);
        }
    };
}
