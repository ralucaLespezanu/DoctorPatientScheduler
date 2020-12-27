package wantsome.project;

import java.sql.SQLException;

public interface SpecializationsDAO {

    void save(SpecializationsDTO specializationsDTO) throws SQLException;

    SpecializationsDTO get(int ID) throws SQLException;

    SpecializationsDTO update(SpecializationsDTO specializationsDTO) throws SQLException;

    void delete(SpecializationsDTO specializationsDTO) throws SQLException;
}
