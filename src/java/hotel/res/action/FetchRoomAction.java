/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.res.action;

import com.opensymphony.xwork2.ActionSupport;
import hotel.res.user.fetchRoom;
import hotel.res.user.FetchRoomBean;
import hotel.res.user.User;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author abhishek-pt4287
 */
public class FetchRoomAction extends ActionSupport{
    List<FetchRoomBean> dataList=null;
    ResultSet rs=null;
    String fetchData="FetchRooms";
    fetchRoom dataObj= null;   

    public List<FetchRoomBean> getDataList() {
        return dataList;
    }

    public void setDataList(List<FetchRoomBean> dataList) {
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
        HttpServletResponse response = ServletActionContext.getResponse();
        HttpServletRequest request = ServletActionContext.getRequest();
        String id = request.getParameter("id");
                dataList=new ArrayList<FetchRoomBean>();
                FetchRoomBean dataBean=null;
        HttpSession session=ServletActionContext.getRequest().getSession(false);
        String user=session.getAttribute("login").toString();
                rs=new fetchRoom().fetchData(user);
                if(rs!=null){
                    while(rs.next()){
                        dataBean=new FetchRoomBean();
                        dataBean.setId(rs.getInt(1));
                        dataBean.setName(rs.getString(2));
                        dataBean.setTotal(rs.getInt(4));
                        dataBean.setAvailable(rs.getInt(5));
                        dataBean.setPrice(rs.getFloat(6));
                        dataList.add(dataBean);
                    }
             
                }
                try{
                rs=User.getRoomPic(Integer.parseInt(id));
                        if(rs.next()){
                            Blob ph=rs.getBlob(1);
                            if(ph!=null){
                            byte data[] = ph.getBytes(1, (int) ph.length());
                            OutputStream out=response.getOutputStream();
                                    out.write(data);
                            out.flush();
                            out.close();}
                        }
                }catch(Exception e){
                    e.printStackTrace();
                    e.getMessage();
                }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return "SUCCESS";        
    }
}
