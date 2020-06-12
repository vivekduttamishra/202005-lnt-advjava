<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/movie-web/resources/style.css" >
<link rel="stylesheet" href="/movie-web/resources/css/bootstrap.min.css" >

<title>Add Movies!!!</title>
</head>
<body>
	<h1>Add New Movie</h1>
	
	<form:form method="POST" action="/movie-web/movie/add" modelAttribute="movie">
             <table>
             	<tr>
                    <td><form:label path="imdbID">Imdb ID</form:label></td>
                    <td><form:input path="imdbID"/></td>
                </tr>
                <tr>
                    <td><form:label path="title">Title</form:label></td>
                    <td><form:input path="title"/></td>
                </tr>
                <tr>
                    <td><form:label path="type">Type</form:label></td>
                    <td><form:input path="type"/></td>
                </tr>
                <tr>
                    <td><form:label path="year">Year</form:label></td>
                    <td><form:input path="year"/></td>
                </tr>
                <tr>
                    <td><form:label path="imdbRating">Imdb Rating</form:label></td>
                    <td><form:input path="imdbRating"/></td>
                </tr>
                <tr>
                    <td><form:label path="poster">Poster</form:label></td>
                    <td><form:input path="poster"/></td>
                </tr>
                <tr>
                    <td><form:label path="tag">Tags</form:label></td>
                    <td><form:input path="tag"/></td>
                </tr>
                <tr>
                    <td><form:label path="description">Description</form:label></td>
                    <td><form:input path="description"/></td>
                    
                </tr>
                
                
                
                
                
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
    </form:form>
</body>
</html>