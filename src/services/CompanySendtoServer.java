package services;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


public class CompanySendtoServer {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter company name");
        String companyName = scan.nextLine();

        System.out.println("Enter company email");
        String companyEmail = scan.nextLine();

        System.out.println("Enter company type");
        String companyType = scan.nextLine();

        System.out.println("Enter company phone");
        String companyPhone = scan.nextLine();

        System.out.println("Enter company description");
        String companyDescription = scan.nextLine();

        Socket socket = new Socket("localhost",8080);
        OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
        
        JSONObject json = new JSONObject();
        json.put("companyName", companyName);
        json.put("companyEmail", companyEmail);
        json.put("companyType", companyType);
        json.put("companyPhone", companyPhone);
        json.put("companyDescription", companyDescription);

        writer.write(json + "\n");
        writer.flush();

        String line = reader.readLine();
        json =new JSONObject(line);

        System.out.println("sending to from server \n" + json);

        socket.close();
    }
}
