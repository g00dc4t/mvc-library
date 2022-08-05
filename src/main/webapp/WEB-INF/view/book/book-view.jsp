<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>

<h4>Book</h4>

<p>${book.name}, ${book.author}, ${book.year}</p>

<hr>

<c:set var="prevUrl" value="/library/books/${book.id}"/>

<div>
    <c:if test="${book.person == null}">
        <p>This book isn't taken</p>

        <form:form action="${prevUrl}/assign" modelAttribute="person">
            Choose people <form:select path="id">
            <c:forEach var="person" items="${peoples}">
                <option value="${person.id}">${person}</option>
            </c:forEach>
        </form:select>

            <input type="submit" value="Assign">

        </form:form>
    </c:if>
</div>

<div>
    <c:if test="${book.person != null}">
        <p>${book.person} has now this book</p>
        <input type="button" value="Release"
               onclick="window.location.href='${prevUrl}/release'"/>
    </c:if>
</div>

<hr>

<input type="button" value="Update"
       onclick="window.location.href='${prevUrl}/edit'"/>
<br>
<br>
<input type="button" value="Delete"
       onclick="window.location.href='${prevUrl}/delete'"/>

<br>
<br>
<a href="/library/books">back to all books</a>

</body>
</html>