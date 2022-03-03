<%-- 
    Document   : map
    Created on : 8 Oct, 2021, 4:37:46 PM
    Author     : abhishek-pt4287
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://unpkg.com/leaflet@1.7.1/dist/leaflet.css"
        integrity="sha512-xodZBNTC5n17Xt2atTPuE1HxjVMSvLVW9ocqUKLsCC5CXdbqCmblAshOMAS6/keqq/sMZMZ19scR4PsZChSR7A=="
        crossorigin=""/>
        <script src="https://unpkg.com/leaflet@1.7.1/dist/leaflet.js"
        integrity="sha512-XQoYMqMTK8LvdxXYG3nZ448hOEQiglfqkJs1NOQV44cWnUrBc8PkAOcXy20w0vlaXaVUearIOBhiXZ5V3ynxwA=="
        crossorigin=""></script>
        <title>MAP Page</title>
    </head>
    <body>
        <div class="row justify-content-md-center h-100">                        
				<div class="card-wrapper w-75">
                                            <br><br><br>
					<div class="card fat w-100">
						<div class="card-body w-100">
							<h2 class="card-title" style="text-align: center;">Our Hotels</h2>
        <div id="mapid" style="height: 500px;"></div>
                                                </div></div></div></div>
    </body>
        <script>
        var mymap = L.map('mapid').setView([51.505, -0.09], 2);
        L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token={accessToken}', {
    attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
    maxZoom: 18,
    id: 'mapbox/streets-v11',
    tileSize: 512,
    zoomOffset: -1,
    accessToken: 'pk.eyJ1IjoiYWJoaXNoZWtzaXZhMjgiLCJhIjoiY2t1aTllZmIzMWRvYjJwbnZ5NGo2N2xxeiJ9.o9L1oMs_iG1YfLoZ5W1k1w'
}).addTo(mymap);
        console.log("Hello");
         <s:iterator value="dataList">
             console.log("Hello1");
             var marker = L.marker([<s:property value="lat"/>,<s:property value="longi"/>]).addTo(mymap);
        marker.bindPopup("<b><s:property value="name"/></b><br><s:url action="getHotelBook" var="myurl"><s:param name="name" value="%{id}"/> </s:url><a href='<s:property value="#myurl"/>'>Book Rooms</a>");
                                                                                        
     </s:iterator>
 

    </script>
</html>
