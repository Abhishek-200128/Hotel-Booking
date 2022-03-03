<%-- 
    Document   : hotels
    Created on : 6 Oct, 2021, 10:51:36 AM
    Author     : abhishek-pt4287
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Hotels</h1>
        <div style="text-align: center">
            <table id="hotels">
                <thead>
                <tr>
                    <td>Name</td>
                    <td>State</td>
                    <td>Address</td>
                    <td>Pin code</td>
                    <td>Latitude</td>
                    <td>Longitude</td>
                    <td>Photo</td>
                </tr>
                </thead>
                <s:iterator value="dataList">
                    <tr>
                        <td><s:property value="name"/></td>
                        <td><s:property value="state"/></td>
                        <td><s:property value="address"/></td>
                        <td><s:property value="pincode"/></td>
                        <td><s:property value="lat"/></td>
                        <td><s:property value="longi"/></td>
                        <td>
			<img width="100" height="100" src="<s:url value='FetchRecords.action?id='/><s:property value='id'/>">
			</td>
                        <td><s:url action="getHotel" var="myurl">
                                <s:param name="id" value="%{id}"/>                                  
                        </s:url>
                            <a href='<s:property value="#myurl"/>'>
                                <input type="button" class="btn btn-primary" value="Modify"/>
                            </a>
                                </td>
                        <td><s:url action="removeHotel" var="myurl1">
                                <s:param name="id" value="%{id}"/>                                  
                        </s:url>
                            <a href='<s:property value="#myurl1"/>'>
                                <input type="button" class="btn btn-danger" value="Remove"/>
                            </a>
                                </td>                                
                    </tr>
                </s:iterator>
            </table>
        </div>
    </body>
</html>
