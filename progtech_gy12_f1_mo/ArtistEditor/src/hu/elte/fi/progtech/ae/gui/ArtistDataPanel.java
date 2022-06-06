package hu.elte.fi.progtech.ae.gui;

import hu.elte.fi.progtech.ae.gui.table.ArtistTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ArtistDataPanel extends JPanel {

    private final ArtistCenterPanel centerPanel;

    public ArtistDataPanel() {
        setPreferredSize(new Dimension(400, 460));
        setLayout(new BorderLayout());

        centerPanel = new ArtistCenterPanel();

        add(createHeaderPanel(), BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(createBottomPanel(), BorderLayout.SOUTH);
    }

    private JPanel createHeaderPanel() {
        JPanel headerPanel = new JPanel();
        headerPanel.setPreferredSize(new Dimension(400, 20));
        headerPanel.add(new JLabel("Artists", SwingConstants.CENTER));
        return headerPanel;
    }

    public JPanel createBottomPanel() {
        JButton newArtistButton = new JButton("New artist");
        newArtistButton.setPreferredSize(new Dimension(100, 40));
        newArtistButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent event) {
                ArtistTableModel artistTableModel = centerPanel.getArtistTableModel();
                artistTableModel.addNewData();
            }
        });


        JButton deleteArtistButton = new JButton("Delete artist");
        deleteArtistButton.setPreferredSize(new Dimension(100, 40));
        deleteArtistButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent event) {
                JTable artistTable = centerPanel.getArtistTable();
                ArtistTableModel artistTableModel = centerPanel.getArtistTableModel();

                int selectedRowIdx = artistTable.getSelectedRow();
                if(selectedRowIdx > -1) {
                    int modelIdx = artistTable.convertRowIndexToModel(selectedRowIdx);
                    artistTableModel.deleteData(modelIdx);
                }
            }
        });

        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(400, 50));
        bottomPanel.add(newArtistButton);
        bottomPanel.add(deleteArtistButton);

        return bottomPanel;
    }

}
