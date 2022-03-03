package models;
import java.io.Serializable;

public class Users implements Serializable {
    private String email;
    private String fullname;
    private long phone;
    private int role;
    private String route;
    private String password;

//    public Users(String email, String fullname, long phone, int role, String password, String route) {
//    }

//    public void Users(String email,String fullname, long phone, int role, String password,String route){
//        this.email = email;
//        this.fullname = fullname;
//        this.phone = phone;
//        this.role = role;
//        this.password = password;
//        this.route = route;
//    }

    public String getEmail(String email) {
        return this.email;
    }

    public String getFullName(String name) {
        return this.fullname;
    }

    public long getPhone(long phone) {
        return this.phone;
    }

    public int getRole(int role) {
        return this.role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFullName(String name) {
        this.fullname = name;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}