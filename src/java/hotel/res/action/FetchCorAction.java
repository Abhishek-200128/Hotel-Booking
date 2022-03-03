/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.res.action;

import com.opensymphony.xwork2.ActionSupport;
import hotel.res.user.FetchCor;
import hotel.res.user.FetchCorBean;
import hotel.res.user.FetchData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author abhishek-pt4287
 */
public class FetchCorAction extends ActionSupport{
   List<FetchCorBean> dataList=null;
    ResultSet rs=null;
    String fetchData="FetchRecords";
    FetchData dataObj= null;

    public List<FetchCorBean> getDataList() {
        return dataList;
    }

    public void setDataList(List<FetchCorBean> dataList) {
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
        try{
            if(fetchData.equals("FetchRecords")){
                dataList=new ArrayList<FetchCorBean>();
                FetchCorBean dataBean=null;
                rs=new FetchCor().fetchData();
                if(rs!=null){
                    while(rs.next()){
                        dataBean=new FetchCorBean();
                        dataBean.setId(rs.getInt(1));
                        dataBean.setName(rs.getString(2));
                        dataBean.setLat(rs.getFloat(3));
                        dataBean.setLongi(rs.getFloat(4));
                        dataList.add(dataBean);
                    }
                }
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return "SUCCESS";
    }    
}
