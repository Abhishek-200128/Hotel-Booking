/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.res.action;

import com.opensymphony.xwork2.ActionSupport;
import static hotel.res.user.User.conn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author abhishek-pt4287
 */
public class CheckIn extends ActionSupport{
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String execute(){
        try{
        PreparedStatement pst=conn().prepareStatement("update booking set checkin_time=curtime() where id=?;");
        pst.setInt(1,Integer.parseInt(id));
        pst.executeUpdate();
        pst=conn().prepareStatement("select room_id from booking where id=?;");
        pst.setInt(1, Integer.parseInt(id));
        ResultSet rs=pst.executeQuery();
        rs.next();
        int rid=rs.getInt(1);
        pst=conn().prepareStatement("update rooms set available=available-1 where id=?;");
        pst.setInt(1, rid);
        pst.executeUpdate();
        pst=conn().prepareStatement("update booking set status='Checked-In' where id=?;");
        pst.setInt(1,Integer.parseInt(id));
        pst.executeUpdate();
        return "SUCCESS";
        }
        catch(Exception e){
            e.printStackTrace();
            return "ERROR";
        }
        }
}
