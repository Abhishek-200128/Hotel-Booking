/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.res.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import hotel.res.user.User;
import java.io.File;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;

/**
 *
 * @author abhishek-pt4287
 */
public class ModifyHotel extends ActionSupport{
    private String Name,state,address;
    private int pincode,phone;
    private File photo;
    String id;
    private float lat,longi;
    SessionMap<String,String> sessionmap; 

    public File getPhoto() {
        return photo;
    }

    public void setPhoto(File photo) {
        this.photo = photo;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLongi() {
        return longi;
    }

    public void setLongi(float longi) {
        this.longi = longi;
    }
    
    public String execute() throws Exception{
        int rec=User.modifyHotel(this);
        if(rec>0){
            return "SUCCESS";
        }
        else{
            return "ERROR";
        }
    }
    
    public void validate(){
        if(Name.equals("")){
            addFieldError("Name","Name is Required");
        }
        if(state.equals("")){
            addFieldError("state","State is Required");
        }
        if(address.equals("")){
            addFieldError("address","Address is Required");
        }
        if(pincode==0){
            addFieldError("pincode","Pincode is Required");
        }
        if(phone==0){
            addFieldError("phone","Phone Number is Required");
        }
        if(photo==null){
            addFieldError("photo","Photo is Required");
        }
        if(lat==0){
            addFieldError("lat","Latitude is Required");
        }
        if(longi==0){
            addFieldError("longi","Longitude is Required");
        }
    }
    
}
