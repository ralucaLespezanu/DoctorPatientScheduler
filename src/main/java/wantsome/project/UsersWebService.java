package wantsome.project;


import com.google.gson.Gson;
import spark.Request;
import spark.Response;

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
}
