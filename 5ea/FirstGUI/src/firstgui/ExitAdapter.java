package firstgui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ExitAdapter extends WindowAdapter {

    @Override
    public void windowClosing(WindowEvent e) {
        //Még egy párbeszéd ablak kilépsz-e? Mentés nem mentés
       
          System.exit(0);
    }

}