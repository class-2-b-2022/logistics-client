package logic;
import Views.DeliveryModel;
import formats.Vehicle;
import Utils.ConnectToServer;
import Utils.RequestBody;
import Utils.ResponseBody;
import com.fasterxml.jackson.databind.ObjectMapper;

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

        }*/

    }
    public List<Vehicle> viewVehicles() throws Exception {
        ObjectMapper inputMapper = new ObjectMapper();
        RequestBody clientRequest = new RequestBody();
        clientRequest.setRoute("/delivery/vehicles");
        clientRequest.setAction("view");
        ConnectToServer clientServerConnector = new ConnectToServer();
        ResponseBody responseBody = clientServerConnector.connectToServer(clientRequest);
        System.out.println(responseBody.getData());
        List<Vehicle> vehicles = Arrays.asList(inputMapper.readValue(responseBody.getData(), Vehicle[].class));
       return vehicles;
    }
}
