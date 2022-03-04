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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestingServerConnecting {
    public static void connect() throws Exception {
        RequestBody clientRequest = new RequestBody();
        clientRequest.setRoute("/testing");
        clientRequest.setAction("testing");
        System.out.println("SENDING A REQUEST");
        BillingModel billModel = new BillingModel(1100, 2000000);
        clientRequest.setData(billModel);
        ObjectMapper objectMapper = new ObjectMapper();
         ResponseBody res = new ConnectToServer().connectToServer(clientRequest);
        System.out.println("Returned data " +res.getData());
        JsonNode jsonNode = objectMapper.readTree(res.getData());
        byte[] dataToparse = objectMapper.writeValueAsBytes(jsonNode);
        List<BillingModel> bills;
        bills = Arrays.asList(objectMapper.readValue(dataToparse, BillingModel[].class));
    for(BillingModel b: bills){
        System.out.println(b.getAmount());
    }
    }
}
