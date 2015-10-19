<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>edit question</title>

<link rel="stylesheet" type="text/css" href="<c:url value='/'/>resources/foundation.css" />
<link rel="stylesheet" type="text/css" href="<c:url value='/'/>/resources/normalize.css" />
<script src="<c:url value='/'/>resources/modernizr.js"></script>
<script src="<c:url value='/'/>resources/jquery.js"></script>

</head>

<body>
	<form:form commandName="question" action="../updateQuestion" method="POST">  
		<form:input path="id"/>
		
		question:<br>
		<form:input path="question"/>
		
		answer:<br>
		<form:input path="answer"/>
		
		<input type="submit" class="button" />
	</form:form>	
</body>
</html>