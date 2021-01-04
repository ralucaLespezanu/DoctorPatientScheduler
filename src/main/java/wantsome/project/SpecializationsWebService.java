package wantsome.project;

import com.google.gson.Gson;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;

public class SpecializationsWebService {
    private static Map<String, Specializations> specializations = new HashMap<>();

    public static void main(String[] args) {

        specializations.put("pediatrie", new Specializations(1, "pediatrie"));
        specializations.put("cardiologie", new Specializations(2, "cardiologie"));

        get("/specializations", (request, response) -> {
            response.type("application/json");
            return new Gson().toJson(specializations);
        });


        get("/specialization/:description", (request, response) -> {
            response.type("application/json");
            String description = request.params(":description");
            Specializations specialization = specializations.get(description);
            return new Gson().toJson(specialization);
        });

        post("/specialization/:description", (request, response) -> {
            Gson gson = new Gson();
            response.type("application/json");
            String description = request.params(":description");
            String body = request.body();
            Specializations newSpecialization = gson.fromJson(body, Specializations.class);
            if (specializations.containsKey(description)) {
                response.status(400);
                return gson.toJson(new Message("Bad Request - Specialization already exists!"));
            }
            specializations.put(description, newSpecialization);
            response.status(200);
            return gson.toJson(new Message("Specialization added successfully!"));
        });

        put("/specialization/:description", (request, response) -> {
            Gson gson = new Gson();
            response.type("application/json");
            String description = request.params(":description");
            String body = request.body();
            Specializations newSpecialization = gson.fromJson(body, Specializations.class);
            if (!specializations.containsKey(description)) {
                response.status(400);
                return gson.toJson(new Message("Bad Request - Specialization doesn't exist!"));
            }
            specializations.put(description, newSpecialization);
            response.status(200);
            return gson.toJson(new Message("Specialization modified successfully!"));
        });

        delete("/specialization/:description", (request, response) -> {
            Gson gson = new Gson();
            response.type("application/json");
            String description = request.params(":last_name");
            if (!specializations.containsKey(description)) {
                response.status(400);
                return gson.toJson(new Message("Bad Request - Specialization doesn't exist!"));
            }
            specializations.remove(description);
            response.status(200);
            return gson.toJson(new Message("Specialization deleted successfully!"));
        });

    }
}
