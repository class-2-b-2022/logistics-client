package Utils;



import java.io.Serializable;

public class RequestBody implements Serializable {
    private String route; // /users
    private String action; //update
    private Object data; //{}

    public RequestBody(){}
    public RequestBody(String url, String action, Object object) {
        this.route = url;
        this.action = action;
        this.data = object;
    }
        /*
           /deleteUsers/1
           /updateUser/1
         */

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}