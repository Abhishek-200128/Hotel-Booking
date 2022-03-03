/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.res.action;

import com.opensymphony.xwork2.ActionSupport;
import hotel.res.user.User;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author abhishek-pt4287
 */
public class BookRoom extends ActionSupport{
    Date checkin,checkout;
    String id;

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String execute(){
        if(checkin.after(checkout)){
            return "ERROR";
        }
        else{
            HttpSession session=ServletActionContext.getRequest().getSession(false);
            String user=session.getAttribute("login").toString();
            int rec=User.book(user,this);
            if(rec>0){
                return "SUCCESS";
            }
            else{
                return "ERROR";
            }
        }
        
    }
    
    public void validate(){
        if(checkin==null){
            addFieldError("checkin","Check In Date is Required");
        }
        if(checkout==null){
            addFieldError("checkout","Check Out Date is Required");
        }
    }
}
