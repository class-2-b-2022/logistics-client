package services;
//
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import data_format.NewCompanyFormat;
//
//import java.io.*;
//import java.net.Socket;
//import java.util.ArrayList;
//import java.util.List;
//
public class CompanyService {
//    private Socket socket;
//    private ObjectMapper objectMapper;
//
//    public CompanyService(){ }
//    public CompanyService(Socket socket){
//        this.socket = socket;
//    }
//
//    public Socket getSocket() {
//        return socket;
//    }
//
//    public void setSocket(Socket socket) {
//        this.socket = socket;
//    }
//
//    public void create(NewCompanyFormat format) throws IOException, ClassNotFoundException {
//        ObjectMapper objectMapper= new ObjectMapper();
//        String json =objectMapper.writeValueAsString(format);
//        System.out.println(json);
//        SendtoServer sendtoServer = new SendtoServer(json, this.socket);
//        if (sendtoServer.send()) {
//            System.out.println("Company Registered Successfully");
////            this.handleCreateCustomerResponse();
//        }
//    }
//    // getting response from the server
//    public void handleCreateCustomerResponse() throws IOException, ClassNotFoundException {
//        try{
//            InputStream inputStream = this.socket.getInputStream();
//            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
//            List<String> response = (List<String>) objectInputStream.readObject();
//            String json_response = response.get(0);
//            System.out.println("Response From The Server :::" + json_response);
//        }catch (Exception e) {
//            System.out.println("Error, "+ e.getMessage());
//        }
//    }
//    String[] requirements = {"companyName", "companyEmail", "companyPhone", "companyType", "companyDescription"};
////        for(int i = 0 ; i< requirements.length; i++) {
////        OutputStream out = socket1.getOutputStream();
////        DataOutputStream newOut = new DataOutputStream(out);
////        newOut.writeUTF("Enter your "+requirements[i]+"::");
////        InputStream inFromClient = socket1.getInputStream();
////        DataInputStream response = new DataInputStream(inFromClient);
////        System.out.println(i + " " + requirements[i]);
////        switch (requirements[i]){
////            case "companyName":
////                newCompany.setCompanyName(response.readUTF());
////                break;
////            case "companyEmail":
////                newCompany.setCompanyEmail(response.readUTF());
////                break;
////            case "companyPhone":
////                newCompany.setCompanyPhone(response.readUTF());
////                break;
////            case "companyType":
////                newCompany.setCompanyType(response.readUTF());
////                break;
////            case "companyDescription":
////                newCompany.setCompanyDescription(response.readUTF());
////                break;
////            default:
////                System.out.println("No matching requirement");
////        }
////    }
//public List getCompany(int companyOwnerCode) throws IOException,ClassNotFoundException {
//    ObjectMapper objectMapper = new ObjectMapper();
//    String json = objectMapper.writeValueAsString(companyOwnerCode);
//    SendtoServer sendtoServer = new SendtoServer(json,this.socket);
//    List<String> res = new ArrayList<>();
//    System.out.println("Your requested is being handled by the server");
////    if(sendtoServer.send()) {
////        try{
////            InputStream input = this.socket.getInputStream();
////            ObjectInputStream objectInputStream = new ObjectInputStream(input);
////            res = (List) objectInputStream.readObject();
////            JsonNode jsonNode = objectMapper.readTree(res.get(0));
////            if(jsonNode.get("status").asInt() == 404){
////                System.out.println("No such company registered");
////                return null;
////            }
////        }catch(Exception e){
////            System.out.println("Error, "+e.getMessage());
////        }
////    }
//    return res;
//    }
////    public List getCompanies() throws IOException {
////        ObjectMapper objectMapper = new ObjectMapper();
////        String json = objectMapper.writeValueAsString();
////    }
}
