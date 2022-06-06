
package firstgui;

import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.net.URL;
import javax.swing.JFrame;

/**
 *
 * @author Madár Bálint
 */
public class MainWindow extends JFrame{   

      
    
  public MainWindow(){
     //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      addWindowListener(new ExitAdapter());
      setTitle("Számláló");
      setSize(400,400);
      setLayout(new FlowLayout());
      getContentPane().add(new CounterButton());
      getContentPane().add(new ExitButton());
      setVisible(true);
      setLocationRelativeTo(null);
      //ikon beállítása benn a java fileok között
      URL url = getClass().getResource("gomb.png");
      setIconImage(Toolkit.getDefaultToolkit().getImage(url));
  }


    public static void main(String[] args) {
        new MainWindow();
    }
    
}
