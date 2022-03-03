<%-- 
    Document   : addRoom
    Created on : 6 Oct, 2021, 12:36:45 PM
    Author     : abhishek-pt4287
--%>
<jsp:include page="hotelNav.jsp"></jsp:include>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Add Room</title>
        <link rel="stylesheet" href="error.css"/>
    </head>
    <body>
        			<div class="row justify-content-md-center h-100">                        
				<div class="card-wrapper">
                                            <br><br><br>
					<div class="card fat">
						<div class="card-body">
							<h4 class="card-title" style="text-align: center;">Add Room Type</h4>
        <s:form action="addRoom" method="post" enctype="multipart/form-data">
            <s:textfield label="Name" name="name"/>
            <s:textfield label="Number of Rooms" name="rooms"/>
            <s:textfield label="Price" name="price"/>
            <s:file name="photo" label="Photo"/>
            <s:submit class="btn btn-success" value="Add Room"/>
        </s:form>
                        		</div>
					</div>
				</div>
                            
			</div>
               	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
