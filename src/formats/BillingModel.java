package formats;

import java.io.Serializable;

public class BillingModel implements Serializable {
    private int userId;
    private float amount;

    public BillingModel() {}

    public BillingModel(int userId, float amount) {
        this.userId = userId;
        this.amount = amount;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
