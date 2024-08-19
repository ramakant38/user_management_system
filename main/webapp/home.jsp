<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="com.org.dao.UserDao, com.org.dto.User, java.util.List"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<%@ include file="components/css_styles.jsp"%>
</head>
<body>
	<%@ include file="components/home_navbar.jsp"%>
	<%
	Object userId = session.getAttribute("userId");	
	System.out.println(userId);
	if (userId == null) {
		response.sendRedirect("login.jsp");
	} else {
	%>
	<%
	int id = (int) session.getAttribute("userId");
	UserDao dao = new UserDao();
	User user = dao.fetchById(id);
	%>

	<h1 class="text-center">
		Hey
		<%=user.getName()%>
		Welcome to home Page
	</h1>
	<div class="container-fluid p-3">
		<div class="row">
			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">User Details</p>

						<a href="adduser.jsp" class="text-decoration-none btn btn-primary">Add
							User</a>
						<table class="table">
							<thead>
								<tr>
									<th>Name</th>
									<th>Age</th>
									<th>Email</th>
									<th>Mobile</th>
									<th>Action</th>
								</tr>

							</thead>
							<tbody>
								<%
								List<User> list = dao.fetchAll();
								for (User u : list) {
									if (u.getId() == id)
										continue;
								%>
								<tr>
									<td><%=u.getName()%></td>
									<td><%=u.getAge()%></td>
									<td><%=u.getEmail()%></td>
									<td><%=u.getMobile()%></td>
									<td><a href="update.jsp?id=<%=u.getId()%>"
										class="btn btn-sm btn-primary">Update</a> <a
										href="delete.jsp?id=<%=u.getId()%>"
										class="btn btn-sm btn-danger">Delete</a></td>
								</tr>

								<%
								}
								%>

							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%
	}
	%>
</body>
</html>