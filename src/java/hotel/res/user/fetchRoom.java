/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.res.user;

import static hotel.res.user.User.conn;

import java.sql.*;

/**
 *
 * @author abhishek-pt4287
 */
public class fetchRoom {
    public ResultSet fetchData(String user){
        try{
            PreparedStatement stmt=conn().prepareStatement("Select id from hotel where username=?;");
            stmt.setString(1, user);
            ResultSet rs=stmt.executeQuery();
            rs.next();
            int id=rs.getInt(1);
            stmt=conn().prepareStatement("select * from rooms where hotel_id=?;");
            stmt.setInt(1,id);
            rs=stmt.executeQuery();
            conn().close();
            return rs;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }    
}
}
