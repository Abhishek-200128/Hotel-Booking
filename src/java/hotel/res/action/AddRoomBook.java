/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.res.action;

import hotel.res.user.User;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author abhishek-pt4287
 */
public class AddRoomBook implements SessionAware{
    String id;
    SessionMap<String,ArrayList<Integer>> sessionmap; 

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
        public String execute() throws Exception{
            if(sessionmap.containsKey("rooms")){
                HttpSession session=ServletActionContext.getRequest().getSession(false);
                ArrayList<Integer> arr=(ArrayList<Integer>)session.getAttribute("rooms");
                arr.add(Integer.parseInt(id));
                sessionmap.put("rooms", arr);
            }
            else{
                ArrayList<Integer> arr=new ArrayList<Integer>();
                arr.add(Integer.parseInt(id));
                sessionmap.put("rooms", arr);
            }
            return "SUCCESS";
    }
        
            public void setSession(Map<String,Object> map) {  
                sessionmap=(SessionMap)map;   
}
    
}
