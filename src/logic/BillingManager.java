package logic;

import utils.ConnectToServer;
import utils.RequestBody;
import utils.ResponseBody;
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

  public void getWallet(int userId, String action) throws Exception{
      RequestBody clientRequest = new RequestBody();
      Wallet wallet = new Wallet();
      clientRequest.setRoute("/billing");
      wallet.setUserId(userId);
      clientRequest.setData(wallet);
      clientRequest.setAction(action);
      ConnectToServer clientServerConnector = new ConnectToServer();
      ResponseBody responseBody = clientServerConnector.connectToServer(clientRequest);
  }
    public void deposit(int userId, float amount, String action) throws Exception {
        RequestBody clientRequest = new RequestBody();
        Wallet wallet = new Wallet();
        clientRequest.setRoute("/billing");
        wallet.setUserId(userId);
        clientRequest.setData(amount);
        clientRequest.setAction(action);
        ConnectToServer clientServerConnector = new ConnectToServer();
        ResponseBody responseBody = clientServerConnector.connectToServer(clientRequest);
    }

    public void withdraw(int userId, float amount, String action) throws Exception {
        RequestBody clientRequest = new RequestBody();
        Wallet wallet = new Wallet();
        clientRequest.setRoute("/billing");
        wallet.setUserId(userId);
        clientRequest.setData(amount);
        clientRequest.setAction(action);
        ConnectToServer clientServerConnector = new ConnectToServer();
        ResponseBody responseBody = clientServerConnector.connectToServer(clientRequest);
    }
}
