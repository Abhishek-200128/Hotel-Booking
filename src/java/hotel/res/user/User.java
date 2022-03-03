/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.res.user;

import hotel.res.action.AddHotel;
import hotel.res.action.AddRoom;
import hotel.res.action.BookRoom;
import hotel.res.action.GetHotel;
import hotel.res.action.GetProfile;
import hotel.res.action.GetRoom;
import hotel.res.action.LoginServer;
import hotel.res.action.ModifyHotel;
import hotel.res.action.ModifyRoom;
import java.sql.*;
import hotel.res.action.RegisterAction;
import hotel.res.action.RemoveHotel;
import hotel.res.action.RemoveRoom;
import hotel.res.action.UpdateProfile;
import java.io.FileInputStream;
import java.util.ArrayList;
/**
 *
 * @author abhishek-pt4287
 */
public class User {
    public static Connection con;
    public static Connection conn() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_mgmt","root","abhishek28");
        return con;
    }
    
    public static int register(RegisterAction ra){
        int flag=0;
        try{
            PreparedStatement pst=conn().prepareStatement("insert into users (user_id,name,pass,phone,type) values(?,?,?,?,'User');");
            pst.setString(1,ra.getUsername());
            pst.setString(2,ra.getName());
            pst.setString(3,ra.getPass());
            pst.setString(4,ra.getPhone());
            flag=pst.executeUpdate();
            conn().close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }
    
    public static String login(LoginServer ls){
        String status="";
        try{    
            Class.forName("com.mysql.jdbc.Driver");            
            PreparedStatement ps=conn().prepareStatement("select pass,type from users where user_id=?;");
            ps.setString(1, ls.getUsername());
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                String type=rs.getString(2);
                String pass=rs.getString(1);
                if(pass.equals(ls.getPass())&&type.equals("Hotel")){
                    status="HOTEL";System.out.println("Done0");
                }
                else if(pass.equals(ls.getPass())&&type.equals("User")){
                    status="USER";
                }
                else if(pass.equals(ls.getPass())&&type.equals("Lobby")){
                    status="LOBBY";
                }
                else if(pass.equals(ls.getPass())&&type.equals("Admin")){
                    status="ADMIN";
                }
            }
            conn().close();
            conn().close();
            }catch(Exception e){
                e.printStackTrace();
            }
        
        return status;
    }
    
    public static int addHotel(AddHotel ad){
        int flag=0;
        try{
        String name=ad.getHotelName().substring(0, 3).toLowerCase();
        String user=name+ad.getPincode();
        FileInputStream inputStream = new FileInputStream(ad.getPhoto());
        PreparedStatement pst=conn().prepareStatement("insert into hotel (name,state,address,pincode,latitude,longitude,phone,username,photo) values(?,?,?,?,?,?,?,?,?);");
        pst.setString(1, ad.getHotelName());
        pst.setString(2,ad.getState());
        pst.setString(3, ad.getAddress());
        pst.setInt(4, ad.getPincode());
        pst.setFloat(5, ad.getLat());
        pst.setFloat(6, ad.getLongi());
        pst.setInt(7, ad.getPhone());
        pst.setString(8, user);
        pst.setBinaryStream(9, inputStream);
        flag=pst.executeUpdate();
        pst=conn().prepareStatement("insert into users (user_id,name,pass,phone,type) values(?,?,?,?,?);");
        pst.setString(1,user);
        pst.setString(2,ad.getHotelName());
        pst.setString(3,user);
        pst.setInt(4, ad.getPhone());
        pst.setString(5,"Hotel");
        pst.executeUpdate();
        conn().close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }
    
    public static int modifyHotel(ModifyHotel mh){
        int flag=0;
        try{
            FileInputStream inputStream = new FileInputStream(mh.getPhoto());
        PreparedStatement pst=conn().prepareStatement("update hotel set name=?,state=?,address=?,pincode=?,latitude=?,longitude=?,phone=?,photo=? where id=?;");
        pst.setString(1, mh.getName());
        pst.setString(2,mh.getState());
        pst.setString(3, mh.getAddress());
        pst.setInt(4, mh.getPincode());
        pst.setFloat(5, mh.getLat());
        pst.setFloat(6, mh.getLongi());
        pst.setInt(7, mh.getPhone());
        pst.setBinaryStream(8, inputStream);
        pst.setInt(9, Integer.parseInt(mh.getId()));
        System.out.println("id="+mh.getId());
        flag=pst.executeUpdate();
        conn().close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }
    
    public static GetHotel getHotel(GetHotel gh){
        try{
            PreparedStatement pst=conn().prepareStatement("select * from hotel where id=?;");
            pst.setInt(1, Integer.parseInt(gh.getId()));
            ResultSet rs=pst.executeQuery();
            if(rs.next()){
            gh.setId(rs.getString(1));
            gh.setName(rs.getString(2));
            gh.setState(rs.getString(3));
            gh.setAddress(rs.getString(4));
            gh.setPincode(rs.getInt(5));
            gh.setLat(rs.getFloat(6));
            gh.setLongi(rs.getFloat(7));
            gh.setPhone(rs.getInt(8));
            }
            conn().close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return gh;
    }
    
    public static int removeHotel(RemoveHotel rh){
        int flag=0;
        try{
            PreparedStatement pst = conn().prepareStatement("delete from rooms where hotel_id=?;");
            pst.setInt(1,Integer.parseInt(rh.getId()));
            pst.executeUpdate();
            pst=conn().prepareStatement("select username from hotel where id=?;");
            pst.setInt(1, Integer.parseInt(rh.getId()));
            ResultSet rs=pst.executeQuery();
            rs.next();
            String user=rs.getString(1);
            pst = conn().prepareStatement("delete from hotel where id=?;");
            pst.setInt(1,Integer.parseInt(rh.getId()));
            pst.executeUpdate();
            pst=conn().prepareStatement("delete from users where user_id=?;");
            pst.setString(1, user);
            pst.executeUpdate();
            flag=1;
            conn().close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public static int addRoom(AddRoom ar,String user){
        int flag=0;
        try{
            FileInputStream inputStream = new FileInputStream(ar.getPhoto());
        System.out.println(user);
        PreparedStatement pst=conn().prepareStatement("select id from hotel where username=?;");
        pst.setString(1,user);
        ResultSet rs=pst.executeQuery();
        rs.next();
        int id=rs.getInt(1);
        pst=conn().prepareStatement("insert into rooms (name,hotel_id,total_rooms,available,price,photo) values(?,?,?,?,?,?);");
        pst.setString(1,ar.getName());
        pst.setInt(2,id);
        pst.setInt(3,ar.getRooms());
        pst.setInt(4, ar.getRooms());
        pst.setFloat(5,ar.getPrice());
        pst.setBinaryStream(6, inputStream);
        flag=pst.executeUpdate();
        conn().close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public static GetRoom getRoom(GetRoom gr){
        try{
            PreparedStatement pst=conn().prepareStatement("select * from rooms where id=?;");
            pst.setInt(1, Integer.parseInt(gr.getId()));
            ResultSet rs=pst.executeQuery();
            if(rs.next()){
            gr.setId(rs.getString(1));
            gr.setName(rs.getString(2));
            gr.setTotal(rs.getInt(4));
            gr.setAvailable(rs.getInt(5));
            gr.setPrice(rs.getFloat(6));
            }
            conn().close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return gr;
    }

    public static int modifyRoom(ModifyRoom mr){
        int flag=0;
        try{
            PreparedStatement pst=conn().prepareStatement("Select total_rooms from rooms where id=?;");
            pst.setInt(1,Integer.parseInt(mr.getId()));
            ResultSet rs=pst.executeQuery();
            rs.next();
            int total1=rs.getInt(1);
            FileInputStream inputStream = new FileInputStream(mr.getPhoto());
        pst=conn().prepareStatement("update rooms set name=?,total_rooms=?,available=available+?,price=?,photo=? where id=?;");
        pst.setString(1, mr.getName());
        pst.setInt(2,mr.getTotal());
        pst.setInt(3,mr.getTotal()-total1);
        pst.setFloat(4, mr.getPrice());
        pst.setBinaryStream(5, inputStream);
        pst.setInt(6,Integer.parseInt(mr.getId()));
        flag=pst.executeUpdate();
        conn().close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }
    
    public static int removeRoom(RemoveRoom rm){
        int flag=0;
        try{
            PreparedStatement pst = conn().prepareStatement("delete from rooms where id=?;");
            pst.setInt(1,Integer.parseInt(rm.getId()));
            pst.executeUpdate();
            flag=1;
            conn().close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }
    
        public static ResultSet getRooms(String id){
        try{
            PreparedStatement pst=conn().prepareStatement("select * from rooms where hotel_id=?;");
            pst.setInt(1, Integer.parseInt(id));
            ResultSet rs=pst.executeQuery();
            conn().close();
            return rs;
            
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
        }
        
        public static ArrayList<String> getAddedRooms(ArrayList<Integer> arr){
            ArrayList<String> names= new ArrayList<String>();
            for(int i=0;i<arr.size();i++){
                try{
                PreparedStatement pst=conn().prepareStatement("select name from rooms where id=?;");
                pst.setInt(1,arr.get(i));
                ResultSet rs=pst.executeQuery();
                if(rs.next()){
                    names.add(rs.getString(1));
                }
                conn().close();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        return names;
        
    }
        
        public static int book(String user,BookRoom br){
            int rec=0;
            try{
                PreparedStatement pst=conn().prepareStatement("select * from rooms where id=?;");
                pst.setInt(1,Integer.parseInt(br.getId()));
                ResultSet rs=pst.executeQuery();
                rs.next();
                String name=rs.getString(2);
                int hid=rs.getInt(3);
                int rid=rs.getInt(1);
                float price=rs.getFloat(6);
                long diff=br.getCheckout().getTime()-br.getCheckin().getTime();
                float days1 = (diff / (1000*60*60*24));
                int days=(int)days1+1;
                float tprice=days*price;
                conn().close();
                pst=conn().prepareStatement("select id from users where user_id=?;");
                pst.setString(1, user);
                rs=pst.executeQuery();
                rs.next();
                int id=rs.getInt(1);
                conn().close();
                pst=conn().prepareStatement("insert into booking (user_id,hotel_id,room_id,checkin_date,checkout_date,status,tprice) values(?,?,?,?,?,?,?);");
                pst.setInt(1, id);;
                pst.setInt(2, hid);
                pst.setInt(3, rid);
                java.sql.Date checkin = new java.sql.Date(br.getCheckin().getTime());
                java.sql.Date checkout = new java.sql.Date(br.getCheckout().getTime());
                pst.setDate(4,checkin);
                pst.setDate(5,checkout);
                pst.setString(6,"Booked");
                pst.setFloat(7, tprice);
                rec=pst.executeUpdate();
                conn().close();
            }catch(Exception e){
                e.printStackTrace();
            }
            return rec;
        }
        
                public static ResultSet getBookedRooms(String id){
        try{
            PreparedStatement pst=conn().prepareStatement("select u.name,r.name,b.checkin_date,b.id,b.status from booking b,users u,rooms r where u.id=b.user_id and b.room_id=r.id and b.hotel_id=? and status='Booked';");
            pst.setInt(1, Integer.parseInt(id));
            ResultSet rs=pst.executeQuery();
            conn().close();
            return rs;
            
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
        }
                
                public static ResultSet getLeavingRooms(String id){
        try{
            System.out.println(id);
            PreparedStatement pst=conn().prepareStatement("select u.name,r.name,b.checkout_date,b.id,b.status from booking b,users u,rooms r where u.id=b.user_id and b.room_id=r.id and b.hotel_id=? and status='Checked-In';");
            pst.setInt(1, Integer.parseInt(id));
            ResultSet rs=pst.executeQuery();
            conn().close();
            return rs;
            
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
        }

public static ResultSet getHotelPic(int id){
    try{
        System.out.println(id);
        PreparedStatement pst=conn().prepareStatement("select photo from hotel where id=?;");
        pst.setInt(1, id);
        ResultSet rs=pst.executeQuery();
        conn().close();
        return rs;
    }catch(Exception e){
        e.printStackTrace();
        return null;
    }
} 

public static ResultSet getRoomPic(int id){
    try{
        System.out.println(id);
        PreparedStatement pst=conn().prepareStatement("select photo from rooms where id=?;");
        pst.setInt(1, id);
        ResultSet rs=pst.executeQuery();
        conn().close();
        return rs;
    }catch(Exception e){
        e.printStackTrace();
        return null;
    }
}

    public static GetProfile getProfile(GetProfile gh){
        try{
            PreparedStatement pst=conn().prepareStatement("select * from users where user_id=?;");
            pst.setString(1,gh.getUser());
            ResultSet rs=pst.executeQuery();
            if(rs.next()){
                gh.setId(rs.getString(1));
            gh.setName(rs.getString(3));
            gh.setUser(rs.getString(2));
            gh.setPhone(rs.getString(5));
            }
            conn().close();
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return gh;
    }
    
        public static int updateProfile(UpdateProfile mh){
        int flag=0;
        try{
        PreparedStatement pst=conn().prepareStatement("update users set name=?,phone=?,user_id=? where id=?;");
        pst.setString(1, mh.getName());
        pst.setString(2, mh.getPhone());
        pst.setString(3, mh.getUser());
        pst.setInt(4, Integer.parseInt(mh.getId()));
        System.out.println("id="+mh.getId());
        flag=pst.executeUpdate();
        conn().close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
