package main.Distributor;

import java.io.Serializable;

public class DistributorModel implements Serializable {
    private String first_name;
    private String last_name;
    private String email;
    private String telephone;
    private String distributor_type;
    private String business_name;
    private String business_description;


    public String getDistributor_type() {
        return distributor_type;
    }

    public void setDistributor_type(String distributor_type) {
        this.distributor_type = distributor_type;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getBusiness_name() {
        return business_name;
    }

    public void setBusiness_name(String business_name) {
        this.business_name = business_name;
    }

    public String getBusiness_description() {
        return business_description;
    }

    public void setBusiness_description(String business_description) {
        this.business_description = business_description;
    }


}
