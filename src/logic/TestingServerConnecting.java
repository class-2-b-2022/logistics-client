package logic;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.BillingModel;
import models.ClientRequest;
import utils.ClientServerConnector;

public class TestingServerConnecting {
    public static void connect(int userId, float amount) throws Exception {
        ClientRequest clientRequest = new ClientRequest();
        clientRequest.setRoute("/testing");
        clientRequest.setAction("testing");
        BillingModel billModel = new BillingModel(userId, amount);
        clientRequest.setData(billModel);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(clientRequest);
        ClientServerConnector.serverClientConnnector(json);
    }
}
