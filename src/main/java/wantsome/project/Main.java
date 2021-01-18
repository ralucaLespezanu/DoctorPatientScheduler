package wantsome.project;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;

import java.security.IdentityScope;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;

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

    private static UsersDAO usersDAO= new UsersDAOImpl();

    private static AppointmentsDAO appointmentsDAO= new AppointmentsDAOImpl();

    private static DoctorsDAO doctorsDAO= new DoctorsDAOImpl();

    private static PatientsDAO patientsDAO= new PatientsDAOImpl();

    private static SpecializationsDAO specializationsDAO= new SpecializationsDAOImpl();

    public static void main(String[] args){
       setup();
       configureRoutesAndStart();
    }

    private static void setup() {
        //create and configure all needed resources (like db tables, sample data, etc)
    }

    private static void configureRoutesAndStart()  {

        staticFileLocation("public");

        //configure all routes
        get("/main", (req, res) -> getMainWebPage(req, res));

        get("/specializations", (req, res) -> getAllSPecializations(req, res));

        get("/specializations/:description", (req, res) -> getOneSPecialization(req, res));

        post("/specializationsForm", (req, res) -> addOneSPecialization(req, res));


        get("/doctors", (req, res) -> getAllDOctors(req, res));
        get("/doctors/:last_name", (req, res) -> getOneDOctor(req, res));
        post("/doctorsForm", (req, res) -> addOneDOctor(req, res));

        get("/patients", (req, res) -> getAllPAtients(req, res));
        get("/patients/:last_name", (req, res) -> getOnePAtient(req, res));
        post("/patientsForm", (req, res) -> addOnePAtient(req, res));


        get("appointments", (req, res) -> getAllAPpointments(req, res));
        get("appointments/:doctor_id, appDate", (req, res) -> getOneAPpointment(req, res));
        post("appointmentsForm", (req, res) -> addOneAPpointment(req, res));

        get("appointmentsMain", (req, res) -> getAppointmentsMain(req, res));


        get("/users", (req, res) -> getAllUSers(req, res));
        get("/users/:last_name", (req, res) -> getOneUSer(req, res));
        post("/usersForm", (req, res) -> addOneUSer(req, res));


        get("login", (req, res) -> getLogin(req, res));
        get("appointmentsForm", (req, res) -> getAppointmentsForm(req, res));
        get("doctorsForm", (req, res) -> getDoctorsForm(req, res));
        get("patientsForm", (req, res) -> getPatientsForm(req, res));
        get("specializationsForm", (req, res) -> getSpecializationsForm(req, res));
        get("usersForm", (req, res) -> getUsersForm(req, res));



        post("login", (req, res) -> getLOgin(req, res));


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

    private static Object addOneDOctor(Request req, Response res) throws SQLException {
        String first_name = req.queryParams("first_name");
        String last_name = req.queryParams("last_name");
        String phone_number = req.queryParams("phone_number");
        String email = req.queryParams("email");
        String specializations_id = req.queryParams("specializations_id");
        DoctorsDTO oneDoctorDTO= doctorsDAO.get(first_name, last_name);
        String content = "";
        if (oneDoctorDTO == null) {
            DoctorsDTO doctorsDTO = new DoctorsDTO(first_name, last_name, phone_number, email, Integer.valueOf(specializations_id));
            doctorsDAO.save(doctorsDTO);
            res.redirect("/doctors/:last_name");
        } else {
            content = "doctor already exists";
        }
        return content + "<br/><a href='doctorsForm'>try again</a>";
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

    private static Object addOnePAtient(Request req, Response res) throws SQLException {
        String first_name = req.queryParams("first_name");
        String last_name = req.queryParams("last_name");
        String phone_number = req.queryParams("phone_number");
        String email = req.queryParams("email");
        String birth_date = req.queryParams("birth_date");
        PatientsDTO onePatientDTO = patientsDAO.get(first_name, last_name, birth_date);
        String content = "";
        if (onePatientDTO == null) {
            PatientsDTO patientsDTO = new PatientsDTO(first_name, last_name, phone_number, email, java.sql.Date.valueOf(birth_date));
            patientsDAO.save(patientsDTO);
            res.redirect("/patients/:last_name");
        } else {
            content = "patient already exists";
        }
        return content + "<br/><a href='patientsForm'>try again</a>";
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

    private static Object addOneSPecialization(Request req, Response res) throws SQLException {
        String description = req.queryParams("description");
        SpecializationsDTO oneSpecializationDTO = specializationsDAO.get(description);
        String content = "";
        if (oneSpecializationDTO == null) {
            SpecializationsDTO specializationsDTO = new SpecializationsDTO(description);
            specializationsDAO.save(specializationsDTO);
            res.redirect("/specializations/:description");
        } else {
            content = "specialization already exists";
        }
        return content + "<br/><a href='specializationsForm'>try again</a>";
    }

    private static Object getAllAPpointments(Request req, Response res) {
        Map<String, Object> model = new HashMap<>();
        try {
            List<AppointmentsDTO> appointments = appointmentsWebService.getAllAppointments();
            System.out.println("appointments: " + appointments);
            model.put("appointments", appointments);
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

    private static Object addOneAPpointment(Request req, Response res) throws SQLException {
        String doctor_id= req.queryParams("doctor_id");
        String patient_id = req.queryParams("patient_id");
        String appDate = req.queryParams("appDate");
        String status = req.queryParams("status");
        String doctor_notes = req.queryParams("doctor_notes");
        String patient_notes = req.queryParams("patient_notes");
        String content= "";
        AppointmentsDTO oneAppointmentDTO = appointmentsDAO.get(Integer.valueOf(doctor_id), Timestamp.valueOf(appDate));
        if (oneAppointmentDTO == null) {
            AppointmentsDTO appointmentsDTO = new AppointmentsDTO(Integer.valueOf(patient_id), Integer.valueOf(doctor_id), Timestamp.valueOf(appDate), Check.valueOf(status), doctor_notes, patient_notes);
            appointmentsDAO.save(appointmentsDTO);
            res.redirect("/appointments/:doctor_id, appDate");
        } else {
            content = "appointment already exists";
        }
        return content + "<br/><a href='appointmentsForm'>try again</a>";
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

    private static Object addOneUSer(Request req, Response res) throws SQLException {
        String first_name = req.queryParams("first_name");
        String last_name = req.queryParams("last_name");
        String password = req.queryParams("password");
        UsersDTO oneUserDTO = usersDAO.get(first_name, last_name, password);
        String content = "";
        if (oneUserDTO == null) {
            UsersDTO usersDTO = new UsersDTO( first_name, last_name, password);
            usersDAO.save(usersDTO);
            res.redirect("/users/:last_name");
        } else {
            content = "user already exists";
        }
        return content + "<br/><a href='usersForm'>try again</a>";
    }




        private static Object getAppointmentsMain (Request req, Response res){
            Map<String, Object> model = new HashMap<>();
            model.put("appointmentsMain", new Date().toString());
            return render("appointmentsMain.vm", model);
        }

        private static Object getLogin (Request req, Response res){
            Map<String, Object> model = new HashMap<>();
            model.put("login", new Date().toString());
            return render("login.vm", model);
        }

        private static Object getAppointmentsForm (Request req, Response res){
            Map<String, Object> model = new HashMap<>();
            model.put("appointmentsForm", new Date().toString());
            return render("appointmentsForm.html", model);
        }

        private static Object getDoctorsForm (Request req, Response res){
            Map<String, Object> model = new HashMap<>();
            model.put("doctorsForm", new Date().toString());
            return render("doctorsForm.html", model);
        }

        private static Object getPatientsForm (Request req, Response res){
            Map<String, Object> model = new HashMap<>();
            model.put("patientsForm", new Date().toString());
            return render("patientsForm.html", model);
        }

        public static Object getSpecializationsForm (Request req, Response res){
            Map<String, Object> model = new HashMap<>();
            model.put("specializationsForm", new Date().toString());
            return render("specializationsForm.html", model);
        }

        public static Object getUsersForm (Request req, Response res){
            Map<String, Object> model = new HashMap<>();
            model.put("usersForm", new Date().toString());
            return render("usersForm.html", model);
        }

        public static Object getLOgin (Request req, Response res) throws SQLException {
            Map<String, Object> model = new HashMap<>();
            String last_name = req.queryParams("last_name");
            String password = req.queryParams("password");
            String content = "";
            if (usersDAO.get(last_name, password) != null) {
                res.redirect("/appointmentsMain");
            } else {
                content = "invalid user or password";
            }
            return content + "<br/><a href='login'>try again</a>";
        }

    }
