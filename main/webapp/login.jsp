<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<%@ include file="components/css_styles.jsp" %>
</head>
<body>
<%@ include file="components/index_navbar.jsp" %>
<h1>Login</h1>
<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Login Page</p>
						 <%
						String str = (String) session.getAttribute("fail");
						 
						 if(str != null){
						%>
						
						    <p class="text-align text-center fs-4 text-danger"><%=str %></p>
						
						<% }
						 session.removeAttribute("fail");
						%>

						<form action="login" method="post">
							
							<div class="mb-3">
								<label class="form-label">Email Address</label> <input
									name="email" type="email" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Password</label> <input
									name="password" type="password" class="form-control" required>
							</div>
							<button type="submit"
								class="btn bg-secondary text-white col-md-12">Login</button>
						</form>

					</div>
				</div>
				     
			</div>
		</div>
	</div>
</body>
</html>