package hu.elte.fi.progtech.ae.gui.table;

import hu.elte.fi.progtech.ae.persistence.dao.IEntityDao;
import hu.elte.fi.progtech.ae.persistence.entity.Identifiable;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public abstract class AbstractDataTableModel<E extends Identifiable<Long> & Serializable> extends AbstractTableModel {

    protected final String[] columnNames;
    protected List<E> dataList;
    protected IEntityDao<E> dao;

    public AbstractDataTableModel(String[] columnNames, IEntityDao<E> dao) {
        this.columnNames = columnNames;
        this.dao = dao;

        dataList = new ArrayList<>();
        reloadData();
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        final E data = getDataAtRow(rowIndex);
        setDataAttributes(columnIndex, data, aValue);
        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                dao.update(data);
                return null;
            }

            @Override
            protected void done() {
                try {
                    get();
                    reloadData();
                } catch (InterruptedException | ExecutionException ex) {
                    displayError(ex);
                }
            }

        }.execute();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        E entity = getDataAtRow(rowIndex);
        return getAttributeOfData(entity, columnIndex);
    }

    protected E getDataAtRow(int rowIndex) {
        return dataList.get(rowIndex);
    }

    protected void addData(final E data) {
        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                dao.add(data);
                return null;
            }

            @Override
            protected void done() {
                try {
                    get();
                    reloadData();
                } catch (InterruptedException | ExecutionException ex) {
                    displayError(ex);
                }
            }

        }.execute();
    }

    protected final void reloadData() {
        new SwingWorker<List<E>, Void>() {

            @Override
            protected List<E> doInBackground() throws Exception {
                return dao.getAll();
            }

            @Override
            protected void done() {
                try {
                    dataList = get();
                    fireTableDataChanged();
                } catch (InterruptedException | ExecutionException ex) {
                    displayError(ex);
                }
            }
        }.execute();
    }

    public void deleteData(int modelIdx) {
        final E data = getDataAtRow(modelIdx);
        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                dao.delete(data.getId());
                return null;
            }

            @Override
            protected void done() {
                try {
                    get();
                    reloadData();
                } catch (InterruptedException | ExecutionException ex) {
                    displayError(ex);
                }
            }

        }.execute();
    }

    @Override
    public int getRowCount() {
        return dataList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    protected abstract void displayError(Exception exception);
    protected abstract Object getAttributeOfData(E data, int columnIndex);
    protected abstract void setDataAttributes(int columnIndex, final E data, Object value);
    public abstract void addNewData();
}
