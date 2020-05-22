<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<title>Code Quality Measure</title>



<style>


@
keyframes bounce-animation { 16.65% {
	-webkit-transform: translateY(8px);
	transform: translateY(8px);
}

33
.3 % {
	-webkit-transform: translateY(-6px);
	transform: translateY(-6px);
}

49
.95 % {
	-webkit-transform: translateY(4px);
	transform: translateY(4px);
}

66
.6 % {
	-webkit-transform: translateY(-2px);
	transform: translateY(-2px);
}

83
.25 % {
	-webkit-transform: translateY(1px);
	transform: translateY(1px);
}

100%
{
-webkit-transform
:
 
translateY
(0);

    
transform
:
 
translateY
(0);

  
}
}
.bounce {
	animation-name: bounce-animation;
	animation-duration: 2s;
}

.hideDiv {
	display: none;
}

.displayDiv {
	display: block;
}

/*everything below here is just setting up the page, so dont worry about it */

	
	.page-title {
		opacity: .75 !important;
	}
	table1, td, th {
		border: 1px solid black;
	}
	table1 {
		border-collapse: collapse;
		width: 100%;
	}
	th {
		text-align: left;
	}
	h2 {
		text-align: center;
		font-size: 41px;
		text-transfrm: uppercase;
		color: #000000;
		font-weight: bold;
	}
	h5 {
		text-align: center;
		font-size: 20px;
		text-transfrm: uppercase;
		color: black;
	}

ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #00376c;
	font-family: century gothic;
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

li a:hover:not (.active ) {
	background-color: #ffd700;
}

.active {
	background-color: #ffd700;
}
</style>
<script>
$(function(){
  var str = '#len'; //increment by 1 up to 1-nelemnts
  $(document).ready(function(){
    var i, stop;
    i = 1;
    stop = 4; //num elements
    setInterval(function(){
      if (i > stop){
        return;
      }
      $('#len'+(i++)).toggleClass('bounce');
    }, 500)
  });
});
</script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

</head>


<body style="background-color:#423F3F;">
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

<h1 style="color:#FFFAFA; font-size:64px; text-align: center; ">Coupling</h1>
	<!-- Page Navigation Buttons  -->
	
	<div style="text-align: center; margin-top: 26px;">
		<a class="btn btn-primary" href="index.jsp" role="button"style="">Size,Variable,Method</a>
	    <a class="btn btn-primary" href="ControlStructure.jsp" role="button">Control Structures</a>
	    <a class="btn btn-primary" href="Inheritance.jsp" role="button">Inheritance</a>
	    <a class="btn btn-primary" href="aFileUpload.jsp" role="button">Coupling</a>
	    <a class="btn btn-primary" href="AllFactors.jsp" role="button">All Factors</a>
   </div><br>
	<!--nav>
   
 
  </nav-->

	<div  class="form-group mt-3" style="color: white; margin-left: 472px;">
		<h1 style="font-size:25x;">UPLOAD YOUR FILE:</h1>
		<input type="file" name="FileUpload">
	</div>
	

	<form method="POST" action="file_servlte">

		<br>

		
		<div align=center class="form-group mt-3">

			<textarea rows="5" cols="80" name="code" required></textarea>
		</div>
		

		<select id="selectOption" name="selectFactor" onchange="setDiv()"
			required>
			<option value="">~Select~</option>
			<option value="coupling">Coupling</option>
		</select>

		




		<div class="hideDiv" style="margin: auto; width: 600px"
			id="couplingFactor">
			<br>
			<h5 align="center">
				<b>Weight To Coupling
			</h5>
			
				<table class="table1">
					<thead class="thead-light">
						<tr>
							<th>Coupling Type</th>
							<th>Weight</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>A recursive call</td>
							<td><select class="form-control" name="recursive">
									<option value="0">0</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
							</select></td>
						</tr>
						<tr>
							<td>A regular method calling another regular method in the
								same file</td>
							<td><select class="form-control" name="regularRegular">
									<option value="0">0</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
							</select></td>
						</tr>
						<tr>
							<td>A regular method calling another regular method in a
								different file</td>
							<td><select class="form-control">
									<option value="0">0</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
							</select></td>
						</tr>
						<tr>
							<td>A regular method calling a recursive method in the same
								file</td>
							<td><select class="form-control" name="regularRecursive">
									<option value="0">0</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
							</select></td>
						</tr>
						<tr>
							<td>A regular method calling a recursive method in a
								different file</td>
							<td><select class="form-control">
									<option value="0">0</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
							</select></td>
						</tr>
						<tr>
							<td>A recursive method calling another recursive method in
								the same file</td>
							<td><select class="form-control" name="recursiveRecursive">
									<option value="0">0</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
							</select></td>
						</tr>
						<tr>
							<td>A recursive method calling another recursive method in a
								different file</td>
							<td><select class="form-control">
									<option value="0">0</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
							</select></td>
						</tr>
						<tr>
							<td>A recursive method calling a regular method in the same
								file</td>
							<td><select class="form-control" name="recursiveRegular">
									<option value="0">0</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
							</select></td>
						</tr>
						<tr>
							<td>A recursive method calling a regular method in a
								different file</td>
							<td><select class="form-control">
									<option value="0">0</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
							</select></td>
						</tr>
						<tr>
							<td>A regular method referencing a global variable in the
								same file</td>
							<td><select class="form-control" name="regularGlobal">
									<option value="0">0</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
							</select></td>
						</tr>
						<tr>
							<td>A regular method referencing a global variable in a
								different file</td>
							<td><select class="form-control">
									<option value="0">0</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
							</select></td>
						</tr>
						<tr>
							<td>A recursive method referencing a global variable in the
								same file</td>
							<td><select class="form-control" name="recursiveGlobal">
									<option value="0">0</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
							</select></td>
						</tr>
						<tr>
							<td>A recursive method referencing a global variable in a
								different file</td>
							<td><select class="form-control">
									<option value="0">0</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
							</select></td>
						</tr>
					</tbody>
				</table>
			
		</div>


		<button type="submit" class="" value="Save">Save</button>

	</form>



	<!--Footer-->
	<div class="footer-container">
		<!--Footer image-->
		<img class="footer-image" src="Images/footer-image-crop.png" alt="">
	</div>

	</div>

	<!-- Javascript -->
	<script type="text/javascript" src="JS/jqueryComp.js"></script>
	<script type="text/javascript"
		src="Plugins/codemirror/lib/codemirror.js"></script>
	<script type="text/javascript" src="JS/default.js"></script>

	<script type="text/javascript" src="JS/behave.js"></script>
	<script type="text/javascript" src="JS/script.js"></script>
	<script>
		var folder = document.getElementById("myInput");
		folder.onchange = function() {
			var files = folder.files, len = files.length, i;
			for (i = 0; i < len; i += 1) {
				console.log(files[i]);
			}
		}
	</script>
</body>
</html>
<script>

	function setDiv(){
		var div = document.getElementById('selectOption').value;
		
		
		if(div=="coupling"){
			hideAll();
			document.getElementById('couplingFactor').classList.add("displayDiv");
		}else if(div=="all"){
			hideAll();
		}else{
			hideAll();
		}
	}
	
	function hideAll(){
		
		document.getElementById('couplingFactor').classList.remove("displayDiv");
		
		
		document.getElementById('couplingFactor').classList.add("hideDiv");
		
	}
	
	

</script>