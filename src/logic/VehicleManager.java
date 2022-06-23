package logic;

import views.DeliveryModel;
import com.fasterxml.jackson.databind.DeserializationFeature;
import org.json.JSONArray;
import org.json.JSONObject;
import views.*;
import formats.*;
import utils.*;
import com.fasterxml.jackson.core.JsonParser;

import formats.Vehicle;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.DataInput;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class VehicleManager {
    public  void registerVehicle() throws Exception {
        /*
       *required fields for vehicle*
        model
        plateNbr
        brand
        owner
        description
        */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter vehicle Owner : ");
        String owner = scanner.next();
        System.out.println("Enter the plate number: ");
        String plateNbr = scanner.next();
        System.out.println("Enter the brand: ");
        String brand = scanner.next();

        System.out.println("Enter the description: ");
        String description = scanner.next();

        Vehicle vehicle = new Vehicle();
        vehicle.setPlateNbr(plateNbr);
        vehicle.setBrand(brand);
        vehicle.setOwner(owner);
        vehicle.setDescription(description);

        RequestBody clientRequest = new RequestBody();
        clientRequest.setRoute("/delivery/vehicles");
        clientRequest.setAction("register");

        clientRequest.setData(vehicle);
        ConnectToServer clientServerConnector = new ConnectToServer();

        ResponseBody responseBody = clientServerConnector.connectToServer(clientRequest);
        if(responseBody.getStatus() == "201"){
            System.out.println("Vehicle registered successfully");
            DeliveryModel delivery = new DeliveryModel();
            delivery.VehicleManagement();
        }else{
            System.out.println("An error occurred behind your screen");
        }


        /*for (Object response : responseBody.getResponse()) {
            ResponseStatus responseStatus = (ResponseStatus) response;
            System.out.println("\t\t -------------------------------------- STATUS: " + responseStatus.getStatus() + " ---------------------------");
            System.out.println("\t\t --------------         Meaning: " + responseStatus.getMessage());
            System.out.println("\t\t --------------         Action: " + responseStatus.getActionToDo());
            System.out.println("\t\t ------------------------------------------------------------------------------");
        }

    }

        }*/

    }
    public List<Vehicle> viewVehicles() throws Exception {
        ObjectMapper inputMapper = new ObjectMapper();
        RequestBody clientRequest = new RequestBody();
        clientRequest.setRoute("/delivery/vehicles");
        clientRequest.setAction("view");
        ConnectToServer clientServerConnector = new ConnectToServer();
        ResponseBody responseBody = clientServerConnector.connectToServer(clientRequest);
        JSONArray jsonArray = new JSONArray(responseBody.getData().toString());
        List<Vehicle> vehicles = new ArrayList<>();

        for(int i=0; i<jsonArray.length(); i++){
            JSONObject json = jsonArray.getJSONObject(i);
            Vehicle vehicle = new Vehicle();
            vehicle.setBrand((String) json.get("brand"));
            vehicle.setVehicleId((Integer) json.get("vehicleId"));
            vehicle.setOwner(json.get("owner").toString());
            vehicle.setDescription(json.get("description").toString());
            vehicle.setPlateNbr(json.get("plateNbr").toString());
            vehicle.setCreatedAt(BigInteger.valueOf((Long) json.get("createdAt")));
            vehicle.setModel(json.get("model").toString());
            vehicles.add(vehicle);

        }
        //        List<Vehicle> vehicles = Arrays.asList(inputMapper.readValue((JsonParser) responseBody.getData(), Vehicle[].class));
       return vehicles;
    }
}
