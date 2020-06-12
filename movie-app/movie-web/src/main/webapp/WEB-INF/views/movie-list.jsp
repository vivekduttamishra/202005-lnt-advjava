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
	<h1>Movie List !!!</h1>
	
	<p>Total Movies :<strong>${movies.size() }</strong></p>
	
	<ul class='gridx' >
		<c:forEach items="${movies}" var="movie">
			<a href='/movie-web/movie/${movie.imdbID }' >
			<li>
    			
    				<div class='box'>
    					<div style="display:inline;width:30%;padding-right:10px;">
    						<img src='${movie.poster}' height="80px"  />
    					</div>
    					
    					<h2  style="display:inline;" >${movie.title }</h2>
    				</div>
    			
    		</li>
    		</a>
		</c:forEach>	
	</ul>

</body>
</html>