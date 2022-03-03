/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.res.action;

import com.opensymphony.xwork2.ActionSupport;
import hotel.res.user.User;

/**
 *
 * @author abhishek-pt4287
 */
public class GetProfile extends ActionSupport{
 private String user,name,id;
 private String phone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

 
       public String execute(){
        try{
        GetProfile gp=User.getProfile(this);
        this.setName(gp.getName());
        this.setPhone(gp.getPhone());
        this.setUser(gp.getUser());
        return "SUCCESS";
        }
        catch(Exception e){
            e.printStackTrace();
            return "ERROR";
        }
    }
}
