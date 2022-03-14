package formats;

import java.io.Serializable;

//import Views.Keys;
public class Data_format implements Serializable {
//    public String keys ="AUTHENTICATION";
    public String email;
    public String password;

//    public Data_format(String email, String password) {
//        this.email = email;
//        this.password = password;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}