
<%@page import="java.nio.file.Paths"%>
<%@page import="java.nio.file.Path"%>
<%@page import="java.util.stream.Collectors"%>
<%@page import="java.util.stream.Collector"%>
<%@page import="com.model.MainMethod"%>
<%@page import="java.util.regex.Pattern"%>
<%@page import="java.util.regex.Matcher"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*,javax.servlet.*"%>
<%@ page import="javax.servlet.http.*"%>
<%@ page import="org.apache.commons.fileupload.*"%>
<%@ page import="org.apache.commons.fileupload.disk.*"%>
<%@ page import="org.apache.commons.fileupload.servlet.*"%>
<%@ page import="org.apache.commons.io.output.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Code Complexity Tool</title>
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
a:hover:not (.active ) {
	background-color: #f2f5f4;
}
</style>

</head>


<body>
	<ul>
		<li><a href="index.jsp">Home</a></li>
	</ul>
<br>
	<div>
	<%
		String currentClassName = "";
		File file = null;
		int maxFileSize = 5000 * 1004;
		int maxMemSize = 5000 * 1004;

		String filePath = "D:/";

		Path root = Paths.get(".").normalize().toAbsolutePath();
		String path = root.toAbsolutePath().toString();

		List<File> fileList = new ArrayList();

		String contentType = request.getContentType();
		if ((contentType.indexOf("multipart/form-data") >= 0)) {

			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(maxMemSize);
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setSizeMax(maxFileSize);
			try {
				List fileItems = upload.parseRequest(request);
				Iterator i = fileItems.iterator();
					while (i.hasNext()) {
					FileItem fi = (FileItem) i.next();
					if (!fi.isFormField()) {
						String fieldName = fi.getFieldName();
						String fileName = fi.getName();

						boolean isInMemory = fi.isInMemory();
						long sizeInBytes = fi.getSize();
						file = new File(filePath + fileName.substring(fileName.indexOf("\\") + 1));
						fi.write(file);
						fileList.add(file);
					}
				}

					
					
				//filter files for .java
				fileList = fileList.stream().filter(e -> e.getName().endsWith(".java")).collect(Collectors.toList());

				//Get all methods and store them
				//Get all VAr and store them
				Map<String, String> allGlobalVar = new LinkedHashMap();
				Map<String, MainMethod> allFileMethods = new HashMap();

				for (File nowfile : fileList) {
					List<String> allProgrammeList = new ArrayList();

					try (BufferedReader br = new BufferedReader(new FileReader(nowfile))) {

						String line;
						int no = 1;

						while ((line = br.readLine()) != null) {
							//Add to list for no and codeline
							if (!line.trim().equals("")) {

								allProgrammeList.add(no + "#" + line);
								no++;
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}

					String regexString = "";

					for (int x = 0; x < allProgrammeList.size(); x++)
						regexString += allProgrammeList.get(x) + "\n";

					String className = "";

					Matcher classF = Pattern.compile("class (.*)( )*\\{").matcher(regexString);
					while (classF.find()) {
						className = classF.group(1);

					}

					currentClassName = className;
					//replace if } with +if to resolve complexity
					Pattern p = Pattern.compile("if( )*\\((.)*\\)( )*\\{(.|\\n)*?(\\d+#.*})");
					Matcher mif = p.matcher(regexString);
					while (mif.find()) {
						// replace first number with "number" and second number with the first
						String identifier = mif.group(5);
						String ifIdentify = identifier.replace("}", "-if");
						regexString = regexString.replace(identifier, ifIdentify);
					}
					//replace if end

					//replace for } with +for to resolve complexity
					Pattern p1 = Pattern.compile("for( )*\\((.)*\\)( )*\\{(.|\\n)*?(\\d+#.*})");
					Matcher mif1 = p1.matcher(regexString);
					while (mif1.find()) {
						// replace first number with "number" and second number with the first
						String identifier = mif1.group(5);
						String ifIdentify = identifier.replace("}", "-for");
						regexString = regexString.replace(identifier, ifIdentify);
					}

				}

				
				for (File nowfile : fileList) {
	%>
	</div>

	<div hidden>
		<%
			List<String> list = new ArrayList();
						//Set<String> listOfOtherMethodCallsThisFile = new HashSet();


						Map<String, String> globalVar = new LinkedHashMap();

						try (BufferedReader br = new BufferedReader(new FileReader(nowfile))) {

							String line;
							int no = 1;

							while ((line = br.readLine()) != null) {
								// process the line.
								
								if (!line.trim().equals("")) {
									list.add(no + "#" + line);
									out.println(line + "</br>");
									no++;
								}
							}
						} catch (Exception e) {
							e.printStackTrace();
						}

						
						String regexString = "";

						for (int x = 0; x < list.size(); x++)
							regexString += list.get(x) + "\n";

						//finding the main class name of the file

						//Map designed with method name and method body
						Map<String, MainMethod> thisFileMethods = new HashMap();
						Map<String, Integer> table = new HashMap();

						//replace if } with +if to resolve complexity
						Pattern p = Pattern.compile("if( )*\\((.)*\\)( )*\\{(.|\\n)*?(\\d+#.*})");
						Matcher mif = p.matcher(regexString);
						while (mif.find()) {
							// replace first number with "number" and second number with the first
							String identifier = mif.group(5);
							String ifIdentify = identifier.replace("}", "-if");
							regexString = regexString.replace(identifier, ifIdentify);
						}
						//replace if end

						//replace for } with +for to resolve complexity
						Pattern p1 = Pattern.compile("for( )*\\((.)*\\)( )*\\{(.|\\n)*?(\\d+#.*})");
						Matcher mif1 = p1.matcher(regexString);
						while (mif1.find()) {
							// replace first number with "number" and second number with the first
							String identifier = mif1.group(5);
							String ifIdentify = identifier.replace("}", "-for");
							regexString = regexString.replace(identifier, ifIdentify);
						}	
		%>
	</div>


	<div align="center">

		<h1 class="display-1"
			style="padding-left: -79px; margin-left: 100px; font-family: century gothic; font-size: 50px; margin-top: 10px">
			<font color="#00376c">Complexity of Control Structure</font>
		</h1>

	</div>

	<form action="AccessFilesServlet" method="post" class="form-group"
		style="width: 50%; margin-left: 380px;">
		<table class="table table-responsive-lg">
			<caption
				style="caption-side: top; text-align: center; font-size: x-large;">Weights
				related to the Control Structure factor</caption>
			<thead class="table-dark">
				<tr>
					<th scope="col" style="text-align: center">Control Structure
						Type</th>
					<th scope="col" style="text-align: center">Weight</th>
				</tr>
			</thead>
			<tbody>
				<tr class="table-secondary">
					<td class="d-flex justify-content-center">if or else-if
						condition</td>
					<td><input class="form-control" type="number"
						name="inputPrimitiveReturnWeight" id="inputPrimitiveReturnWeight"
						value="2"></td>
				</tr>

				<tr class="table-secondary">
					<td class="d-flex justify-content-center">for, while, or
						do-while loop</td>
					<td><input class="form-control" type="number"
						name="inputCompositeReturnWeight" id="inputCompositeReturnWeight"
						value="3"></td>
				</tr>

				<tr class="table-secondary">
					<td class="d-flex justify-content-center">switch statement in
						a switch-case</td>
					<td><input class="form-control" type="number"
						name="inputCompositeReturnWeight" id="inputCompositeReturnWeight"
						value="2"></td>
				</tr>

				<tr class="table-secondary">
					<td class="d-flex justify-content-center">case statement in a
						switch-case</td>
					<td><input class="form-control" type="number"
						name="inputCompositeReturnWeight" id="inputCompositeReturnWeight"
						value="1"></td>
				</tr>

			</tbody>
		</table>
		<div class="col text-right">
			<button class="btn btn-dark" type="submit" name="sumbitButton"
				id="sumbitButton" disabled>Save</button>
		</div>
	</form>
<br>

		<hr>
		<center><h1 id="<%="id" + nowfile.getName().replaceAll(" ", "")%>">File Name: <%=nowfile.getName()%></h1></center>
		<hr>

	<br>





	<br>

	<table style="width: 78%; margin-left: 184px; background-color: #fff; " class="table table-bordered">
		<colgroup>
			<col style="width: 8%;">
			<col style="width: 78%;">
			<col style="width: 1%;">
			<col style="width: 4%;">
			<col style="width: 4%;">

		</colgroup>

		<tbody>
			<tr>
				<th>Line No</th>
				<th>Program statements</th>
				<th>Wtcs</th>
				<th>NC</th>
				<th>Ccspps</th>
				<th>Ccs</th>
			</tr>


			<%
				int outermost = 0;

							for (int i1 = 0; i1 < list.size(); i1++) {

								String originalCodeLine = list.get(i1).toString();
								String codeLine[] = { list.get(i1).toString() };
								String number = codeLine[0].substring(0, codeLine[0].indexOf("#"));

								int typeOfStructure = 0;
								int noOfConditions = 0;
								int previouse = 0;
								Matcher controleTypes = Pattern.compile("(for|if|switch|case|while)( )*(\\((.*)\\)|.*\\:)")
										.matcher(originalCodeLine);

								while (controleTypes.find()) {

									String type = controleTypes.group(1);
									System.out.println(type + " type " + originalCodeLine);

									String conditions = controleTypes.group(3);

									switch (type) {

									case "for":
										if (outermost != 0) {
											previouse = 3;
										}
										outermost++;
										typeOfStructure = 3;
										break;

									case "while":
										typeOfStructure = 3;
										break;

									case "if":
										typeOfStructure = 2;
										break;

									case "switch":
										typeOfStructure = 2;
										break;

									case "case":
										typeOfStructure = 1;
										break;

									}

									Matcher conditionSet = Pattern.compile("(==|!=|<=|>=|>|<)").matcher(conditions);
									while (conditionSet.find()) {
										System.out.println(conditionSet.group(1) + " condition");
										noOfConditions++;
									}

									System.out.println("structure   " + typeOfStructure + "\n\n\n");

								}
			%>

			<tr>

				<td><%=originalCodeLine.substring(0, originalCodeLine.indexOf("#"))%></td>
				<td><%=originalCodeLine.substring(originalCodeLine.indexOf("#") + 1)%></td>

				<td><%=typeOfStructure%></td>

				<td><%=noOfConditions%></td>

				<td><%=previouse%></td>
				<%
					table.put(number, (typeOfStructure * noOfConditions) + previouse);
				%>

				<td><%=(typeOfStructure * noOfConditions) + previouse%></td>

			</tr>
			
			<%
				}
			%>
		</tbody>
	</table>

	<br>
	<br>

	<%
		}
			} catch (Exception exc) {
				exc.printStackTrace();
			}

			//if there is no file
		} else {
			out.println("<html>");
			out.println("<body>");
			out.println("<p>No file uploaded</p>");
			out.println("</body>");
			out.println("</html>");
		}
	%>
	
</body>
</html>