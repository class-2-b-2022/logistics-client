package services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class CompanyService {
    private Socket socket;
    private ObjectMapper objectMapper;

    public CompanyService(){ }
    public CompanyService(Socket socket){
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public void create(JSONObject json) throws IOException, ClassNotFoundException {
        SendToServer sendtoServer = new SendToServer(json, socket);

        if (sendtoServer.send()) {
            System.out.println("Company Registered Successfully");
//            this.handleCreateCustomerResponse();
        }
    }
    // getting response from the server
    public void handleCreateCustomerResponse() throws IOException, ClassNotFoundException {
        try{
            InputStream inputStream = this.socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            List<String> response = (List<String>) objectInputStream.readObject();
            String json_response = response.get(0);
            System.out.println("Response From The Server :::" + json_response);
        }catch (Exception e) {
            System.out.println("Error, "+ e.getMessage());
        }
    }
public List getCompany(int companyOwnerCode) throws IOException,ClassNotFoundException {

    JSONObject json = new JSONObject();
    json.put("companyOwnerCode", companyOwnerCode);
    SendToServer sendtoServer = new SendToServer(json,this.socket);
    List<String> res = new ArrayList<>();
    System.out.println("Your requested is being handled by the server");
//    if(sendtoServer.send()) {
//        try{
//            InputStream input = this.socket.getInputStream();
//            ObjectInputStream objectInputStream = new ObjectInputStream(input);
//            res = (List) objectInputStream.readObject();
//            JsonNode jsonNode = objectMapper.readTree(res.get(0));
//            if(jsonNode.get("status").asInt() == 404){
//                System.out.println("No such company registered");
//                return null;
//            }
//        }catch(Exception e){
//            System.out.println("Error, "+e.getMessage());
//        }
//    }
    return res;
    }
}
