package wantsome.project;

import java.sql.Timestamp;

public class AppointmentsDTO {

    private Integer id;
    private Integer doctor_id;
    private Integer patient_id;
    private Timestamp appDate;
    private Check status;
    private String doctor_notes;
    private String patient_notes;


    public AppointmentsDTO(Integer id, Integer doctor_id, Integer patient_id,
                           Timestamp appDate, Check status, String doctor_notes,
                           String patient_notes) {
        this.id = id;
        this.doctor_id = doctor_id;
        this.patient_id = patient_id;
        this.appDate = appDate;
        this.status = status;
        this.doctor_notes = doctor_notes;
        this.patient_notes = patient_notes;
    }

    public AppointmentsDTO(Appointments appointments) {
        this.id = appointments.getId();
        this.doctor_id = appointments.getDoctor_id();
        this.patient_id = appointments.getPatient_id();
        this.appDate = appointments.getAppDate();
        this.status = appointments.getStatus();
        this.doctor_notes = appointments.getDoctor_notes();
        this.patient_notes = appointments.getPatient_notes();
    }

    public Appointments toAppointments() {
        Appointments appointments = new Appointments();
        appointments.setId(this.id);
        appointments.setDoctor_id(this.doctor_id);
        appointments.setPatient_id(this.patient_id);
        appointments.setAppDate(this.appDate);
        appointments.setStatus(this.status);
        appointments.setDoctor_notes(this.doctor_notes);
        appointments.setPatient_notes(this.patient_notes);
        return appointments;
    }

    public Integer getId() {
        return id;
    }

    public Integer getDoctor_id() {
        return doctor_id;
    }

    public Integer getPatient_id() {
        return patient_id;
    }

    public Timestamp getAppDate() {
        return appDate;
    }

    public Check getStatus() {
        return status;
    }

    public String getDoctor_notes() {
        return doctor_notes;
    }

    public String getPatient_notes() {
        return patient_notes;
    }
}
