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
        <div>
          <a href="/account/detail?id=<%=list.get(i).getUsername()%>"><%= list.get(i).getUsername()%></a>
        </div>
        <div>
            <%
                if(list.get(i).getStudentRef()!=null)
                {
                    Student student = list.get(i).getStudentRef().get();
            %>
            <img src="<%=student.getAvatarUrl()%>" alt="" style="width: 70px;">
            <%
                }
            %>
        </div>

    </li>
    <%
        }
    %>

</ul>
</body>
</html>
