<%-- 
    Document   : bookedRooms
    Created on : 11 Oct, 2021, 4:17:46 PM
    Author     : abhishek-pt4287
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <br>
        <div style="padding-left: 5%">
        <table id="hotels" style="text-align: center">
                <thead>
                <tr>
                    <td>Name</td>
                    <td>Room Type</td>
                    <td>Check In Date</td>
                    <td>Status</td>
                </tr>
                </thead>
                <s:iterator value="dataList">
                    <tr>
                        <td><s:property value="name"/></td>
                        <td><s:property value="room"/></td>
                        <td><s:property value="checkin"/></td>
                        <td><s:property value="status"/></td>
                        <td><s:url action="checkin" var="myurl">
                                <s:param name="id" value="%{id}"/>                                  
                        </s:url>
                            <a href='<s:property value="#myurl"/>'>
                                <input type="button" class="btn btn-success" value="Check In"/>
                            </a>
                                </td>                               
                    </tr>
                </s:iterator>
            </table>
            </div>
    </body>
</html>
