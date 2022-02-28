package View;

public class UserSession {
    public boolean loggedIn;

    private String userJsonObject;
    public UserSession() {
//        RetrieveLoggedInUser loggedInUser=new RetriveLoggedInUser()

    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public String getUserJsonObject() {
        return userJsonObject;
    }

    public void setUserJsonObject(String userJsonObject) {
        this.userJsonObject = userJsonObject;
    }
public boolean setAdmin(String json_object) {
//        ObjectMapper objectMapper=new ObjectMapper();
//    JsonNode jsonNode=new objectMapper.readTree(json_object);
//    String email=jsonNode.get("email").asText();
    //    String firstname=jsonNode.get("firstname").asText();
    //    String createdAt=jsonNode.get("createdAt").asText();
    String buce=json_object;
//    break;
    System.out.println(buce);
//    return ;
}
public boolean unSet() {
        boolean removed=false;
        if(loggedIn){
//            RemoveUser removeUser=new RemoveUser();
//            removed=removeUser.isDeleted()
        }else{
            System.out.println("No session created");
        }
        return removed;
}
}
