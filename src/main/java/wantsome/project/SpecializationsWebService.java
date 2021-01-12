package wantsome.project;

import com.google.gson.Gson;
import spark.Request;

import static spark.Spark.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpecializationsWebService {
    private static Map<String, Specializations> specializations = new HashMap<>();

    private static SpecializationsDAO specializationsDAO = new SpecializationsDAOImpl();


    public List<SpecializationsDTO> getAllSpecializations() throws SQLException {
        List<SpecializationsDTO> specializationsDTOList = new ArrayList<>();
        specializationsDTOList.addAll(specializationsDAO.getAll());
        return specializationsDTOList;
    }

    public Specializations getOneSpecialization(String description) throws SQLException {
        SpecializationsDTO oneSpecializationDTO = specializationsDAO.get(description);
        Specializations specialization = oneSpecializationDTO.toSpecializations();
        return specialization;

    }

    public Specializations addOneSpecialization(String description) throws SQLException {
        SpecializationsDTO oneSpecializationDTO = specializationsDAO.get(description);
        if (oneSpecializationDTO == null) {
            // nu exista in baza de date
            SpecializationsDTO specializationsDTO = new SpecializationsDTO(null, description);
            specializationsDAO.save(specializationsDTO);
            SpecializationsDTO savedObject = specializationsDAO.get(description);
            return savedObject.toSpecializations();
        } else {
            // exista in baza de date
            throw new RuntimeException("Specialization already exists");
        }
    }


    public static void main(String[] args) {
        /*

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
*/
    }
}
