<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: sam
  Date: 12/8/16
  Time: 7:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    my first webpage
    <c:out value="jstl out test"/>
    <%
        List<String> userNamesList  = Arrays.asList("name1", "name2", "name3", "name4", "name5");
        response.getWriter().print(userNamesList);
        request.setAttribute("userNamesList1", userNamesList);
    %>
    <table border="2">
        <tr>
            <th>User Names</th>
            </tr>

<c:forEach var="usrName" items="${userNamesList1}">
    <tr>
        <td>
     ${usrName}
        </td>
     </tr>
</c:forEach>
        </table>
</body>
</html>
