//package main;
//import views.Home;
//import views.company.CompanyMainView;
//
//import java.io.IOException;
//import java.io.ObjectOutputStream;
//import java.io.OutputStream;
//import java.net.*;
//
//public class Main {
//    private OutputStream output = null;
//    private ObjectOutputStream objectOutput = null;
//    private boolean isConnectionOn = true;
//
//    public Main(String serverIP) throws IOException {
//        if(!connectTOServer(serverIP)) {
//            System.out.println("Failed to connect to the server on: "+serverIP);
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        new Main("localhost");
//        System.out.println("Shutting down.......");
//
//    }
//
//    private boolean connectTOServer(String serverIp) {
//        int portNumber = 5450;
//        try{
//            Socket socket = new Socket(serverIp, portNumber);
//            while(isConnectionOn){
//                Home home = new Home(socket);
//                home.view();
//            }
//        }catch (Exception e){
//            System.out.println("Failed to connect to the server at port: " + portNumber);
//            System.out.println("Exception: " + e.toString());
//        }
//        return true;
//    }
//
//}
