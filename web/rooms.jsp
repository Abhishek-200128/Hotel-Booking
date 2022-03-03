<%-- 
    Document   : rooms
    Created on : 11 Oct, 2021, 10:09:50 AM
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
                <div class="card fat">
	<div class="card-body">
            <h1>Select The Room of your Choice</h1>
        <table style="text-align: center;">
            <thead>
                <tr>
                    <td>Name</td>
                    <td>Available</td>
                    <td>Price</td>
                    <td>Photo</td>
                </tr>
                </thead>
                <s:iterator value="dataList">
                    <tr>
                        <td><s:property value="name"/></td>
                        <td><s:property value="available"/></td>
                        <td><s:property value="price"/></td>
                        <td>
                            <img width="100" height="100" src="<s:url value='getRooms.action?id='/><s:property value='id'/>">
                        </td>
                        <td><s:url action="bookRoom" var="myurl">
                                <s:param name="id" value="%{id}"/>                                  
                        </s:url>
                            <a href='<s:property value="#myurl"/>'>
                                <input type="button" class="btn btn-success" value="Book Room"/>
                            </a>
                                </td>                               
                    </tr>
                </s:iterator>
            </table>
        </div></div>       
    </body>
</html>
