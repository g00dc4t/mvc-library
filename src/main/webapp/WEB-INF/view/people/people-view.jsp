<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>

<h4>Person</h4>

<p>${people.name} ${people.surName}, ${people.year}</p>

<hr>

<c:set var="booksNumber" value="${people.books.size()}"/>
<c:if test="${booksNumber == 0}">
    <p>Hasn't taken books yet</p>
</c:if>
<c:if test="${booksNumber > 0}">
    <h3>Books:</h3>
    <c:forEach var="book" items="${people.books}">
        <p>${book.name}, ${book.author}, ${book.year}</p>
    </c:forEach>
</c:if>

<hr>

<input type="button" value="Update"
       onclick="window.location.href='../people/${people.id}/edit'"/>
<br>
<br>
<input type="button" value="Delete"
       onclick="window.location.href='../people/${people.id}/delete'"/>

<br>
<br>
<a href="/library/people">back to all people</a>

</body>
</html>