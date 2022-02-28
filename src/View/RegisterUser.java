package View;
import java.io.DataOutputStream;
import java.io.*;
import java.util.*;
import java.net.*;

public class RegisterUser {

    public static void main(String[] args) throws IOException {
        Selection();
    }

    public static void Selection() throws IOException {
        System.out.println("\n====================================");

        Scanner scan = new Scanner(System.in);

        System.out.println("\nCHOOSE USER ROLE\n");
        System.out.println("\t1.BRANCH ADMIN");
        System.out.println("\t2.DISTRIBUTOR");
        System.out.println("\t3.RESELLER\n");

        System.out.print("ENTER USER ROLE: ");
        int role = scan.nextInt();

        Form(role);

    }

    public static void RegisterCompanyAdmin() throws IOException {
        System.out.println("\nREGISTER COMPANY ADMIN\n");

        Form(1);
    }

    public static void Form(int role) throws IOException {

        System.out.println("\n====================================");

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
        System.out.print("\tPHONE NUMBER : (250) ");
        int phone = scan.nextInt();
        System.out.print("\tPASSWORD : ");
        String password = scan.next();

        SaveUser(fullname,email,phone, password);
    }

    public static void SaveUser(String fullname, String email, int phone, String password) throws IOException {
//        Socket client = new Socket("192.168.0.146", 5450);
//
//        OutputStream out = client.getOutputStream();
//        DataOutputStream req = new DataOutputStream(out);
//        req.writeUTF(fullname);
    }
}
