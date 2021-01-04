package wantsome.project;

import com.google.gson.Gson;

import static spark.Spark.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class PatientsWebService {

    private static Map<String, Patients> patients = new HashMap<>();

    public static void main(String[] args) {

        patients.put("Mircea", new Patients(1, "Claudiu", "Mircea",
                "0712129711", "claudiumircea@email.com", Date.valueOf("1948-01-22")));
        patients.put("Dumitrescu", new Patients(2, "Razvan", "Dumitrescu",
                "0712129712", "razvandumitrescu@email.com", Date.valueOf("1945-02-12")));

        get("/patients", (request, response) -> {
            response.type("application/json");
            return new Gson().toJson(patients);
        });


        get("/patient/:last_name", (request, response) -> {
            response.type("application/json");
            String last_name = request.params(":last_name");
            Patients patient = patients.get(last_name);
            return new Gson().toJson(patient);
        });

        post("/patient/:last_name", (request, response) -> {
            Gson gson = new Gson();
            response.type("application/json");
            String last_name = request.params(":last_name");
            String body = request.body();
            Patients newPatient = gson.fromJson(body, Patients.class);
            if (patients.containsKey(last_name)) {
                response.status(400);
                return gson.toJson(new Message("Bad Request - Patient already exists!"));
            }
            patients.put(last_name, newPatient);
            response.status(200);
            return gson.toJson(new Message("Patient added successfully!"));
        });

        put("/patient/:last_name", (request, response) -> {
            Gson gson = new Gson();
            response.type("application/json");
            String last_name = request.params(":last_name");
            String body = request.body();
            Patients newPatient = gson.fromJson(body, Patients.class);
            if (!patients.containsKey(last_name)) {
                response.status(400);
                return gson.toJson(new Message("Bad Request - Patient doesn't exist!"));
            }
            patients.put(last_name, newPatient);
            response.status(200);
            return gson.toJson(new Message("Patient modified successfully!"));
        });

        delete("/patient/:last_name", (request, response) -> {
            Gson gson = new Gson();
            response.type("application/json");
            String last_name = request.params(":last_name");
            if (!patients.containsKey(last_name)) {
                response.status(400);
                return gson.toJson(new Message("Bad Request - Patient doesn't exist!"));
            }
            patients.remove(last_name);
            response.status(200);
            return gson.toJson(new Message("Patient deleted successfully!"));
        });

    }
}
