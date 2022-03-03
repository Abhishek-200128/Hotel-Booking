<%-- 
    Document   : book
    Created on : 11 Oct, 2021, 11:30:20 AM
    Author     : abhishek-pt4287
--%>
<jsp:include page="roomBook.jsp"></jsp:include> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script> 
  <link rel="stylesheet" href="error.css"/>
        <title>Booking Page</title>
    </head>
    <body>

                <div class="row justify-content-md-center h-100">                        
				<div class="card-wrapper">
                                            <br><br><br>
					<div class="card fat">
						<div class="card-body">
							<h4 class="card-title" style="text-align: center;">Select Check in and Check out date</h4>
        <s:form action="booked">    
        <s:textfield name="checkin" type="date" format="dd-MM-yyyy" label="Check in Date" />
            <s:textfield name="checkout" type="date" format="dd-MM-yyyy" label="Check out Date" />
            <s:textfield name="id" type="hidden" value="%{id}"/>
            <s:submit class="btn btn-success" value="Book"/>
        </s:form>
                                                </div></div></div></div>
    </body>
</html>
