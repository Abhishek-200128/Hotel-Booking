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
public class FetchCor {
    public ResultSet fetchData(){
        try{
            Statement stmt=conn().createStatement();
            String query="Select id,name,latitude,longitude from hotel;";
            ResultSet rs=stmt.executeQuery(query);
            conn().close();
            return rs;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }       
    }    
}
