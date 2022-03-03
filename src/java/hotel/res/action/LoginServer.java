/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.res.action;

import com.opensymphony.xwork2.ActionSupport;
import hotel.res.user.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author abhishek-pt4287
 */
public class LoginServer implements SessionAware{
    private String username,pass;
    SessionMap<String,String> sessionmap; 
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    public String execute() throws Exception{
        if(User.login(this).equals("ADMIN")){
            sessionmap.put("login","Admin");
            return "ADMIN";
        }
        else if(User.login(this).equals("HOTEL")){
            sessionmap.put("login",username);System.out.println("Done1");
            return "HOTEL";
        }
        else if(User.login(this).equals("USER")){
            sessionmap.put("login",username);System.out.println("Done1");
            return "USER";
        }
        else{
            return "ERROR";
        }
    }
    
    public void setSession(Map<String,Object> map) {  
    sessionmap=(SessionMap)map;   
} 
    
 
    
    
}
