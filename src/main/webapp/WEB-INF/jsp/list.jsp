<!DOCTYPE html>
<html>
<head>
    <title>Customer Support</title>
</head>
<body>
<h2>Tickets</h2>
<a href="<c:url value="/ticket/create" />">Create a Ticket</a><br/><br/>
<c:choose>
    <c:when test="${fn:length(ticketDatabase) == 0}">
        <i>There are no tickets in the system.</i>
    </c:when>
    <c:otherwise>
        <c:forEach items="${ticketDatabase}" var="entry">
            Ticket ${entry.id}:
            <a href="<c:url value="/ticket/view/${entry.id}" />">
                <c:out value="${entry.subject}"/></a>
            (customer: <c:out value="${entry.customerName}"/>)
            [<a href="<c:url value="/ticket/delete/${entry.id}" />">Delete</a>]<br />
        </c:forEach>
    </c:otherwise>
</c:choose>
</body>
</html>
