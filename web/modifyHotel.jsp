<%-- 
    Document   : modifyHotel
    Created on : 5 Oct, 2021, 3:01:05 PM
    Author     : abhishek-pt4287
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modify Hotel</title>
        <link rel="stylesheet" href="error.css"/>
    </head>
    <body>
        <div class="row justify-content-md-center h-100">                        
				<div class="card-wrapper">
                                            <br><br><br>
					<div class="card fat">
						<div class="card-body">
							<h4 class="card-title" style="text-align: center;">Modify Hotel</h4>
        <s:form action="modifyHotel?id=%{id}" method="POST" enctype="multipart/form-data">
            <s:textfield name="Name" label="Hotel Name"/>
        <s:combobox label="State" name="state" headerKey="-1" headerValue="--Select State--" list="#{'Karnataka':'Karnataka','Tamilnadu':'Tamilnadu','3':'Kerala','Andhra Pradesh':'Andhra Pradesh','Maharashtra':'Maharashtra'}"/>
        <s:textarea label="Address" name="Address"/>
        <s:textfield label="Pincode" name="pincode"/>
        <s:textfield label="Latitude" name="lat"/>
        <s:textfield label="Longitude" name="longi"/>
        <s:textfield label="Phone" name="phone"/>
        <s:file name="photo" label="Photo"/>
        <s:submit value="Modify Hotel" class="btn btn-success"/>   
        </s:form>
                 </div>
					</div>
				</div>
                            
			</div>
    </body>
</html>
