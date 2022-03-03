<%-- 
    Document   : addhotel
    Created on : 4 Oct, 2021, 6:08:19 AM
    Author     : abhishek-pt4287
--%>
<jsp:include page="adminNav.jsp"></jsp:include>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Add Hotel</title>
        <link rel="stylesheet" href="error.css"/>
    </head>
    <body>
			<div class="row justify-content-md-center h-100">                        
				<div class="card-wrapper">
                                            <br><br><br>
					<div class="card fat">
						<div class="card-body">
							<h4 class="card-title" style="text-align: center;">Add Hotel</h4>
        <s:form action="addhotel" method="post" enctype="multipart/form-data">
            <s:textfield name="hotelName" id="name" label="Hotel Name"/>
        <s:combobox label="State" id="state" name="state" headerKey="-1" headerValue="--Select State--" list="#{'Karnataka':'Karnataka','Tamilnadu':'Tamilnadu','Kerala':'Kerala','Andhra Pradesh':'Andhra Pradesh','Maharashtra':'Maharashtra'}"/>
        <s:textarea label="Address" id="address" name="Address"/>
        <s:textfield label="Pincode" id="pincode" name="pincode"/>
        <s:textfield label="Latitude" id="lat" name="lat"/>
        <s:textfield label="Longitude" id="longi" name="longi"/>
        <s:textfield label="Phone" id="phone" name="phone"/>
        <s:file name="photo" id="photo" label="Photo"/>
        <s:submit class="btn btn-primary" onclick="validate()" value="Add Hotel"/>   
        </s:form>
                                                        						</div>
					</div>
				</div>
                            
			</div>
               	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script>
    function validate(){        
    var name=document.getElementById("name");
            var state=document.getElementById("state");
            var address=document.getElementById("address");
            var pincode=document.getElementById("pincode");
            var lat=document.getElementById("lat");
            var longi=document.getElementById("longi");
            var phone=document.getElementById("phone");
            var photo=document.getElementById("photo");
            if(name==null){
                alert("Enter Name");
                cancel submit;
            }
            else if(state==null){
                alert("Enter State");
                cancel submit;
            }
        }
        </script>
    </body>
</html>
