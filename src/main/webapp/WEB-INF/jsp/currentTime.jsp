<fmt:setLocale value="en" scope="session"/>
<!DOCTYPE html>
<html>
<head>
    <title>Hello Spring MVC</title>
</head>
<body>
<h1>Current time</h1>
<jsp:useBean id="timeValues" class="java.util.Date"/>
<p>It is now: <fmt:formatDate value="${timeValues}"
                              pattern="EEE, d MMM yyyy HH:mm:ss Z"/></p>
</body>
</html>