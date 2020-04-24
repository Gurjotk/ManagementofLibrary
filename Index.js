var express = require('express');
var mysql = require('mysql');
var bodyparser = require('body-parser');

var con = mysql.createConnection({
	host : 'localhost',
	user : 'root',
	password : 'Helloworld19*', 
	database : 'library'
});

// initialise express
var app = express();
app.use(bodyparser.json());
app.use(bodyparser.urlencoded({extended:true}));





app.post('/register/',(req,res,next)=>{
	var data = req.body;
	var name = data.name;
	var pass = data.pass;
	var email = data.email;


	con.query( 'SELECT * FROM  User where email=?' ,[email], function(err,result,fields){
			con.on('error',(err)=>{
				console.log('[MySQL ERROR]',err);
			});

			if(result && result.length){
				res.json('User exists !!!');
			}else{
				//con.query("INSERT INTO 'user'('id', 'email', 'password') VALUES (?,?,?)", [uid,email,password],function(err,result,fields){
				var sql = "INSERT INTO User (name, email, pass) VALUES (?,?,?)";
				var values = [name,email,pass];

				console.log(sql,values)

				con.query(sql, values ,function(err,result,fields){
					con.on('error',(err)=>{
						console.log('[MySQL ERROR]',err)
					});
					res.json('Register Successful')
					console.log('registered')
				});
			}
		});
});

app.post('/login/',(req,res,next)=>{
	var data = req.body;
	var pass = data.pass;
	var email = data.email;
    console.log("here");

	con.query('SELECT * FROM User where email = ?',[email],function(err,result,fields){
		con.on('error',(err)=>{
			console.log('[MySQL ERROR]',err);
		});
		
		if(result && result.length){


			// result = [ RowDataPacket { id: 1, email: 'abc@abc.com', pass: 'pass' } ]

			if(pass == result[0].pass){
				res.json('Valid user');	
			}else{
				res.json('Invalid user');
			}
		}
	});


});

// start node server
app.listen(3000,() => {
	console.log('server running on : http://localhost:%s',3000);
});