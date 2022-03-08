package logic;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import formats.*;
import Utils.ClientServerConnector;
import Utils.ConnectToServer;
import Utils.RequestBody;
import Utils.ResponseBody;

import java.io.DataInput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestingServerConnecting {

    public static void connect(int userId, float amount) throws Exception {
        RequestBody clientRequest = new RequestBody();
        clientRequest.setRoute("/testing");
        clientRequest.setAction("testing");
        BillingModel billModel = new BillingModel(userId, amount);
        clientRequest.setData(billModel);
        ObjectMapper objectMapper = new ObjectMapper();
         ResponseBody res = new ConnectToServer().connectToServer(clientRequest);
        System.out.println("Returned data " +res.getData());
        JsonNode jsonNode = objectMapper.readTree(res.getData());
        byte[] dataToparse = objectMapper.writeValueAsBytes(jsonNode);
        BillingModel bills = objectMapper.readValue(dataToparse, BillingModel.class);
        System.out.println(bills.getAmount());

    }
}
