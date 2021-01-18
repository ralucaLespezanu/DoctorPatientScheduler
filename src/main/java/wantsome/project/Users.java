package wantsome.project;

import java.util.Objects;

public class Users {

    private Integer id;
    private String first_name;
    private String last_name;
    private String password;

    public Users( int id, String first_name, String last_name, String password) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
    }

    public Users() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return id == users.id && Objects.equals(first_name, users.first_name) &&
                Objects.equals(last_name, users.last_name) && Objects.equals(password, users.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, first_name, last_name, password);
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
