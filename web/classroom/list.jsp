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
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Account List</h1>
<ul>
    <%
        for (int i = 0; i < list.size(); i++) {
    %>
    <li>
        <%= list.get(i).getName()%> - <%= list.get(i).getDescription()%>

        <img src="<%=list.get(i).getImageUrl()%>" alt="" style="width: 200px">


    </li>
    <%
        }
    %>

</ul>


</body>
</html>
