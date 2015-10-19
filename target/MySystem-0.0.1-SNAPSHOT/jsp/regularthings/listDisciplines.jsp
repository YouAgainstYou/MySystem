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
	<input type=text id="filterText" />

	<table>
		<c:forEach var="discipline" items="${disciplines}">
			<tr>
				<td><c:out value="${discipline.id}" /></td>
				<td><c:out value="${discipline.description}" /></td>

				<td><a href="<c:url value='/'/>editDiscipline">/${discipline.id}" class="button">edit</a></td>
				<td><a href="<c:url value='/'/>deleteDiscipline">/${discipline.id}" class="button">delete</a></td>

			</tr>
		</c:forEach>
	</table>
	<a href="<c:url value='/'/>addDiscipline" class="button">new</a>

</body>
</html>