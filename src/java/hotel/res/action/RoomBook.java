/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.res.action;

import hotel.res.user.User;
import java.sql.Date;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author abhishek-pt4287
 */
public class RoomBook {
    String id;
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String execute(){
            return "SUCCESS";

        
    }    
}
