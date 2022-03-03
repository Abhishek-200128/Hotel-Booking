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
public class UpdateProfile extends ActionSupport{
 private String user,name,id;
 private String phone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String execute() throws Exception{
        int rec=User.updateProfile(this);
        if(rec>0){
            return "SUCCESS";
        }
        else{
            return "ERROR";
        }
    }

    public void validate(){
        if(user.equals("")){
            addFieldError("user","User Name is Required");
        }
        if(name.equals("")){
            addFieldError("name","Name is Required");
        }
        if(phone.equals("")){
            addFieldError("phone","Phone Number is Required");
        }
    }
}
