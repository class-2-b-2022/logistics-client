package views.company;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import services.CompanyService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ReadCompanyView {
    private Socket socket;
    public ReadCompanyView() {}
    public ReadCompanyView(Socket socket) {this.socket = socket;}

    public void view() throws IOException, ClassNotFoundException {
        boolean customerView = true;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        search: do{
            System.out.println("\n\t\t\t--------------VIEW COMPANY INFO--------------");
            System.out.println("\n\t\t\t00. Return");
            System.out.println("\n\t\t\tEnter Company Owner Code: ");
            String companyCode = reader.readLine();
            if(companyCode.equals("00"))
                break search;
            CompanyService companyService = new CompanyService(this.socket);
            List<String> res = new ArrayList<>();
//            res = companyService.getCompany(Integer.parseInt(companyCode));
            if(res != null){
                System.out.println("\n\t\t\t\t\t\t\t-------------------------------------------");
                System.out.println("CompanyOwnerCode\tCompanyName\tCompanyEmail\tCompanyPhone\tCompanyType\tCompanyDescription");
                for(int i = 0; i<res.size();i++){
                    try{
                        ObjectMapper objectMapper = new ObjectMapper();
                        JsonNode jsonNode = objectMapper.readTree(res.get(i));
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
            }
        }while (true);
    }
}
