package wantsome.project;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public interface AppointmentsDAO {

    void save(AppointmentsDTO appointmentsDTO) throws SQLException;

    AppointmentsDTO get(int doctor_id, Timestamp appDate) throws SQLException;

    AppointmentsDTO update(AppointmentsDTO appointmentsDTO) throws SQLException;

    void delete(AppointmentsDTO appointmentsDTO) throws SQLException;

    List<AppointmentsDTO> getAll() throws SQLException;
}
