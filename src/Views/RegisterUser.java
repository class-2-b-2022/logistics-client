package Views;

import Utils.ConnectToServer;
import Utils.RequestBody;
import Utils.ResponseBody;
import models.Users;

import java.util.Scanner;

public class RegisterUser {

    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) throws Exception {
        Selection();
    }

    public static void Selection() throws Exception {
        System.out.println("\n====================================");

        Scanner scan = new Scanner(System.in);
        System.out.println(ANSI_BLUE);
        System.out.println("CHOOSE USER ROLE");
        System.out.println(ANSI_RESET);
        System.out.println("\t1.BRANCH ADMIN");
        System.out.println("\t2.DISTRIBUTOR");
        System.out.println("\t3.RESELLER\n");

        System.out.print("ENTER USER ROLE: ");
        int role = scan.nextInt();

        Form(role);

    }

    public static void Form(int role) throws Exception {

        System.out.println("====================================");

        switch(role){
            case 1: System.out.println("\nREGISTER BRANCH ADMIN\n");
                break;
            case 2: System.out.println("\nREGISTER DISTRIBUTOR\n");
                break;
            case 3: System.out.println("\nREGISTER RESELLER\n");
                break;
            default: System.out.println("INVALID CHOICE, TRY AGAIN"); Selection();
                break;
        }

        Scanner scan = new Scanner(System.in);
        System.out.print("\tUSERNAME : ");
        String fullname = scan.nextLine();
        System.out.print("\tEMAIL : ");
        String email = scan.nextLine();

        boolean isEmailValid = validateEmail(email);
        if(!isEmailValid){
            System.out.println(ANSI_RED);
            System.out.println("INVALID EMAIL ADDRESS FORMAT");
            System.out.println(ANSI_RESET);
            Form(role);
        }

        long phone=0;
        String password="";

        try{
            System.out.print("\tPHONE NUMBER : (250) ");
            phone = scan.nextInt();

            if(Long.toString(phone).length()<9){
                System.out.print("\n\tPHONE NUMBER IS SHORT \n");
                Form(role);
                return ;
            }

            System.out.print("\tPASSWORD : ");
            password = scan.next();

        }
        catch(Exception e){
            System.out.print("\n\tINVALID PHONE NUMBER \n");
            Form(role);
            return ;
        }

        SaveUser(fullname,email,phone, password,role);
    }

    public static void SaveUser(String fullname, String email, long phone, String password,int role) throws Exception {
        Users user = new Users();
        user.setNames(fullname);
        user.setPhone(phone);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);

        RequestBody clientRequest = new RequestBody();
        clientRequest.setRoute("/users");
        clientRequest.setAction("register");

        clientRequest.setData(user);
        ConnectToServer clientServerConnector = new ConnectToServer();
        ResponseBody responseBody = clientServerConnector.connectToServer(clientRequest);

        System.out.println(responseBody);
//        json = objectMapper.writeValueAsString(clientRequest);
//        responseBody = new ClientServerConnector().serverClientConnnector(json);
//        System.out.println(responseBody.getStatus());

//        Socket socket = new Socket("192.168.0.95", 5450);
//
//        OutputStream outputStream = socket.getOutputStream();
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
//
//        List<Users> user = new ArrayList<>();
//        user.add(new Users(email,fullname, phone, role, password,"/registeruser"));
//        objectOutputStream.writeObject(user);
//        socket.close();
    }

    public static boolean validateEmail(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }
}