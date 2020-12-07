<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ include file="header.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Education Details</title>
<link rel="stylesheet" type="text/css" href="styles.css" />
<link rel="stylesheet" type="text/css" href="selectbox.css" />
</head>
<body>
	<div align="center">
	${succMsg}
		<h3>
			<font color="red">Education Details</font>
		</h3>
		<form:form action="/educationPlan" modelAttribute="educationDetails"
			method="post">
			<table>
				<tr>
					<th>Case No</th>
				</tr>
				<tr>
					<td><form:input path="caseNo" readonly="true" /></td>
				</tr>
				<tr>
					<th>Individual's Name</th>
				</tr>
				<tr>
					<td><form:input path="firstName" required="required" /></td>
				</tr>
				  <tr>
					<th>Highest Qualification</th>
				
				</tr>
				<tr> 
					<td>
					   <form:select path="qualification"  cssClass="custom-select" style="width:200px;">
							<form:option value="">-Select-</form:option>
							<form:option value="10">10</form:option>
							<form:option value="12">10+2</form:option>
							<form:option value="15">10+2+3</form:option>
							<form:option value="17">10+2+3+2</form:option>
						</form:select>
					</td>
				</tr>
				<tr>
					<th>Completed Year</th>
				</tr>
				<tr>
					<td><form:input path="completedYear" required="required" /></td>
				</tr>
				<tr> 
					<td>
					   <form:select path="grade"  cssClass="custom-select" style="width:200px;">
							<form:option value="">-Select-</form:option>
							<form:option value="A+">A+</form:option>
							<form:option value="A">A</form:option>
							<form:option value="B">B</form:option>
							<form:option value="C">C</form:option>
						</form:select>
					</td>
				</tr>
				
				<tr>
				
					<td><input type="submit" value="Next" id="sumbitbtn"></td>
				</tr>
				
         
         </table>
     
    </form:form>
   </div>
</body>
</html>