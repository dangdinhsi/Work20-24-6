<%@ page import="java.util.List" %>
<%@ page import="entity.Account" %>
<%@ page import="entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: Sidang
  Date: 6/24/2019
  Time: 9:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Account> list =(List<Account>) request.getAttribute("list");
%>

<style>
    a{
        text-decoration: none;
    }
    .nameTh{
        text-align: center;
    }
    .nameTd{
        color: #798c73	;
        text-align: center;
    }
</style>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Account List</h1>
<%--<ul>--%>
<%--    <%--%>
<%--        for (int i = 0; i < list.size(); i++) {--%>
<%--    %>--%>
<%--    <li>--%>
<%--        <div>--%>
<%--          <a href="/account/detail?id=<%=list.get(i).getUsername()%>"><%= list.get(i).getUsername()%></a>--%>
<%--        </div>--%>
<%--        <div>--%>
<%--            <%--%>
<%--                if(list.get(i).getStudentRef()!=null)--%>
<%--                {--%>
<%--                    Student student = list.get(i).getStudentRef().get();--%>
<%--            %>--%>
<%--            <img src="<%=student.getAvatarUrl()%>" alt="" style="width: 70px;">--%>
<%--            <%--%>
<%--                }--%>
<%--            %>--%>
<%--        </div>--%>

<%--    </li>--%>
<%--    <%--%>
<%--        }--%>
<%--    %>--%>

<%--</ul>--%>
<table border="2px" bordercolor="#8c7373">
<tr class="nameTh">
    <th>Avatar</th>
    <th>RollNumber</th>
    <th>Username</th>


</tr>
    <%
        for (int i = 0; i < list.size(); i++) {
    %>
<tr class="nameTd">

    <%
        if(list.get(i).getStudentRef()!=null)
        {
            Student student = list.get(i).getStudentRef().get();
    %>
    <td><a href="/account/detail?id=<%=list.get(i).getUsername()%>"><img src="<%=student.getAvatarUrl()%>" alt="" style="width: 70px;"></a></td>
    <td><%=student.getRollNumber()%></td>
    <%
        }
    %>
    <td><%= list.get(i).getUsername()%></td>
</tr>
    <%
        }
    %>
</table>
</body>
</html>
