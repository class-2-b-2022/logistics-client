package formats;

import java.io.Serializable;
public class CreateWalletModel implements Serializable{
    private int userId;
    private float amount;

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
