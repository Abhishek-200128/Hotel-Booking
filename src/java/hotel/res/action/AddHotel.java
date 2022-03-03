/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.res.action;

import com.opensymphony.xwork2.ActionSupport;
import hotel.res.user.User;
import java.io.File;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author abhishek-pt4287
 */
public class AddHotel extends ActionSupport{
    private String hotelName,state,address;
    File photo;
    private int pincode,phone;
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

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
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
        System.out.println(photo.getAbsolutePath());
        int rec=User.addHotel(this);
        if(rec>0){
            return "SUCCESS";
        }
        else{
            return "ERROR";
        }
    }
   
    
    public void validate(){
        System.out.println(hotelName);
        if(hotelName.equals("")){
            addFieldError("hotelName","Name is Required");
        }
        if(pincode==0){
            addFieldError("pincode","Pincode is Required");
        }
        if(state.equals("")){
            addFieldError("state","State is Required");
        }
        if(address.equals("")){
            addFieldError("address","Address is Required");
        }
        if(phone==0){
            addFieldError("phone","Phone Number is Required");
        }
        if(lat==0){
            addFieldError("lat","Latitude is Required");
        }
        if(longi==0){
            addFieldError("longi","Longitude is Required");
        }
        if(photo==null){
            addFieldError("photo","Photo is Required");
        }
    }
    
}
