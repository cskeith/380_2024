<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.util.concurrent.*" %>
<%
    String[] firstNames = {"Elon", "Bill", "Mark"};
    List<String> lastNames = new CopyOnWriteArrayList<>();
    lastNames.add("Musk");
    lastNames.add("Gates");
    lastNames.add("Zuckerberg");
    Map<String, String> companyNames = new ConcurrentHashMap<>();
    companyNames.put("Gates", "Microsoft");
    companyNames.put("Musk", "Tesla");
    companyNames.put("Zuckerberg", "Meta");
    request.setAttribute("first", firstNames);
    request.setAttribute("last", lastNames);
    request.setAttribute("company", companyNames);
%>
<!DOCTYPE html>
<html>
<head>
    <title>Accessing Collections with EL</title>
</head>
<body>
<h1>Accessing Collections with EL</h1>
<ul>
    <li>${first[0]} ${last[0]} (${company[last[0]]})</li>
    <li>${first[1]} ${last[1]} (${company[last[1]]})</li>
    <li>${first[2]} ${last[2]} (${company[last[2]]})</li>
</ul>
</body>
</html>