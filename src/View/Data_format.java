package View;
import View.Keys;
public class Data_format {
    public String keys = String.valueOf(Keys.AUTHENTICATION);
   public String email;
   public String password;
public Data_format(String email,String password){
    this.email=email;
    this.password=password;
}
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
