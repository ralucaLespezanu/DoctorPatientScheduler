package wantsome.project;

import com.google.gson.Gson;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;


public class AppointmentsWebService {

    private static Map<String, Appointments> appointments = new HashMap<>();

    public static void main(String[] args) {
        /*
        de ce pica la popularea mapei ?


        appointments.put("1", new Appointments(1, 2, 7, Timestamp.valueOf("2021-01-10 08:00:00"),
                Check.valueOf("pending"), "AVC in antecedente", "tratament cu Tertensif"));
*/
        get("/appointments", ((request, response) -> {
            response.type("application/json");
            return new Gson().toJson(appointments);
        }));

        get("/appointment/:id", (request, response) -> {
            response.type("application/json");
            String id = request.params(":id");
            Appointments appointment = appointments.get(id);
            return new Gson().toJson(appointment);
        });

        post("appointments/:id", (request, response) -> {
            Gson gson = new Gson();
            response.type("application/json");
            String id = request.params(":id");
            String body = request.body();
            Appointments newAppointment = gson.fromJson(body, Appointments.class);
            if (appointments.containsKey(id)) {
                response.status(400);
                return gson.toJson(new Message("Bad request- Appointment already exists!"));
            }
            appointments.put(id, newAppointment);
            response.status(200);
            return gson.toJson(new Message("Appointment added successfully!"));
        });

        put("/appointment/:id", ((request, response) -> {
            Gson gson = new Gson();
            response.type("application/json");
            String id = request.params(":id");
            String body = request.body();
            Appointments newAppointment = gson.fromJson(body, Appointments.class);
            if (!appointments.containsKey(id)) {
                response.status(400);
                return gson.toJson(new Message("Bad request- appointment doesn't exist!"));
            }
            appointments.put(id, newAppointment);
            response.status(200);
            return gson.toJson(new Message("Appointment added successfully!"));
        }));

        delete("/appointment/:id", (request, response) -> {
            Gson gson = new Gson();
            response.type("application/json");
            String id = request.params(":/id");
            if (!appointments.containsKey(id)) {
                response.status(400);
                return gson.toJson(new Message("Bad request- appointment doesn't exist!"));
            }
            appointments.remove(id);
            response.status(200);
            return gson.toJson(new Message("Appointment deleted successfully!"));
        });

    }
}
