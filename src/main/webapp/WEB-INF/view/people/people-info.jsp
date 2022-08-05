<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>

<h2>People info</h2>
<br>

<form:form action="/library/people/save" modelAttribute="people">

    <form:hidden path="id"/>

    Name <form:input path="name"/>
    <br><br>
    Surname <form:input path="surName"/>
    <br><br>
    Year <form:input path="year"/>
    <br><br>
    <input type="submit" value="OK">
</form:form>

<br>
<br>
<a href="/library/people">back to all people</a>

</body>
</html>