package wantsome.project;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;

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

        // doctors

        // appointments

//        get("/specialization/:description", (request, response) -> {
//            response.type("application/json");
//            String description = request.params(":description");
//            Specializations specialization = specializations.get(description);
//            return new Gson().toJson(specialization);
//        });
//
//        post("/specialization/:description", (request, response) -> {
//            Gson gson = new Gson();
//            response.type("application/json");
//            String description = request.params(":description");
//            String body = request.body();
//            Specializations newSpecialization = gson.fromJson(body, Specializations.class);
//            if (specializations.containsKey(description)) {
//                response.status(400);
//                return gson.toJson(new Message("Bad Request - Specialization already exists!"));
//            }
//            specializations.put(description, newSpecialization);
//            response.status(200);
//            return gson.toJson(new Message("Specialization added successfully!"));
//        });

        awaitInitialization();
        System.out.println("\nServer started: http://localhost:4567/main");
    }

    private static Object getAllDOctors(Request req, Response res) {
        Map<String,Object> model= new HashMap<>();
        try{
            model.put("doctors", doctorsWebService.getAllDoctors());
        }
        catch (Exception e){
            System.out.println("Unable to get doctors: " + e.getMessage());
        }
        return render("doctors.vm", model);
    }

    private static Object getOneDOctor(Request req, Response res)  {
        Map<String, Object> model = new HashMap<>();
        String last_name = req.params("last_name");
        try {
            model.put("doctor", doctorsWebService.getOneDoctor(last_name));
        }
        catch(Exception e) {
            System.out.println("Unable to get one doctor: " + e.getMessage());
        }
        return render("doctor.vm", model);
    }

    private static Object addOneDOctor(Request req, Response res)  {
        Map<String, Object> model = new HashMap<>();
        String first_name= req.params("first_name");
        String last_name = req.params("last_name");
        String phone_number = req.params("phone_number");
        String email = req.params("email");
        String specialization_id= req.params("specialization_id");
        try {
            model.put("doctor", doctorsWebService.addOneDoctor(first_name, last_name, phone_number,email, Integer.valueOf(specialization_id)));
        }
        catch(Exception e) {
            System.out.println("Unable to add doctor: " + e.getMessage());
        }
        return render("specialization.vm", model);
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
        }
        catch(Exception e) {
            System.out.println("Unable to get specializations: " + e.getMessage());
        }
        return render("specializations.vm", model);
    }

    private static Object getOneSPecialization(Request req, Response res)  {
        Map<String, Object> model = new HashMap<>();
        String description = req.params("description");
        try {
            model.put("specialization", specializationsWebService.getOneSpecialization(description));
        }
        catch(Exception e) {
            System.out.println("Unable to get one specialization: " + e.getMessage());
        }
        return render("specialization.vm", model);
    }

    private static Object addOneSPecialization(Request req, Response res)  {
        Map<String, Object> model = new HashMap<>();
        String description = req.params("description");
        try {
            model.put("specialization", specializationsWebService.addOneSpecialization(description));
        }
        catch(Exception e) {
            System.out.println("Unable to add specialization: " + e.getMessage());
        }
        return render("specialization.vm", model);
    }

}
