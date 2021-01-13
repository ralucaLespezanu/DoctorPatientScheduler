package wantsome.project;

import org.sqlite.SQLiteConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDAOImpl implements UsersDAO {

    private static final String databaseUrl = "jdbc:sqlite:C:\\Users\\home\\raluca\\sql-dbeaver";

    @Override
    public void save(UsersDTO usersDTO) throws SQLException {
        System.out.println("About to save: " + usersDTO.toString());
        SQLiteConfig config = new SQLiteConfig();
        config.enforceForeignKeys(true);

        Connection connection = DriverManager.getConnection(databaseUrl);
        String query = "INSERT INTO users(first_name, last_name, password) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, usersDTO.getFirst_name());
        preparedStatement.setString(2, usersDTO.getLast_name());
        preparedStatement.setString(3, usersDTO.getPassword());

        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            int IDinserted = rs.getInt("id");
            System.out.println("User with id created: " + IDinserted);
        }
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    @Override
    public UsersDTO get(String last_name) throws SQLException {
        UsersDTO result = null;
        SQLiteConfig config = new SQLiteConfig();
        config.enforceForeignKeys(true);

        Connection connection = DriverManager.getConnection(databaseUrl, config.toProperties());
        String query = "SELECT FROM users WHERE ID= ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, last_name);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            result = new UsersDTO(rs.getInt("ID"), rs.getString("FIRST_NAME"),
                    rs.getString("LAST_NAME"), rs.getString("PASSWORD"));
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
    public UsersDTO update(UsersDTO usersDTO) throws SQLException {
        if (usersDTO.getId() == null) {
            throw new IllegalArgumentException("usersDAO.getID() is null.");
        }
        SQLiteConfig config = new SQLiteConfig();
        config.enforceForeignKeys(true);

        Connection connection = DriverManager.getConnection(databaseUrl);
        String query = "UPDATE users SET FIRST_NAME=?, LAST_NAME=?, PASSWORD=? ";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, usersDTO.getFirst_name());
        preparedStatement.setString(2, usersDTO.getLast_name());
        preparedStatement.setString(3, usersDTO.getPassword());

        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
        return usersDTO;
    }

    @Override
    public void delete(UsersDTO usersDTO) throws SQLException {
        if (usersDTO.getId() == null) {
            throw new IllegalArgumentException("usersDTO.getId() is null");
        }
        SQLiteConfig config = new SQLiteConfig();
        config.enforceForeignKeys(true);

        Connection connection = DriverManager.getConnection(databaseUrl);
        String query = "DELETE FROM users WHERE ID=?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, usersDTO.getId());

        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    @Override
    public List<UsersDTO> getAll() throws SQLException {
        List<UsersDTO> result = new ArrayList<>();
        SQLiteConfig config = new SQLiteConfig();
        config.enforceForeignKeys(true);

        Connection connection = DriverManager.getConnection(databaseUrl, config.toProperties());
        String query = "SELECT * FROM users ";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            result.add(new UsersDTO(rs.getInt("ID"), rs.getString("FIRST_NAME"),
                    rs.getString("LAST_NAME"), rs.getString("PASSWORD")));
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
