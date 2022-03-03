/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.res.action;

import hotel.res.user.FetchRoomBean;
import hotel.res.user.User;
import hotel.res.user.fetchRoom;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author abhishek-pt4287
 */
public class RemoveRoomBook implements SessionAware{
    String name;
    List<FetchRoomBean> dataList=null;
    ArrayList<String> rs=null;
    String fetchData="FetchRooms";
    fetchRoom dataObj= null;  
    SessionMap<String,ArrayList<Integer>> sessionmap; 

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
        rooms.remove(rooms.indexOf(name));
        sessionmap.put("rooms", rooms);
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
    
        public void setSession(Map<String,Object> map) {  
    sessionmap=(SessionMap)map;   
}
}
