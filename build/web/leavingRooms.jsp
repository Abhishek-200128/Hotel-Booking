<%-- 
    Document   : leavingRooms
    Created on : 11 Oct, 2021, 5:07:41 PM
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
        <div style="padding-left: 5%">
        <table id="bookedrooms" style="text-align: center">
                <thead>
                <tr>
                    <td>Name</td>
                    <td>Room Type</td>
                    <td>Check Out Date</td>
                </tr>
                </thead>
                <s:iterator value="dataList">
                    <tr>
                        <td><s:property value="name"/></td>
                        <td><s:property value="room"/></td>
                        <td><s:property value="checkout"/></td>
                        <td><s:property value="status"/></td>
                        <td><s:url action="checkout" var="myurl">
                                <s:param name="id" value="%{id}"/>                                  
                        </s:url>
                            <a href='<s:property value="#myurl"/>'>
                                <input type="button" class="btn btn-danger" value="Check Out"/>
                            </a>
                                </td>                               
                    </tr>
                </s:iterator>
            </table>
    </div>
    </body>
</html>
