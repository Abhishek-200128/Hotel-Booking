<%-- 
    Document   : layoutmanager
    Created on : 13 Oct, 2021, 12:02:14 PM
    Author     : abhishek-pt4287
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>  
<!DOCTYPE html>
<html>
    <head>
        <title><tiles:getAsString name="title" /></title>
    </head>
    <body>
        <tiles:insertAttribute name="header" /> 
        <tiles:insertAttribute name="body" /> 
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
