package logic;

import Utils.ConnectToServer;
import Utils.RequestBody;
import Utils.ResponseBody;
import Views.DeliveryModel;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import formats.Wallet;

public class BillingManager {
  public void createWallet(int userId, String action) throws Exception {
      RequestBody clientRequest = new RequestBody();
      Wallet wallet = new Wallet();
      clientRequest.setRoute("/billing");
      wallet.setUserId(userId);
      clientRequest.setData(wallet);
      clientRequest.setAction(action);
      ConnectToServer clientServerConnector = new ConnectToServer();
      ResponseBody responseBody = clientServerConnector.connectToServer(clientRequest);
  }

}
