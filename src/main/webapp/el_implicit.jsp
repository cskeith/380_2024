<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Using EL implicit objects</title>
</head>
<body>
<h1>Using EL implicit objects</h1>
<ul>
    <li>Request parameter called <code>test</code>: ${param.test}</li>
    <li>User-agent info in request header: ${header["User-Agent"]}</li>
    <li>Cookie (JSESSIONID) value: ${cookie.JSESSIONID.value}</li>
    <li>Server info: ${pageContext.servletContext.serverInfo}</li>
    <li>Request method: ${pageContext.request.method}</li>
</ul>
</body>
</html>