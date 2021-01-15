package wantsome.project;

import org.sqlite.SQLiteConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorsDAOImpl implements DoctorsDAO {

    private static final String databaseUrl = "jdbc:sqlite:C:\\Users\\home\\raluca\\sql-dbeaver";

    @Override
    public void save(DoctorsDTO doctorsDTO) throws SQLException {
        System.out.println("About to save: " + doctorsDTO.toString());
        SQLiteConfig config = new SQLiteConfig();
        config.enforceForeignKeys(true);

        Connection connection = DriverManager.getConnection(databaseUrl, config.toProperties());
        String query = "INSERT INTO doctors (FIRST_NAME, LAST_NAME, " +
                " PHONE_NUMBER, EMAIL, SPECIALIZATION_ID) values(?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);


        preparedStatement.setString(1, doctorsDTO.getFirst_name());
        preparedStatement.setString(2, doctorsDTO.getLast_name());
        preparedStatement.setString(3, doctorsDTO.getPhone_number());
        preparedStatement.setString(4, doctorsDTO.getEmail());
        preparedStatement.setInt(5, doctorsDTO.getSpecializations_id());
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            int idInserted = rs.getInt("ID");
            System.out.println("doctor with id created: " + idInserted);
        }

        if (preparedStatement != null) {
            preparedStatement.close();
        }

        if (connection != null) {
            connection.close();
        }
    }

    @Override
    public DoctorsDTO get(String last_name) throws SQLException {
        DoctorsDTO result = null;
        SQLiteConfig config = new SQLiteConfig();
        config.enforceForeignKeys(true);

        Connection connection = DriverManager.getConnection(databaseUrl, config.toProperties());
        String query = "select * from doctors where last_name= ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, last_name);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            result = new DoctorsDTO(rs.getInt("ID"), rs.getString("FIRST_NAME"),
                    rs.getString("LAST_NAME"), rs.getString("PHONE_NUMBER"),
                    rs.getString("EMAIL"), rs.getInt("SPECIALIZATION_ID"));
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
    public DoctorsDTO update(DoctorsDTO doctorsDTO) throws SQLException {
        if (doctorsDTO.getId() == null) {
            throw new IllegalArgumentException("doctorsDTO.getID() is null.");
        }
        SQLiteConfig config = new SQLiteConfig();
        config.enforceForeignKeys(true);
        Connection connection = DriverManager.getConnection(databaseUrl);
        String query = "update doctors set first_name= ?, last_name= ?, " +
                "phone_number= ?, email= ?, specialization_id= ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, doctorsDTO.getFirst_name());
        preparedStatement.setString(1, doctorsDTO.getLast_name());
        preparedStatement.setString(1, doctorsDTO.getPhone_number());
        preparedStatement.setString(1, doctorsDTO.getEmail());
        preparedStatement.setInt(1, doctorsDTO.getSpecializations_id());

        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
        return doctorsDTO;
    }


    @Override
    public void delete(DoctorsDTO doctorsDTO) throws SQLException {
        if (doctorsDTO.getId() == null) {
            throw new IllegalArgumentException("doctorsDTO.getId() is null");
        }
        SQLiteConfig config = new SQLiteConfig();
        config.enforceForeignKeys(true);

        Connection connection = DriverManager.getConnection(databaseUrl);
        String query = "delete from doctors where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setInt(1, doctorsDTO.getId());
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    @Override
    public List<DoctorsDTO> getAll() throws SQLException {
        List<DoctorsDTO> result = new ArrayList<>();
        SQLiteConfig config = new SQLiteConfig();
        config.enforceForeignKeys(true);

        Connection connection = DriverManager.getConnection(databaseUrl, config.toProperties());
        String query = "select * from doctors";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            result.add(new DoctorsDTO(rs.getInt("ID"), rs.getString("FIRST_NAME"),
                    rs.getString("LAST_NAME"), rs.getString("PHONE_NUMBER"),
                    rs.getString("EMAIL"), rs.getInt("SPECIALIZATION_ID")));
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