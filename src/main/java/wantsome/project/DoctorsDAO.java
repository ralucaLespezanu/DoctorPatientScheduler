package wantsome.project;

import java.sql.SQLException;

public interface DoctorsDAO {

    void save(DoctorsDTO doctorsDTO) throws SQLException;

    DoctorsDTO get(int ID) throws SQLException;

    DoctorsDTO update(DoctorsDTO doctorsDTO) throws SQLException;

    void delete(DoctorsDTO doctorsDTO) throws SQLException;
}
