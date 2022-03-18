package logic;

import Views.DeliveryModel;
import formats.Vehicle;
import utils.ConnectToServer;
import utils.RequestBody;
import utils.ResponseBody;
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
        String owner = scanner.nextLine();
        System.out.println("Enter the plate number: ");
        String plateNbr = scanner.nextLine();
        System.out.println("Enter the brand: ");
        String brand = scanner.nextLine();

        System.out.println("Enter the description: ");
        String description = scanner.nextLine();
        System.out.println("Enter vehicle Model : ");
        String model = scanner.nextLine();

        Vehicle vehicle = new Vehicle();
        vehicle.setPlateNbr(plateNbr);
        vehicle.setBrand(brand);
        vehicle.setOwner(owner);
        vehicle.setDescription(description);
        vehicle.setModel(model);

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


    public void updateVehicles(int id)throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter vehicle Owner : ");
        String owner = scanner.nextLine();
        System.out.println("Enter the plate number: ");
        String plateNbr = scanner.nextLine();
        System.out.println("Enter the brand: ");
        String brand = scanner.nextLine();

        System.out.println("Enter the description: ");
        String description = scanner.nextLine();
        System.out.println("Enter vehicle Model : ");
        String model = scanner.nextLine();

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleId(id);
        vehicle.setPlateNbr(plateNbr);
        vehicle.setBrand(brand);
        vehicle.setOwner(owner);
        vehicle.setDescription(description);
        vehicle.setModel(model);


        RequestBody req = new RequestBody();
        req.setRoute("/delivery/vehicles");
        req.setAction("update");

        req.setData(vehicle);
        ConnectToServer clientServerConnector = new ConnectToServer();
        ResponseBody responseBody = clientServerConnector.connectToServer(req);
        System.out.println(responseBody.getStatus());
        if(!responseBody.getStatus().equals("200")){
            System.out.println("An error occurred behind your screen");
        }
        else{
            System.out.println("Vehicle updated successfully");
            DeliveryModel delivery = new DeliveryModel();
            delivery.VehicleManagement();

        }






    }
    public void deleteVehicle(int id) throws Exception{


        Vehicle vehicle = new Vehicle();

        vehicle.setVehicleId(id);

        RequestBody req = new RequestBody();
        req.setRoute("/delivery/vehicles");
        req.setAction("delete");

        req.setData(vehicle);
        ConnectToServer clientServerConnector = new ConnectToServer();
        ResponseBody responseBody = clientServerConnector.connectToServer(req);
        System.out.println(responseBody.getStatus());
        if(!responseBody.getStatus().equals("200")){
            System.out.println("An error occurred behind your screen");
        }
        else{
            System.out.println("Vehicle Deleted successfully");
            DeliveryModel delivery = new DeliveryModel();
            delivery.VehicleManagement();

        }


    }
}
