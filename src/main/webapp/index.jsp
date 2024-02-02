<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Index page</title>
</head>
<body>
<jsp:useBean id="visit" scope="application"
             class="hkmu.comps380f.VisitCounter"/>
<jsp:setProperty name="visit" property="count"
                 value='<%= visit.getCount() + 1%>'/>
<h1>Example</h1>
The site was visited for
<jsp:getProperty name="visit" property="count"/>
times.
</body>
</html>
