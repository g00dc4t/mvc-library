<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>

<h2>People info</h2>
<br>

<form:form action="/library/people/save" modelAttribute="person">

    <form:hidden path="id"/>

    Name <form:input path="name"/>
    <form:errors path="name"/>
    <br><br>
    Surname <form:input path="surName"/>
    <form:errors path="surName"/>
    <br><br>
    Year <form:input path="year"/>
    <form:errors path="year"/>
    <br><br>
    <input type="submit" value="OK">
</form:form>

<br>
<br>
<a href="/library/people">back to all people</a>

</body>
</html>