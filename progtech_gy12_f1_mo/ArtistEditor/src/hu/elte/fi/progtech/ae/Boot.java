package hu.elte.fi.progtech.ae;

import hu.elte.fi.progtech.ae.gui.ArtistFrame;

import javax.swing.*;

public class Boot {

    private static final String NIMBUS_LOOK_AND_FEEL_NAME = "Nimbus";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->{
            applyNimbusLookAndFeelTheme();

            new ArtistFrame().setVisible(true);
        });
    }

    private static void applyNimbusLookAndFeelTheme(){
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if (NIMBUS_LOOK_AND_FEEL_NAME.equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            System.err.println("Failed to use 'Nimbus' look and feel! Exception message: " + ex.getMessage());
        }
    }

}
