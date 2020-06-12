<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<h1><%=request.getAttribute("error") %></h1>
	
	<p>couldn't find the movie with imdbId <%=request.getAttribute("id") %>
	
	
</body>
</html>