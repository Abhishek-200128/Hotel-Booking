/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.res.action;

/**
 *
 * @author abhishek-pt4287
 */
public class UserHome {
    String user;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    
    public String execute(){
        return "SUCCESS";
    }    
}
