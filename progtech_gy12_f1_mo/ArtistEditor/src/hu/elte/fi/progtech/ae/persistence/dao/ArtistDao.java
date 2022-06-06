package hu.elte.fi.progtech.ae.persistence.dao;

import hu.elte.fi.progtech.ae.persistence.connection.DataSource;
import hu.elte.fi.progtech.ae.persistence.entity.Artist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtistDao implements IEntityDao<Artist> {

    private static final String SELECT_ALL_QUERY = "SELECT * FROM artist";
    private static final String INSERT_QUERY = "INSERT INTO artist (name, age, instruments) VALUES (?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE artist SET name = ?, age = ?, instruments = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM artist WHERE id = ?";

    private static final String ATTR_NAME_ID = "id";
    private static final String ATTR_NAME_NAME = "name";
    private static final String ATTR_NAME_AGE = "age";
    private static final String ATTR_NAME_INSTRUMENTS = "instruments";

    @Override
    public List<Artist> getAll() throws SQLException {
        try(Connection connection = DataSource.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_QUERY)) {

            final List<Artist> artists = new ArrayList<>();
            while(resultSet.next()) {
                final Artist artist = new Artist();
                artist.setId(resultSet.getLong(ATTR_NAME_ID));
                artist.setName(resultSet.getString(ATTR_NAME_NAME));
                Object age = resultSet.getObject(ATTR_NAME_AGE);
                artist.setAge((Integer) age);
                artist.setInstruments(resultSet.getString(ATTR_NAME_INSTRUMENTS));
                artists.add(artist);
            }
            return artists;
        }
    }

    @Override
    public void add(Artist entity) throws SQLException {
        try(Connection connection = DataSource.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setObject(2, entity.getAge(), Types.SMALLINT); // null miatt
            preparedStatement.setString(3, entity.getInstruments());

            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void update(Artist entity) throws SQLException {
        try(Connection connection = DataSource.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY)) {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setObject(2, entity.getAge(), Types.SMALLINT); // null miatt
            preparedStatement.setString(3, entity.getInstruments());
            preparedStatement.setLong(4, entity.getId());

            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void delete(Long id) throws SQLException {
        try(Connection connection = DataSource.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY)) {
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
        }
    }

}
