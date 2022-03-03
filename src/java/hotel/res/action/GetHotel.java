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
public class GetHotel extends ActionSupport{
    private String id,name,state,address;
    private int pincode,phone;
    private float lat,longi;

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public String getAddress() {
        return address;
    }

    public int getPincode() {
        return pincode;
    }

    public float getLat() {
        return lat;
    }

    public float getLongi() {
        return longi;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public void setLongi(float longi) {
        this.longi = longi;
    }
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String execute(){
        try{
        GetHotel gh=User.getHotel(this);
        this.setName(gh.getName());
        this.setState(gh.getState());
        this.setAddress(gh.getAddress());
        this.setPincode(gh.getPincode());
        this.setLat(gh.getLat());
        this.setLongi(gh.getLongi());
        this.setPhone(gh.getPhone());
        return "SUCCESS";
        }
        catch(Exception e){
            e.printStackTrace();
            return "ERROR";
        }
    }
}
