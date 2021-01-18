package wantsome.project;

public class DoctorsDTO {
    private Integer id;
    private String first_name;
    private String last_name;
    private String phone_number;
    private String email;
    private int specializations_id;


    public DoctorsDTO(Doctors doctors) {
        this.id = doctors.getId();
        this.first_name = doctors.getFirst_name();
        this.last_name = doctors.getLast_name();
        this.phone_number = doctors.getPhone_number();
        this.email = doctors.getEmail();
        this.specializations_id = doctors.getSpecialization_id();
    }
    public DoctorsDTO( String first_name, String last_name,
                    String phone_number, String email, int specialization_id) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.email = email;
        this.specializations_id = specialization_id;
    }

    public DoctorsDTO(Integer id, String first_name, String last_name, String phone_number,
                      String email, int specializations_id) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.email = email;
        this.specializations_id = specializations_id;
    }

    public Doctors toDoctors() {
        Doctors doctors = new Doctors();
        doctors.setId(this.id);
        doctors.setFirst_name(this.first_name);
        doctors.setLast_name(this.last_name);
        doctors.setPhone_number(this.phone_number);
        doctors.setEmail(this.email);
        doctors.setSpecialization_id(this.specializations_id);
        return doctors;
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

    public int getSpecializations_id() {
        return specializations_id;
    }
}
