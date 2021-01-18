package wantsome.project;

import java.sql.SQLException;
import java.util.List;

public interface PatientsDAO {


    void save(PatientsDTO patientsDTO) throws SQLException;

    PatientsDTO get(String last_name) throws SQLException;

    PatientsDTO get(String first_name, String last_name, String birth_date) throws SQLException;

    PatientsDTO update(PatientsDTO patientsDTO) throws SQLException;

    void delete(PatientsDTO patientsDTO) throws SQLException;

    List<PatientsDTO> getAll() throws SQLException;
}
