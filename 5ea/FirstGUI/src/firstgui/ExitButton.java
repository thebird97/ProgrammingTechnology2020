/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstgui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Madár Bálint
 */
public class ExitButton extends JButton implements ActionListener {
    public ExitButton(){
        setText("Kilépés");
        setSize(100,30);
        addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       new ExitAdapter().windowClosing(null);
    }
    
}
