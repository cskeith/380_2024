<!DOCTYPE html>
<html>
<head>
    <title>Edit Comment</title>
</head>
<body>
<h1>Edit Comment</h1>
<form:form method="POST" modelAttribute="entry">
    <form:label path="name">Name:</form:label>
    <form:input path="name"/><br/>
    <form:textarea path="message"/><br/>
    <input type="submit" name="edit" value="Save"/>
</form:form>
</body>
</html>