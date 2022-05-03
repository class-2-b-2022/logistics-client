package logic;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import formats.ReportModel;
import formats.RequestBody;
import formats.ResponseBody;
import formats.Vehicle;
import org.json.JSONArray;
import org.json.JSONObject;
import utils.ConnectToServer;

import java.math.BigInteger;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReportManager {
    public List<ReportModel> viewReports() throws Exception{
        ObjectMapper inputMapper = new ObjectMapper();
        RequestBody clientRequest = new RequestBody();
        clientRequest.setRoute("/reports");
        clientRequest.setAction("view");
        ConnectToServer clientServerConnector = new ConnectToServer();
        ResponseBody responseBody = clientServerConnector.connectToServer(clientRequest);
//        List<ReportModel> reportModels = Arrays.asList(inputMapper.readValue((JsonParser) responseBody.getData(), ReportModel[].class));

//        return reportModels;
        JSONArray jsonArray = new JSONArray(responseBody.getData().toString());
        List<ReportModel> reports = new ArrayList<>();

        for(int i=0; i<jsonArray.length(); i++){
            JSONObject json = jsonArray.getJSONObject(i);
            ReportModel report = new ReportModel();
            report.getDate((Long) json.get("date"));
            report.setCompanyName(json.get("companyName").toString());
            System.out.println(json);
            reports.add(report);
        }
        return  reports;
    }
}
