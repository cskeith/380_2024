<!DOCTYPE html>
<html>
<body>
<!-- This is an HTML comment -->
<%-- This is a JSP comment --%>
If you don't attend lecture,
<% if (Math.random() < 0.5) { %>
you would still pass the course.
<% } else { %>
you will definitely fail the course.
<% } %>
</body>
</html>
