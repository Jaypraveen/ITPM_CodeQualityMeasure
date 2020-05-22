<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>

<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #2c2e2d;
	font-size: 25px;
}

li {
	float: left;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li


a


:hover


:not

 

(
.active

 

)
{
background-color


:

 

#f2f5f4


;
}
<
sty <style>ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #2c2e2d;
	font-size: 25px;
}

li {
	float: left;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li


a:hover:not (.active ) {
	background-color: #f2f5f4;
}
</style>
<title>Code Quality Measure</title>
</head>
<body>
<div>
<ul>
		<li><a href="index.jsp" style="text-decoration: none;">Home</a></li>

	</ul>
</div>
	<br>
	
		<div style="text-align: center;">
		<h1>Unzip Files</h1>
		</div>
	
	<br>
	<br>
	<div class="container-fluid" style="text-align: center; margin-top: 10%">
		<form action="UnzipFileServlet" method="post">
			<div class="custom-file col-4">
				<input type="file" class="custom-file-input " id="unzip" name="unzip">
				<label class="custom-file-label" for="customFile">Choose
					file</label> <br> <br>
				<button class="btn btn-dark" name="unzipButton" id="unzipButton">Unzip</button>
			</div>
		</form>
	</div>
	<div class="fixed-bottom" style="height: 20px; background-color: #2c2e2d;">
	
	</div>
</body>
</html>