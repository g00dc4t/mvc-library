<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>

<h3>Book info</h3>
<br>

<div>
    <form:form action="/library/books/save" modelAttribute="book">

        <form:hidden path="id"/>

        Name <form:input path="name"/>
        <br><br>
        Surname <form:input path="author"/>
        <br><br>
        Year <form:input path="year"/>
        <br><br>
        <input type="submit" value="OK">
    </form:form>
</div>

<br>
<br>
<a href="/library/books">back to all books</a>

</body>
</html>