/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.res.action;

import com.opensymphony.xwork2.ActionSupport;
import hotel.res.user.User;
import java.io.File;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author abhishek-pt4287
 */
public class AddRoom extends ActionSupport{
    private String name;
    File photo;
    private int rooms;
    private float price;

    public File getPhoto() {
        return photo;
    }

    public void setPhoto(File photo) {
        this.photo = photo;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }
    
    public String execute(){
        HttpSession session=ServletActionContext.getRequest().getSession(false);
        String user=session.getAttribute("login").toString();
        int rec=User.addRoom(this,user);
        if(rec>0){
            return "SUCCESS";
        }
        else{
            return "ERROR";
        }        
    }
    
    public void validate(){
        if(name.equals("")){
            addFieldError("name","Name is Required");
        }
        if(rooms==0){
            addFieldError("rooms","Number of Rooms is Required");
        }
        if(price==0){
            addFieldError("price","Price is Required");
        }
        if(photo==null){
            addFieldError("photo","Photo is Required");
        }
    }
    
}
