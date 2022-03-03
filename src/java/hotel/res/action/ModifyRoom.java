/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.res.action;

import com.opensymphony.xwork2.ActionSupport;
import hotel.res.user.User;
import java.io.File;

/**
 *
 * @author abhishek-pt4287
 */
public class ModifyRoom extends ActionSupport{
    private String name,id;
    private File photo;
    private int total;
    private float price;

    public File getPhoto() {
        return photo;
    }

    public void setPhoto(File photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    public String execute(){
        int rec=User.modifyRoom(this);
        if(rec>0){
            return "SUCCESS";
        }
        else{
            return "ERROR";
        }
    }
    
    public void validate(){
        if(photo==null){
            addFieldError("photo","Photo is Required");
        }
        if(name.equals("")){
            addFieldError("name","Name is Required");
        }
        if(total==0){
            addFieldError("total","Total Rooms is Required");
        }
        if(price==0){
            addFieldError("price","Photo is Required");
        }
    }
}
