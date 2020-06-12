<%@page import="in.conceptarchitect.movies.Movie"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% Collection<Movie> movies= (Collection<Movie>) request.getAttribute("movies"); %>

<ul>
	<% for (Movie movie : movies){ %>
		<li><a href="movie/<%=movie.getImdbID()%>"><%=movie.getTitle() %></a></li>
	<%} %>

</ul>

</body>
</html>