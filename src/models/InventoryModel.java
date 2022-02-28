package models;

import java.util.Date;

public class InventoryModel {
    int quantity;
    String Price;
    String Status;
    int productId;
    int userId;
    Date date;

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getUserId() {
        return userId;
    }

    public String getPrice() {
        return Price;
    }

    public String getStatus() {
        return Status;
    }
}
