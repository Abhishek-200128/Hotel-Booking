<%-- 
    Document   : modifyRoom
    Created on : 7 Oct, 2021, 9:50:37 AM
    Author     : abhishek-pt4287
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modify Room</title>
        <link rel="stylesheet" href="error.css"/>
    </head>
    <body>
        <div class="row justify-content-md-center h-100">                        
				<div class="card-wrapper">
                                            <br><br><br>
					<div class="card fat">
						<div class="card-body">
							<h4 class="card-title" style="text-align: center;">Modify Room Type</h4>
        <s:form action="modifyRoom?id=%{id}" method="post" enctype="multipart/form-data">
            <s:textfield label="Name" name="name"/>
            <s:textfield label="Number of Rooms" name="total"/>
            <s:textfield label="Price" name="price"/>
            <s:file name="photo" label="Photo"/>
            <s:submit value="Modify Room" class="btn btn-success"/>
        </s:form>
                                                </div></div></div></div>
    </body>
</html>
