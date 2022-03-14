package formats;

      /*
       *required fields for vehicle*
        model
        plateNbr
        brand
        owner
        description
        */

import java.io.Serializable;
import java.math.BigInteger;

public class Vehicle implements Serializable {


    private Integer VehicleId;
    private String plateNbr;
    private String brand;
    private String owner;
    private String model;
    private String description ;
    private BigInteger createdAt;
    public BigInteger getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(BigInteger createdAt) {
        this.createdAt = createdAt;
    }



    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }
    public Integer getVehicleId() {
        return VehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        VehicleId = vehicleId;
    }

    public String getPlateNbr() {
        return plateNbr;
    }

    public String getBrand() {
        return brand;
    }

    public String getOwner() {
        return this.owner;
    }

    public String getDescription() {
        return description;
    }


    public void setPlateNbr(String plateNbr) {
        this.plateNbr = plateNbr;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
