package hu.elte.fi.progtech.ae.persistence.dao;

import hu.elte.fi.progtech.ae.persistence.entity.Identifiable;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public interface IEntityDao<E extends Identifiable<Long> & Serializable>  {

    List<E> getAll() throws SQLException;

    void add(E entity) throws SQLException;

    void update(E entity) throws SQLException;

    void delete(Long id) throws SQLException;
}
