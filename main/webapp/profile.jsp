<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
import="com.org.dao.UserDao, com.org.dto.User"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
<%@ include file="components/css_styles.jsp" %>
</head>
<body>
    <%@ include file="components/profile_navbar.jsp" %>

   <%
   int id = (int) session.getAttribute("userId");
   UserDao dao = new UserDao();
   User user = dao.fetchById(id);
   %>
   <h2></h2>
   <h2>Your ID : <%=user.getId() %></h2>
   <h2>Your Name : <%=user.getName()%></h2>
   <h2>Your Age : <%=user.getAge() %></h2>
   <h2>Your Mobile : <%=user.getMobile() %></h2>
   <h2>Your Email : <%=user.getEmail()%></h2>
</body>
</html>