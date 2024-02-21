<jsp:useBean id="gb" class="hkmu.comps380f.GuestBookBean" scope="application"/>
<c:if test="${not empty param.add}">
    <%-- invoke setAddEntry() to create an empty entry --%>
    <jsp:setProperty name="gb" property="addEntry" value="dummy"/>
    <%-- set name & message into the new entry --%>
    <c:set target="${gb.lastEntry}" property="name" value="${param.name}"/>
    <c:set target="${gb.lastEntry}" property="message" value="${param.message}"/>
    <c:redirect url="GuestBook.jsp"/>
</c:if>
<!DOCTYPE html>
<html>
<head>
    <title>Add Guest Book Comment</title>
</head>
<body>
<h1>Add Guest Book Comment</h1>
<form action="AddComment.jsp" method="post">
    Name: <input type="text" name="name"/> <br/>
    Message: <input type="text" name="message"/> <br/>
    <input type="submit" name="add" value="Add"/>
</form>
</body>
</html>