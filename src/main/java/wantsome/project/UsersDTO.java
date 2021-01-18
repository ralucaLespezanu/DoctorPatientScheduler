package wantsome.project;

public class UsersDTO {

    private Integer id;
    private String first_name;
    private String last_name;
    private String password;

    public UsersDTO( Integer id, String first_name, String last_name, String password) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
    }

    public UsersDTO(  String first_name, String last_name, String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
    }
    public UsersDTO(Users users) {
        this.id = users.getId();
        this.first_name = users.getFirst_name();
        this.last_name = users.getLast_name();
        this.password = users.getPassword();
    }

    public Users toUsers() {
        Users user = new Users();
        user.setId(this.id);
        user.setFirst_name(this.first_name);
        user.setLast_name(this.last_name);
        user.setPassword(this.password);
        return user;
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

    public String getPassword() {
        return password;
    }
}
