package View;
// import com.client.dashboards.BusinessAdminDashboard;
// import com.client.dashboards.EmployeeDashboard;
// import com.client.dashboards.SuperAdminDashboard;
// import com.client.data_format.AuthenticationDataFormat;
// import com.client.services.AuthService;
// import com.client.utils.authorization.UserSession;
// import com.jackson.databind.JsonNode;
// import com.jackson.databind.ObjectMapper;
import java.awt.desktop.UserSessionEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
public class Services {
private Socket socket;
private Data_format data;
private boolean isAuth=false;
private String loggedInUser=null;

    public String getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(String loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public Data_format getData() {
        return data;
    }

    public void setData(Data_format data) {
        this.data = data;
    }

    public boolean isAuth() {
        return isAuth;
    }

    public void setAuth(boolean auth) {
        isAuth = auth;
    }
    public Services(){};
    public Services(Socket socket,Data_format data){
        this.socket=socket;
        this.data=data;
    };

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) throws IOException{
        this.socket = socket;
    }
    public boolean authanticate() throws IOException,ClassNotFoundException {
//        ObjectMapper objectMapper=new ObjectMapper();
//        String json= objectMapper.writeValueAsString(this.data)
//        SendToServer sendToServer=new SendToServer(json,this.socket)
//        if(sendToServer.send()){
        //this.handleLoginResponse()
        // }
        return isAuth;
    }
    public void handleLoginResponse() throws IOException,ClassNotFoundException{
try {
    InputStream inputStream=this.socket.getInputStream();
    ObjectInputStream objectInputStream=new ObjectInputStream(inputStream);
    List<String> response=(List) objectInputStream.readObject();
    //        ObjectMapper objectMapper=new ObjectMapper();
//        JsonNode jsonNode= objectMapper.readTree(res.get[0]);
//    if(jsonNode.get("status").asInt() == 201){
////UserSession userSession=new UserSession();
//        switch (jsonNode.get("appUser").asText){
//            case "Employer":
//                session.setEmployee(res.get(0));
//                break;
//            case "ADMIN":
//                session.setadmin(res.get(0));
//                break;
//            case "branch":
//                session.setbranch(res.get(0));
//                break;
//            default:
//                System.out.println("Invalid");
//        }
//        setLoggedInUser(json.get("appUser").asText);
//        setAuth(true);
//    }

}catch (Exception e){
    System.out.println(e.getMessage());
}
    }

}
