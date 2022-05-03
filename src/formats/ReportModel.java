package formats;

public class ReportModel {

    private Long date;
    private String companyName;
    private String status;
    private String  product;
    private Integer quantity;

    public Long getDate(Long date) {
        return this.date;
    }

    public void setDate(Long date) {
        this.date = date;
    }




    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProduct() {
        return this.product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }



}