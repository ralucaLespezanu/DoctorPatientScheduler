package wantsome.project;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public interface UsersDAO {

    void save(UsersDTO usersDTO) throws SQLException;

    UsersDTO get(String last_name) throws SQLException;

    UsersDTO get(String last_name, String password) throws SQLException;

    UsersDTO get(String first_name, String last_name, String password) throws SQLException;

    UsersDTO update(UsersDTO usersDTO) throws SQLException;

    void delete(UsersDTO usersDTO) throws SQLException;

    List<UsersDTO> getAll() throws SQLException;

}
