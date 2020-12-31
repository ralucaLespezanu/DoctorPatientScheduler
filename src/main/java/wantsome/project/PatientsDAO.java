package wantsome.project;

import java.sql.SQLException;

public interface PatientsDAO {


    void save(PatientsDTO patientsDTO) throws SQLException;

    PatientsDTO get(int id) throws SQLException;

    PatientsDTO update(PatientsDTO patientsDTO) throws SQLException;

    void delete(PatientsDTO patientsDTO) throws SQLException;

}
