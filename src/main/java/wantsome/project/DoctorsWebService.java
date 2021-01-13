package wantsome.project;

import com.google.gson.Gson;

import static spark.Spark.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoctorsWebService {
    private static DoctorsDAO doctorsDAO = new DoctorsDAOImpl();

    public List<DoctorsDTO> getAllDoctors() throws SQLException {
        List<DoctorsDTO> doctorsDTOList = new ArrayList<>();
        doctorsDTOList.addAll(doctorsDAO.getAll());
        return doctorsDTOList;
    }

    public Doctors getOneDoctor(String last_name) throws SQLException {
        DoctorsDTO oneDoctorDTO = doctorsDAO.get(last_name);
        Doctors doctor = oneDoctorDTO.toDoctors();
        return doctor;
    }

    public Doctors addOneDoctor(String first_name, String last_name, String phone_number,
                                String email, int specialization_id) throws SQLException {
        DoctorsDTO oneDoctorDTO = doctorsDAO.get(last_name);

        if (oneDoctorDTO == null) {
            DoctorsDTO doctorsDTO = new DoctorsDTO(null, first_name, last_name,
                    phone_number, email, specialization_id);
            doctorsDAO.save(doctorsDTO);
            DoctorsDTO savedObject = doctorsDAO.get(last_name);
            return savedObject.toDoctors();
        } else {
            throw new RuntimeException("Doctor already exists");
        }
    }
}




