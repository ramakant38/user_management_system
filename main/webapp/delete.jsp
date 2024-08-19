<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
import="com.org.dao.UserDao, com.org.dto.User"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="components/css_styles.jsp" %>
</head>
<body>
  <%@ include file="components/home_navbar.jsp" %>
  
  <%
   int id = Integer.parseInt(request.getParameter("id"));

%>
  
  <div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
					
					<form action="delete?id=<%= id%>" method="post">
						<p class="fs-4 text-center">Confirm you want to delete user</p>
						<button type="submit" class="btn btn-sm btn-primary">Confirm</button>
						    
						<a href="home.jsp" class="btn btn-sm btn-secondary">Cancel</a>
					</form>

					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>