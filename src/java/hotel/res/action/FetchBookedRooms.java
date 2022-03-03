/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.res.action;

import hotel.res.user.FetchBookedBean;
import hotel.res.user.FetchRoomBean;
import hotel.res.user.User;
import hotel.res.user.fetchRoom;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author abhishek-pt4287
 */
public class FetchBookedRooms {
    List<FetchBookedBean> dataList=null;
    ResultSet rs=null;
    String fetchData="FetchRooms";
    fetchRoom dataObj= null;   

    public List<FetchBookedBean> getDataList() {
        return dataList;
    }

    public void setDataList(List<FetchBookedBean> dataList) {
        this.dataList = dataList;
    }


    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public String getFetchData() {
        return fetchData;
    }

    public void setFetchData(String fetchData) {
        this.fetchData = fetchData;
    }

    public fetchRoom getDataObj() {
        return dataObj;
    }

    public void setDataObj(fetchRoom dataObj) {
        this.dataObj = dataObj;
    }
    
    public String execute(){
        try{
                dataList=new ArrayList<FetchBookedBean>();
                FetchBookedBean dataBean=null;
        HttpSession session=ServletActionContext.getRequest().getSession(false);
        String user=session.getAttribute("hotelid").toString();
        System.out.println("HELLO "+user);
                rs=User.getBookedRooms(user);
                if(rs!=null){
                    while(rs.next()){
                        dataBean=new FetchBookedBean();
                        dataBean.setName(rs.getString(1));
                        dataBean.setRoom(rs.getString(2));
                        dataBean.setCheckin(rs.getDate(3));
                        dataBean.setId(rs.getInt(4));
                        dataBean.setStatus(rs.getString(5));
                        dataList.add(dataBean);
                    }
                }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return "SUCCESS";        
    }    
}
