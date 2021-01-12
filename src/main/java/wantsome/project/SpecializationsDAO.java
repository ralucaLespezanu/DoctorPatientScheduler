package wantsome.project;

import java.sql.SQLException;
import java.util.List;

public interface SpecializationsDAO {

    void save(SpecializationsDTO specializationsDTO) throws SQLException;

    SpecializationsDTO get(String description) throws SQLException;

    SpecializationsDTO update(SpecializationsDTO specializationsDTO) throws SQLException;

    void delete(SpecializationsDTO specializationsDTO) throws SQLException;

    List<SpecializationsDTO> getAll() throws SQLException;
}
