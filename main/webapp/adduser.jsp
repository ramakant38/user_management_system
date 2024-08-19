<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
   <div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Add User</p>
						
						<%
						String str = (String) session.getAttribute("Added");
						if(str != null){
						%>
						
						<h3 class="text-center text-success"><%= str%></h3>
						
						<%
						}
						session.removeAttribute("success");
						%>

						<form action="adduser" method="post">
							<div class="mb-3">
								<label class="form-label">Name</label> <input name="name"
									type="text" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Age</label> <input name="age"
									type="tel" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Mobile</label> <input name="mobile"
									type="tel" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Email Address</label> <input
									name="email" type="email" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Password</label> <input
									name="password" type="password" class="form-control" required>
							</div>
							<button type="submit"
								class="btn bg-secondary text-white col-md-12">Submit</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div> 
</body>
</html>