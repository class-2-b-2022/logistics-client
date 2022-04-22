package logic;

import Utils.ConnectToServer;
import com.fasterxml.jackson.databind.JsonNode;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import formats.*;
<<<<<<< HEAD
//import utils.*;
=======
import Utils.*;
>>>>>>> master
import java.io.DataInput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import Utils.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import formats.BillingModel;
import formats.ClientRequest;


public class TestingServerConnecting {

    public static void connect(Wallet wallet) throws Exception {
        RequestBody clientRequest = new RequestBody();
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
