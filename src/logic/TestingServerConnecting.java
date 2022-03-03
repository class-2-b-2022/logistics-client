package logic;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import formats.*;
import utils.ClientServerConnector;
import utils.ConnectToServer;
import utils.RequestBody;
import utils.ResponseBody;

import java.io.DataInput;

public class TestingServerConnecting {
    public static void connect() throws Exception {
        RequestBody clientRequest = new RequestBody();
        clientRequest.setRoute("/testing");
        clientRequest.setAction("testing");
        System.out.println("SENDING A REQUEST");
        BillingModel billModel = new BillingModel(1100, 2000000);
        clientRequest.setData(billModel);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(clientRequest);
         ResponseBody res = new ConnectToServer().connectToServer(clientRequest);
        System.out.println("Returned data " +res.getData());
        JsonNode jsonNode = objectMapper.readTree(res.getData());
        System.out.println("ResponseData");
        System.out.println(jsonNode);
    }
}
