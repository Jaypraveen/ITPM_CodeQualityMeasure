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
				<font color="#00376c">Complexity of Methods</font>
			</h1>
			<br>

		</div>
		<!-- 
		<div>
			<form action="CustomWeightsServlet" method="post" class="form-group">
				<table class="table table-responsive-lg">
					<caption
						style="caption-side: top; text-align: center; font-size: x-large;">Weights
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
				<div class="col text-right">
					<input type="hidden" name="hiddenValue" value="method">
					<button class="btn btn-dark" type="submit" name="sumbitButton"
						id="sumbitButton">Save</button>
				</div>
			</form>
		</div>
		 -->
		
		<table class="table" style="font-family: century gothic"
			cellpadding="20px" cellspacing="20px" align="center" border="2">
			<thead>
				<tr>
					<th style="font =weight: bold;">Line Number</th>
					<th style="font =weight: bold;">Statement</th>
					<th style="font =weight: bold;">Wmrt</th>
					<th style="font =weight: bold;">Wpdtp</th>
					<th style="font =weight: bold;">Wcdtp</th>
					<th style="font =weight: bold;">Cm</th>
				</tr>
			</thead>


			<%
				int x = 1;

				String[] codeLines = (String[]) session.getAttribute("lines");
				ArrayList<StatementLine> StatementListWmrt = (ArrayList<StatementLine>) session.getAttribute("Wmrt");
				ArrayList<StatementLine> StatementListWpdtp = (ArrayList<StatementLine>) session.getAttribute("Wpdtp");
				ArrayList<StatementLine> StatementListWcdtp = (ArrayList<StatementLine>) session.getAttribute("Wcdtp");

				while (x <= codeLines.length) {
					StatementLine Wmrt = StatementListWmrt.get(x - 1);
					StatementLine Wpdtp = StatementListWpdtp.get(x - 1);
					StatementLine Wcdtp = StatementListWcdtp.get(x - 1);
			%>

			<tr>
				<td><%=x%></td>
				<td><%=codeLines[x - 1].replace(" ", "&nbsp;")%></td>
				<td><%=Wmrt.getComplexity()%></td>
				<td><%=Wpdtp.getComplexity()%></td>
				<td><%=Wcdtp.getComplexity()%></td>
				<td><%=Wmrt.getComplexity() + Wpdtp.getComplexity() + Wcdtp.getComplexity()%></td>
			</tr>

			<%
				x++;
				}
			%>
		</table>
	</div>
	<br>
	<div class="fixed-bottom" style="height: 20px; background-color: #2c2e2d;">
	
	</div>
</body>
</html>