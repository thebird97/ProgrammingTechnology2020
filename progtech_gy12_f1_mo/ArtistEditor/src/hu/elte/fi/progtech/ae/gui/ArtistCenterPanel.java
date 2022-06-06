package hu.elte.fi.progtech.ae.gui;

import hu.elte.fi.progtech.ae.gui.table.ArtistTableModel;

import javax.swing.*;
import java.awt.*;

public class ArtistCenterPanel extends JPanel {

    private final ArtistTableModel artistTableModel;
    private final JTable artistTable;

    public ArtistCenterPanel() {
        artistTableModel = new ArtistTableModel();
        artistTable = new JTable(artistTableModel);
        artistTable.setAutoCreateRowSorter(true);
        artistTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(artistTable);
        scrollPane.setPreferredSize(new Dimension(400, 400));

        setPreferredSize(new Dimension(400, 400));
        add(scrollPane);
    }

    public ArtistTableModel getArtistTableModel() {
        return artistTableModel;
    }

    public JTable getArtistTable() {
        return artistTable;
    }
}
