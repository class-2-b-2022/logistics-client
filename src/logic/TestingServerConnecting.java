package logic;


import com.fasterxml.jackson.databind.JsonNode;

import com.fasterxml.jackson.databind.ObjectMapper;
import utils.*;
import formats.*;

import formats.ClientRequest;


public class TestingServerConnecting {

    public static void connect(Wallet wallet) throws Exception {
        ClientRequest clientRequest = new ClientRequest();
        clientRequest.setRoute("/testing");
        clientRequest.setAction("testing");
        clientRequest.setData(wallet);
        ObjectMapper objectMapper = new ObjectMapper();
        ResponseBody res = new ConnectToServer().connectToServer(clientRequest);
        System.out.println("Returned data " +res.getData());
        JsonNode jsonNode = objectMapper.readTree((byte[]) res.getData());
        byte[] dataToparse = objectMapper.writeValueAsBytes(jsonNode);
        Wallet bills = objectMapper.readValue(dataToparse, Wallet.class);
        System.out.println(bills.getAmount());

    }
}
