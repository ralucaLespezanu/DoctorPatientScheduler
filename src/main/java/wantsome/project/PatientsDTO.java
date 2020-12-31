package wantsome.project;

import java.sql.Date;

public class PatientsDTO {

    private Integer id;
    private String first_name;
    private String last_name;
    private String phone_number;
    private String email;
    private Date birth_date;


    public PatientsDTO(Integer id, String first_name, String last_name, String phone_number,
                       String email, Date birth_date) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.email = email;
        this.birth_date = birth_date;
    }

    public PatientsDTO(Patients patients) {
        this.id = patients.getId();
        this.first_name = patients.getFirst_name();
        this.last_name = patients.getLast_name();
        this.phone_number = patients.getPhone_number();
        this.email = patients.getEmail();
        this.birth_date = patients.getBirth_date();
    }

    public Patients toPatients() {
        Patients patients = new Patients();
        patients.setId(this.id);
        patients.setFirst_name(this.first_name);
        patients.setLast_name(this.last_name);
        patients.setPhone_number(this.phone_number);
        patients.setEmail(this.email);
        patients.setBirth_date(this.birth_date);
        return patients;
    }

    public Integer getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getEmail() {
        return email;
    }

    public Date getBirth_date() {
        return birth_date;
    }
}
