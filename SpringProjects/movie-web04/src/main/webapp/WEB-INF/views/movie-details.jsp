<%@page import="in.conceptarchitect.movies.Movie"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	Movie movie=(Movie) request.getAttribute("movie");
%>

<h1><%=movie.getTitle() %></h1>

<p><strong><%=movie.getDescription() %></strong>


</body>
</html>