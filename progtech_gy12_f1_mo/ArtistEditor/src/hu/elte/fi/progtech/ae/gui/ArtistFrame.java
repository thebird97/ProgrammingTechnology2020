package hu.elte.fi.progtech.ae.gui;

import javax.swing.*;
import java.awt.*;

public class ArtistFrame extends JFrame {

    public ArtistFrame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Artist table");

        getContentPane().add(new ArtistDataPanel(), BorderLayout.CENTER);
        pack();

        setLocationRelativeTo(null);
    }
}
