<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    import="com.org.dao.UserDao, com.org.dto.User"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Page</title>

<%@ include file="components/css_styles.jsp" %>

</head>
<body>

<%@ include file="components/home_navbar.jsp" %>

<h1 class="text-center">Update Page</h1>
<%
   int id = Integer.parseInt(request.getParameter("id"));
   UserDao dao = new UserDao();
   User user = dao.fetchById(id);

%>

<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center"><%= user.getName() %> 's Page</p>
						

						<form action="update" method="post">
							<div class="mb-3">
								<label class="form-label">Name</label> <input name="name"
									type="text" class="form-control" value="<%=user.getName() %>" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Age</label> <input name="age"
									type="tel" class="form-control" value="<%=user.getAge() %>" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Mobile</label> <input name="mobile"
									type="tel" class="form-control" value="<%=user.getMobile() %>" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Email Address</label> <input
									name="email" type="email" class="form-control" value="<%=user.getEmail() %>" required>
							</div>
							<input type="hidden" name="id" value="<%= user.getId()%>">
							
							<button type="submit"
								class="btn bg-secondary text-white col-md-12">Update</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>