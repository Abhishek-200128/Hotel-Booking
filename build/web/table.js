var mysql= require('mysql');

var con=mysql.createConnection({
    host: "localhost",
    user: "root",
    password: "abhizoho16",
    database: "hotel_mgmt"
});

con.connect(function(err){
    if(err) throw err;
    con.query("Select * from hotel;",function(err,result,fields){
        if(err) throw err;
        for(i=0;i<result.length;i++){
        $('#hotels').append('<tr><td>'+result[i]['Name']+'</td><td>'+result[i]['State']+'</td><td>'+result[i]['Address']+'</td><td>'+result[i]['Pincode']+'</td><td>'+result[i]['Latitude']+'</td><td>'+result[i]['Longitude']+'</td><tr>');
        }
        console.log(result.length);
    });
    
});