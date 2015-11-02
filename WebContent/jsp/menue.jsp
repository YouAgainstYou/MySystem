<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="<c:url value='/'/>resources/foundation.css" />
<link rel="stylesheet" type="text/css" href="<c:url value='/'/>/resources/normalize.css" />


<nav class="top-bar" data-topbar role="navigation">
  <ul class="title-area">
    <li class="name">
      <h1><a href="<c:url value='/'/>/dashboard">My System</a></h1>
    </li>
    <li class="toggle-topbar menu-icon"><a href="#"><span>Menu</span></a></li>
  </ul>

  <section class="top-bar-section">
    <ul class="left">
      <li class="active"><a href="<c:url value='/'/>/listDates">dates</a></li>
      <li class="active"><a href="<c:url value='/'/>/listTasks">to dos</a></li>
      <li class="active"><a href="<c:url value='/'/>/listDisciplines">disciplines</a></li>
      <li class="active"><a href="<c:url value='/'/>/listHabits">habits</a></li>
      <li class="active"><a href="<c:url value='/'/>/listJournal">journal</a></li>
    </ul>

  </section>
</nav>