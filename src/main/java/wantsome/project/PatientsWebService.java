package wantsome.project;

import com.google.gson.Gson;

import static spark.Spark.*;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;

public class PatientsWebService {

    private static PatientsDAO patientsDAO = new PatientsDAOImpl();

    public List<PatientsDTO> getAllPatients() throws SQLException {
        List<PatientsDTO> patientsDTOList = new ArrayList<>();
        patientsDTOList.addAll(patientsDAO.getAll());
        return patientsDTOList;
    }

    public Patients getOnePatient(String last_name) throws SQLException {
        PatientsDTO onePatientDTO = patientsDAO.get(last_name);
        Patients patient = onePatientDTO.toPatients();
        return patient;
    }

    public Patients addOnePatient(String first_name, String last_name, String phone_number, String email,
                                  Date birth_date) throws SQLException {
        PatientsDTO onePatientDTO = patientsDAO.get(last_name);
        if (onePatientDTO == null) {
            PatientsDTO patientsDTO = new PatientsDTO(null, first_name, last_name, phone_number, email,
                    java.sql.Date.valueOf(String.valueOf(birth_date)));
            patientsDAO.save(patientsDTO);
            PatientsDTO savedObject = patientsDAO.get(last_name);
            return savedObject.toPatients();
        } else {
            throw new RuntimeException("Patient already exists");
        }
    }
}
