package wantsome.project;


import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
import static spark.Spark.delete;

public class UsersWebService {

    private static Map<String, Users> users = new HashMap<>();

    public static void main(String[] args) {

        users.put("Popescu", new Users(1, "Mihai", "Popoescu", "popescum"));
        users.put("Ionescu", new Users(2, "Teodora", "Ionescu", "ionescut"));

        get("/users", (request, response) -> {
            response.type("application/json");
            return new Gson().toJson(users);
        });


        get("/user/:last_name", (request, response) -> {
            response.type("application/json");
            String last_name = request.params(":last_name");
            Users user = users.get(last_name);
            return new Gson().toJson(user);
        });

        post("/user/:last_name", (request, response) -> {
            Gson gson = new Gson();
            response.type("application/json");
            String last_name = request.params(":last_name");
            String body = request.body();
            Users newUser = gson.fromJson(body, Users.class);
            if (users.containsKey(last_name)) {
                response.status(400);
                return gson.toJson(new Message("Bad Request - User already exists!"));
            }
            users.put(last_name, newUser);
            response.status(200);
            return gson.toJson(new Message("User added successfully!"));
        });

        put("/user/:last_name", (request, response) -> {
            Gson gson = new Gson();
            response.type("application/json");
            String last_name = request.params(":last_name");
            String body = request.body();
            Users newUser = gson.fromJson(body, Users.class);
            if (!users.containsKey(last_name)) {
                response.status(400);
                return gson.toJson(new Message("Bad Request - User doesn't exist!"));
            }
            users.put(last_name, newUser);
            response.status(200);
            return gson.toJson(new Message("User modified successfully!"));
        });

        delete("/user/:last_name", (request, response) -> {
            Gson gson = new Gson();
            response.type("application/json");
            String last_name = request.params(":last_name");
            if (!users.containsKey(last_name)) {
                response.status(400);
                return gson.toJson(new Message("Bad Request - User doesn't exist!"));
            }
            users.remove(last_name);
            response.status(200);
            return gson.toJson(new Message("User deleted successfully!"));
        });

    }
}
