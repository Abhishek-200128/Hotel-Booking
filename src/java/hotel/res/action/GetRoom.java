/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.res.action;

import hotel.res.user.User;

/**
 *
 * @author abhishek-pt4287
 */
public class GetRoom {
    private String name,id;
    private int total,available;
    private float price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    public String execute(){
        try{
        GetRoom gr=User.getRoom(this);
        this.setName(gr.getName());
        this.setTotal(gr.getTotal());
        this.setPrice(gr.getPrice());
        this.setId(gr.getId());
        return "SUCCESS";
        }
        catch(Exception e){
            e.printStackTrace();
            return "ERROR";
        }        
    }
    
}
