package logic;

import Utils.ConnectToServer;
import Utils.RequestBody;
import Utils.ResponseBody;
import models.Vehicle;

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
        clientRequest.setRoute("/delivery/vehicle");
        clientRequest.setAction("register");

        clientRequest.setData(vehicle);
        ConnectToServer clientServerConnector = new ConnectToServer();
        ResponseBody responseBody = clientServerConnector.connectToServer(clientRequest);
//        for (Object response : responseBody.getResponse()) {
//            ResponseStatus responseStatus = (ResponseStatus) response;
//            System.out.println("\t\t -------------------------------------- STATUS: " + responseStatus.getStatus() + " ---------------------------");
//            System.out.println("\t\t --------------         Meaning: " + responseStatus.getMessage());
//            System.out.println("\t\t --------------         Action: " + responseStatus.getActionToDo());
//            System.out.println("\t\t ------------------------------------------------------------------------------");
//
//        }

    }
}
