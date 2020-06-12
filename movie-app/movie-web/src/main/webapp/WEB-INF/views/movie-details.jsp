<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/movie-web/resources/style.css" >
<link rel="stylesheet" href="/movie-web/resources/css/bootstrap.min.css" >

<title>Movies!!!</title>
</head>
<body>
	<h1>${movie.title }</h1>
	<a href='/movie-web/movies'>Back to List</a>
	
	<ul style="columns:2;">
		<li style="list-style:none;">
			<ul>
				<li>Type: <strong>${movie.type }</strong></li>
				<li>Year: <strong>${movie.year }</strong></li>
				<li>Rating: <strong>${movie.imdbRating }</strong></li>
				<li>Tags: <strong>${movie.tag }</strong></li>
			</ul>
		
		</li>
		<li style="list-style:none;">
			<img src="${movie.poster }" />
		</li>
	</ul>
	
	<div>${movie.description}</div>
</body>
</html>