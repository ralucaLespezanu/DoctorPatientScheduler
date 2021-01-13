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
}
