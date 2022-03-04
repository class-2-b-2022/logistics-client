package models;

import java.io.Serializable;
public class CreateWalletModel implements Serializable{
    private int userId;

    public CreateWalletModel(){}
    public CreateWalletModel(int userId){
        this.userId = userId;
    }
    public int getUserId(){
        return userId;
    }
    public void setUserId(int userId){
        this.userId= userId;
    }
}
