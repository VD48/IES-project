<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>all child</title>
<link rel="stylesheet" type="text/css" href="table.css" />
<script type="text/javascript">
    function deletefuction(){
    	return confirm("Press OK to Deactive contact");
        }
</script>
</head>
<body>
  <table id="customers">
		<thead>
			<tr>
			    <th>Child id</th>
				<th>Child Name</th>
				<th>Child Gender</th>
				<th>SSN No</th>
				<th>Date of Birth</th>
				<th>action</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${allChilds}" var="c">
				<tr>
                     <td>${ c.childId }</td>
					<td>${ c.childName }</td>
					<td>${c.childGender }</td>
					<td>${c.childSSN}</td>
					<td>${c.childDob }</td>
					<td><a href="/editChild?id=${c.childId }">edit</a></td>
					<td><a href="/deleteChild?id=${c.childId }"
						onclick="return deletefuction()">delete </a></td>
				</tr>
			</c:forEach>
		</tbody>


	</table>
  
</body>
</html>