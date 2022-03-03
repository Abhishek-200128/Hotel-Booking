<%-- 
    Document   : hotelRooms
    Created on : 13 Oct, 2021, 10:38:43 AM
    Author     : abhishek-pt4287
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <br>
        <h1>Rooms</h1>
        <div class="card fat">
	<div class="card-body">
            <s:if test="dataList==null">
                No Rooms to Display
            </s:if>
            <s:else>
        <div style="text-align: center">
            <table id="hotels">
                <thead>
                <tr>
                    <td>Name</td>
                    <td>Total Rooms</td>
                    <td>Available Rooms</td>
                    <td>Price</td>
                    <td>Photo</td>
                </tr>
                </thead>
                <s:iterator value="dataList">
                    <tr>
                        <td><s:property value="name"/></td>
                        <td><s:property value="total"/></td>
                        <td><s:property value="available"/></td>
                        <td><s:property value="price"/></td>
                        <td>
			<img width="100" height="100" src="<s:url value='FetchRooms.action?id='/><s:property value='id'/>">
			</td>
                        <td><s:url action="getRoom" var="myurl">
                                <s:param name="id" value="%{id}"/>                                  
                        </s:url>
                            <a href='<s:property value="#myurl"/>'>
                                <input type="button" class="btn btn-primary" value="Modify"/>
                            </a>
                                </td>
                        <td><s:url action="removeRoom" var="myurl1">
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
            </s:else>
        </div></div>
    </body>
</html>
