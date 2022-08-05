<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>

<p>${book.name}, ${book.author}, ${book.year}</p>

<hr>

<div>
    <c:if test="${book.people == null}">
        <p>This book isn't taken</p>

        <form:form action="../books/${book.id}/assign" modelAttribute="people">
            Choose people <form:select path="id">
            <c:forEach var="people" items="${peoples}">
                <option value="${people.id}">${people}</option>
            </c:forEach>
        </form:select>

            <input type="submit" value="Assign">

        </form:form>
    </c:if>
</div>

<div>
    <c:if test="${book.people != null}">
        <p>${book.people} has now this book</p>
        <input type="button" value="Release"
               onclick="window.location.href='../books/${book.id}/release'"/>
    </c:if>
</div>

<hr>

<input type="button" value="Update"
       onclick="window.location.href='../books/${book.id}/edit'"/>
<br>
<br>
<input type="button" value="Delete"
       onclick="window.location.href='../books/${book.id}/delete'"/>

</body>
</html>