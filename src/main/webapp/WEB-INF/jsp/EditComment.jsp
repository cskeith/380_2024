<!DOCTYPE html>
<html>
<head>
    <title>Edit Comment</title>
</head>
<body>
<h1>Edit Comment</h1>
<form action="EditComment" method="post">
    Name: <input type="text" name="name" value="${entry.name}"/> <br/>
    <textarea name="message">${entry.message}</textarea> <br/>
    <input type="hidden" name="id" value="${entry.id}"/>
    <input type="submit" name="save" value="Save"/>
</form>
</body>
</html>