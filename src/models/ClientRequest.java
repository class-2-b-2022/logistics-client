package models;

import java.io.Serializable;

public class ClientRequest implements Serializable {
    private String route; // /users
    private String action; //update
    private Object data; //{}

    public ClientRequest(){}
    public ClientRequest(String route, String action, Object data) {
        this.route = route;
        this.action = action;
        this.data = data;
    }
        /*
           /deleteUsers/1
           /updateUser/1

         */

    public String getRoute() {
        return route;
    }

    public void setRoute(String url) {
        this.route = url;
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

    public void setData(Object object) {
        this.data = object;
    }
}