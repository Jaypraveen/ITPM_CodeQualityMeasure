<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.service.*"%>
<%@page import="com.model.*"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Code Quality Measure</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
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
table, td, th {
	border: 1px solid black;
}

table {
	border-collapse: collapse;
	width: 100%;
}

th {
	height: 50px;
}

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
</style>

</head>
<body>

	<ul>
		<li><a href="index.jsp">Home</a></li>
	</ul>

	<br>
	<br>

	<div align="center">

		<h1 class="display-1"
			style="padding-left: -79px; margin-left: 100px; font-family: century gothic; font-size: 50px; margin-top: 10px">
			<font color="#00376c">Complexity of Coupling</font>
		</h1>
	</div>

	<br>
	<br>

	<center>
		<table style="width: 78%; margin-left: 0px; background-color: #fff;"
			class="table table-bordered">
			<tr>
			<thead>
				<th>Line no</th>
				<th>Program statements</th>
				<th>Nr</th>
				<th>Nmcms</th>
				<th>Nmcmd</th>
				<th>Nmcrms</th>
				<th>Nmcrmd</th>
				<th>Nrmcrms</th>
				<th>Nrmcrmd</th>
				<th>Nrmcms</th>
				<th>Nrmcmd</th>
				<th>Nmrgvs</th>
				<th>Nmrgvd</th>
				<th>Nrmrgvs</th>
				<th>Nrmrgvd</th>
				<th>Ccp</th>
				</tr>
			</thead>
			<tbody>
				<%
					Coupling_service test5 = new Coupling_service();
					ArrayList<Coupling> arrayList5 = test5.coupling(session.getAttribute("test_code").toString());

					for (Coupling coupling : arrayList5) {

						int Nr = coupling.getRecursive() * Integer.parseInt(session.getAttribute("recursive").toString());

						int Nmcms = coupling.getRegular_regular()
								* Integer.parseInt(session.getAttribute("regularRegular").toString());

						int Nmcrms = coupling.getRegular_recursive()
								* Integer.parseInt(session.getAttribute("regularRecursive").toString());

						int Nrmcrms = coupling.getRecursive_recursive()
								* Integer.parseInt(session.getAttribute("recursiveRecursive").toString());

						int Nrmcms = coupling.getRecursive_regular()
								* Integer.parseInt(session.getAttribute("recursiveRegular").toString());

						int total = Nr + Nmcms + Nmcrms + Nrmcrms + Nrmcms
								+ (coupling.getRegular_global()
										* Integer.parseInt(session.getAttribute("regularGlobal").toString()))
								+ (coupling.getRegular_regular()
										* Integer.parseInt(session.getAttribute("recursiveGlobal").toString()));
				%>
				<tr>
					<td><%=coupling.getLineNumber()%></td>
					<td><%=coupling.getLine()%></td>
					<td><%=coupling.getRecursive()%></td>
					<td><%=coupling.getRegular_regular()%></td>
					<td>0</td>
					<td><%=coupling.getRegular_recursive()%></td>
					<td>0</td>
					<td><%=coupling.getRecursive_recursive()%></td>
					<td>0</td>
					<td><%=coupling.getRecursive_regular()%></td>
					<td>0</td>
					<td><%=coupling.getRegular_global()%></td>
					<td>0</td>
					<td><%=coupling.getRegular_regular()%></td>
					<td>0</td>
					<td><%=total%></td>
				</tr>
				<%
					}
				%>

			</tbody>
		</table>
	</center>
</body>
</html>