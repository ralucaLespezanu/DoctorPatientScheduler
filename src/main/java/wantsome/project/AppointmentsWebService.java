package wantsome.project;

import com.google.gson.Gson;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;


public class AppointmentsWebService {

    private static AppointmentsDAO appointmentsDAO = new AppointmentsDAOImpl();

    public List<AppointmentsDTO> getAllAppointments() throws SQLException {
        List<AppointmentsDTO> appointmentsDTOList = new ArrayList<>();
        appointmentsDTOList.addAll(appointmentsDAO.getAll());
        return appointmentsDTOList;
    }

    public Appointments getOneAppointment(int doctor_id, Timestamp appDate) throws SQLException {
        AppointmentsDTO oneAppointmentsDTO = appointmentsDAO.get(doctor_id, appDate);
        Appointments appointment = oneAppointmentsDTO.toAppointments();
        return appointment;
    }

    public Appointments addOneAppointment(int doctor_id, int patient_id,
                                          Timestamp appDate, Check status, String doctor_notes,
                                          String patient_notes) throws SQLException {
        AppointmentsDTO oneAppointmentDTO = appointmentsDAO.get(doctor_id, appDate);
        if (oneAppointmentDTO == null) {
            AppointmentsDTO appointmentsDTO = new AppointmentsDTO(null, doctor_id,
                    patient_id, appDate, status, doctor_notes, patient_notes);
            appointmentsDAO.save(appointmentsDTO);
            AppointmentsDTO savedObject = appointmentsDAO.get(doctor_id, appDate);
            return savedObject.toAppointments();
        } else {
            throw new RuntimeException("Appointment already exists!");
        }
    }
}
