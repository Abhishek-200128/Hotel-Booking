<%-- 
    Document   : index
    Created on : 3 Oct, 2021, 5:57:51 AM
    Author     : abhishek-pt4287
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="error.css"/>
    </head>
    <body>
			<div class="row justify-content-md-center h-100">                        
				<div class="card-wrapper">
                                            <br><br><br>
					<div style="text-align: center;">
                                            <h1>Hotel Booking</h1>
					</div>
					<div class="card fat">
						<div class="card-body">
							<h4 class="card-title" style="text-align: center;">Register</h4>
    <s:form action="Register">
        <s:textfield name="name" label="Name"/>
        <s:textfield name="username" label="User Name"/>
        <s:password name="pass" label="Password"/>
        <s:password name="confirmpass" label="Confirm Password"/>
        <s:textfield name="phone" label="Phone Number"/>
        <s:submit class="btn btn-primary" value="Submit"/>
    </s:form>
    <a href="login.jsp">Already Have an Account?</a>
						</div>
					</div>
				</div>
                            
			</div>
                    

        
        	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
