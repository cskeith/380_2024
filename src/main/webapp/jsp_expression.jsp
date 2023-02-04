<!DOCTYPE html>
<html>
<body>
<h1>JSP expressions</h1>
<ul>
    <li>Current time is: <%= new java.util.Date()%>
    <li>Server Info: <%= application.getServerInfo()%>
    <li>Servlet Init Info: <%= config.getInitParameter("WebMaster")%>
    <li>This Session ID: <%= session.getId()%>
    <li>The value of <code>TestParam</code> is:
            <%= request.getParameter("TestParam")%>
</ul>
<form action="expr" method="GET">
    TestParam: <input type="text" name="TestParam"/>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>
