package hu.elte.fi.progtech.ae.gui.table;

import hu.elte.fi.progtech.ae.persistence.dao.ArtistDao;
import hu.elte.fi.progtech.ae.persistence.entity.Artist;

public class ArtistTableModel extends AbstractDataTableModel<Artist>{

    private static final String[] COLUMN_NAMES = new String[]{"Name", "Age", "Instruments"};

    public ArtistTableModel() {
        super(COLUMN_NAMES, new ArtistDao());
    }

    @Override
    protected void displayError(Exception exception) {
        String message = (exception == null) ? "Unknown error!" : exception.getMessage();
        System.err.println(message);
    }

    @Override
    protected Object getAttributeOfData(Artist data, int columnIndex) {
        return switch (columnIndex) {
            case 0 -> data.getName();
            case 1 -> data.getAge();
            case 2 -> data.getInstruments();
            default -> null;
        };
    }

    @Override
    protected void setDataAttributes(int columnIndex, Artist data, Object value) {
        switch (columnIndex) {
            case 0 -> data.setName((String) value);
            case 1 -> data.setAge((Integer) value);
            case 2 -> data.setInstruments((String) value);
        }
    }

    @Override
    public void addNewData() {
        Artist artist = new Artist();
        artist.setName("New artist");
        artist.setInstruments("-");
        addData(artist);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return switch (columnIndex) {
            case 0, 2 -> String.class;
            case 1 -> Integer.class;
            default -> null;
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
}
