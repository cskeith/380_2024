<!DOCTYPE html>
<html>
<body>
<jsp:useBean id="hello" scope="session" class="hkmu.comps380f.HelloBean" />
<jsp:setProperty name="hello" property="name" value='<%=request.getParameter("name")%>' />
<jsp:setProperty name="hello" property="email" value='<%=request.getParameter("email")%>' />
Hello, your name is <jsp:getProperty name="hello" property="name" />!
Your email address is <jsp:getProperty name="hello" property="email" />.
</body>
</html>