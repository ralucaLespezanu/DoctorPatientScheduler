package wantsome.project;

import com.google.gson.Gson;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;

public class DoctorsWebService {
    private static Map<String, Doctors> doctors = new HashMap<>();

    public static void main(String[] args) {

        doctors.put("Popoescu", new Doctors(1, "Mihai", "Popoescu",
                "mihaipopescu@email.com", "0744919900", 1));
        doctors.put("Ionescu", new Doctors(2, "Teodora", "Ionescu",
                "teodoraionescu@email.com", "0744919901", 1));

        get("/doctors", (request, response) -> {
            response.type("application/json");
            return new Gson().toJson(doctors);
        });


        get("/doctor/:last_name", (request, response) -> {
            response.type("application/json");
            String last_name = request.params(":last_name");
            Doctors doctor = doctors.get(last_name);
            return new Gson().toJson(doctor);
        });

        post("/doctor/:last_name", (request, response) -> {
            Gson gson = new Gson();
            response.type("application/json");
            String last_name = request.params(":last_name");
            String body = request.body();
            Doctors newDoctor = gson.fromJson(body, Doctors.class);
            if (doctors.containsKey(last_name)) {
                response.status(400);
                return gson.toJson(new Message("Bad Request - Doctor already exists!"));
            }
            doctors.put(last_name, newDoctor);
            response.status(200);
            return gson.toJson(new Message("Doctor added successfully!"));
        });

        put("/doctor/:last_name", (request, response) -> {
            Gson gson = new Gson();
            response.type("application/json");
            String last_name = request.params(":last_name");
            String body = request.body();
            Doctors newDoctor = gson.fromJson(body, Doctors.class);
            if (!doctors.containsKey(last_name)) {
                response.status(400);
                return gson.toJson(new Message("Bad Request - Doctor doesn't exist!"));
            }
            doctors.put(last_name, newDoctor);
            response.status(200);
            return gson.toJson(new Message("Doctor modified successfully!"));
        });

        delete("/doctor/:last_name", (request, response) -> {
            Gson gson = new Gson();
            response.type("application/json");
            String last_name = request.params(":last_name");
            if (!doctors.containsKey(last_name)) {
                response.status(400);
                return gson.toJson(new Message("Bad Request - Doctor doesn't exist!"));
            }
            doctors.remove(last_name);
            response.status(200);
            return gson.toJson(new Message("Doctor deleted successfully!"));
        });

    }

}




