<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>

<h4>Books</h4>

<div>
    <c:forEach var="book" items="${books}">
        <a href="books/${book.id}">${book.name}, ${book.author}, ${book.year}</a>
        <br>
    </c:forEach>
</div>

<br>

<input type="button" value="Add"
       onclick="window.location.href='books/new'"/>

<br>
<br>

<a href="/library">back to main</a>

</body>
</html>