package wantsome.project;

import java.sql.SQLException;

public interface AppointmentsDAO {

    void save(AppointmentsDTO appointmentsDTO) throws SQLException;

    AppointmentsDTO get(int id) throws SQLException;

    AppointmentsDTO update(AppointmentsDTO appointmentsDTO) throws SQLException;

    void delete(AppointmentsDTO appointmentsDTO) throws SQLException;
}
