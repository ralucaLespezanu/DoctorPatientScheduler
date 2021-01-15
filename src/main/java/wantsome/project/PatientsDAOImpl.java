package wantsome.project;

import org.sqlite.SQLiteConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class PatientsDAOImpl implements PatientsDAO {

    private static final String databaseUrl = "jdbc:sqlite:C:\\Users\\home\\raluca\\sql-dbeaver";


    @Override
    public void save(PatientsDTO patientsDTO) throws SQLException {
        System.out.println("About to save: " + patientsDTO.toPatients());
        SQLiteConfig config = new SQLiteConfig();
        config.enforceForeignKeys(true);

        Connection connection = DriverManager.getConnection(databaseUrl);
        String query = "INSERT INTO patients(first_name, last_name, " +
                "phone_number, email, birth_date) values(?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, patientsDTO.getFirst_name());
        preparedStatement.setString(2, patientsDTO.getLast_name());
        preparedStatement.setString(3, patientsDTO.getPhone_number());
        preparedStatement.setString(4, patientsDTO.getEmail());
        preparedStatement.setDate(5, patientsDTO.getBirth_date());

        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            int IDinserted = rs.getInt("ID");
            System.out.println("Patient with ID created: " + IDinserted);
        }
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    @Override
    public PatientsDTO get(String last_name) throws SQLException {
        PatientsDTO result = null;
        SQLiteConfig config = new SQLiteConfig();
        config.enforceForeignKeys(true);

        Connection connection = DriverManager.getConnection(databaseUrl, config.toProperties());
        String query = "SELECT FROM patients WHERE last_name= ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, last_name);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            result = new PatientsDTO(rs.getInt("id"), rs.getString("first_name"),
                    rs.getString("last_name"), rs.getString("phone_number"),
                    rs.getString("email"), rs.getDate("birth_date"));
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
    public PatientsDTO update(PatientsDTO patientsDTO) throws SQLException {
        if (patientsDTO.getId() == null) {
            throw new IllegalArgumentException("patientsDTO.getID() is null.");
        }
        SQLiteConfig config = new SQLiteConfig();
        config.enforceForeignKeys(true);

        Connection connection = DriverManager.getConnection(databaseUrl);
        String query = "UPDATE patients SET FIRST_NAME=?, LAST_NAME=?, PHONE_NUMBER=?, EMAIL=?, BIRTH_DATE=? ";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, patientsDTO.getFirst_name());
        preparedStatement.setString(2, patientsDTO.getLast_name());
        preparedStatement.setString(3, patientsDTO.getPhone_number());
        preparedStatement.setString(4, patientsDTO.getEmail());
        preparedStatement.setDate(5, patientsDTO.getBirth_date());

        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
        return patientsDTO;
    }

    @Override
    public void delete(PatientsDTO patientsDTO) throws SQLException {

        if (patientsDTO.getId() == null) {
            throw new IllegalArgumentException("patientsDTO.getId() is null");
        }
        SQLiteConfig config = new SQLiteConfig();
        config.enforceForeignKeys(true);

        Connection connection = DriverManager.getConnection(databaseUrl);
        String query = "DELETE FROM patients WHERE ID=?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, patientsDTO.getId());

        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    @Override
    public List<PatientsDTO> getAll() throws SQLException {
        List<PatientsDTO> result = new ArrayList<>();
        SQLiteConfig config = new SQLiteConfig();
        config.enforceForeignKeys(true);

        Connection connection = DriverManager.getConnection(databaseUrl, config.toProperties());
        String query = "SELECT * FROM patients";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            result.add(new PatientsDTO(rs.getInt("id"), rs.getString("first_name"),
                    rs.getString("last_name"), rs.getString("phone_number"),
                    rs.getString("email"), rs.getDate("birth_date")));
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
