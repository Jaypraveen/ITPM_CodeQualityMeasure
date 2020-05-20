<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.servlet.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

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


<link rel="stylesheet" type="text/css" href="CSS/main.css">
<link rel="stylesheet" href="CSS/style.css" />
<!--background: linear-gradient(45deg, #8614ce, #ff0057);-->
<title>Insert title here</title>

</head>
<body class="body">

	<!--Header section-->
	<section>
		<div class="header-container">
			<header>
				<!--Header image-->
				<img class="header-image" src="Images/header-image-crop.png" alt="">
				<!--Heading-->
				<h1 class="heading" style="text-align: center;">Code Quality
					Measure</h1>
			</header>

		</div>
	</section>

	<!--Main body part-->
	<div class="container-fluid main" style="text-align: center;">

		<!--Description-->
		<!--Button: browse
            <input type="file" id="browse-button" accept="java, c++" onchange="readURL(this);" >
    <label for="browse-button" id="labelFile" style="margin-top: 322px;">
    Choose file
    </label>-->

		<!-- 
    
     -->

		<form action="AccessFileServlet" method="post" name="form">


			<div class="custom-file col-4">
				<input type="file" class="custom-file-input" id="input-file"
					name="code"> <label class="custom-file-label"
					for="customFile">Choose file</label>
			</div>
			<br> <br>
			<div class="form-group">
				<span class="help-block">If your file is zipped, Click here</span> <a
					href="unzipFiles.jsp"><button class="btn btn-secondary"
						type="button" title="Use this if you have a zipped file">
						Unzip File</button></a>
			</div>

			<div style="text-align: center;">

				<a class="btn btn-light" href="index.jsp" role="button">Size,Variable,Method</a>

				<a class="btn btn-light" href="Action-file-ControlStructure.jsp"
					role="button">Control Structures</a> <a class="btn btn-light"
					href="action_file_Inheritance.jsp" role="button">Inheritance</a> <a
					class="btn btn-light" href="action_file_Coupeling.jsp"
					role="button">Coupeling</a> <a class="btn btn-light"
					href="action_file_allfactors.jsp" role="button">All Factors</a>
			</div>

			<div class="form-group container-fluid"
				style="font-size: 20px; font-weight: normal;">
				<label for="complexity">Complexity Type:</label> <select
					class="custom-select" name="type">

					<option value="1">By Size</option>
					<option value="2">By Variables</option>
					<option value="3">By Methods</option>
				</select>
			</div>

			<div class="display-code"
				style="font-size: 25px; font-weight: normal;">
				<div class="container-fluid">
					<textarea class="form-control" rows="11" id="code" name="demo"></textarea>
				</div>
			</div>

			<!--Control buttons-->
			<div class="control-buttons">
				<!--Button: enter-->
				<button type="submit" class="btn calculate-button"
					name="calculateButton">Calculate</button>

				<!--Button: clean-->
				<button class="btn clear-button" type="reset">Clean</button>
			</div>
		</form>
		<!--Results viewer-->

		<br> <br>

	</div>

	<!--Footer-->
	<div>
	<footer class="page-footer">
		<img class="footer-image" src="Images/footer-image-crop.png" >
	</footer>
	</div>
	

	<!-- Javascript -->
	<script type="text/javascript" src="JS/jqueryComp.js"></script>
	<script type="text/javascript"
		src="Plugins/codemirror/lib/codemirror.js"></script>
	<script type="text/javascript" src="JS/default.js"></script>

	<script type="text/javascript" src="JS/behave.js"></script>
	<script type="text/javascript" src="JS/script.js"></script>

	<script data-require="angularjs@1.3.6" data-semver="1.3.6"
		src="//cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.6/angular.min.js"></script>


</body>
</html>