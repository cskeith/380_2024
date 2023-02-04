<!DOCTYPE html>
<html>
<body>
<%
    // This scriptlet declares and initializes "date"
    java.util.Date date = new java.util.Date();
%>
Hello! The time is:
<%
    out.println(date);
    out.println("<br />Your machine's address is: ");
    out.println(request.getRemoteHost());
%>
</body>
</html>