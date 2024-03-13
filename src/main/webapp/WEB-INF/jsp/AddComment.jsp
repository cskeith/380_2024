<!DOCTYPE html>
<html>
<head>
    <title>Add Comment</title>
</head>
<body>
<h1>Add Comment</h1>
<form:form method="POST" modelAttribute="entry">
    <form:label path="name">Name:</form:label>
    <form:input path="name"/><br/>
    <form:textarea path="message"/><br/>
    <input type="submit" name="add" value="Add"/>
</form:form>
</body>
</html>