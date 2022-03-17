package formats;

import java.io.Serializable;

public class Users implements Serializable {
    private int userId;
    private String names;
    private String email;
    private long phone;
    private String password ;
    private int role;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNames() {
        return names;
    }

    public long getPhone() {
        return this.phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public int getRole(){
        return this.role;
    }

    public String getPassword() {
        return password;
    }

    public void setNames(String fullName) {
        this.names = fullName;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
