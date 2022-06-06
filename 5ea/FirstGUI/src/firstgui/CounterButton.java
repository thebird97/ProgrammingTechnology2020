/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstgui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class CounterButton extends JButton implements ActionListener{
    private int counter = 0;
   
   public CounterButton(){
       setSize(100,30);
       addActionListener(this);
       refreshText();
   } 
    
    @Override
    public void actionPerformed(ActionEvent e) {
        counter++;
        refreshText();
    }
    
    private void refreshText(){        
        setText("Kattintások száma: " + counter );
    }
    
}
