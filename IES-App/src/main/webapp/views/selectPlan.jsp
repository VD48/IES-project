<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="header.jsp" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Select Plan</title>
<style>
/*the container must be positioned relative:*/
.custom-select {
  position: relative;
  font-family: Arial;
}

.custom-select select {
  display: none; /*hide original SELECT element:*/
}

.select-selected {
  background-color: DodgerBlue;
}

/*style the arrow inside the select element:*/
.select-selected:after {
  position: absolute;
  content: "";
  top: 14px;
  right: 10px;
  width: 0;
  height: 0;
  border: 6px solid transparent;
  border-color: #fff transparent transparent transparent;
}

/*point the arrow upwards when the select box is open (active):*/
.select-selected.select-arrow-active:after {
  border-color: transparent transparent #fff transparent;
  top: 7px;
}

/*style the items (options), including the selected item:*/
.select-items div,.select-selected {
  color: #ffffff;
  padding: 8px 16px;
  border: 1px solid transparent;
  border-color: transparent transparent rgba(0, 0, 0, 0.1) transparent;
  cursor: pointer;
  user-select: none;
}

/*style items (options):*/
.select-items {
  position: absolute;
  background-color: DodgerBlue;
  top: 100%;
  left: 0;
  right: 0;
  z-index: 99;
}

/*hide the items when the select box is closed:*/
.select-hide {
  display: none;
}

.select-items div:hover, .same-as-selected {
  background-color: rgba(0, 0, 0, 0.1);
}
</style>
<link rel="stylesheet" type="text/css" href="styles.css" />
</head>
<body>
<div align="center">
   <h3><font color="red">Select Plan</font></h3>
    <form:form action="/selectPlan" modelAttribute="selectPlan" method="post">
      <table>
                <tr>
					<th>Case Id</th>
				</tr>
				<tr>
					<td><form:input path="caseNo" maxlength="12" required="required" readonly="true"/></td>
				</tr>
				<tr>
					<th>First Name</th>
				</tr>
				<tr>
					<td><form:input path="firstName" maxlength="12" required="required"/></td>
				</tr>
				<tr>
					<th>Last Name</th>
				</tr>
				<tr>
					<td><form:input path="lastName" maxlength="12" required="required" /></td>
				</tr>
				<tr>
					<th>Select Plan</th>
				
				</tr>
				<tr> 
					<td>
					   <form:select path="planName" id="cid" cssClass="custom-select" style="width:200px;">
							<form:option value="">-Select-</form:option>
							<form:options items="${ planList}" />
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