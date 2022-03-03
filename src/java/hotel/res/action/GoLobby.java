/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.res.action;

import static hotel.res.user.User.conn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author abhishek-pt4287
 */
public class GoLobby implements SessionAware{
    String hotel;
    SessionMap<String,String> sessionmap;

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }
    
    
    public String execute(){
        try{
        PreparedStatement pst=conn().prepareStatement("select * from hotel where username=?");
        pst.setString(1, hotel);
        ResultSet rs=pst.executeQuery();
        rs.next();
        int id=rs.getInt(1);
        sessionmap.put("hotelid",Integer.toString(id));
        return "SUCCESS";
        }
        catch(Exception e){
            e.printStackTrace();
            return "ERROR";
        }

        
    }

    public void setSession(Map<String,Object> map) {  
    sessionmap=(SessionMap)map;   
}    
}
