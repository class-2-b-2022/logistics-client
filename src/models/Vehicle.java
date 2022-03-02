package models;

      /*
       *required fields for vehicle*
        model
        plateNbr
        brand
        owner
        description
        */

import java.io.Serializable;

public class Vehicle implements Serializable {
    private String plateNbr;
    private String brand;
    private String owner;
    private String description ;

    public String getPlateNbr() {
        return plateNbr;
    }

    public String getBrand() {
        return brand;
    }

    public String getOwner(String owner) {
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
