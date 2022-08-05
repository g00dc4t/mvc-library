<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>

<h4>People</h4>

<c:forEach var="p" items="${people}">
    <a href="people/${p.id}" >${p.name} ${p.surName}, ${p.year}</a>
    <br>
</c:forEach>

<br>

<input type="button" value="Add"
       onclick="window.location.href='people/new'"/>

<br>
<br>

<a href="/library">back to main</a>

</body>
</html>