/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.res.action;

import com.opensymphony.xwork2.ActionSupport;
import hotel.res.user.User;

/**
 *
 * @author abhishek-pt4287
 */
public class RegisterAction extends ActionSupport{
    private String name;
    private String username;
    private String pass;
    private String confirmpass;

    public String getConfirmpass() {
        return confirmpass;
    }

    public void setConfirmpass(String confirmpass) {
        this.confirmpass = confirmpass;
    }
    private String phone;
    
    public RegisterAction(){
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String execute() throws Exception{
        if(!pass.equals(confirmpass)){
            return "ERROR";
        }
        else{
        int rec=User.register(this);
        if(rec>0){
            return "SUCCESS";
        }
        else{
            return "ERROR";
        }
    }
    }
    
    public void validate(){
        if(name.equals("")){
            addFieldError("name","Name is Required");
        }
        if(username.equals("")){
            addFieldError("username","User Name is Required");
        }
        if(pass.equals("")){
            addFieldError("pass","Password is Required");
        }
        if(confirmpass.equals("")){
            addFieldError("confirmpass","Field is Required");
        }
        if(phone.equals("")){
            addFieldError("phone","Phone Number is Required");
        }
        if(!pass.equals(confirmpass)){
            addFieldError("confirmpass","Password is not the same as the Confirm Password");
        }
    }
    
}
