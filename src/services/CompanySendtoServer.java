import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamReader;
import java.io.Socket;

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
        OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));

        JSONObject json = new JSONObject();
        json.put("companyName", companyName);
        json.put("companyEmail", companyEmail);
        json.put("companyType", companyType);
        json.put("companyPhone", companyPhone);
        json.put("companyDescription", companyDescription);

        writer.write(json.toString()+ "\n");
        writer.flush();

        String line = reader.readline();
        json = new JSONObject(line);

        System.out.println("received from server \n" + json.toString());

        socket.close();
    }
}
