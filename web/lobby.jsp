<%-- 
    Document   : lobby
    Created on : 11 Oct, 2021, 4:00:29 PM
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
        <h1 style="padding-left: 5%">Bookings</h1>
        <s:action name="fetchBookedRooms" executeResult="true"></s:action>
        <br>
        <h1 style="padding-left: 5%">Check Outs</h1>
        <s:action name="fetchLeavingRooms" executeResult="true"></s:action>
    </body>
</html>
