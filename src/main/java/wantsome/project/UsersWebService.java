package wantsome.project;


import com.google.gson.Gson;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;
import static spark.Spark.delete;

public class UsersWebService {

    private static UsersDAO usersDAO = new UsersDAOImpl();

    public List<UsersDTO> getAllUsers() throws SQLException {
        List<UsersDTO> allUsersDTO = new ArrayList<>();
        allUsersDTO.addAll(usersDAO.getAll());
        return allUsersDTO;
    }

    public Users getOneUser(String last_name) throws SQLException {
        UsersDTO oneUserDTO = usersDAO.get(last_name);
        Users user = oneUserDTO.toUsers();
        return user;
    }

    public Users addOneUser(String first_name, String last_name, String password) throws SQLException {
        UsersDTO oneUserDTO = usersDAO.get(last_name);
        if (oneUserDTO == null) {
            UsersDTO usersDTO = new UsersDTO(null, first_name, last_name, password);
            usersDAO.save(usersDTO);
            UsersDTO savedObject = usersDAO.get(last_name);
            return savedObject.toUsers();
        } else {
            throw new RuntimeException("User already exists");
        }
    }


}
