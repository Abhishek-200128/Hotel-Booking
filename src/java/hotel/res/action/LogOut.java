/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.res.action;

import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author abhishek-pt4287
 */
public class LogOut implements SessionAware{
    SessionMap<String,String> sessionmap; 
    
    public String execute(){
        sessionmap.invalidate();
        return "SUCCESS";
    }
    
        public void setSession(Map<String,Object> map) {  
    sessionmap=(SessionMap)map;   
} 
}
