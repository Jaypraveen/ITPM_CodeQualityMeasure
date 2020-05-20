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
<link rel="stylesheet" type="text/css"
	href="Plugins/codemirror/lib/codemirror.css">
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
				<h1 class="heading">Code Quality Measure</h1>
			</header>

		</div>
	</section>

	<!--Main body part-->
	<div class="container-fluid main">

		<!--Description-->
		<!--Button: browse
            <input type="file" id="browse-button" accept="java, c++" onchange="readURL(this);" >
    <label for="browse-button" id="labelFile" style="margin-top: 322px;">
    Choose file
    </label>-->
    
    <!-- 
    
     -->
     <div style="margin-left: 436px; margin-top: 26px;">
		<a class="btn btn-primary" href="index.jsp" role="button">Size,Variable,Method</a>
	    <a class="btn btn-primary" href="Action-file-ControlStructure.jsp" role="button">Control Structures</a>
	    <a class="btn btn-primary" href="action_file_Inheritance.jsp" role="button">Inheritance</a>
	    <a class="btn btn-primary" href="action_file_Coupeling.jsp" role="button">Coupeling</a>
	    <a class="btn btn-primary" href="action_file_allfactors.jsp" role="button">All Factors</a>
   </div><br><br>
     
     
     
		<form action="AccessFileServlet" method="post" name="form">

			<div class=browse>
				<label for="input-file">Choose a file:</label><br> <input
					class="btn " type="file" id="input-file" name="code">
					<a  href="unzipFiles.jsp"><button class="btn btn-secondary" type="button" title="You this if you have a zipped file"> Unzip File</button></a>
			</div>
			<!-- 
			<div class="topic d-flex justify-content-center mx-auto">
				<p class="display-4 font-weight-bold" style="display: none"
					id="topicSize">Size</p>
				<p class="display-4 font-weight-bold" style="display: none"
					id="topicVariable">Variable</p>
				<p class="display-4 font-weight-bold" style="display: none"
					id="topicMethod">Method</p>
				<p class="display-4 font-weight-bold" style="display: none"
					id="topicInheritance">Inheritance</p>
				<p class="display-4 font-weight-bold" style="display: none"
					id="topicCoupling">Coupling</p>
				<p class="display-4 font-weight-bold" style="display: none"
					id="topicControlStr">Control Structure</p>
			</div>
			 -->
			

			<!--Selection check boxes-->
			<!-- 
			<div class="btn-block checkboxes" data-toggle="checkboxs">
				<label class="btn btn-default lable"> <input type="checkbox"
					name="selection" id="size" onchange="selectTopicFunction()"
					onchange="checkDisable(this)">Size
				</label>
				<label class="btn btn-default lable"> <input type="checkbox"
					name="selection" id="variables" onchange="selectTopicFunction()"
					onchange="checkDisable(this)">variables
				</label>
				<label class="btn btn-default lable"> <input type="checkbox"
					name="selection" id="method" onchange="selectTopicFunction()"
					onchange="checkDisable(this)">method
				</label>
				<label class="btn btn-default lable"> <input type="checkbox"
					name="selection" id="inheritance" onchange="selectTopicFunction()"
					onchange="checkDisable(this)">Inheritance
				</label>
				<label class="btn btn-default lable"> <input type="checkbox"
					name="selection" id="coupling" onchange="selectTopicFunction()"
					onchange="checkDisable(this)">Coupling
				</label>
				<label class="btn btn-default lable"> <input type="checkbox"
					name="selection" id="control-structures"
					onchange="selectTopicFunction()" onchange="checkDisable(this)">Control
					structures
				</label>
			</div>
			 -->
			

			<div class="form-group" style="font-size: 20px; font-weight: normal;">
				<label for="complexity">Complexity Type:</label> 
				<select class="custom-select" name ="type">

					<option value="1">By Size</option>
					<option value="2">By Variables</option>
					<option value="3">By Methods</option>
					<option value="4">By Control Structure</option>
					<option value="5">By Inheritance</option>
					<option value="6">By Coupling</option>
				</select>
			</div>

			<div class="display-code">
				<div class="container">
					<textarea id="code" name="demo"></textarea>
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


	</div>

	<!--Footer-->
	<div class="footer-container">
		<!--Footer image-->
		<img class="footer-image" src="Images/footer-image-crop.png" alt="">

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