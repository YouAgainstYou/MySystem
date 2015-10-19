<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>list tasks</title>

<link rel="stylesheet" type="text/css" href="<c:url value='/'/>resources/foundation.css" />
<link rel="stylesheet" type="text/css" href="<c:url value='/'/>resources/normalize.css" />
<script src="<c:url value='/'/>resources/modernizr.js"></script>
<script src="<c:url value='/'/>resources/jquery.js"></script>

<script>
function doSearch() {
	searchText = $('#filterText').val();
	
	$("tr").each(function() {
		elementText = $(this).html().toLowerCase();
		
		if (elementText.indexOf(searchText.toLowerCase()) >= 0) {
			$(this).show();
		} else {
			$(this).hide();
		}
	});
}

$(document).ready("filterText").keyup(function(){
    doSearch();
});
</script>

</head>
<body>
	<jsp:include page="../menue.jsp" />

	<input type=text id="filterText" />

	<table>
		<c:forEach var="todo" items="${tasks}">
			<tr>
				<td><c:out value="${todo.id}" /></td>
				<td><c:out value="${todo.description}" /></td>

				<td><a href="<c:url value='/'/>edit<c:out value="${todo.type}" />/${todo.id}" class="button">edit</a></td>
				<td><a href="<c:url value='/'/>delete<c:out value="${todo.type}" />/${todo.id}" class="button">delete</a></td>

			</tr>
		</c:forEach>
	</table>
	<a href="<c:url value='/'/>addTask" class="button">new</a>

</body>
</html>