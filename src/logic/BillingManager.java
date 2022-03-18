package logic;


import utils.*;
import formats.Wallet;

public class BillingManager {
  public void createWallet(int userId, String action) throws Exception {
      ClientRequest clientRequest = new ClientRequest();
      Wallet wallet = new Wallet();
      clientRequest.setRoute("/billing");
      wallet.setUserId(userId);
      clientRequest.setData(wallet);
      clientRequest.setAction(action);
      ConnectToServer clientServerConnector = new ConnectToServer();
      ResponseBody responseBody = clientServerConnector.connectToServer(clientRequest);
  }

}
