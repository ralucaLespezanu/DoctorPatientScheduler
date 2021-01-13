package wantsome.project;

import org.sqlite.SQLiteConfig;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AppointmentsDAOImpl implements AppointmentsDAO {

    private static final String databaseUrl = "jdbc:sqlite:C:\\Users\\home\\raluca\\sql-dbeaver";


    @Override
    public void save(AppointmentsDTO appointmentsDTO) throws SQLException {
        System.out.println("About to save: " + appointmentsDTO.toString());
        SQLiteConfig config = new SQLiteConfig();
        config.enforceForeignKeys(true);

        Connection connection = DriverManager.getConnection(databaseUrl);
        String query = "INSERT INTO appointments(doctor_id, patient_id, appDate, " +
                " status, doctor_notes, patient_notes) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, appointmentsDTO.getDoctor_id());
        preparedStatement.setInt(2, appointmentsDTO.getPatient_id());
        preparedStatement.setTimestamp(3, appointmentsDTO.getAppDate());
        preparedStatement.setString(4, appointmentsDTO.getStatus().toString());
        preparedStatement.setString(5, appointmentsDTO.getDoctor_notes());
        preparedStatement.setString(6, appointmentsDTO.getPatient_notes());

        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            int IDinserted = rs.getInt("id");
            System.out.println("Appointment with id created: " + IDinserted);
        }
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    @Override
    public AppointmentsDTO get(int doctor_id, Timestamp appDate) throws SQLException {
        AppointmentsDTO result = null;
        SQLiteConfig config = new SQLiteConfig();
        config.enforceForeignKeys(true);

        Connection connection = DriverManager.getConnection(databaseUrl);
        String query = "SELECT FROM appointments WHERE id= ?, appDate=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setInt(1, doctor_id);
        preparedStatement.setTimestamp(2, appDate);

        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            result = new AppointmentsDTO(rs.getInt("id"),
                    rs.getInt("doctor_id"),
                    rs.getInt("patient_id"),
                    rs.getTimestamp("appDate"),
                    Check.valueOf(rs.getString("status")),
                    rs.getString("doctor_notes"),
                    rs.getString("patient_notes"));
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
    public AppointmentsDTO update(AppointmentsDTO appointmentsDTO) throws SQLException {
        if (appointmentsDTO.getId() == null) {
            throw new IllegalArgumentException("appointmentsDTO.getId() is null.");
        }
        SQLiteConfig config = new SQLiteConfig();
        config.enforceForeignKeys(true);

        Connection connection = DriverManager.getConnection(databaseUrl, config.toProperties());
        String query = "UPDATE appointments SET doctor_id=?, patient_id=?, appDate=?, " +
                " status=?, doctor_notes=?, patient_notes=?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, appointmentsDTO.getDoctor_id());
        preparedStatement.setInt(2, appointmentsDTO.getPatient_id());
        preparedStatement.setTimestamp(3, appointmentsDTO.getAppDate());
        preparedStatement.setString(4, appointmentsDTO.getStatus().toString());
        preparedStatement.setString(5, appointmentsDTO.getDoctor_notes());
        preparedStatement.setString(6, appointmentsDTO.getPatient_notes());

        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
        return appointmentsDTO;
    }

    @Override
    public void delete(AppointmentsDTO appointmentsDTO) throws SQLException {
        if (appointmentsDTO.getId() == null) {
            throw new IllegalArgumentException("appointmentsDTO.getId() is null.");
        }
        SQLiteConfig config = new SQLiteConfig();
        config.enforceForeignKeys(true);

        Connection connection = DriverManager.getConnection(databaseUrl);
        String query = "DELETE FROM appointments WHERE ID= ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, appointmentsDTO.getId());

        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    @Override
    public List<AppointmentsDTO> getAll() throws SQLException {
        List<AppointmentsDTO> result = new ArrayList<>();
        SQLiteConfig config = new SQLiteConfig();
        config.enforceForeignKeys(true);

        Connection connection = DriverManager.getConnection(databaseUrl, config.toProperties());
        String query = "select * from appointments ";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            result.add(new AppointmentsDTO(rs.getInt("id"),
                    rs.getInt("doctor_id"),
                    rs.getInt("patient_id"),
                    rs.getTimestamp("appDate"),
                    Check.valueOf(rs.getString("status")),
                    rs.getString("doctor_notes"),
                    rs.getString("patient_notes")));
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
