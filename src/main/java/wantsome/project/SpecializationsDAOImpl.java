package wantsome.project;

import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class SpecializationsDAOImpl implements SpecializationsDAO {

    private static final String databaseUrl = "jdbc:sqlite:C:\\Users\\home\\raluca\\sql-dbeaver";


    @Override
    public void save(SpecializationsDTO specializationsDTO) throws SQLException {
        System.out.println("About to save: " + specializationsDTO.toString());
        SQLiteConfig config = new SQLiteConfig();
        config.enforceForeignKeys(true);

        Connection connection = DriverManager.getConnection(databaseUrl);
        String query = "INSERT INTO specializations( DESCRIPTION) values (?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);


        preparedStatement.setString(1, specializationsDTO.getDescription());

       preparedStatement.execute();

        if (preparedStatement != null) {
            preparedStatement.close();
        }

        if (connection != null) {
            connection.close();
        }

    }

    @Override
    public SpecializationsDTO get(String description) throws SQLException {
        SpecializationsDTO result = null;
        SQLiteConfig config = new SQLiteConfig();
        config.enforceForeignKeys(true);

        Connection connection = DriverManager.getConnection(databaseUrl, config.toProperties());
        String query = "select * from specializations where description= ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, description);

        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            result = new SpecializationsDTO(rs.getInt("ID"), rs.getString("DESCRIPTION"));
        }
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
        return result;
    }

    @Override
    public SpecializationsDTO update(SpecializationsDTO specializationsDTO) throws SQLException {
        if (specializationsDTO.getId() == null) {
            throw new IllegalArgumentException("specializationsDTO.getID() is null.");
        }
        SQLiteConfig config = new SQLiteConfig();
        config.enforceForeignKeys(true);
        Connection connection = DriverManager.getConnection(databaseUrl);
        String query = "update specializations set description= ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, specializationsDTO.getDescription());


        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
        return specializationsDTO;
    }

    @Override
    public void delete(SpecializationsDTO specializationsDTO) throws SQLException {
        if (specializationsDTO.getId() == null) {
            throw new IllegalArgumentException("specializationsDTO.getId() is null");
        }
        SQLiteConfig config = new SQLiteConfig();
        config.enforceForeignKeys(true);

        Connection connection = DriverManager.getConnection(databaseUrl);
        String query = "delete from specializations where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setInt(1, specializationsDTO.getId());
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    @Override
    public List<SpecializationsDTO> getAll() throws SQLException {
        List<SpecializationsDTO> result = new ArrayList<>();
        SQLiteConfig config = new SQLiteConfig();
        config.enforceForeignKeys(true);

        Connection connection = DriverManager.getConnection(databaseUrl, config.toProperties());
        String query = "select * from specializations";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            result.add(new SpecializationsDTO(rs.getInt("ID"), rs.getString("DESCRIPTION")));
        }
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
        return result;
    }
}
