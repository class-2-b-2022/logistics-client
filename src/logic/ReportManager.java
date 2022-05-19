package logic;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import formats.*;
import org.json.JSONArray;
import org.json.JSONObject;
import utils.ConnectToServer;

import java.math.BigInteger;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReportManager {
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_MAG = "\u001b[1;35m";
    public static final String ANSI_RESET = "\u001B[0m";

    public List<ReportModel> viewReports() throws Exception{
        ObjectMapper inputMapper = new ObjectMapper();
        RequestBody clientRequest = new RequestBody();
        clientRequest.setRoute("/reports");
        clientRequest.setAction("view");
        ConnectToServer clientServerConnector = new ConnectToServer();
        ResponseBody responseBody = clientServerConnector.connectToServer(clientRequest);
        System.out.println(responseBody.getData());
        String leftAlignFormat = "| %-11s | %-4d |%n";
        String json = (String) responseBody.getData();
        List<ReportModel> inventoryReports= Arrays.asList(inputMapper.readValue(json, ReportModel[].class));

        System.out.println(ANSI_MAG +"\t\t\t\t List of all reports "+ANSI_RESET);
        System.out.format("\t\t| Date \t\t | Company \t| Product  | Status\t| Quantity |\n");

        for(ReportModel reportModel: inventoryReports){
            Date date = reportModel.getDate();
            String company = reportModel.getCompanyName();
            String product = reportModel.getProduct();
            String status = reportModel.getStatus();
            Integer quantity = reportModel.getQuantity();
//
//                String line = String.format("\t\t| "+date+"  | "+company+"\t| "+product+"\t | "+status+"\t\t| "+quantity+  "\t|");
//                System.out.format(line+"\n");
            String line = String.format("    %s    |   %s   | %s  | %s  | %s ",date,company,product,status,quantity);
            System.out.format(leftAlignFormat, line,2,3);
        }


        return null;
    }
    public static void main(String[] args) throws Exception {
        ReportManager reportManager = new ReportManager();
        reportManager.viewReports();
    }
}
