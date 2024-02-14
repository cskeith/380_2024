<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<body>
Welcome to your page!
<% if (request.getParameter("userName") == null) { %>
<jsp:forward page="CollectName.jsp"/>
<% } %>
Hello ${param.userName}.
</body>
</html>