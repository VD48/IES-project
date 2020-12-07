<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ include file = "header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All contacts</title>
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<style>
#customers {
  font-family: Arial black, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #1f5d63;
  color: white;
}
.dropbtn {
	background-color: #1f5d63;
	color: white;
	padding: 20px;
	font-size: 20px;
	border: none;
	cursor: pointer;
}

.dropdown {
	position: relative;
	display: inline-block;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 160px;
	box-shadow: 0px 10px 20px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.dropdown-content a:hover {
	background-color: #f1f1f1
}

.dropdown:hover .dropdown-content {
	display: block;
}

.dropdown:hover .dropbtn {
	background-color: #3e8e41;
}
body {
	background-image: url("data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxAPDxAPEBAQDg8PDw8QDw8PDw8PDw8PFREXFhURFRUYHSggGBolGxUVITEhJSkrLi8uFx8zODMsNygtLisBCgoKDQ0NDg0NDysZFRkrKysrKysrKys3Ny03Kzc3Ny03KysrKysrKy0rKysrKysrLSsrKysrKysrKysrKysrK//AABEIAJ8BPgMBIgACEQEDEQH/xAAbAAADAQEBAQEAAAAAAAAAAAAAAQIDBAYFB//EADMQAAICAQMCBAQFAwUBAAAAAAABAhEhAxIxQVEEYXGRBSKB8BMyscHRFKHhBkJScvEz/8QAFgEBAQEAAAAAAAAAAAAAAAAAAAEC/8QAFhEBAQEAAAAAAAAAAAAAAAAAAAER/9oADAMBAAIRAxEAPwD9OijSKJijSKNIqKLSEkWgGkUu33QJE6/F+aINkghqRfDTy1yuU6a9zm0Hn1OyKCplqxim3JJJW22sIqOOev3RS+/QUV07cegFpjde+KChvj75IJ05K3G05Rq++eH9TRExWPPr6lIB0DBgln/wAQwaBAAUMAEFDABAMAJAdCAQmUJgSyWWxUBm0JlsloozaJaNGiWBk0S0aNENBGTRDRq0Q0UYyREkayRm0BcUaJERRogKSLSEi0QRrcfUys6qJ1oquFz2A5oWpPz4pVS7Hx/F+H15eIuMdRu1smp1GK9sH3tGNs6dKcHlOPLWKw06a90B53+j8V/U7qn/APdy329n4X8Vij0upFutrSd3bV/L1QT1YpNuSSStttUl3Kh6ffYKaT8vZ/yDT3JtrbTxTvd0d36+5YPjiyBN/wByjOGora3LdGrVq6fD+pn/AFfp7gdEmDXHr59ifD6qnFSTTTvKdrmuTTyAVfuNIXHQoAAAAAAAAVDABCGACEMAJEyhMCGhMpksCGS0aMhlENENGjIYGbM2ashoIykjOSNZEMocTSJETRAWi0Si0QUiqsSKCnGCXCRaEhoCiY3dffkUmTNPFNJ3bbVrb1RBoLUlSt8de48917f5MPExlhtrbxVO93R3fHK+oGfiviWloRTnKreEk22/JeR81fGvD2lv567ZUvXsZfHPBfiRjNJyendxT5i6/jg+H4Pwq1pqMIvN78/Lpq/zcey8jUiPcaGqkqb5vubfiJ8U37YPn7ajtXKSUW85Swzo8Hzn/jylSIrrQABAAAAAAAAAAAAAAAmMAJEUxASyWWSwJZDLZLKIZDNGQwM2QzRkMIykQzSREiho0iREtAWjREItEFItEJlhTXPOOwQ1IviSeWsNcp017g+yI19daaiqtydRVqK4ttt8IDSepGPzOSUUm3bVV3NIrr3+6MPD+JU24tJNJPEozi0+zX6ehtB5rt+hBoDXQx0tZt169GaylSsDPer22lKNbli6fHv+xwaWnCG7aox3PdKqy+59SKr16mf9OvMDPwtSipJpq3TVNPOf4OhEwio4XD/Uq6AYCsdgABYJgAAAAAAAAAAAAACBgAEsTGxMCWSymSwIZLLZDKIZDLZDCM5GcjWRmyhxNEZxNIgWjREItEFIpLr9CUVYUQvc7ad/lpVS6p98nm/jEYS8clqVt/DVKcnCDdNpOS4Vnpb6Wr5Rz6vh9DWSlOMJtJq3Tap5X0dgeb8LGMfFeG2qMZtR/Fjpy3RUndrybXK4R6rxOi5uO1pNd03jqY6fhfDaT3xjpQcU/mwml1dndBde4RxQ023Vr2f8nRHSknG2nFXine7o7virVeZrHTSykU1ZFNAZLVim4uS3KrVq88e9FrUXde6AWs8OsN/lxeejEot4bXCt01n3JjqxfzJprKTTWc/yqPN/H/jOtFz0VGWi1JOGonTlDh/RsYPSTUuU1Vpv5ZO41lLOGaNJryfmz5PwL4pPxG69NqEYxS1LvdJL5r8+uD6kZJNRbVu3FXylz7WvcDRAKTrPTqMAAEwAAAYCABgIAABAxiYCYmMQEsllMlgQyWUyWUQzORoyJBGcjNmjIZQRNEZxNEBoi0ZotEFotEItBTVfqWv7EoFxXkA2kXDt90JIjUu0o83bbVrb16rkg2BuiVf2v8kSctytrblflypdHd8cr1aApuk289/UrSnuV8HPqqWbur+ldBae7pdWB01Tro/1PO/GP9PubnqablPUnNPbKSSjGs5fmei1eHXP+2856E/MkrpvF1F5+lgfP+D/AAiPh25KUm5xinFv5Yvr65PpQzn29CZqWEmqvOOY9lnBcnS4b9AGwBAgBDAAAAAAAAAAAAEIYgEIbEBLJZTIYEsllMllEMhlszYREiGXIzZQ4loziaRA0RaM0WiDRFIhFoKtFIhFXWSBzmopyk0klbbwku5h+M7eFf7dinrR+nXD+hy6jfzbcyztvh9rA+J8X+IzhrasfxNWNqOxQbjGK29Fec/oeq0YtwipZe2O5tU26yzyz8B4xtt6mm30by4/9Xt+X6H3PhEtWMHHXlGck/labbcezws2WpHa5xdwcluVWrV+T+o9PbFUmvdDSa7X/u9CyKjTmpfMmnHo07T7ssh2uKz9ssAoBgAgQwAAAAAAAAAAABDEAgAQCYmNiYEsllMlgSyGUyWUQyGWzNhEszZbM2UETRGUTSIGiNEZotEGiKRCKQVohav5X6AikBxJf3FJPFUmmuVeOp3o45r5n6sIM+Xt/kvQT3ptrbT6Z3dHdm3heH6+RrKP3jIVY0jOGqra3LcqtWrSfDrzK3ruvdEC1eHXPS856HPr2ms52q6wvYWpq7nujK41hxdp93gzm2+r9Sjr8K8P1Nj58ZNcNr6nT4aTad5yQbgAAAAAAAAAAAgAAEwATGSwBksbJYCZLGyWUJkMpkMCWQymQwiGQymZsoIs0RlEuIGyLRki0QaopGaZdhVplJkFAaIh6EW7znzGmE28KLSdq7Vrb1IL04JKkOXAs917P+Sfm3K2ttPFO93R3fHPugHqai04ym7e1OT2q3hW0u5n4Dx0deLnFSSUnH547XdJ/ucH+o6cNOLk4QlrRjNp7bW2WL6cHB8HlHR1XW5J6MpT0lJ6ijJTSTxxjuVHpHFXlKn5f2MPERSfFYNL3QutsnwpU6l0eHnuabbS3JN1n1IrLw0E1lJ0/wBjdRS4SQRilwqGAARHVTddclgAAAAAAAAAgGIBMAEwEAmSxslgJksbJZQmQxslsIlkMpmbAmRm2XIzbKFFmkWYxZomBqmaJmSZaYGqZRmmWmQWmXZmUgqpTSTlJpJK23hJd2VGXfl/p2EEH9+XQDRMHJcd8ISG2QY+I09PUi9PUUZVVxbXPR+Rn4f4f4fTtQhGO5VKnyr4z+h1QXv1LTAnTkpfMmnHhNO0+7KbrLfZCjh10YwKM9Zyxt/Sy0MDii3eOcnXpN1nkiOlUrvv07mtgMQAABYCAdiAQDFYEgMlsGJsAbJbBslsoGSwbJbATZDY2yGwhMiTHJkSZRMmZtlNkNgf/9k=");
	
}

</style>
<script type="text/javascript">
    function deletefuction(){
    	return confirm("Press OK to Deactive contact");
        }
</script>

</head>
<body>
<br>
<br>
<div class="dropdown" align="center">
		<button class="dropbtn">Select Role</button>
		<div class="dropdown-content">
			 <a href="/viewAccount?role=caseWorker">CaseWorker</a>
			 <a href="/viewAccount?role=admin">Admin</a>
		</div>
	</div>
<table id="customers">
  <thead>
        <tr>
          <th>First Name</th>
          <th> Last Name</th>
          <th>Email Address</th>
          <th>Date of Birth</th>
          <th>Gender</th>
          <th>Phone No</th>
          <th>SSN No</th>
          <th>Role</th>
          <th>action</th>
        </tr>
     </thead>
     <tbody>
         
         <c:forEach items="${adminRoleList}" var="c">
            <tr>
               
               <td>${ c.firstName }</td>
               <td>${c.lastName }</td>
               <td>${c.emailAdd}</td>
               <td>${c.dob }</td>
               <td>${c.gender }</td>
               <td>${c.phoneNo }</td>
               <td>${c.ssnNo }</td>
               <td>${c.role }</td>
               
                <td><a href="/edit?id=${c.srNo }" class='far fa-edit' style='font-size:20px'></a></td>
                <td><a href="/delete?id=${c.srNo }" onclick="return deletefuction()"> 
                <c:choose>
                   <c:when test="${c.status}">
                                   
							       <i class='fa fa-trash' style='font-size:20px'></i>
							</c:when>
							<c:otherwise>
								active
							</c:otherwise>
                   
                </c:choose> 
                </a></td>
            </tr>
         </c:forEach>
      </tbody>
     

</table>
</body>
</html>