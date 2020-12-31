package wantsome.project;

import java.util.Objects;

public class Doctors {

    private Integer id;
    private String first_name;
    private String last_name;
    private String phone_number;
    private String email;
    private int specialization_id;


    public Doctors() {
    }

    public Doctors(Integer id, String first_name, String last_name,
                   String phone_number, String email, int specialization_id) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.email = email;
        this.specialization_id = specialization_id;
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

    public int getSpecialization_id() {
        return specialization_id;
    }

    public void setSpecialization_id(int specialization_id) {
        this.specialization_id = specialization_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctors doctors = (Doctors) o;
        return Objects.equals(id, doctors.id) &&
                Objects.equals(first_name, doctors.first_name) &&
                Objects.equals(last_name, doctors.last_name) &&
                Objects.equals(phone_number, doctors.phone_number) &&
                Objects.equals(email, doctors.email) &&
                Objects.equals(specialization_id, doctors.specialization_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, first_name, last_name, phone_number, email, specialization_id);
    }


    @Override
    public String toString() {
        return "Doctors{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", email='" + email + '\'' +
                ", specializations_id=" + specialization_id +
                '}';
    }
}
