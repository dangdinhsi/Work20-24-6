<%@ page import="java.util.List" %>
<%@ page import="entity.Classroom" %><%--
  Created by IntelliJ IDEA.
  User: Sidang
  Date: 6/24/2019
  Time: 10:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Classroom> list =(List<Classroom>) request.getAttribute("list");
%>
<style>
    .tableTh{
        color: #798c73	;
        text-align: center;
    }
</style>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Classroom list</h1>
<%--<ul>--%>
<%--    <%--%>
<%--        for (int i = 0; i < list.size(); i++) {--%>
<%--    %>--%>
<%--    <li>--%>
<%--        <%= list.get(i).getName()%> - <%= list.get(i).getDescription()%>--%>

<%--        <img src="<%=list.get(i).getImageUrl()%>" alt="" style="width: 200px">--%>


<%--    </li>--%>
<%--    <%--%>
<%--        }--%>
<%--    %>--%>

<%--</ul>--%>

<table border="2px" bordercolor="#8c7373">
    <tr class="tableTh">
        <th>Name</th>
        <th>Description</th>
        <th>Illustration</th>
    </tr>
    <%
        for (int i = 0; i < list.size(); i++) {
    %>
    <tr class="tableTh">
        <td><%=list.get(i).getName()%></td>
        <td><%=list.get(i).getDescription()%></td>
        <td><img src="<%=list.get(i).getImageUrl()%>" alt="" style="width: 100px"></td>
    </tr>
    <%
        }
    %>

</table>
</body>
</html>
