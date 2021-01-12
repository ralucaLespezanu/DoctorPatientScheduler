package wantsome.project;

import java.sql.SQLException;
import java.util.List;

public interface DoctorsDAO {

    void save(DoctorsDTO doctorsDTO) throws SQLException;

    DoctorsDTO get(String last_name) throws SQLException;

    DoctorsDTO update(DoctorsDTO doctorsDTO) throws SQLException;

    void delete(DoctorsDTO doctorsDTO) throws SQLException;

    List<DoctorsDTO> getAll() throws SQLException;
}
