package logic;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import formats.ReportModel;
import formats.RequestBody;
import formats.ResponseBody;
import formats.Vehicle;
import utils.ConnectToServer;

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
        List<ReportModel> reportModels = Arrays.asList(inputMapper.readValue((JsonParser) responseBody.getData(), ReportModel[].class));

        return reportModels;
    }
}
