package logic;

import Utils.ClientServerConnector;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.*;

public class TestingServerConnecting {
    public static void connect() throws Exception {
        ClientRequest clientRequest = new ClientRequest();
        clientRequest.setRoute("/testing");
        clientRequest.setAction("testing");
        BillingModel billModel = new BillingModel(11, 105000);
        clientRequest.setData(billModel);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(clientRequest);
        ClientServerConnector.serverClientConnnector(json);
    }
}
