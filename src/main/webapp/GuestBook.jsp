<!DOCTYPE html>
<html>
<head>
    <title>Guest Book</title>
</head>
<body>
<h1>Guest Book</h1>
<jsp:useBean id="gb" class="hkmu.comps380f.GuestBookBean" scope="application"/>
<c:if test="${fn:length(gb.entries) == 0}">
    <p>There is no message yet.</p>
</c:if>
<c:if test="${fn:length(gb.entries) > 0}">
    <ul>
        <c:forEach items="${gb.entries}" var="entry">
            <li>
                    ${entry.name} (<fmt:formatDate value="${entry.date}" pattern="yyyy-MM-dd HH:mm:ss"/>): <br/>
                    ${entry.message}
            </li>
        </c:forEach>
    </ul>
</c:if>
<p><a href="AddComment.jsp">Add Comment</a></p>
</body>
</html>