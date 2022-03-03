/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.res.action;

import com.opensymphony.xwork2.ActionSupport;
import hotel.res.user.FetchData;
import hotel.res.user.FetchDataBean;
import hotel.res.user.User;
import java.io.OutputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author abhishek-pt4287
 */
public class FetchDataAction extends ActionSupport{
    List<FetchDataBean> dataList=null;
    ResultSet rs=null;
    String fetchData="FetchRecords";
    FetchData dataObj= null;

    public List<FetchDataBean> getDataList() {
        return dataList;
    }

    public void setDataList(List<FetchDataBean> dataList) {
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

    public FetchData getDataObj() {
        return dataObj;
    }

    public void setDataObj(FetchData dataObj) {
        this.dataObj = dataObj;
    }
    
    
    public String execute() throws Exception{
        HttpServletResponse response = ServletActionContext.getResponse();
        HttpServletRequest request = ServletActionContext.getRequest();
        String id = request.getParameter("id");
        try{
            if(fetchData.equals("FetchRecords")){
                dataList=new ArrayList<FetchDataBean>();
                FetchDataBean dataBean=null;
                rs=new FetchData().fetchData();
                if(rs!=null){
                    while(rs.next()){
                        dataBean=new FetchDataBean();
                        dataBean.setId(rs.getInt(1));
                        dataBean.setName(rs.getString(2));
                        dataBean.setState(rs.getString(3));
                        dataBean.setAddress(rs.getString(4));
                        dataBean.setPincode(rs.getInt(5));
                        dataBean.setLat(rs.getFloat(6));
                        dataBean.setLongi(rs.getFloat(7));
                        dataBean.setPhone(rs.getInt(8));
                        dataList.add(dataBean);
                    }
                }
                
                try{
                rs=User.getHotelPic(Integer.parseInt(id));
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
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return "SUCCESS";
    }
    
}
