<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>dot operator vs. bracket [] operator</title>
</head>
<body>
<h1>dot operator vs. bracket [] operator</h1>
<h2>dot operator:</h2>
<p>Chinese food can be found in: ${dinnerMap.Chinese}</p>
<h2>[] operator:</h2>
<p>Chinese food can be found in: ${dinnerMap[DinnerType[0]]}</p>
</body>
</html>