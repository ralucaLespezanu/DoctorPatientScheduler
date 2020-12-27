package wantsome.project;

import java.sql.Date;
import java.util.Objects;

public class Patients {

    private Integer id;
    private String first_name;
    private String last_name;
    private String phone_number;
    private String email;
    private Date birth_date;


    public Patients(){
    }

    public Patients(Integer id, String first_name, String last_name, String phone_number, String email, Date birth_date) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.email = email;
        this.birth_date = birth_date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patients patients = (Patients) o;
        return Objects.equals(id, patients.id) &&
                Objects.equals(first_name, patients.first_name) &&
                Objects.equals(last_name, patients.last_name) &&
                Objects.equals(phone_number, patients.phone_number) &&
                Objects.equals(email, patients.email) &&
                Objects.equals(birth_date, patients.birth_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, first_name, last_name, phone_number, email, birth_date);
    }

    @Override
    public String toString() {
        return "Patients{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", email='" + email + '\'' +
                ", birth_date=" + birth_date +
                '}';
    }
}
