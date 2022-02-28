package logic;

import models.BillingModel;
import models.ClientRequest;
import utils.ClientServerConnector;

public class TestingServerConnecting {
    public static void connect() throws Exception {
        ClientRequest clientRequest = new ClientRequest();
        clientRequest.setRoute("/testing");
        clientRequest.setAction("testing");
        BillingModel billModel = new BillingModel(11, 105000);
        clientRequest.setData(billModel);
        ClientServerConnector.serverClientConnnector(clientRequest);
    }
}
