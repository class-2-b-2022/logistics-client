package utils;


import java.io.Serializable;


public class ResponseBody implements Serializable {
    private String message;///users
    private String status;//regist
    private String data;
    public ResponseBody(){}
    public ResponseBody(String message, String status, String data){
        this.status = status;
        this.message = message;
        this.data = data;
    }
    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }

    public String getData() {
        return data;
    }



    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setData(String data) {
        this.data = data;
    }


}
