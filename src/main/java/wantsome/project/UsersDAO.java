package wantsome.project;

import java.sql.SQLException;

public interface UsersDAO {

    void save(UsersDTO usersDTO) throws SQLException;

    UsersDTO get(int id) throws SQLException;

    UsersDTO update(UsersDTO usersDTO) throws SQLException;

    void delete(UsersDTO usersDTO) throws SQLException;
}
