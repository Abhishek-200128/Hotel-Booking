<%-- 
    Document   : loginsuccess
    Created on : 4 Oct, 2021, 5:51:04 AM
    Author     : abhishek-pt4287
--%>

    <jsp:include page="login.jsp"></jsp:include>  
    <hr/>  
    <%@ taglib uri="/struts-tags" prefix="s" %>  
      
    <br>Welcome, <s:property value="username"/>  
