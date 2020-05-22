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

<title>Code Quality Measure</title>

</head>
<body class="body">

	<!--Header section-->
	<section>
		<div class="header-container justify">
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

		<!-- Test
    
     -->
		<h1
			style="color: #FFFAFA; font-size: 64px; text-align: center; margin-top: -41px;">Size,Variable,Method</h1>

		<div style="text-align: center;">
			<a class="btn btn-primary" href="index.jsp" role="button">Size,Variable,Method</a>
			<a class="btn btn-primary" href="ControlStructure.jsp" role="button">Control
				Structures</a> <a class="btn btn-primary" href="Inheritance.jsp"
				role="button">Inheritance</a> <a class="btn btn-primary"
				href="FileUpload.jsp" role="button">Coupeling</a> <a
				class="btn btn-primary" href="AllFactors.jsp" role="button">All
				Factors</a>
		</div>
		<br>
		<br>

		<form action="AccessFileServlet" method="post" name="form">
			<div class="custom-file col-4">
				<input type="file" class="custom-file-input" id="input-file"
					name="code"> <label class="custom-file-label"
					for="customFile">Choose file</label>
			</div>
			<br> <br>
			<div class="form-group">
				<span class="help-block">If your file is zipped, </span> <a
					href="unzipFiles.jsp" style="text-decoration: none;">Click here</a>
			</div>

			<div class="form-group container-fluid"
				style="font-size: 25px; font-weight: normal;">
				<label for="complexity">Complexity Type:</label><br> <select
					class="custom-select select" name="type">

					<option value="1">By Size</option>
					<option value="2">By Variables</option>
					<option value="3">By Methods</option>
				</select>
			</div>

			<div class="display-code"
				style="font-size: 25px; font-weight: normal; width: 80%">
				<div class="container-fluid">
					<textarea class="form-control code-viewer" rows="11" id="code"
						name="demo" placeholder="Enter your code here"></textarea>
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

			<div class="container-fluid">
				<table class="table table-responsive-lg">
					<caption
						style="caption-side: top; text-align: center; font-size: x-large; color: #bab9b6;">Weights
						related to the size factor</caption>
					<thead class="table-dark">

						<tr>
							<th scope="col" style="text-align: center">Program Component</th>
							<th scope="col" style="text-align: center">Weight</th>
						</tr>
					</thead>
					<tbody>
						<tr class="table-secondary">
							<td class="d-flex justify-content-center">Keyword</td>
							<td><input class="form-control" type="number"
								name="inputKeywordWeight" value="1"></td>
						</tr>
						<tr class="table-secondary">
							<td class="d-flex justify-content-center">Identifier</td>
							<td><input class="form-control" type="number"
								name="inputIdentifiersWeight" value="1"></td>
						</tr>
						<tr class="table-secondary">
							<td class="d-flex justify-content-center">Operator</td>
							<td><input class="form-control" type="number"
								name="inputOperatorWeight" value="1"></td>
						</tr>
						<tr class="table-secondary">
							<td class="d-flex justify-content-center">Numeric Value</td>
							<td><input class="form-control" type="number"
								name="inputNumericsWeight" value="1"></td>
						</tr>
						<tr class="table-secondary">
							<td class="d-flex justify-content-center">Stirng Literal</td>
							<td><input class="form-control" type="number"
								name="inputStringsWeight" value="1"></td>
						</tr>
					</tbody>
				</table>
			</div>


			<div class="container-fluid">
				<table class="table table-responsive-lg">
					<caption
						style="caption-side: top; text-align: center; font-size: x-large; color: #bab9b6;">Weights
						related to the variable factor</caption>
					<thead class="table-dark">
						<tr>
							<th scope="col" style="text-align: center">Program Component</th>
							<th scope="col" style="text-align: center">Weight</th>
						</tr>
					</thead>
					<tbody>
						<tr class="table-secondary">
							<td class="d-flex justify-content-center">Global Variable</td>
							<td><input class="form-control" type="number"
								name="inputGlobalWeight" id="inputGlobalWeight" value="2"></td>
						</tr>
						<tr class="table-secondary">
							<td class="d-flex justify-content-center">Local Variable</td>
							<td><input class="form-control" type="number"
								name="inputLocalWeight" id="inputLocalWeight" value="1"></td>
						</tr>
						<tr class="table-secondary">
							<td class="d-flex justify-content-center">Primitive Data
								Type Variable</td>
							<td><input class="form-control" type="number"
								name="inputPrimitiveVariableWeight"
								id="inputPrimitiveVariableWeight" value="1"></td>
						</tr>
						<tr class="table-secondary">
							<td class="d-flex justify-content-center">Composite Data
								Type Variable</td>
							<td><input class="form-control" type="number"
								name="inputCompositeVariableWeight"
								id="inputCompositeVariableWeight" value="2"></td>
						</tr>
					</tbody>
				</table>
			</div>


			<div class="container-fluid">
				<table class="table table-responsive-lg">
					<caption
						style="caption-side: top; text-align: center; font-size: x-large; color: #bab9b6;">Weights
						related to the method factor</caption>
					<thead class="table-dark">
						<tr>
							<th scope="col" style="text-align: center">Program Component</th>
							<th scope="col" style="text-align: center">Weight</th>
						</tr>
					</thead>
					<tbody>
						<tr class="table-secondary">
							<td class="d-flex justify-content-center">Method with a
								primitive return type</td>
							<td><input class="form-control" type="number"
								name="inputPrimitiveReturnWeight"
								id="inputPrimitiveReturnWeight" value="1"></td>
						</tr>
						<tr class="table-secondary">
							<td class="d-flex justify-content-center">Method with a
								composite return type</td>
							<td><input class="form-control" type="number"
								name="inputCompositeReturnWeight"
								id="inputCompositeReturnWeight" value="2"></td>
						</tr>
						<tr class="table-secondary">
							<td class="d-flex justify-content-center">Method with a void
								return type</td>
							<td><input class="form-control" type="number"
								name="inputVoidReturnWeight" id="inputVoidReturnWeight"
								value="0"></td>
						</tr>
						<tr class="table-secondary">
							<td class="d-flex justify-content-center">Primitive data
								type parameter</td>
							<td><input class="form-control" type="number"
								name="inputPrimitiveParaWeight" id="inputPrimitiveParaWeight"
								value="1"></td>
						</tr>
						<tr class="table-secondary">
							<td class="d-flex justify-content-center">Composite data
								type parameter</td>
							<td><input class="form-control" type="number"
								name="inputCompositeParaWeight" id="inputCompositeParaWeight"
								value="2"></td>
						</tr>
					</tbody>
				</table>
			</div>
		</form>
		<!--Results viewer-->
		<br> <br>
	</div>
	<!--Footer-->
	<div>
		<footer class="page-footer">
			<img class="footer-image" src="Images/footer-image-crop.png">
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