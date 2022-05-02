package logic;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import formats.*;
import java.io.DataInput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import Utils.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import formats.BillingModel;
import formats.ClientRequest;


public class TestingServerConnecting {
    private static final ParserObj parserObj = new ParserObj();
    public static void connect(Wallet wallet) throws Exception {
        RequestBody clientRequest = new RequestBody();
        clientRequest.setRoute("/testing");
        clientRequest.setAction("testing");
        clientRequest.setData(wallet);
        ObjectMapper objectMapper = new ObjectMapper();
        ResponseBody res = new ConnectToServer().connectToServer(clientRequest);
//        System.out.println("data " +res.getData());
//        JsonNode jsonNode = objectMapper.readTree((byte[]) res.getData());
//        System.out.println("converting data");
//        byte[] dataToparse = objectMapper.writeValueAsBytes(res.getData());
//        System.out.println(dataToparse);
        System.out.println("see conversion");
        Wallet bills = objectMapper.readValue((byte[]) res.getData(), Wallet.class);
        System.out.println(res.getData());


        System.out.println("found data"+bills.getAmount());


    }
}
