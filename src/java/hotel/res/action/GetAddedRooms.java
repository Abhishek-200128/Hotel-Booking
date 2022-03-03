/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.res.action;

import hotel.res.user.FetchRoomBean;
import hotel.res.user.User;
import hotel.res.user.fetchRoom;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author abhishek-pt4287
 */
public class GetAddedRooms {
    List<FetchRoomBean> dataList=null;
    ArrayList<String> rs=null;
    String fetchData="FetchRooms";
    fetchRoom dataObj= null;   

    public List<FetchRoomBean> getDataList() {
        return dataList;
    }

    public void setDataList(List<FetchRoomBean> dataList) {
        this.dataList = dataList;
    }

    public ArrayList<String> getRs() {
        return rs;
    }

    public void setRs(ArrayList<String> rs) {
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
                dataList=new ArrayList<FetchRoomBean>();
                FetchRoomBean dataBean=null;
        HttpSession session=ServletActionContext.getRequest().getSession(false);
        ArrayList<Integer> rooms=(ArrayList<Integer>)session.getAttribute("rooms");
                rs=User.getAddedRooms(rooms);
                for(int i=0;i<rs.size();i++){
                    dataBean=new FetchRoomBean();
                    dataBean.setName(rs.get(i));
                    dataList.add(dataBean);
                }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return "SUCCESS";        
    }    
}
