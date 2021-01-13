package wantsome.project;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
import static wantsome.project.web.SparkUtil.render;

/**
 * Main class of the application. Using Spark framework.
 */
public class Main {


    private static SpecializationsWebService specializationsWebService = new SpecializationsWebService();

    private static DoctorsWebService doctorsWebService = new DoctorsWebService();

    private static PatientsWebService patientsWebService = new PatientsWebService();

    private static AppointmentsWebService appointmentsWebService = new AppointmentsWebService();

    private static UsersWebService usersWebService = new UsersWebService();

    public static void main(String[] args) {
        setup();
        configureRoutesAndStart();
    }

    private static void setup() {
        //create and configure all needed resources (like db tables, sample data, etc)
    }

    private static void configureRoutesAndStart() {
        staticFileLocation("public");

        //configure all routes
        get("/main", (req, res) -> getMainWebPage(req, res));

        get("/specializations", (req, res) -> getAllSPecializations(req, res));

        get("/specializations/:description", (req, res) -> getOneSPecialization(req, res));

        post("/specializations", (req, res) -> addOneSPecialization(req, res));


        get("/doctors", (req, res) -> getAllDOctors(req, res));
        get("/doctors/:last_name", (req, res) -> getOneDOctor(req, res));
        post("/doctors", (req, res) -> addOneDOctor(req, res));

        get("/patients", (req, res) -> getAllPAtients(req, res));
        get("/patients/:last_name", (req, res) -> getOnePAtient(req, res));
        post("/patients", (req, res) -> addOnePAtient(req, res));


        get("/appointments", (req, res) -> getAllAPpointments(req, res));
        get("/appointments/:doctor_id, appDate", (req, res) -> getOneAPpointment(req, res));
        post("/appointments", (req, res) -> addOneAPpointment(req, res));


        get("/users", (req, res) -> getAllUSers(req, res));
        get("/users/:last_name", (req, res) -> getOneUSer(req, res));
        post("/users", (req, res) -> addOneUSer(req, res));

        awaitInitialization();
        System.out.println("\nServer started: http://localhost:4567/main");
    }

    private static Object getAllDOctors(Request req, Response res) {
        Map<String, Object> model = new HashMap<>();
        try {
            model.put("doctors", doctorsWebService.getAllDoctors());
        } catch (Exception e) {
            System.out.println("Unable to get doctors: " + e.getMessage());
        }
        return render("doctors.vm", model);
    }

    private static Object getOneDOctor(Request req, Response res) {
        Map<String, Object> model = new HashMap<>();
        String last_name = req.params("last_name");
        try {
            model.put("doctor", doctorsWebService.getOneDoctor(last_name));
        } catch (Exception e) {
            System.out.println("Unable to get doctor: " + e.getMessage());
        }
        return render("doctor.vm", model);
    }

    private static Object addOneDOctor(Request req, Response res) {
        Map<String, Object> model = new HashMap<>();
        String first_name = req.params("first_name");
        String last_name = req.params("last_name");
        String phone_number = req.params("phone_number");
        String email = req.params("email");
        String specialization_id = req.params("specialization_id");
        try {
            model.put("doctor", doctorsWebService.addOneDoctor(first_name, last_name,
                    phone_number, email, Integer.valueOf(specialization_id)));
        } catch (Exception e) {
            System.out.println("Unable to add doctor: " + e.getMessage());
        }
        return render("doctor.vm", model);
    }

    private static Object getAllPAtients(Request req, Response res) {
        Map<String, Object> model = new HashMap<>();
        try {
            model.put("patients", patientsWebService.getAllPatients());
        } catch (Exception e) {
            System.out.println("Unable to get patients: " + e.getMessage());
        }
        return render("patients.vm", model);
    }


    private static Object getOnePAtient(Request req, Response res) {
        Map<String, Object> model = new HashMap<>();
        String last_name = req.params("last_name");
        try {
            model.put("patient", patientsWebService.getOnePatient(last_name));
        } catch (Exception e) {
            System.out.println("Unable to get patient: " + e.getMessage());
            ;
        }
        return render("patient.vm", model);
    }

    private static Object addOnePAtient(Request req, Response res) {
        Map<String, Object> model = new HashMap<>();
        String first_name = req.params("first_name");
        String last_name = req.params("last_name");
        String phone_number = req.params("phone_number");
        String email = req.params("email");
        String birth_date = req.params("birth_date");
        try {
            model.put("patient", patientsWebService.addOnePatient(first_name, last_name, phone_number,
                    email, java.sql.Date.valueOf(String.valueOf(birth_date))));
        } catch (Exception e) {
            System.out.println("Unable to add patient: " + e.getMessage());
        }
        return render("patient.vm", model);
    }


    //example of returning a web page
    private static Object getMainWebPage(Request req, Response res) {
        Map<String, Object> model = new HashMap<>();
        model.put("serverTime", new Date().toString());
        return render("main.vm", model);
    }

    private static Object getAllSPecializations(Request req, Response res) {
        Map<String, Object> model = new HashMap<>();
        try {
            model.put("specializations", specializationsWebService.getAllSpecializations());
        } catch (Exception e) {
            System.out.println("Unable to get specializations: " + e.getMessage());
        }
        return render("specializations.vm", model);
    }

    private static Object getOneSPecialization(Request req, Response res) {
        Map<String, Object> model = new HashMap<>();
        String description = req.params("description");
        try {
            model.put("specialization", specializationsWebService.getOneSpecialization(description));
        } catch (Exception e) {
            System.out.println("Unable to get one specialization: " + e.getMessage());
        }
        return render("specialization.vm", model);
    }

    private static Object addOneSPecialization(Request req, Response res) {
        Map<String, Object> model = new HashMap<>();
        String description = req.params("description");
        try {
            model.put("specialization", specializationsWebService.addOneSpecialization(description));
        } catch (Exception e) {
            System.out.println("Unable to add specialization: " + e.getMessage());
        }
        return render("specialization.vm", model);
    }

    private static Object getAllAPpointments(Request req, Response res) {
        Map<String, Object> model = new HashMap<>();
        try {
            model.put("appointments", appointmentsWebService.getAllAppointments());
        } catch (Exception e) {
            System.out.println("Unable to get appointments: " + e.getMessage());
        }
        return render("appointments.vm", model);
    }

    private static Object getOneAPpointment(Request req, Response res) {
        Map<String, Object> model = new HashMap<>();
        String doctorId = req.params("doctor_id");
        String appDate = req.params("appDate");
        try {
            model.put("appointment", appointmentsWebService.getOneAppointment
                    (Integer.valueOf(doctorId), Timestamp.valueOf(appDate)));
        } catch (Exception e) {
            System.out.println("Unable to get appointment: " + e.getMessage());
        }
        return render("appointment.vm", model);
    }

    private static Object addOneAPpointment(Request req, Response res) {
        Map<String, Object> model = new HashMap<>();
        String doctorId = req.params("doctor_id");
        String patientId = req.params("patient_id");
        String appDate = req.params("appDate");
        String status = req.params("status");
        String doctorNotes = req.params("doctor_notes");
        String patientNotes = req.params("patient_notes");
        try {
            model.put("appointment", appointmentsWebService.addOneAppointment(
                    Integer.valueOf(doctorId), Integer.valueOf(patientId),
                    Timestamp.valueOf(appDate), Check.valueOf(status), doctorNotes, patientNotes));
        } catch (Exception e) {
            System.out.println("Unable to add appointment: " + e.getMessage());
        }
        return render("appointment.vm", model);
    }

    private static Object getAllUSers(Request req, Response res) {
        Map<String, Object> model = new HashMap<>();
        try {
            model.put("users", usersWebService.getAllUsers());
        } catch (Exception e) {
            System.out.println("Unable to get users: " + e.getMessage());
        }
        return render("users.vm", model);
    }

    private static Object getOneUSer(Request req, Response res) {
        Map<String, Object> model = new HashMap<>();
        String last_name = req.params("last_name");
        try {
            model.put("user", usersWebService.getOneUser(last_name));
        } catch (Exception e) {
            System.out.println("Unable to get user: " + e.getMessage());
        }
        return render("user.vm", model);
    }

    private static Object addOneUSer(Request req, Response res) {
        Map<String, Object> model = new HashMap<>();
        String first_name = req.params("first_name");
        String last_name = req.params("last_name");
        String password = req.params("password");
        try {
            model.put("user", usersWebService.addOneUser(first_name, last_name, password));
        } catch (Exception e) {
            System.out.println("Unable to add user: " + e.getMessage());
        }
        return render("user.vm", model);
    }
}
