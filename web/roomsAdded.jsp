<%-- 
    Document   : roomsAdded
    Created on : 11 Oct, 2021, 11:49:45 AM
    Author     : abhishek-pt4287
--%>
<jsp:include page="roomBook.jsp"></jsp:include> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Rooms Added</h1>
                    <table id="rooms" style="text-align: center">
                <thead>
                <tr>
                    <td>Name</td>
                </tr>
                </thead>
                <s:iterator value="dataList">
                    <tr>
                        <td><s:property value="name"/></td>
                        <td><s:url action="removeRoomBook" var="myurl">
                                <s:param name="id" value="%{name}"/>                                  
                        </s:url>
                            <a href='<s:property value="#myurl"/>'>
                                <input type="button" value="Remove Room"/>
                            </a>
                                </td>                               
                    </tr>
                </s:iterator>
            </table>
    </body>
</html>
