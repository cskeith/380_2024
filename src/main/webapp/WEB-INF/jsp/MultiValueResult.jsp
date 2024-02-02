<%
    String[] fruits = request.getParameterValues("fruit");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Hello User Application</title>
</head>
<body>
<h1>Your Selections</h1>
<% if (fruits == null) { %>
You did not select any fruits
<% } else { %>
<ul>
    <% for (String fruit : fruits) { %>
    <li><%= fruit %></li>
    <% } %>
</ul>
<% } %>
</body>
</html>
