<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="utils.*"%>
<%@page import="java.util.ArrayList"%>
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

<title>Insert title here</title>

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
.active {
	background-color: #f2f5f4;
}
</style>
</head>
<body>
	<ul>
		<li><a href="index.jsp">Home</a></li>

	</ul>

	<div class="container" style="overflow: auto; min-height: 500px">

		<div align="center">


			<h1 class="display-1"
				style="text-align: center; font-size: 50px; margin-top: 10px">
				<font color="#00376c">Complexity of Variables</font>
			</h1>
			<br>

		</div>
		<div>
			<!-- 
		<div class="form-group" style="font-size: 20px; font-weight: normal;">
				<label for="complexity">Change weight:</label> <select
					class="custom-select" name="weightOfVariables">
					<option value="1">Weight of Wvs</option>
					<option value="2">Weight of Wpdtv</option>
					<option value="3">Weight of Wcdtv</option>
				</select>

				<div class="input-group input-group-sm mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text" id="inputGroup-sizing-sm">Weight</span>
					</div>
					<input type="text" name="weightVariables" id="weightVariables"  class="form-control" aria-label="Small"
						aria-describedby="inputGroup-sizing-sm">
				</div>
				<div class="col text-right">
					<button class="btn btn-dark" type="submit" name="sumbitButton"
						id="sumbitButton">Submit</button>
				</div>
			</div>
		 -->
			<form action="CustomWeightsServlet" method="post" class="form-group">
				<table class="table table-responsive-lg">
					<caption
						style="caption-side: top; text-align: center; font-size: x-large;">Weights
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
				<div class="col text-right">
					<input type="hidden" name="hiddenValue" value="variable">
					<button class="btn btn-dark" type="submit" name="sumbitButton"
						id="sumbitButton">Save</button>
				</div>
			</form>

		</div>

		<table class="table" style="font-family: century gothic"
			cellpadding="20px" cellspacing="20px" align="center" border="2">
			<thead>
				<tr>
					<th style="font =weight: bold;">Line Number</th>
					<th style="font =weight: bold;">Statement</th>
					<th style="font =weight: bold;">Wvs</th>
					<th style="font =weight: bold;">Wpdtv</th>
					<th style="font =weight: bold;">Wcdtv</th>
					<th style="font =weight: bold;">Cv</th>
				</tr>
			</thead>


			<%
				int x = 1;

				String[] codeLines = (String[]) session.getAttribute("lines");
				ArrayList<StatementLine> StatementListWvs = (ArrayList<StatementLine>) session.getAttribute("Wvs");
				ArrayList<StatementLine> StatementListWpdtv = (ArrayList<StatementLine>) session.getAttribute("Wpdtv");
				ArrayList<StatementLine> StatementListWcdtv = (ArrayList<StatementLine>) session.getAttribute("Wcdtv");

				while (x <= codeLines.length) {
					StatementLine Wvs = StatementListWvs.get(x - 1);
					StatementLine Wpdtv = StatementListWpdtv.get(x - 1);
					StatementLine Wcdtv = StatementListWcdtv.get(x - 1);
			%>

			<tr>
				<td><%=x%></td>
				<td><%=codeLines[x - 1].replace(" ", "&nbsp;")%></td>
				<td><%=Wvs.getComplexity()%></td>
				<td><%=Wpdtv.getComplexity()%></td>
				<td><%=Wcdtv.getComplexity()%></td>
				<td><%=Wvs.getComplexity() + Wpdtv.getComplexity() + Wcdtv.getComplexity()%></td>
			</tr>

			<%
				x++;
				}
			%>
		</table>
	</div>
</body>
</html>