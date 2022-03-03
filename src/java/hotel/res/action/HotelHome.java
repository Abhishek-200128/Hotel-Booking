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
public class HotelHome {
    String hotel;

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }
    
    public String execute(){
        return "SUCCESS";
    }
}
