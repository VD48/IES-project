<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ include file = "header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Plan</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script type="text/javascript">
    function deletefuction(){
    	return confirm("Press OK to Deactive contact");
        }
</script>
  
  </head>
<body>
<div class="container">
   <table class="table table-bordered">
      <thead>
        <tr>
          <th>Plan Name</th>
          <th> Plan Description</th>
          <th>Plan Start Date</th>
          <th>Plan End Date</th>
          <th>action</th>
        </tr>
     </thead>
      <tbody>
         
         <c:forEach items="${planList}" var="c">
            <tr>
               
               <td>${ c.planName }</td>
               <td>${c.planDescription }</td>
               <td>${c.planStartDate}</td>
               <td>${c.planEndDate }</td>
               
                 <td><a href="/editPlan?planNo=${c.planNo }">edit</a></td>
                <td><a href="/deletePlan?planNo=${c.planNo }" onclick="return deletefuction()"> 
                <c:choose>
                   <c:when test="${c.status}">
							       active
							</c:when>
							<c:otherwise>
								delete
							</c:otherwise>
                   
                </c:choose> 
                </a></td>
                
               
            </tr>
         </c:forEach>
      </tbody>
   </table>
   </div>
</body>
</html>