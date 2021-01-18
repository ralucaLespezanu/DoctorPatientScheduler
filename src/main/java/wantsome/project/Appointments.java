package wantsome.project;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Objects;

public class Appointments {

    private Integer id;
    private Integer doctor_id;
    private Integer patient_id;
    private Timestamp appDate;
    private Check status;
    private String doctor_notes;
    private String patient_notes;

    public Appointments() {
    }

    public Appointments( Integer doctor_id, Integer patient_id,
                        Timestamp appDate, Check status, String doctor_notes,
                        String patient_notes) {
        this.doctor_id = doctor_id;
        this.patient_id = patient_id;
        this.appDate = appDate;
        this.status = status;
        this.doctor_notes = doctor_notes;
        this.patient_notes = patient_notes;
    }

    public Appointments(Integer id, Integer doctor_id, Integer patient_id,
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(Integer doctor_id) {
        this.doctor_id = doctor_id;
    }

    public Integer getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(Integer patient_id) {
        this.patient_id = patient_id;
    }

    public Timestamp getAppDate() {
        return appDate;
    }

    public void setAppDate(Timestamp appDate) {
        this.appDate = appDate;
    }

    public Check getStatus() {
        return status;
    }

    public void setStatus(Check status) {
        this.status = status;
    }

    public String getDoctor_notes() {
        return doctor_notes;
    }

    public void setDoctor_notes(String doctor_notes_text) {
        this.doctor_notes = doctor_notes_text;
    }

    public String getPatient_notes() {
        return patient_notes;
    }

    public void setPatient_notes(String patient_notes_text) {
        this.patient_notes = patient_notes_text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointments that = (Appointments) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(doctor_id, that.doctor_id) &&
                Objects.equals(patient_id, that.patient_id) &&
                Objects.equals(appDate, that.appDate) &&
                status == that.status &&
                Objects.equals(doctor_notes, that.doctor_notes) &&
                Objects.equals(patient_notes, that.patient_notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, doctor_id, patient_id, appDate, status, doctor_notes, patient_notes);
    }

    @Override
    public String toString() {
        return "Appointments{" +
                "id=" + id +
                ", doctor_id=" + doctor_id +
                ", patient_id=" + patient_id +
                ", date=" + appDate +
                ", status=" + status +
                ", doctor_notes_text='" + doctor_notes + '\'' +
                ", patient_notes_text='" + patient_notes + '\'' +
                '}';
    }
}
