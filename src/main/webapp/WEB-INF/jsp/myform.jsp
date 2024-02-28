<!DOCTYPE html>
<html>
<head>
    <title>JSP Page</title>
</head>
<body>
<form:form action="formhandle" method="POST" modelAttribute="myData">
    <form:label path="name">Enter a name: </form:label>
    <form:input path="name"/><br/>
    <form:label path="num">Enter a number: </form:label>
    <form:input path="num"/> <br/>
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>