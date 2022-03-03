<%-- 
    Document   : updateProfile
    Created on : 13 Oct, 2021, 11:09:40 AM
    Author     : abhishek-pt4287
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Profile</title>
        <link rel="stylesheet" href="error.css"/>
    </head>
    <body>
                <div class="row justify-content-md-center h-100">                        
				<div class="card-wrapper">
                                            <br><br><br>
					<div class="card fat">
						<div class="card-body">
							<h4 class="card-title" style="text-align: center;">Update Profile</h4>
        <s:form action="modifyProfile?id=%{id}" method="POST" enctype="multipart/form-data">
            <s:textfield name="name" label="Name"/>
            <s:textfield name="user" label="User_id"/>
        <s:textfield label="Phone" name="phone"/>
        <s:submit value="Update Profile" class="btn btn-success"/>   
        </s:form>
                                                </div></div></div></div>
    </body>
</html>
